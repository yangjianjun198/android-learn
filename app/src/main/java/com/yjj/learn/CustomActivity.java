package com.yjj.learn;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import androidx.annotation.Nullable;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * created by yangjianjun on 2019/4/20
 */
public class CustomActivity extends BaseActivity {
    private Messenger messenger;
    private Messenger replyMessenger;

    public void onRequestLayout(View view) {
        ((ViewGroup) findViewById(R.id.my)).forceLayout();
        Log.d("yjj","ceshi");

    }

    public void onInvlitate(View view) {
        findViewById(R.id.my).invalidate();
        Intent serviceIntent = new Intent(this, MyMessengerService.class);
        replyMessenger = new Messenger(new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 2) {
                    Bundle data = (Bundle) msg.obj;
                    Toast.makeText(CustomActivity.this,data.getString("key") , Toast.LENGTH_SHORT).show();
                }
                super.handleMessage(msg);
            }
        });
        bindService(serviceIntent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("CustomActivity","CustomActivity  CustomActivity " +  service);
                messenger = new Messenger(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
    }

    public void sendMessage(View view) {
        if (messenger != null) {
            Message msg = Message.obtain();
            msg.what = 1;
            msg.replyTo = replyMessenger;
            try {
                messenger.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
    }

    public void handle(View view) {
        String url = "http://www.qq.com";
        Cache cache = new Cache(new File(this.getFilesDir().getAbsolutePath() + "/okhttp"), 100 * 1024 *1024);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().cache(cache).build();
        final Request request = new Request.Builder().url(url).get()//默认就是GET请求，可以不写
            .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("yjj", "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("yjj", "onResponse: " + response.body().string());
            }
        });
    }
}
