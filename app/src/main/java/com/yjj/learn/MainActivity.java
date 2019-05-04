package com.yjj.learn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yjj.TestActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter();
        addCaseEntryList();
        recyclerView.setAdapter(adapter);
    }

    private void addCaseEntryList() {
        List<CaseEntry> caseEntries = new ArrayList<>(16);
        caseEntries.add(new CaseEntry("测试Fragment", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, FragmentDemoActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试webp", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, WebpActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试inflater", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, InflaterDemoActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试bolts", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, BoltsTaskDemoActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试scroll", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, ScrollDemoActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试布局更新", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, CustomActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试scroll", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, ScrollTestActivity.class);
                context.startActivity(intent);
            }
        }));
        caseEntries.add(new CaseEntry("测试bsdiff", new CaseEntry.Action() {
            @Override
            public void onDo(Context context) {
                Intent intent = new Intent(context, TestActivity.class);
                context.startActivity(intent);
            }
        }));
        adapter.caseEntries = caseEntries;
    }

    static class Adapter extends RecyclerView.Adapter<MyViewHolder> {
        private List<CaseEntry> caseEntries = new ArrayList<>();

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final CaseEntry caseEntry = caseEntries.get(position);
            holder.titleView.setText(caseEntry.title);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (caseEntry.action != null) {
                        caseEntry.action.onDo(v.getContext());
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return caseEntries.size();
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.title);
        }
    }
}
