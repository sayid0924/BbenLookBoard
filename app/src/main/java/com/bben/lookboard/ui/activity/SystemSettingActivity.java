package com.bben.lookboard.ui.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SystemSettingActivity extends BaseActivity {




    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @BindView(R.id.rl_check_dept)
    RelativeLayout rlCheckDept;


    @Override
    public int getLayoutId() {
        return R.layout.activity_system_setting;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        actionbarTitle.setText("系统设置");
    }

    @OnClick({R.id.rl_back, R.id.rl_check_dept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_check_dept:
                finish();
                break;
        }
    }

}
