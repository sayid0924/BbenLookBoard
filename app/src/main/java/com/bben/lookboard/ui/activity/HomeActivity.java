package com.bben.lookboard.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.base.BaseActivity;
import com.bben.lookboard.base.BaseFragmentPageAdapter;
import com.bben.lookboard.bean.SettingEvenBus;
import com.bben.lookboard.service.nettyUtils.NettyService;
import com.bben.lookboard.ui.fragment.homefragment.InfuseControlFragment;
import com.bben.lookboard.ui.fragment.homefragment.NursTrainFragment;
import com.bben.lookboard.ui.fragment.homefragment.NurseSchedulFragment;
import com.bben.lookboard.ui.fragment.homefragment.PatientListFragment;
import com.bben.lookboard.ui.fragment.homefragment.SystemSettingFragment;
import com.bben.lookboard.ui.fragment.homefragment.TodyWorkFragment;
import com.bben.lookboard.ui.fragment.homefragment.TreatmentFragment;
import com.bben.lookboard.utils.AreaClickListener;
import com.bben.lookboard.utils.CommonUtil;
import com.bben.lookboard.utils.PreferUtil;
import com.bben.lookboard.utils.startRTC.listener.DemoBeautyCallback;
import com.bben.lookboard.utils.startRTC.listener.XHChatManagerListener;
import com.bben.lookboard.utils.startRTC.listener.XHGroupManagerListener;
import com.bben.lookboard.utils.startRTC.listener.XHLoginManagerListener;
import com.bben.lookboard.utils.startRTC.listener.XHVoipManagerListener;
import com.bben.lookboard.utils.startRTC.listener.XHVoipP2PManagerListener;
import com.bben.lookboard.view.dialog.CustomDialog;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import skin.support.SkinCompatManager;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.vp)
    ViewPager vp;

    @BindView(R.id.ll_theme)
    LinearLayout llTheme;
    @BindView(R.id.ll_log)
    LinearLayout llLog;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_dept)
    TextView tvDept;

    private BaseFragmentPageAdapter myAdapter;
    private ArrayList<String> mTitleList = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private CustomDialog themeDialog;
    public static HomeActivity homeActivity;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        setSwipeBackEnable(false);
        mTitleList.add("今日工作");
        mTitleList.add("病床信息");
        mTitleList.add("护理培训");
        mTitleList.add("护士排班");
        mTitleList.add("输液监控");
        mTitleList.add("特殊治疗");
        mTitleList.add("系统设置");

        mFragments.add(TodyWorkFragment.newInstance());
        mFragments.add(PatientListFragment.newInstance());
        mFragments.add(NursTrainFragment.newInstance());
        mFragments.add(NurseSchedulFragment.newInstance());
        mFragments.add(InfuseControlFragment.newInstance());
        mFragments.add(TreatmentFragment.newInstance());
        mFragments.add(SystemSettingFragment.newInstance());

        myAdapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), mFragments, mTitleList);
        vp.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(vp);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        tvDept.setText(PreferUtil.getInstance().getDeptName());

        switch (PreferUtil.getInstance().getThemeType()) {
            case "def":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4));
                break;
            case "green":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_green));
                break;
            case "night":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_night));
                break;
//            case "red":
//                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_red));
//                break;
            case "violet":
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_violet));
                break;
        }

//        startService(new Intent().setComponent(new ComponentName("com.bben.lookboard",
//                "com.bben.lookboard.service.SeverSocket")));

//        startService(new Intent(this, NettyService.class));

        llLog.setOnClickListener(new AreaClickListener(5, 500, new AreaClickListener.ClickEvent() {
            @Override
            public void onEvent() {
                startActivityIn(new Intent(HomeActivity.this, SettingActivity.class), HomeActivity.this);
            }
        }));
//        initFree();
        homeActivity = this;
    }

    @OnClick({R.id.ll_theme})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_theme:
                changeThemeDialog();
                break;
        }
    }

    @Override
    protected void initTime(String date, String time) {
        if (tvDate != null)
            tvDate.setText(date + "   " + time);
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {
        tvDept.setText(PreferUtil.getInstance().getDeptName());
    }

    /**
     * 显示选择主题提示框
     */
    public Dialog changeThemeDialog() {
        hideChangeThemeDialog();
        View view = View.inflate(this, R.layout.dialog_theme, null);
        LinearLayout llNight = (LinearLayout) view.findViewById(R.id.ll_night);
        LinearLayout llRed = (LinearLayout) view.findViewById(R.id.ll_red);
        LinearLayout llGreen = (LinearLayout) view.findViewById(R.id.ll_green);
        LinearLayout llViolet = (LinearLayout) view.findViewById(R.id.ll_violet);
        themeDialog = new CustomDialog(this, view, R.style.MyDialog);
        themeDialog.show();
        themeDialog.setCancelable(true);

        llNight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_night));
                PreferUtil.getInstance().setThemeType("night");
                TodyWorkFragment.todyWorkFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_night));
                NursTrainFragment.nursTrainFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_night));
                themeDialog.dismiss();
            }
        });
        llRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinCompatManager.getInstance().restoreDefaultTheme();
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4));
                PreferUtil.getInstance().setThemeType("def");
                TodyWorkFragment.todyWorkFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4));
                NursTrainFragment.nursTrainFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4));
                themeDialog.dismiss();
            }
        });
        llGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinCompatManager.getInstance().loadSkin("green", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_green));
                PreferUtil.getInstance().setThemeType("green");
                TodyWorkFragment.todyWorkFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_green));
                NursTrainFragment.nursTrainFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_green));
                themeDialog.dismiss();
            }
        });
        llViolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SkinCompatManager.getInstance().loadSkin("violet", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                tabLayout.setBackgroundColor(getResources().getColor(R.color.color_44A4E4_violet));
                PreferUtil.getInstance().setThemeType("violet");
                TodyWorkFragment.todyWorkFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_violet));
                NursTrainFragment.nursTrainFragment.setTabLayoutTheme(getResources().getColor(R.color.color_44A4E4_violet));
                themeDialog.dismiss();
            }
        });

        return themeDialog;
    }

    /**
     * 隐藏选择主题提示框
     */
    public void hideChangeThemeDialog() {
        if (themeDialog != null && themeDialog.isShowing()) {
            themeDialog.dismiss();
            themeDialog = null;
        }
    }

    private void initFree(){
        //初始化 开放版 无调度 直接指定Server地址
        XHCustomConfig customConfig =  XHCustomConfig.getInstance();
        customConfig.setAppId(CommonUtil.getIP());
        customConfig.setChatroomServerUrl("192.168.1.9:19906");
        customConfig.setLiveSrcServerUrl("192.168.1.9:19931");
        customConfig.setLiveVdnServerUrl("192.168.1.9:19925");
        customConfig.setImServereUrl("192.168.1.9:19903");
        customConfig.setVoipServerUrl("192.168.1.9:10086");

        customConfig.initSDKForFree(this, CommonUtil.getIP(), new IXHErrorCallback() {
            @Override
            public void error(final String errMsg, Object data) {
                Logger.e(errMsg);
            }
        },new Handler());

        customConfig.setDefConfigOpenGLESEnable(false);
        XHClient.getInstance().getChatManager().addListener(new XHChatManagerListener());
        XHClient.getInstance().getGroupManager().addListener(new XHGroupManagerListener());
        XHClient.getInstance().getVoipManager().addListener(new XHVoipManagerListener());
        XHClient.getInstance().getVoipP2PManager().addListener(new XHVoipP2PManagerListener());
        XHClient.getInstance().getLoginManager().addListener(new XHLoginManagerListener());
        XHBeautyManager.getInstance().setBeautyDataCallback(new DemoBeautyCallback());

        //登录SDK 不需要验证用户权限
        XHClient.getInstance().getLoginManager().loginFree(new IXHResultCallback() {
            @Override
            public void success(Object data) {
                Logger.e("StarRTC登陆成功");
            }
            @Override
            public void failed(final String errMsg) {
                Logger.e("StarRTC登陆失败");
            }
        });
    }
}
