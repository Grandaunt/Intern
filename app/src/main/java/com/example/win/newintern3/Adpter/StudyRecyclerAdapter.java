//package com.example.win.newintern3.Adpter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.win.newintern3.Entity.AllEducationInfoEndtity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import cn.czhj.intern.Entity.AllEducationInfoEndtity;
//import cn.czhj.intern.R;
//import cn.czhj.intern.Widgets.LeftLineTextView;
//import cn.czhj.intern.Widgets.NoScrollGridView;
//
//import static com.baidu.location.h.i.R;
//
///**
// * Created by TAO_SX on 2016/5/6/006.
// */
//public class StudyRecyclerAdapter extends RecyclerView.Adapter<StudyRecyclerAdapter.ViewHolder> {
//    private Context context;
//    private StudyAdapter studyAdapter;
//
//    public StudyRecyclerAdapter(Context context){
//        this.context = context;
//    }
//
//    private List<AllEducationInfoEndtity.EducationEntity> education = new ArrayList<>();
//    private OnItemClickListener mOnItemClickListener = null;
//
//    public interface OnItemClickListener {
//        public void OnMore(String title, String categoryId);
//        public void OnGrid(AllEducationInfoEndtity.EducationEntity.EducationinfoEntity item);
//
//
//    }
//
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.mOnItemClickListener = listener;
//    }
//
//    public void setData(List<AllEducationInfoEndtity.EducationEntity> data){
//        this.education.clear();
//        this.education = data;
//        notifyDataSetChanged();
//    }
//
//    //创建新的View,被LayoutManager所调用
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//    //与界面数据进行绑定
//    @Override
//    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.Ltext_name.setText(getItem(position).getCategoryinfo().getCategoryTitle());
//        studyAdapter = new StudyAdapter(context,getItem(position).getEducationinfo());
//        if (mOnItemClickListener != null) {
//            holder.text_more.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnItemClickListener.OnMore(getItem(position).getCategoryinfo().getCategoryTitle(),
//                            String.valueOf(getItem(position).getCategoryinfo().getCategoryId()));
//                }
//            });
//            studyAdapter.setOnItemClickListener(new cn.czhj.intern.UI.StartPractice.PrejobTraining.Adapter.OnItemClickListener<AllEducationInfoEndtity.EducationEntity.EducationinfoEntity>() {
//                @Override
//                public void onClick(View view, AllEducationInfoEndtity.EducationEntity.EducationinfoEntity item) {
//                    mOnItemClickListener.OnGrid(item);
//                }
//            });
//        }
//        holder.Ngrid_content.setAdapter(studyAdapter);
//
//    }
//
//    //获取数据的数量
//    @Override
//    public int getItemCount() {
//        return education.size();
//    }
//
//    public AllEducationInfoEndtity.EducationEntity getItem(int position) {
//        return education.get(position);
//    }
//
//    //自定义的ViewHolder，持有每个Item的的所有界面元素
//    public static class ViewHolder extends RecyclerView.ViewHolder{
//        public LeftLineTextView Ltext_name;
//        public NoScrollGridView Ngrid_content;
//        public TextView text_more;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            Ltext_name = (LeftLineTextView) itemView.findViewById(R.id.text_item_name);
//            Ngrid_content = (NoScrollGridView) itemView.findViewById(R.id.grid_item_content);
//            text_more = (TextView) itemView.findViewById(R.id.text_item_more);
//        }
//    }
//}
