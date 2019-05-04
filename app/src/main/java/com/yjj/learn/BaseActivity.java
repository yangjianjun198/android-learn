package com.yjj.learn;

import androidx.appcompat.app.AppCompatActivity;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 * created by yangjianjun on 2019/3/23
 */
public class BaseActivity extends AppCompatActivity implements CustomAdapt {
    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    @Override
    public float getSizeInDp() {
        return 375;
    }
}
