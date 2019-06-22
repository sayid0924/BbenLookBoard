/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bben.lookboard.api;


import com.bben.lookboard.base.Constant;
import com.bben.lookboard.bean.DeptCodeListBean;
import com.bben.lookboard.bean.PatientListBean;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class Api {

    private static Api instance;
    private ApiService service;

    private Api(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constant.API_BASE_URL)
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance() {
        synchronized (Api.class) {
            if (instance == null)
                instance = new Api(Okhttp.provideOkHttpClient());
            return instance;
        }
    }

     private static Map<String, String> getMap(String... s) {
        Map<String, String> map = new HashMap<>();
        if (s.length % 2 != 0) {
            return null;
        } else {
            for (int i = 0; i < s.length; i++) {
                map.put(s[i], s[++i]);
            }
        }
        return map;
    }

//    /**
//     * 根据条件查询床位信息
//     */
//    public Observable<BedInfoBean> bedcardGetbedinfo(String... s) {
//        return service.bedcardGetbedinfo(getMap(s));
//    }

    /**
     * 根据条件查询床位信息
     */
    public Observable<ResponseBody> test(String... s) {
        return service.test(getMap(s));
    }

    /**
     * 获取病人列表
     */
    public Observable<PatientListBean> FetchPatientList(String... s) {
        return service.FetchPatientList(getMap(s));
    }

    /**
     * 获取科室列表
     */
    public Observable<DeptCodeListBean> FetchDeptCodeList(String... s) {
        return service.FetchDeptCodeList(getMap(s));
    }

}
