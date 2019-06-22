
package com.bben.lookboard.presenter.impl.activity;


import com.bben.lookboard.api.Api;
import com.bben.lookboard.base.BasePresenter;
import com.bben.lookboard.presenter.contract.activity.MainContract;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {


    @Override
    public void bedcardGetbedinfo(boolean tag, String... s) {
//        addSubscrebe(Api.getInstance().bedcardGetbedinfo(s).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<BedInfoBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
////                        mView.showError(e.getMessage());
//                    }
//
//                    @Override
//                    public void onNext(BedInfoBean data) {
//                        if (mView != null && data != null && data.getCode()==0) {
//                            mView.bedcardGetbedinfoSuccess(data);
//                        }else
//                            ToastUtils.showLongToast("请求错误  请重新请求........");
//                    }
//                }));
    }

    @Override
    public void test(String... s) {
        addSubscrebe(Api.getInstance().test(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseBody data) {
//                        if (mView != null && data != null && data.getCode()==0) {
//                            mView.bedcardGetbedinfoSuccess(data);
//                        }else
//                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
