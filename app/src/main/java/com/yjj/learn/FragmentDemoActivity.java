package com.yjj.learn;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;

/**
 * created by yangjianjun on 2019/3/23
 */
public class FragmentDemoActivity extends BaseActivity {
    RecyclerView view;
    private boolean isHide = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (!isHide) {
                    transaction.add(R.id.fragment_container, new Fragment(), "cc");
                } else {
                    transaction.replace(R.id.fragment_container,new Fragment());
                }
                isHide = !isHide;
                transaction.commit();
            }
        });
    //    getLifecycle().addObserver(new Life());
      //  getLifecycle().addObserver(new MyLife());
        Log.d("yjjxxx","onCreate this "+this + this.isChangingConfigurations());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Log.d("yjjxxx","" +(new Handler().getLooper().getQueue() == new Handler().getLooper().getQueue()));
        }
    }


    static class Life implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void onCreate() {
            Log.d("yjj", "oncreate");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        void onResume() {
            Log.d("yjj", "onResume");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        void onPause() {
            Log.d("yjj","onPause");
        }
    }

    @Override
    protected void onDestroy() {
        Log.d("yjjxxx","onDestroy this "+this + "  "+this.isChangingConfigurations());
        super.onDestroy();
    }
}
