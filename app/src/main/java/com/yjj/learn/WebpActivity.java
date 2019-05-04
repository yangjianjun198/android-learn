package com.yjj.learn;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * created by yangjianjun on 2019/3/23
 */
public class WebpActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webp);
    }

    private void makeManyString() {
        for (int i = 0; i < 1024 * 1024; i++) {
            new String("我是的值的");
        }
    }
}
