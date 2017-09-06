package com.example.win.newintern3.Test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.win.newintern3.R;
import com.example.win.newintern3.Widgets.ItemDivider;


/**
 * Describe the function of the class
 *
 * @author zhujinlong@ichoice.com
 * @date 2016/10/28
 * @time 15:31
 * @description Describe the place where the class needs to pay attention.
 */
public class LinearManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        RecyclerView re = (RecyclerView) findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
        re.addItemDecoration(new ItemDivider().setDividerWith(2).setDividerColor(Color.MAGENTA));
        re.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false)) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView tv = (TextView) holder.itemView.findViewById(android.R.id.text1);
            tv.setText(String.valueOf(position));
//            holder.itemView.setBackgroundColor(Color.BLUE);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
