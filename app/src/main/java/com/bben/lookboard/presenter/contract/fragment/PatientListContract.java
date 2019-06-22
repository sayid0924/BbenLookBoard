
package com.bben.lookboard.presenter.contract.fragment;


import com.bben.lookboard.base.BaseContract;
import com.bben.lookboard.bean.PatientListBean;

public interface PatientListContract {

    interface View extends BaseContract.BaseView {


        void  FetchPatientListSuccess(PatientListBean patientListBean);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void  FetchPatientList(String ...s);
    }
}
