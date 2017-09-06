package com.example.win.newintern3.UI.FourModule;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.Adpter.ViewPageAdapter;
import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.NewEntity.WeekReportBack;
import com.example.win.newintern3.NewEntity.WeekReportInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.MainModule.AIntern.InWeeklyFragment;
import com.example.win.newintern3.Utils.DividerItemDecoration;
import com.example.win.newintern3.Utils.logger.Logger;

import java.util.List;


/***
 * 周报详情
 */
public class WeeklyInfoActivity extends AppCompatActivity implements View.OnClickListener, InWeeklyFragment.OnFragmentInteractionListener {
    public static  String intenttag1 = "weeklyId";
//    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private TextView post;          //工作岗位
    private TextView address;       //工作地点
    private TabLayout tabLayout;    //
    private ViewPager pager;        //
    private TextView summary;       //工作小结
    private TextView plan;          //下周计划
    private TextView num;           //点评条数
    private RecyclerView recycler;  //点评

    private WeeklyInfoAdapter adapter;

    private WeekReportInfo data = null;
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_info);
        application = (MyApplication) getApplication();
        data = (WeekReportInfo) getIntent().getSerializableExtra(intenttag1);
        if (data == null) {
            data = new WeekReportInfo();
        }

        findview();
    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("周报详情");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");

        post = (TextView) findViewById(R.id.text_awi_post);
        post.setText(data.getWeekpost());

        address = (TextView) findViewById(R.id.text_awi_address);
        address.setText(data.getWeekReportAddressText());

        tabLayout = (TabLayout) findViewById(R.id.tab_awi_tab);
        pager = (ViewPager) findViewById(R.id.page_awi_journal);
        summary = (TextView) findViewById(R.id.edt_awi_summary);
        summary.setText(data.getWeekReportExperience());

        plan = (TextView) findViewById(R.id.edt_awi_plan);
        plan.setText(data.getNextWeekPlan());

        num = (TextView) findViewById(R.id.text_evaluation_num);
        num.setText("共"+data.getWeekReportBackList().size()+"条评论");

        recycler = (RecyclerView) findViewById(R.id.recycler_awi_evaluation);
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        pager.setOffscreenPageLimit(5);
        tabLayout.addTab(tabLayout.newTab().setText("周一"));
        tabLayout.addTab(tabLayout.newTab().setText("周二"));
        tabLayout.addTab(tabLayout.newTab().setText("周三"));
        tabLayout.addTab(tabLayout.newTab().setText("周四"));
        tabLayout.addTab(tabLayout.newTab().setText("周五"));
        setupViewPager(pager);
        tabLayout.setupWithViewPager(pager);

        adapter = new WeeklyInfoAdapter(data.getWeekReportBackList());
        recycler.setAdapter(adapter);
    }

    private void setupViewPager(ViewPager mViewPager) {
        //如果Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
        InWeeklyFragment f1 = InWeeklyFragment.newInstance(1, data.getMondayContent(),true, this);
        InWeeklyFragment f2 = InWeeklyFragment.newInstance(2, data.getTuesdayContent(),true, this);
        InWeeklyFragment f3 = InWeeklyFragment.newInstance(3, data.getWednesdayContent(),true, this);
        InWeeklyFragment f4 = InWeeklyFragment.newInstance(4, data.getThursdayContent(),true, this);
        InWeeklyFragment f5 = InWeeklyFragment.newInstance(5, data.getFridayContent(),true, this);

        adapter.addFragment(f1, "周一");
        adapter.addFragment(f2, "周二");
        adapter.addFragment(f3, "周三");
        adapter.addFragment(f4, "周四");
        adapter.addFragment(f5, "周五");

        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(int type, String s) {
        Logger.d(s);
    }




    private class WeeklyInfoAdapter extends BaseQuickAdapter<WeekReportBack> {
        public WeeklyInfoAdapter(List<WeekReportBack> data) {
            super(R.layout.item_journal_evaluation, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, WeekReportBack item,int positions) {
            helper
//                    .setText(R.id.text_evaluation_name, item.getUserName())
//                    .setText(R.id.text_evaluation_time, item.getBackTime())
                    .setText(R.id.text_evaluation_body, item.getBackContent());
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
