
package com.bben.lookboard.api;


import android.annotation.SuppressLint;

import com.bben.lookboard.api.persistentcookiejar.PersistentCookieJar;
import com.bben.lookboard.api.persistentcookiejar.cache.SetCookieCache;
import com.bben.lookboard.api.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.bben.lookboard.base.BaseApplication;
import com.bben.lookboard.utils.CommonUtil;
import com.blankj.utilcode.utils.NetworkUtils;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


class Okhttp {

    private static PersistentCookieJar cookieJar;

    static OkHttpClient provideOkHttpClient() {

        //cookie
        cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(BaseApplication.getContext()));

        File httpCacheDir = new File(BaseApplication.getContext().getCacheDir(), "response");
        int cacheSize = 10 * 1024 * 1024;  //10 MiB
        Cache cache = new Cache(httpCacheDir, cacheSize);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .retryOnConnectionFailure(true) // 失败重发
//                .cache(cache)
//                .cookieJar(cookieJar)
//                .addInterceptor(new TokenInterceptor())
                //处理多BaseUrl,添加应用拦截器
                .addInterceptor(new MoreBaseUrlInterceptor())
                .addInterceptor(new LoggingInterceptor());

        return builder.build();

    }

    private static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();
            Request request = chain.request();
            if (!NetworkUtils.isAvailableByPing()) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isAvailableByPing()) {
                int maxAge = 0;//read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28;//tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Prama")
                        .header("Cache-Control", "poublic, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };

    static class LoggingInterceptor implements Interceptor {
        @SuppressLint("DefaultLocale")
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long t1 = System.nanoTime();//请求发起的时间
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < request.url().queryParameterNames().size(); i++) {
                map.put(request.url().queryParameterName(i), request.url().queryParameterValue(i));
            }

            Response response = chain.proceed(request);
            long t2 = System.nanoTime();//收到响应的时间

            ResponseBody responseBody = response.peekBody(1024 * 1024);

            Logger.e(String.format("接收响应: [%s] %n返回json:【%s】%n请求参数: [%s] %n响应时间[%.1fms]",
                    response.request().url(),
                    formatJson(responseBody.string()),
                    transMapToString(map),
                    (t2 - t1) / 1e6d
            ));

            return response;
        }
    }

    static String transMapToString(Map map) {
        Map.Entry entry;
        StringBuilder sb = new StringBuilder();
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            entry = (Map.Entry) iterator.next();
            sb.append(entry.getKey().toString()).append(" == ").append(null == entry.getValue() ? "" :
                    entry.getValue().toString()).append(iterator.hasNext() ? "\n" : "");
        }
        return sb.toString();
    }


    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }


    static class MoreBaseUrlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //获取原始的originalRequest
            Request originalRequest = chain.request();
            //获取老的url
            HttpUrl oldUrl = originalRequest.url();
            //获取originalRequest的创建者builder
            Request.Builder builder = originalRequest.newBuilder();

            HttpUrl baseURL;
//            String strBaseUrl ="http://"+PreferUtil.getInstance().getBaseUrl()+":"+PreferUtil.getInstance().getServerPort();
            baseURL = HttpUrl.parse(CommonUtil.getBaseUrl());
            //重建新的HttpUrl，需要重新设置的url部分

            HttpUrl newHttpUrl = oldUrl.newBuilder()
                    .scheme(baseURL.scheme())
                    .host(baseURL.host())
                    .port(baseURL.port())
                    .build();
            //获取处理后的新newRequest
            Request newRequest = builder.url(newHttpUrl).build();
            return  chain.proceed(newRequest);
        }
    }



//    class TokenInterceptor implements Interceptor {
//
//        private final Charset UTF8 = Charset.forName("UTF-8");
//
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
//            // try the request
//            Response originalResponse = chain.proceed(request);
//            ResponseBody responseBody = originalResponse.body();
//
//            BufferedSource source = responseBody.source();
//            source.request(Long.MAX_VALUE); // Buffer the entire body.
//            Buffer buffer = source.buffer();
//            Charset charset = UTF8;
//            MediaType contentType = responseBody.contentType();
//            if (contentType != null) {
//                charset = contentType.charset(UTF8);
//            }
//
//            String bodyString = buffer.clone().readString(charset);
//            JSONObject jsonObj = null;
//            try {
//                jsonObj = new JSONObject(bodyString);
//                if (jsonObj.has("status")) {
//                    int status = jsonObj.optInt("status");
//                    if (status == 10000) {
//                        OkHttpClient client = new OkHttpClient();
//                        FormBody.Builder builder = new FormBody.Builder();
//                        builder.add("account", LocalAppConfigUtil.getInstance().getUserTelephone());
//                        builder.add("password", LocalAppConfigUtil.getInstance().getPassword());
//                        RequestBody requestBody = builder.build();
//
//                        Request tokRequest = new Request.Builder()
//                                .url(Constant.API_BASE_URL + Constant.MEMBER_LOGIN)
//                                .post(requestBody)
//                                .build();
//
//                        Call call = client.newCall(tokRequest);
//                        Response response = call.execute();
//                        String responseStr = response.body().string();
//                        LoginBean newToken = new Gson().fromJson(responseStr, LoginBean.class);
//
//                        if (newToken.getData() != null && newToken.getData().getRCToken() != null) {
//                           LocalAppConfigUtil.getInstance().setJsessionId(newToken.getData().getJSESSIONID());
//                            HttpUrl originalHttpUrl = request.url();
//                            HttpUrl url = originalHttpUrl.newBuilder()
//                                    .setQueryParameter("access_token",newToken.getData().getJSESSIONID())
//                                    .build();
//
//                            Request newRequest = request.newBuilder()
//                                    .url(url)
//                                    .build();
//
//                            return chain.proceed(newRequest);
//
//                        }
//                    }
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return originalResponse;
//        }
//    }

}