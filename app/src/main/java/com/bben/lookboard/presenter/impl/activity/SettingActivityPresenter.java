
package com.bben.lookboard.presenter.impl.activity;


import com.bben.lookboard.R;
import com.bben.lookboard.api.Api;
import com.bben.lookboard.base.BasePresenter;
import com.bben.lookboard.bean.DeptCodeListBean;
import com.bben.lookboard.presenter.contract.activity.SettingActivityContract;
import com.blankj.utilcode.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SettingActivityPresenter extends BasePresenter<SettingActivityContract.View> implements SettingActivityContract.Presenter<SettingActivityContract.View> {


    @Override
    public void connectTest(String... s) {
        addSubscrebe(Api.getInstance().FetchDeptCodeList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeptCodeListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        ToastUtils.showLongToast("测试连接失败");
                    }

                    @Override
                    public void onNext(DeptCodeListBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.connectTestSuccess(data);
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_sucess);
                        } else {
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        }
                    }
                }));
    }

    @Override
    public void FetchDeptCodeList(String... s) {
        addSubscrebe(Api.getInstance().FetchDeptCodeList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeptCodeListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        if (mView != null) {
                            mView.showError(e.toString());
                        }
                    }

                    @Override
                    public void onNext(DeptCodeListBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchDeptCodeListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
