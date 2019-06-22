package com.bben.lookboard.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.bben.lookboard.ui.activity.HomeActivity;


//开机自启动广播接受
public class AutoStartBroadcastReceiver extends BroadcastReceiver {

    static final String action_boot = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive( Context context, Intent intent) {
        if (intent.getAction().equals(action_boot)){
            Intent sayHelloIntent=new Intent(context,HomeActivity.class);
            sayHelloIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(sayHelloIntent);
        }
    }
}