//package com.example.win.newintern3.UI.FourModule;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.lzy.okhttputils.OkHttpUtils;
//import com.lzy.okhttputils.cache.CacheMode;
//import com.lzy.okhttputils.callback.AbsCallback;
//
//import cn.czhj.intern.BaseApplication;
//import cn.czhj.intern.Entity.ApplyInfo;
//import cn.czhj.intern.R;
//import cn.czhj.intern.Utils.BuildConfig;
//import cn.czhj.intern.Utils.JsonUtils;
//import okhttp3.Call;
//import okhttp3.Request;
//import okhttp3.Response;
//
///***
// * 我的申请详情
// */
//public class LookOverApplyPracticeActivity extends AppCompatActivity implements View.OnClickListener {
//    public static final String AppyId = "appyid";
//    private Toolbar toolbar;
//    private ImageView back;
//    private TextView title;
//
//    private TextView plan_name;             //计划名字
//    private TextView company_name;          //企业名字
//    private TextView apply_time;            //申请时间
//    private TextView apply_result_time;     //审批时间
//    private TextView approval_people;       //审批人
//    private TextView approval_result;       //审批结果
//    private TextView apply_advice;          //申请意见
//    private TextView apply_office;          //实习岗位
//    private TextView apply_city;            //实习城市
//    private TextView start_time;            //开始时间
//    private TextView end_time;              //结束时间
//    private TextView address;               //详细地址
//    private TextView tutor_name;            //导师姓名
//    private TextView tutor_tel;             //导师电话
//
//    private BaseApplication application;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_look_over_apply_practice);
//        application = (BaseApplication) getApplication();
//        findview();
//        getdata();
//    }
//
//    private void getdata() {
//        OkHttpUtils.post(BuildConfig.MyAPI)
//                .tag(this)
//                .cacheKey("apply_info")
//                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
//                .params("userId", application.getUserid())
//                .params("action", "applyinfo")
//                .params("applyId", getIntent().getStringExtra(AppyId))
//                .execute(new ApplyCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, ApplyInfo applyInfo, Request request, @Nullable Response response) {
//                        if (applyInfo != null) {
//                            if (applyInfo.getCode().equals("200")) {
//                                plan_name.setText("计划名字: " + applyInfo.getPostinfo().getPracticeName());
//                                company_name.setText("企业名字: " + applyInfo.getPostinfo().getCompanyName());
//                                apply_time.setText("申请时间: " + applyInfo.getPostinfo().getApplyTime());
//                                apply_result_time.setText("审批时间: " + (applyInfo.getPostinfo().getCheckTime() == null ? "-" : applyInfo.getPostinfo().getCheckTime()));
//                                approval_people.setText("审  批  人: " + (applyInfo.getPostinfo().getChecker() == null ? "-" : applyInfo.getPostinfo().getChecker()));
//                                approval_result.setText("审批结果: " + (applyInfo.getPostinfo().getApplyStatus() == 1 ? "待审核" : applyInfo.getPostinfo().getApplyStatus() == 2 ? "审核通过" : "审核驳回"));
//                                apply_advice.setText("申请意见: \n" + (applyInfo.getPostinfo().getCheckDes() == null ? "-" : applyInfo.getPostinfo().getCheckDes()));
//                                apply_office.setText("实习岗位: " + applyInfo.getPostinfo().getPracticePost());
//                                apply_city.setText("实习城市: " + applyInfo.getPostinfo().getPracticeAddress());
//                                start_time.setText("开始时间: " + applyInfo.getPostinfo().getPracticeStartTime());
//                                end_time.setText("结束时间: " + applyInfo.getPostinfo().getPracticeEndTime());
//                                address.setText("详细地址: " + applyInfo.getPostinfo().getCompanyName());
//                                tutor_name.setText("导师姓名: " + (applyInfo.getPostinfo().getCompanyTeacher() == null ? "-" : applyInfo.getPostinfo().getCompanyTeacher()));
//                                tutor_tel.setText("联系电话: " + (applyInfo.getPostinfo().getCompanyTeacherTel() == null ? "-" : applyInfo.getPostinfo().getCompanyTeacherTel()));
//
//                            } else if (applyInfo.getCode().equals("500")) {
//                                Toast.makeText(LookOverApplyPracticeActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//                            } else if (applyInfo.getCode().equals("505")) {
//                                Toast.makeText(LookOverApplyPracticeActivity.this, "服务器错误 请稍后重试", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(isFromCache, call, response, e);
//                        Toast.makeText(LookOverApplyPracticeActivity.this, getResources().getString(R.string.network_error), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
//
//    private abstract class ApplyCallBack extends AbsCallback<ApplyInfo> {
//        @Override
//        public ApplyInfo parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s, ApplyInfo.class);
//        }
//    }
//
//    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        back = (ImageView) findViewById(R.id.img_back);
//        title = (TextView) findViewById(R.id.text_title);
//        title.setText("申请详情");
//        back.setOnClickListener(this);
//
//        plan_name = (TextView) findViewById(R.id.text_aloap_plan_name);
//        company_name = (TextView) findViewById(R.id.text_aloap_company_name);
//        apply_time = (TextView) findViewById(R.id.text_aloap_apply_time);
//        apply_result_time = (TextView) findViewById(R.id.text_aloap_apply_result);
//        approval_people = (TextView) findViewById(R.id.text_aloap_approval_people);
//        approval_result = (TextView) findViewById(R.id.text_aloap_approval_result);
//        apply_advice = (TextView) findViewById(R.id.text_aloap_apply_advice);
//        apply_office = (TextView) findViewById(R.id.text_aloap_apply_office);
//        apply_city = (TextView) findViewById(R.id.text_aloap_apply_city);
//        start_time = (TextView) findViewById(R.id.text_aloap_practice_start_time);
//        end_time = (TextView) findViewById(R.id.text_aloap_practice_end_time);
//        address = (TextView) findViewById(R.id.text_aloap_more_address);
//        tutor_name = (TextView) findViewById(R.id.text_aloap_tutor_name);
//        tutor_tel = (TextView) findViewById(R.id.text_aloap_tutor_city);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_back:
//                finish();
//                break;
//        }
//    }
//
//
//}
