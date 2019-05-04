package com.yjj.learn;

import android.content.Context;

/**
 * created by yangjianjun on 2019/3/23
 * 测试入口
 */
public class CaseEntry {
    public String title;
    public Action action;

    public CaseEntry(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    public static interface Action {
        void onDo(Context context);
    }
}
