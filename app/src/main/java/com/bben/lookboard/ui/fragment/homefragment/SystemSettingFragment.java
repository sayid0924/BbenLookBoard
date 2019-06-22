package com.bben.lookboard.ui.fragment.homefragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseFragment;
import com.bben.lookboard.base.Constant;
import com.bben.lookboard.ui.activity.HomeActivity;
import com.bben.lookboard.ui.activity.SystemSettingActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SystemSettingFragment extends BaseFragment {

    @BindView(R.id.ll_system_setting)
    LinearLayout llSystemSetting;

    public static SystemSettingFragment newInstance() {
        SystemSettingFragment systemSettingFragment = new SystemSettingFragment();
        return systemSettingFragment;
    }

    @Override
    public void loadData() {
        setState(Constant.STATE_SUCCESS);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_system_setting;
    }

    @Override
    public void attachView() {

    }



    @OnClick({R.id.ll_system_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_system_setting:   //  系统设置
                HomeActivity.homeActivity.startActivityIn(new Intent(getSupportActivity(), SystemSettingActivity.class), getSupportActivity());
                break;
        }
    }
}
