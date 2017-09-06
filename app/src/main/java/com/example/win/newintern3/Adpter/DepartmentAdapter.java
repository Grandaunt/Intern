package com.example.win.newintern3.Adpter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.win.newintern3.Entity.SchoolDepartmentEntity;
import com.example.win.newintern3.UI.FourModule.SchoolInfoActivity;

import java.util.List;

/**
 * Created by win on 2017/8/22.
 */

public class DepartmentAdapter extends RecyclerView.Adapter {
    private List<SchoolDepartmentEntity.DepartmentEntity> newData;
    private SchoolInfoActivity onRecyclerViewItemClickListener;

    public DepartmentAdapter(Object o) {

    }

    public void setNewData(List<SchoolDepartmentEntity.DepartmentEntity> newData) {
        this.newData = newData;
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

    public void setOnRecyclerViewItemClickListener(SchoolInfoActivity onRecyclerViewItemClickListener) {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
