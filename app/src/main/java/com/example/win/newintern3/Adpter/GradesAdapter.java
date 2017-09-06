package com.example.win.newintern3.Adpter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.win.newintern3.Entity.SchoolGradesEntity;
import com.example.win.newintern3.UI.FourModule.SchoolInfoActivity;

import java.util.List;

/**
 * Created by win on 2017/8/22.
 */

public class GradesAdapter extends RecyclerView.Adapter {
    private SchoolInfoActivity onRecyclerViewItemClickListener;
    private List<SchoolGradesEntity.GradesEntity> newData;

    public GradesAdapter(Object o) {


    }

    public void setOnRecyclerViewItemClickListener(SchoolInfoActivity onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setNewData(List<SchoolGradesEntity.GradesEntity> newData) {
        this.newData = newData;
    }
}
