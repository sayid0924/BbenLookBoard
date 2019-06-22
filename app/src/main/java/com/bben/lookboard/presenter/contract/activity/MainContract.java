
package com.bben.lookboard.presenter.contract.activity;


import com.bben.lookboard.base.BaseContract;
import com.bben.lookboard.bean.BedInfoBean;

public interface MainContract {

    interface View extends BaseContract.BaseView {
        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfoSuccess(BedInfoBean data);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {


        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfo(boolean tag , String... s);
        void  test(String... s);
    }
}
