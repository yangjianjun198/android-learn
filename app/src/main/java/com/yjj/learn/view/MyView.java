package com.yjj.learn.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.yjj.learn.R;

import androidx.annotation.Nullable;

/**
 * created by yangjianjun on 2019/3/23
 */
public class MyView extends LinearLayout {
    public MyView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_inflater_test, this, true);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        LayoutInflater.from(context).inflate(R.layout.view_inflater_test, this, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("yjjMyView","onDraw====");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d("yjjMyView","dispatchDraw====");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Log.d("yjjMyView","onLayout====");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("yjjMyView","onMeasure====");
    }
}
