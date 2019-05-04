package com.yjj.learn;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * created by yangjianjun on 2019/4/23
 */
public class ScrollTestActivity extends BaseActivity {
    private View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_test);
        contentView = findViewById(R.id.content);
        findViewById(R.id.scroll).setOnClickListener(v -> {
            contentView.offsetLeftAndRight(10);
            Log.d("yjj", "scrollX = " + contentView.getScrollX() + ";scrollY=" + contentView.getScrollY());
            Log.d("yjj", "leftX = " + contentView.getLeft() + ";leftY=" + contentView.getRight());
        });
        TextView textView = new TextView(this);
        textView.setText("测试宽度");
        textView.measure(0,0);
        Log.d("yjj","measure width "+textView.getMeasuredWidth());
    }
}
