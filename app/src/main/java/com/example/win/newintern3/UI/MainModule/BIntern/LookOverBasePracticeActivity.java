package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.NewEntity.BasePost;
import com.example.win.newintern3.NewEntity.PracticeBase;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.x;

import java.util.List;


/**
 * 查看基地详情
 */
public class LookOverBasePracticeActivity extends AppCompatActivity implements View.OnClickListener {
    public static  String intenttag1 = "basePlanId";
    private Intent intent;

    private TextView save;
    private TextView title;
    private ImageView back;
    private String planId = "";

    private ImageView icon;          //公司LOGO
    private TextView text_name;             //公司名字
    private TextView text_scale;            //公司规模
    private TextView text_statistics;       //统计
    private TextView text_starttime;
    private TextView text_endtime;
    private TextView text_totalpeoplenum;   //实习人数
    private TextView text_stoptime;         //申请截至
    private TextView text_contacts;         //联系人
    private TextView text_contactsnumber;   //联系电话
    private TextView text_address;          //实习地点
    private TextView text_welfare;          //实习福利

    private RecyclerView recycle_info;

//    private TextView text_office_name;      //职位名称
//    private TextView text_peoplenum;        //招聘人数
//    private TextView text_treatment;        //公司待遇
//    private TextView text_claim;            //职位要求

    private Button btn_repost;

    private BaseInfoAdapter adapter;

    private MyApplication application;
    private PracticeBase mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_over_practice);
        application = (MyApplication) getApplication();
        mData = (PracticeBase) getIntent().getSerializableExtra(intenttag1);
        initView();
    }

    private void initView() {
        title = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.img_back);
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");
        title.setText("基地信息");
        back.setOnClickListener(this);

        btn_repost = (Button) findViewById(R.id.btn_alop_repost);
        btn_repost.setOnClickListener(this);

        icon = (ImageView) findViewById(R.id.img_alop_practice_icon);
        text_name = (TextView) findViewById(R.id.text_alop_practice_name);
        text_scale = (TextView) findViewById(R.id.text_alop_practice_scale);
        text_statistics = (TextView) findViewById(R.id.text_alop_practice_statistics);
        text_starttime = (TextView) findViewById(R.id.text_alop_practice_time_start);
        text_endtime = (TextView) findViewById(R.id.text_alop_practice_start_time_end);
//        text_totalpeoplenum = (TextView) findViewById(R.id.text_alop_practice_total_people_num);
//        text_stoptime = (TextView) findViewById(R.id.text_alop_practice_start_time_stop);
        text_contacts = (TextView) findViewById(R.id.text_alop_practice_contacts);
        text_contactsnumber = (TextView) findViewById(R.id.text_alop_practice_contact_number);
        text_address = (TextView) findViewById(R.id.text_alop_practice_address);
//        text_welfare = (TextView) findViewById(R.id.text_alop_practice_welfare);
//        text_office_name = (TextView) findViewById(R.id.text_alop_practice_office_name);
//        text_peoplenum = (TextView) findViewById(R.id.text_alop_practice_people_num);
//        text_treatment = (TextView) findViewById(R.id.text_alop_practice_treatment);
//        text_claim = (TextView) findViewById(R.id.text_alop_practice_claim);

        x.image().bind(icon, mData.getBaseIcon(), application.options);
        text_name.setText(mData.getCompanyName());
        text_scale.setText("公司规模 ："+"234人");
        text_statistics.setText("行业 ："+"互联网");
        text_starttime.setText("实习开始 ："+mData.getPracticePlan().getPlanStartTime());
        text_endtime.setText("实习结束 ："+mData.getPracticePlan().getPlanEndTime());
//        text_totalpeoplenum.setText(mData.getBaseIcon());
//        text_stoptime.setText(mData.getBaseIcon());
        text_contacts.setText("联系人 ："+mData.getContact());
        text_contactsnumber.setText("联系电话 ："+mData.getContactPhone());
        text_address.setText("实习地点 ："+mData.getAddress());
//        text_welfare.setText(mData.getBaseIcon());
        recycle_info = (RecyclerView) findViewById(R.id.recycle_alop_practice_info);
//        recycle_info.setNestedScrollingEnabled(true);
        recycle_info.setLayoutManager(new LinearLayoutManager(LookOverBasePracticeActivity.this));
        adapter = new BaseInfoAdapter(mData.getBasePostList());
        recycle_info.setAdapter(adapter);

//        if (mData.getBasePostList().getIsApply() == 0) {
//            btn_repost.setEnabled(true);
//        }
        Logger.i("mData.getCompanyId()="+mData.getBaseDes());

    }






    private class BaseInfoAdapter extends BaseQuickAdapter<BasePost> {

        public BaseInfoAdapter(List<BasePost> data) {
            super(R.layout.item_base_info, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, BasePost item,int positions) {
            //   text_office_name = (TextView) findViewById(R.id.text_alop_practice_office_name);
//        text_peoplenum = (TextView) findViewById(R.id.text_alop_practice_people_num);
//        text_treatment = (TextView) findViewById(R.id.text_alop_practice_treatment);
//        text_claim = (TextView) findViewById(R.id.text_alop_practice_claim);
            helper.setText(R.id.text_alop_practice_office_name, "职位名称: " + item.getPostName())
                    .setText(R.id.text_alop_practice_people_num, "招聘人数: " + item.getPostNum() + "人")
                    .setText(R.id.text_alop_practice_treatment, "公司待遇: " + item.getPostPay())
                    .setText(R.id.text_alop_practice_claim, "职位要求: \n" + item.getPostOrder())
                    .setText(R.id.text_alop_practice_post_claim, "岗位职责: \n" + item.getPostDuty())
                    .setText(R.id.text_alop_practice_welfare, "公司福利: \n" + item.getPostDuty());

        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back_coll:
                finish();
                break;

            case R.id.btn_alop_repost:
//                intent = new Intent(LookOverBasePracticeActivity.this, NewInternActivity.class);
//                                            intent.putExtra(NewInternActivity.SubmitType, "success");
//                                            finish();
//                                            startActivity(intent);
//                if (!planId.equals("")) {
//                    OkHttpUtils.post(BuildConfig.BasePracticeAPI)
//                            .tag(this)
//                            .params("userId", application.getUserid())
//                            .params("action", "applybase")
//                            .params("basePlanId", basePlanId)
//                            .params("planId", planId)
//                            .execute(new StringCallback() {
//                                @Override
//                                public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {
//                                    if (s != null && !s.equals("")) {
//
//                                        if (s.equals("{\"code\":\"200\"}")) {
//                                            intent = new Intent(LookOverBasePracticeActivity.this, SubmitResultsActivity.class);
//                                            intent.putExtra(SubmitResultsActivity.SubmitType, "success");
//                                            finish();
//                                            startActivity(intent);
//                                            Toast.makeText(LookOverBasePracticeActivity.this, "基地申请成功", Toast.LENGTH_SHORT).show();
//                                        } else if (s.equals("{\"code\":\"300\"}")) {
//                                            intent = new Intent(LookOverBasePracticeActivity.this, SubmitResultsActivity.class);
//                                            intent.putExtra(SubmitResultsActivity.SubmitType, "other");
//                                            finish();
//                                            startActivity(intent);
//                                            Toast.makeText(LookOverBasePracticeActivity.this, "已申请过该基地实习", Toast.LENGTH_SHORT).show();
//                                        } else if (s.equals("{\"code\":\"505\"}")) {
//                                            intent = new Intent(LookOverBasePracticeActivity.this, SubmitResultsActivity.class);
//                                            intent.putExtra(SubmitResultsActivity.SubmitType, "other");
//                                            finish();
//                                            startActivity(intent);
//                                            Toast.makeText(LookOverBasePracticeActivity.this, "服务器错误 请稍后重试", Toast.LENGTH_SHORT).show();
//                                        }
//
//                                    }
//                                }
//
//                                @Override
//                                public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//                                    super.onError(isFromCache, call, response, e);
//                                    Logger.e(e.getMessage());
//                                    Toast.makeText(LookOverBasePracticeActivity.this, getResources().getString(R.string.network_error), Toast.LENGTH_LONG).show();
//                                }
//                            });
//                }

                break;
        }
    }


}
