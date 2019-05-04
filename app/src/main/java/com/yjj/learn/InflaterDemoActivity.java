package com.yjj.learn;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yjj.learn.view.MyView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * created by yangjianjun on 2019/3/23
 */
public class InflaterDemoActivity extends BaseActivity {
    private LayoutInflater.Factory2 delegate;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(this);

        inflater.setFactory2(new LayoutInflater.Factory2() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                Log.d("yjj", "name = " + name);
                count++;
                return null;
            }

            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                Log.d("yjj", "name = " + name);
                count++;
                return null;
            }
        });
        super.onCreate(savedInstanceState);
        delegate = inflater.getFactory2();
        setContentView(R.layout.activity_inflater);
        Toast.makeText(this,"inflate count "+count,Toast.LENGTH_SHORT).show();

        //RecyclerView container = findViewById(R.id.container);
        //container.setLayoutManager(new LinearLayoutManager(this));
        //container.setAdapter(new Adapter());

        ViewGroup containerView = findViewById(R.id.container);
        containerView.addView(new MyView(this));
        View view = containerView.getChildAt(0);
    }

    static class Adapter extends RecyclerView.Adapter<ViewHolder> {
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.view_inflater, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
