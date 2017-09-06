package com.example.win.newintern3.Adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by win on 2017/8/14.
 */

public class GuideFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> list;

    public GuideFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public GuideFragmentAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.list=list;
    }//写构造方法，方便赋值调用
    @Override
    public Fragment getItem(int arg0) {
        return list.get(arg0);
    }//根据Item的位置返回对应位置的Fragment，绑定item和Fragment

    @Override
    public int getCount() {
        return list.size();
    }//设置Item的数量

}