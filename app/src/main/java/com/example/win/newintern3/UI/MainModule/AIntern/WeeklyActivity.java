package com.example.win.newintern3.UI.MainModule.AIntern;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Adpter.ViewPageAdapter;
import com.example.win.newintern3.Base.LocationBaseAvtivity;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.NewEntity.PracticePlan;
import com.example.win.newintern3.NewEntity.WeekReportInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DateDialog;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.KeyBoardUtil;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;



public class WeeklyActivity extends LocationBaseAvtivity implements View.OnClickListener, InWeeklyFragment.OnFragmentInteractionListener, View.OnTouchListener {

    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private EditText post;
    private EditText address;
    private TabLayout tab;
    private ViewPager pager;
    private EditText summary;
    private EditText plan;
    private Button submit;
    private TextView startTime;
    private TextView endTime;
    private DateDialog dateDialog;

    private ScrollView scrollView;

    private MyApplication application;

    private WeekReportInfo w = new WeekReportInfo();
    private PracticePlan practiceplan = null;//记录当前计划

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly);
        application = (MyApplication) getApplication();

        findview();


    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("周报");
        save= (TextView) findViewById(R.id.text_save);
        save.setText("提交");
        save.setOnClickListener(this);
        dateDialog = new DateDialog(this);
        post = (EditText) findViewById(R.id.text_aw_post);
        address = (EditText) findViewById(R.id.text_aw_address);
        startTime = (TextView) findViewById(R.id.text_weekly_starttime);
        endTime = (TextView) findViewById(R.id.text_weekly_endtime);

        tab = (TabLayout) findViewById(R.id.tab_aw_tab);
        pager = (ViewPager) findViewById(R.id.page_aw_journal);
        pager.setOffscreenPageLimit(5);
        tab.addTab(tab.newTab().setText("周一"));
        tab.addTab(tab.newTab().setText("周二"));
        tab.addTab(tab.newTab().setText("周三"));
        tab.addTab(tab.newTab().setText("周四"));
        tab.addTab(tab.newTab().setText("周五"));
        setupViewPager(pager);
        tab.setupWithViewPager(pager);


        summary = (EditText) findViewById(R.id.edt_aw_summary);
        plan = (EditText) findViewById(R.id.edt_aw_plan);
//        submit = (Button) findViewById(R.id.btn_aw_submit);
//        submit.setOnClickListener(this);

        scrollView = (ScrollView) findViewById(R.id.scroll);
        scrollView.setOnTouchListener(this);
//        scrollView.getParent().requestDisallowInterceptTouchEvent(true);
        startTime.setOnClickListener(this);
        endTime.setOnClickListener(this);
    }


    private void setupViewPager(ViewPager mViewPager) {


        //如果Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
//
        adapter.addFragment(new InWeeklyFragment().newInstance(1,  "" , false, this), "周一");
        adapter.addFragment(new InWeeklyFragment().newInstance(2, "", false, this), "周二");
        adapter.addFragment(new InWeeklyFragment().newInstance(3, "", false, this), "周三");
        adapter.addFragment(new InWeeklyFragment().newInstance(4, "", false, this), "周四");
        adapter.addFragment(new InWeeklyFragment().newInstance(5, "", false, this), "周五");
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
//            case R.id.btn_aw_submit:
//                submit();
//                break;
            case R.id.text_save:
                submit();
                break;
            //开始实习时间
            case R.id.text_weekly_starttime:
                KeyBoardUtil.getInstance(WeeklyActivity.this).hide();
                dateDialog.setting(startTime, TimeUtils.getCurrentTimeInString(),null );
                endTime.setText("");
                break;
            //结束实习时间
            case R.id.text_weekly_endtime:
                KeyBoardUtil.getInstance(WeeklyActivity.this).hide();
                if (startTime.getText().toString().length() > 0) {
                    dateDialog.setting(endTime, startTime.getText().toString(),null);
                }else{
                    Toast.makeText(WeeklyActivity.this, "请先选择开始实习时间", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }



    private void submit() {

        if (address.getText().length() > 0
                && w.getMondayContent().length() > 0
                && w.getTuesdayContent().length() > 0
                && w.getWednesdayContent().length() > 0
                && w.getThursdayContent().length() > 0
                && w.getFridayContent().length() > 0
                && post.getText().length() > 0
                && summary.getText().length() > 0
                && plan.getText().length() > 0) {
            RequestParams params = new RequestParams(URLConfig.WeekAPI);
//            params.addParameter("action", "publishweekreport");
            params.addParameter("UserId",  application.getUserid());
            params.addParameter("weekpost", post.getText().toString());
            params.addParameter("practiceId", String.valueOf(application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId()));
            params.addParameter("weekreportExperience", summary.getText().toString());
            params.addParameter("nextWeekPlan", plan.getText().toString());
            params.addParameter("SignAddress", mAddress);
            params.addParameter("weekreportAddressText", address.getText().toString());
            params.addParameter("mondayContent", w.getMondayContent());
            params.addParameter("tuesdayContent", w.getTuesdayContent());
            params.addParameter("wednesdayContent", w.getWednesdayContent());
            params.addParameter("thursdayContent", w.getThursdayContent());
            params.addParameter("fridayContent", w.getFridayContent());
            Logger.d(params);
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Logger.d(s);
                    if (!TextUtils.isEmpty(s)) {
                        if (s.equals("{\"code\":\"200\"}")) {
                            Toast.makeText(WeeklyActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } if (s.equals("{\"code\":\"450\"}")) {
                            Toast.makeText(WeeklyActivity.this, "重复提交", Toast.LENGTH_SHORT).show();
                            finish();
                        }else {
                            Toast.makeText(WeeklyActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    Logger.d(ex);
                }
                @Override
                public void onCancelled(CancelledException cex) {
                }
                @Override
                public void onFinished() {
                }
            });
        }else{
            Toast.makeText(WeeklyActivity.this, "内容为空", Toast.LENGTH_SHORT).show();
        }

    }

    //文字输入注册的回调
    @Override
    public void onFragmentInteraction(int type, String s) {
        switch (type) {
            case 1:
//                Logger.d("周一：" + s);
                w.setMondayContent(s);
                break;
            case 2:
//                Logger.d("周二：" + s);
                w.setTuesdayContent(s);
                break;
            case 3:
//                Logger.d("周三：" + s);
                w.setWednesdayContent(s);
                break;
            case 4:
//                Logger.d("周四：" + s);
                w.setThursdayContent(s);
                break;
            case 5:
//                Logger.d("周五：" + s);
                w.setFridayContent(s);
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Logger.i("======dispatchTouchEvent======ACTION_DOWN==");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.i("======dispatchTouchEvent======ACTION_MOVE==");
                break;
            case MotionEvent.ACTION_UP:
                Logger.i("======dispatchTouchEvent======ACTION_UP==");
                break;
        }
        return false;
    }
}
