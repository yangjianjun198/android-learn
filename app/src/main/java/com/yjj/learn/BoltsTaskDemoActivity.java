package com.yjj.learn;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.Nullable;
import bolts.Continuation;
import bolts.Task;

/**
 * created by yangjianjun on 2019/3/24
 */
public class BoltsTaskDemoActivity extends BaseActivity {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Task.call(new Callable<String>() {
            @Override
            public String call() {
                Log.d("yjj", "call---" + Thread.currentThread().getName());
                return "测试内容";
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<String, String>() {
            @Override
            public String then(Task<String> task) {
                Log.d("yjj", "then " + task.getResult());
                return null;
            }
        });
        Collection<Task<Object>> taskList = new ArrayList<>();
        taskList.add(Task.call(new Callable() {
            @Override
            public Object call() throws Exception {

                Thread.sleep(10000);
                Log.d("yjj", "call 1" + Thread.currentThread().getName());
                return null;
            }
        }, Task.BACKGROUND_EXECUTOR));
        taskList.add(Task.call(new Callable() {
            @Override
            public Object call() throws Exception {

                Thread.sleep(5000);
                Log.d("yjj", "call 2" + Thread.currentThread().getName());
                return null;
            }
        }, Task.BACKGROUND_EXECUTOR));

        Task.whenAny(taskList).continueWith(new Continuation() {
            @Override
            public Object then(Task task) throws Exception {
                Log.d("yjj","continue "+Thread.currentThread().getName());
                return null;
            }
        },executorService);

    }
}
