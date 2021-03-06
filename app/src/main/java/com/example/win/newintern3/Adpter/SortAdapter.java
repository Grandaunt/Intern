package com.example.win.newintern3.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.win.newintern3.Entity.CityEntity;
import com.example.win.newintern3.NewEntity.CityInfo;
import com.example.win.newintern3.R;

import java.util.List;



public class SortAdapter extends BaseAdapter implements SectionIndexer {
    private List<CityEntity.CitylistEntity> list = null;
    private Context mContext;
    private OnCityClickListener onCityClickListener;

    public SortAdapter(Context mContext, List<CityEntity.CitylistEntity> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public void changeData(List<CityEntity.CitylistEntity> data){
        if (this.list == null){
            this.list = data;
        }else{
            this.list.clear();
            this.list.addAll(data);
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder = null;
        final CityEntity.CitylistEntity mContent = list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_select_city, null);
            viewHolder.tvTitle = (TextView) view.findViewById(R.id.tv_city_name);
            viewHolder.tvLetter = (TextView) view.findViewById(R.id.tv_catagory);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        int section = getSectionForPosition(position);

        if (position == getPositionForSection(section)) {
            viewHolder.tvLetter.setVisibility(View.VISIBLE);
            viewHolder.tvLetter.setText(mContent.getFirstChar());
        } else {
            viewHolder.tvLetter.setVisibility(View.GONE);
        }

        viewHolder.tvTitle.setText(this.list.get(position).getCityName());

        if (onCityClickListener != null) {
            viewHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCityClickListener.onCityClick(((CityEntity.CitylistEntity) getItem(position)));
                }
            });
        }

        return view;

    }


    final static class ViewHolder {
        TextView tvLetter;
        TextView tvTitle;
    }

    /**
     * 获取字母索引的位置
     * @param position
     * @return
     */
    public int getSectionForPosition(int position) {
        return list.get(position).getFirstChar().charAt(0);
    }


    public int getPositionForSection(int section) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getFirstChar();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }

        return -1;
    }


    @Override
    public Object[] getSections() {
        return null;
    }

    public void setOnCityClickListener(OnCityClickListener listener){
        this.onCityClickListener = listener;
    }

    public interface OnCityClickListener{
        void onCityClick(CityEntity.CitylistEntity name);
    }
}