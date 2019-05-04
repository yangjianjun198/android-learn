package com.yjj.learn;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * created by yangjianjun on 2019/4/20
 */
public class MyMessengerService extends Service {
    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.d("MyMessengerService", "handleMessage");
                    Message replyMsg = Message.obtain();
                    replyMsg.what = 2;
                    Bundle data = new Bundle();
                    data.putString("key","回复内容");
                    replyMsg.obj = data;
                    try {
                        msg.replyTo.send(replyMsg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IBinder binder = new Messenger(messageHandler).getBinder();
        Log.d("MyMessengerService", "onBind " +binder);
        return binder;
    }
}
