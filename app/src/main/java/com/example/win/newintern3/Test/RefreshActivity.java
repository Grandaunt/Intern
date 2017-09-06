package com.example.win.newintern3.Test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.win.newintern3.R;
import com.example.win.newintern3.Widgets.ItemDivider;
import com.example.win.newintern3.Widgets.SuperRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class RefreshActivity extends AppCompatActivity {

    SuperRefreshLayout refreshLayout;
    RecyclerView recyclerView;
    MyAdapter adapter;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        refreshLayout = (SuperRefreshLayout) findViewById(R.id.refresh);
        recyclerView = (RecyclerView) findViewById(R.id.re);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new ItemDivider());
        adapter = new MyAdapter();
        refreshLayout.setAdapter(recyclerView,adapter);
        refreshLayout.setOnRefreshHandler(new SuperRefreshLayout.OnRefreshHandler() {
            @Override
            public void refresh() {
                flag = 0;
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> datas = new ArrayList<>();
                        for (int i = 0; i < 30; i++) {
                            datas.add("DATA: " + i);
                        }
                        adapter.setDatas(datas);
                        refreshLayout.setRefreshing(false);
                    }
                },1500);

            }

            @Override
            public void loadMore() {
                super.loadMore();
                flag ++;
                refreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(flag % 3 == 2){
                            refreshLayout.loadError();
                        }else if(flag % 3 == 1){
                            List<String> datas = new ArrayList<>();
                            for (int i = 0; i < 10; i++) {
                                datas.add("ADD: " + i);
                            }
                            adapter.addDatas(datas);
                            refreshLayout.loadComplete(true);
                        }else {
                            refreshLayout.loadComplete(false);
                        }
                    }
                },1000);


            }
        });
        refreshLayout.autoRefresh();
    }

    private class MyAdapter extends SuperRefreshLayout.Adapter {

        List<String> datas = new ArrayList<>();

        public void setDatas(List<String> datas) {
            this.datas = datas;
            notifyDataSetChanged();
        }

        public void addDatas(List<String> datas) {
            this.datas.addAll(datas);
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateItemHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_office_practice_page, parent, false)) {
            };
        }

        @Override
        public void onBindItemHolder(final RecyclerView.ViewHolder holder, int position) {
            TextView tv = (TextView) holder.itemView.findViewById(R.id.item_train_title);
            tv.setText(datas.get(position));
        }

        @Override
        public int getCount() {
            return datas.size();
        }
    }
}
