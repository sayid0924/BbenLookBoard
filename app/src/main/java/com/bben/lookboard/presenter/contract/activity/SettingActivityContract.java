
package com.bben.lookboard.presenter.contract.activity;


import android.widget.ImageView;
import android.widget.TextView;

import com.bben.lookboard.base.BaseContract;
import com.bben.lookboard.bean.DeptCodeListBean;


public interface SettingActivityContract {

    interface View extends BaseContract.BaseView {

        TextView getTvLocation();
        ImageView getIvServicePort();

        void  connectTestSuccess(DeptCodeListBean data);
        void  FetchDeptCodeListSuccess(DeptCodeListBean data);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void connectTest(String... s);
        void FetchDeptCodeList(String... s);

    }
}
