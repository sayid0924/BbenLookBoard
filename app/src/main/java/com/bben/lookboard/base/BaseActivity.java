package com.bben.lookboard.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bben.lookboard.R;
import com.bben.lookboard.bean.SettingEvenBus;
import com.bben.lookboard.ui.activity.MainActivity;
import com.bben.lookboard.ui.activity.VoipRingingActivity;
import com.bben.lookboard.utils.MediaPlayerThread;
import com.bben.lookboard.utils.startRTC.AEvent;
import com.bben.lookboard.utils.startRTC.IEventListener;
import com.bben.lookboard.view.SwipeBackActivity.SwipeBackActivity;
import com.bben.lookboard.view.SwipeBackActivity.SwipeBackLayout;
import com.bben.lookboard.view.dialog.CustomDialog;
import com.blankj.utilcode.utils.EmptyUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.protocol.CancelVoiceResponse;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends SwipeBackActivity  implements IEventListener {

    private SwipeBackLayout mSwipeBackLayout;
    private Unbinder bind;
    private CustomDialog mDialogWaiting;
    //    public static UDPMessageListener listener = UDPMessageListener.getInstance();
    private PopupWindow p;
    private PopupWindow logPw;
//    private UDPMessage message;

    private TextView tvToggle, tvClientId;

    private MediaPlayerThread mediaPlayerThread;


    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initTime(TimeUtils.getNowTimeString("EEEE yyyy-MM-dd"), TimeUtils.getNowTimeString("HH:mm:ss"));
                    break;
                case 2:
//                    BaseMsg baseMsg = (BaseMsg) msg.obj;
//                    VoiceResponse voiceResponse = (VoiceResponse) baseMsg;
//                    showToggleRingDidlog(voiceResponse.getBedInfo(), baseMsg.getIp());
//                    if (mediaPlayerThread == null) {
//                        mediaPlayerThread = MediaPlayerThread.getInstance(BaseActivity.this);
//                    }
//                    mediaPlayerThread.playUrl(1);

                    break;
                case 3:
                    hideWaitingDialog();

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(getLayoutId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏

        bind = ButterKnife.bind(this);
        //沉浸式状态栏
//        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark), 10);
        attachView();
        initView();

        EventBus.getDefault().register(this);
        BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(TimeTask(), 0, 1, TimeUnit.SECONDS);
        BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(UpaddteDate(), 0, 5, TimeUnit.MINUTES);

    }


    public Runnable TimeTask() {
        return new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
    }

    public Runnable UpaddteDate() {
        return new Runnable() {
            @Override
            public void run() {
                if (EmptyUtils.isNotEmpty(MainActivity.mainActivity)) {
                    MainActivity.mainActivity.bedcardGetbedinfo();
                }
            }
        };
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {

    }

    @Subscribe
    public void getEventBus(BaseMsg baseMsg) {

        Message message = handler.obtainMessage();
        switch (baseMsg.getType()) {
            case VOICE:  //  有床头卡在呼叫
                Logger.e("有床头卡在呼叫    ");
                message.what = 2;
                message.obj = baseMsg;
                handler.sendMessage(message);

                break;
            case CANCEL_VOICE:   ///   取消呼叫
                CancelVoiceResponse cancelVideoResponse = (CancelVoiceResponse) baseMsg;
                Logger.e("CANCEL_VOICE    ");
                message.what = 3;
                handler.sendMessage(message);
                break;
        }
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, final Object eventObj) {
        switch (aEventID){
            case AEvent.AEVENT_VOIP_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_REV_CALLING);

                Intent intent = new Intent(BaseActivity.this,VoipRingingActivity.class);
                intent.putExtra("targetId",eventObj.toString());
                startActivity(intent);


                break;
            case AEvent.AEVENT_VOIP_P2P_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_P2P_REV_CALLING);
                break;
            case AEvent.AEVENT_C2C_REV_MSG:
                Logger.e(AEvent.AEVENT_C2C_REV_MSG);
                break;
            case AEvent.AEVENT_GROUP_REV_MSG:
                Logger.e(AEvent.AEVENT_GROUP_REV_MSG);
                break;
            case AEvent.AEVENT_USER_OFFLINE:
                Logger.e(AEvent.AEVENT_USER_OFFLINE);
                break;
            case AEvent.AEVENT_USER_ONLINE:
//                Logger.e(AEvent.AEVENT_USER_ONLINE);
                break;
        }
    }

    private void addListener(){
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.addListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.addListener(AEvent.AEVENT_GROUP_REV_MSG,this);
        AEvent.addListener(AEvent.AEVENT_USER_ONLINE,this);
        AEvent.addListener(AEvent.AEVENT_USER_OFFLINE,this);
    }
    private void removeListener(){
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.removeListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.removeListener(AEvent.AEVENT_GROUP_REV_MSG,this);
        AEvent.removeListener(AEvent.AEVENT_USER_ONLINE,this);
        AEvent.removeListener(AEvent.AEVENT_USER_OFFLINE,this);
    }



    @Override
    protected void onResume() {
        super.onResume();
        addListener();
    }

    public void onPause() {
        super.onPause();
        removeListener();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
//        synchronized (mActivities) {
//            mActivities.remove(this);
//        }
        if (bind != null)
            bind.unbind();
        detachView();
//        BaseApplication.getRefWatcher().watch(this);
    }

    @SuppressWarnings("deprecation")
    public void initSwipeBackLayout() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    public void setEdgeTrackingEnabled(int size, int position) {
        if (size == 0) {
        }
        // 只有一个fragment  - 左右滑关闭
        else if (size == 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
        }
        // 多个fragment  - 位于左侧尽头 - 只可左滑关闭
        else if (size != 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        }
        // 多个fragment  - 位于右侧尽头 - 只可右滑关闭
        else if (size != 1 && position == size - 1) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);
        }
        // 多个fragment  - 位于中间 - 屏蔽所有左右滑关闭事件
        else {
            mSwipeBackLayout.setEdgeTrackingEnabled(0);
        }
    }

    protected void finishActivity() {
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    public void startActivityIn(Intent intent, Activity curAct) {
        if (intent != null) {
            curAct.startActivity(intent);
            curAct.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        finishActivity();
    }

    /**
     * 显示等待提示框
     */
    public Dialog showWaitingDialog(String tip) {
        hideWaitingDialog();
        View view = View.inflate(this, R.layout.dialog_waiting, null);
        if (!TextUtils.isEmpty(tip))
            ((TextView) view.findViewById(R.id.tvTip)).setText(tip);
        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
        mDialogWaiting.show();
        mDialogWaiting.setCancelable(true);
        return mDialogWaiting;
    }

    /**
     * 隐藏等待提示框
     */
    public void hideWaitingDialog() {
        if (mediaPlayerThread != null && mediaPlayerThread.isPlay()) {
            mediaPlayerThread.stop();
            mediaPlayerThread=null;
        }
        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            mDialogWaiting = null;
        }
    }


    /**
     * 隐藏呼叫护士对话框
     */
    public void hideToggleRingDidlog() {
        if (p != null && p.isShowing()) {
            p.dismiss();
        }
    }

    /**
     * 呼叫护士对话框
     */
    public void showToggleRingDidlog(String text, final String ClientId) {
//        hideWaitingDialog();
//        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_toggle_ring, null);
//
//        tvToggle = view.findViewById(R.id.tv_toggle);
//        tvClientId = view.findViewById(R.id.tv_ClientId);
//        tvToggle.setText(text);
//        tvClientId.setText(ClientId);
//        Button btnCancel = view.findViewById(R.id.btn_cancel);
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideWaitingDialog();
//                NettyService.sendCancelVoiceData(ClientId);
//            }
//        });
//        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
//        mDialogWaiting.show();
//        mDialogWaiting.setCancelable(false);
//        mDialogWaiting.show();

    }

    public abstract int getLayoutId();

    public abstract void attachView();

    public abstract void detachView();

    public abstract void initView();

    protected void initTime(String date, String time) {
    }

}
