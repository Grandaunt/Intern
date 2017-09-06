package com.example.win.newintern3.Adpter;


import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Entity.AllEducationInfoEndtity;

import java.util.List;


/**
 * Created by TAO_SX on 2016/5/6/006.
 */
public class StudyAdapter   extends BaseQuickAdapter<AllEducationInfoEndtity.EducationEntity.CategoryinfoEntity> {
    public StudyAdapter(int layoutResId, List<AllEducationInfoEndtity.EducationEntity.CategoryinfoEntity> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, AllEducationInfoEndtity.EducationEntity.CategoryinfoEntity item,int positions) {

    }
}