package com.example.win.newintern3.UI.MainModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.MainFragment.FourFragment;
import com.example.win.newintern3.UI.MainFragment.MainFragment;
import com.example.win.newintern3.UI.MainFragment.ThreeFragment;
import com.example.win.newintern3.UI.MainFragment.TwoFragment;
import com.example.win.newintern3.Utils.BottomNavigationViewHelper;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    public static String mpracticeLink = "practiceLink";
    @ViewInject(R.id.viewpager_main)
    ViewPager viewPager;
    @ViewInject(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        /*初始化显示内容*/

        final ArrayList<Fragment> fgLists = new ArrayList<>(4);
        fgLists.add(new MainFragment());
        fgLists.add(new TwoFragment());
        fgLists.add(new ThreeFragment());
        fgLists.add(new FourFragment());
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fgLists.get(position);
            }

            @Override
            public int getCount() {
                return fgLists.size();
            }
        };
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(3); //预加载剩下两页


//默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_main:
                        //主页
                        viewPager.setCurrentItem(0);
//                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_two:
                        //在线学习
                        viewPager.setCurrentItem(1);
//                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_three:
                        //圈子
                        viewPager.setCurrentItem(2);
//                        mNavTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_four:
                        //我的
                        viewPager.setCurrentItem(3);
//                        mNavTv.setText(item.getTitle());
                        break;
//                    case R.id.bottom_nav_media:
//                        mNavTv.setText(item.getTitle());
//                        break;
                }
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //禁止ViewPager滑动
//        viewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

//        setupViewPager(viewPager);

    }




}
