package com.bben.lookboard.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.bben.lookboard.utils.CrashHandler;
import com.bben.lookboard.utils.GreenDaoUtil;
import com.bben.lookboard.utils.PreferUtil;
import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.blankj.utilcode.utils.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;


public class BaseApplication extends Application {

    private static Context mContext;//上下文
//    private RefWatcher mRefWatcher;
    private  static  BaseApplication instance = null;

    /**
     * 获取BaseApplication实例
     *
     * @return
     */
    public static ThreadPoolUtils MAIN_EXECUTOR = new ThreadPoolUtils(ThreadPoolUtils.Type.FixedThread, 5);

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        initLogger();
        Utils.init(this);
        PreferUtil.getInstance().init(this);
        CrashHandler.getInstance(this).init();
        GreenDaoUtil.initDataBase(getApplicationContext());
//        mRefWatcher =  LeakCanary.install(this);
        instance = this;

        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();

    }

    public static BaseApplication getInstance() {
        return instance;
    }

//    public static RefWatcher getRefWatcher() {
//        return getInstance().mRefWatcher;
//    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initLogger() {
        Logger.init("ART").methodCount(2).methodOffset(0).logLevel(LogLevel.FULL).hideThreadInfo();
    }
}
