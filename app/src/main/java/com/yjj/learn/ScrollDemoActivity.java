package com.yjj.learn;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

/**
 * created by yangjianjun on 2019/3/25
 */
public class ScrollDemoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_demo);
        NestedScrollView scrollView = findViewById(R.id.scroll);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.d("yjj", "scrollY" + scrollY);
            }
        });
    }
}
