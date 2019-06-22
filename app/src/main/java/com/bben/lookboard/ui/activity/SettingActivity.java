package com.bben.lookboard.ui.activity;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseActivity;
import com.bben.lookboard.base.BaseApplication;
import com.bben.lookboard.bean.DeptCodeListBean;
import com.bben.lookboard.bean.SettingEvenBus;
import com.bben.lookboard.broadcastReceiver.NetworkConnectChangedReceiver;
import com.bben.lookboard.broadcastReceiver.NetworkLinten;
import com.bben.lookboard.db.database.BedInfoBeanDbDao;
import com.bben.lookboard.presenter.contract.activity.SettingActivityContract;
import com.bben.lookboard.presenter.impl.activity.SettingActivityPresenter;
import com.bben.lookboard.service.nettyUtils.NettyClient;
import com.bben.lookboard.ui.adapter.CheckDeptApadter;
import com.bben.lookboard.utils.CommonUtil;
import com.bben.lookboard.utils.GreenDaoUtil;
import com.bben.lookboard.utils.Permission;
import com.bben.lookboard.utils.PreferUtil;
import com.bben.lookboard.view.dialog.CustomDialog;
import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.DeviceUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity implements SettingActivityContract.View, NetworkLinten {

    private BedInfoBeanDbDao collectionInfoDao;

    @BindView(R.id.tv_connecttest)
    TextView tvConnecttest;
    @BindView(R.id.tv_socket_connecttest)
    TextView tvSocketConnecttest;

    @BindView(R.id.iv_service_port)
    ImageView ivServicePort;
    @BindView(R.id.iv_socket_port)
    ImageView ivSocketPort;
    @BindView(R.id.tv_wifi_info)
    TextView tvWifiInfo;
    @BindView(R.id.iv_wifi_level)
    ImageView ivWifiLevel;

    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @BindView(R.id.switch_wifi)
    Switch switchWifi;
    @BindView(R.id.switch_log)
    Switch switchLog;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_sn_info)
    TextView tvSnInfo;
    @BindView(R.id.tv_ip_info)
    TextView tvIpInfo;
    @BindView(R.id.tv_location_info)
    TextView tvLocationInfo;
    @BindView(R.id.tv_version_info)
    TextView tvVersionInfo;
    @BindView(R.id.tv_mac_info)
    TextView tvMacInfo;
    @BindView(R.id.tv_check_dept)
    TextView tvCheckDept;
    @BindView(R.id.ed_service_ip)
    EditText edServiceIp;
    @BindView(R.id.ed_service_port)
    EditText edServicePort;
    @BindView(R.id.ed_socket_port)
    EditText edSocketPort;
    @BindView(R.id.ed_socket_ip)
    EditText edSocketIp;
    @BindView(R.id.iv_socket_ip)
    ImageView ivSocketIp;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    private WifiManager mWifiManager;
    private SettingActivityPresenter mPresenter = new SettingActivityPresenter();
    private NetworkConnectChangedReceiver networkConnectChangedReceiver;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
        mPresenter.detachView();
    }

    @Override
    public void initView() {

        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        mWifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        actionbarTitle.setText("系统设置");
        tvSnInfo.setText(Build.SERIAL);
        tvIpInfo.setText(CommonUtil.getIP());
        tvMacInfo.setText(DeviceUtils.getMacAddress());
        tvVersionInfo.setText(AppUtils.getAppVersionName(this));

        edSocketPort.setText(PreferUtil.getInstance().getSoketPort());
        edServicePort.setText(PreferUtil.getInstance().getServerPort());
        edServiceIp.setText(PreferUtil.getInstance().getBaseUrl());
        edSocketIp.setText(PreferUtil.getInstance().getSoketIp());
        tvCheckDept.setText(PreferUtil.getInstance().getDeptName());
        ivBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);

        mPresenter.connectTest();
        showWaitingDialog("测试连接中...");

        if (NetworkUtils.isWifiConnected()) {
            switchWifi.setChecked(true);
            tvWifiInfo.setText(CommonUtil.getWifiInfo(this));
            switch (CommonUtil.getWifiLevel(this)) {
                case 0:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_3);
                    break;
                case 1:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_2);
                    break;
                case 2:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_1);
                    break;
            }
        } else {
            switchWifi.setChecked(false);
        }

        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mWifiManager.setWifiEnabled(isChecked);
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        networkConnectChangedReceiver = new NetworkConnectChangedReceiver();
        networkConnectChangedReceiver.setNetworkLinten(this);
        registerReceiver(networkConnectChangedReceiver, filter);

        Permission.requestPermission(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferUtil.getInstance().setIsFirst(true);
        EventBus.getDefault().post(new SettingEvenBus());
        unregisterReceiver(networkConnectChangedReceiver);
    }

    /**
     * 网络连接成功
     */
    @Override
    public void ConnectedSuccess() {
        mPresenter.connectTest();
        ivWifiLevel.setVisibility(View.VISIBLE);
        tvWifiInfo.setText(CommonUtil.getWifiInfo(this));
        tvIpInfo.setText(CommonUtil.getIP());
        switch (CommonUtil.getWifiLevel(this)) {
            case 0:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_3);
                break;
            case 1:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_2);
                break;
            case 2:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_1);
                break;
        }
    }

    /**
     * 网络连接失败
     */
    @Override
    public void ConnectedFail() {
        ivServicePort.setBackgroundResource(R.drawable.test_result_fail);
        ivWifiLevel.setVisibility(View.GONE);
        tvWifiInfo.setText("");
    }

    @OnClick({R.id.iv_right, R.id.rl_back, R.id.tv_connecttest, R.id.tv_socket_connecttest, R.id.tv_check_dept})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                PreferUtil.getInstance().setBaseUrl(edServiceIp.getText().toString());
                PreferUtil.getInstance().setServerPort(edServicePort.getText().toString());

                PreferUtil.getInstance().setSocketPort(edSocketPort.getText().toString());
                PreferUtil.getInstance().setSocketIp(edSocketIp.getText().toString());

                finish();
                break;
            case R.id.tv_connecttest:
                // 网络连接测试
                PreferUtil.getInstance().setBaseUrl(edServiceIp.getText().toString());
                PreferUtil.getInstance().setServerPort(edServicePort.getText().toString());
                mPresenter.connectTest();
                showWaitingDialog("测试连接中...");
                break;
            case R.id.tv_socket_connecttest:
                // socket连接测试
                showWaitingDialog("Socket连接....");
                PreferUtil.getInstance().setSocketPort(edSocketPort.getText().toString());
                PreferUtil.getInstance().setSocketIp(edSocketIp.getText().toString());
                BaseApplication.MAIN_EXECUTOR.schedule(new Runnable() {
                    @Override
                    public void run() {
                        hideWaitingDialog();
                        if (NettyClient.getInstance().getConnectStatus()) {
                            ivSocketPort.setBackgroundResource(R.drawable.test_result_sucess);
                            ToastUtils.showLongToast("Socket连接测试成功");
                        } else {
                            ToastUtils.showLongToast("Socket连接测试失败");
                            ivSocketPort.setBackgroundResource(R.drawable.test_result_fail);
                        }
                    }
                }, 10, TimeUnit.SECONDS);

                break;
            case R.id.tv_check_dept:
                //  选择科室列表
                mPresenter.FetchDeptCodeList();
                showWaitingDialog("正在加载中....");

                break;
        }
    }

    @Override
    public TextView getTvLocation() {
        return tvLocationInfo;
    }

    @Override
    public ImageView getIvServicePort() {
        return ivServicePort;
    }


    @Override
    public void connectTestSuccess(DeptCodeListBean data) {
        hideWaitingDialog();
        ToastUtils.showLongToast("连接成功");
    }

    @Override
    public void FetchDeptCodeListSuccess(DeptCodeListBean data) {
        hideWaitingDialog();
        showDeptListDialog(data);
    }

    public void showDeptListDialog(DeptCodeListBean deptCodeListBean) {
        hideWaitingDialog();

        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_dept_list, null);
        RecyclerView rvDeptList = view.findViewById(R.id.rv_dept_list);

        CheckDeptApadter apadter = new CheckDeptApadter(deptCodeListBean.getData(), this);
        rvDeptList.setLayoutManager(new LinearLayoutManager(this));
        rvDeptList.setAdapter(apadter);
        final CustomDialog dialogDeptList = new CustomDialog(this, view, R.style.MyDialog);
        dialogDeptList.setCancelable(true);
        dialogDeptList.show();
        apadter.onItemClick(new CheckDeptApadter.onItemClick() {
            @Override
            public void onItemClick(DeptCodeListBean.DataBean item) {
                tvCheckDept.setText(item.getName());
                PreferUtil.getInstance().setDeptCode(item.getCode());
                PreferUtil.getInstance().setDeptName(item.getName());
                dialogDeptList.dismiss();
            }
        });
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }

}
