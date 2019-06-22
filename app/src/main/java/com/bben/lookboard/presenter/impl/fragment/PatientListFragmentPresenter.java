
package com.bben.lookboard.presenter.impl.fragment;


import com.bben.lookboard.api.Api;
import com.bben.lookboard.base.BasePresenter;
import com.bben.lookboard.bean.PatientListBean;
import com.bben.lookboard.presenter.contract.fragment.PatientListContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PatientListFragmentPresenter extends BasePresenter<PatientListContract.View> implements PatientListContract.Presenter<PatientListContract.View> {


    @Override
    public void FetchPatientList(String... s) {
        addSubscrebe(Api.getInstance().FetchPatientList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PatientListBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(PatientListBean data) {

                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.FetchPatientListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
