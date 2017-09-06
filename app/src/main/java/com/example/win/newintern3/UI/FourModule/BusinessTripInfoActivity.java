package com.example.win.newintern3.UI.FourModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;

import com.example.win.newintern3.NewEntity.DayReportinfo;
import com.example.win.newintern3.NewEntity.LeaveInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/***
 * 出差
 */
public class BusinessTripInfoActivity extends AppCompatActivity implements View.OnClickListener {
    public static  String intenttag1 = "leaveId";
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private EditText leaveofabsence;//出差人
    private EditText company;//实习企业
    private EditText starttime;//开始时间
    private EditText endtime;//结束时间
    private EditText goon;//去向
    private EditText tel;//联系方式
    private EditText body;//请假事由

    private LinearLayout view_back;//
    private EditText leaveback;//驳回理由
    private MyApplication application;
    private LeaveInfo data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_trip_info);
        application = (MyApplication) getApplication();
        data = (LeaveInfo) getIntent().getSerializableExtra(intenttag1);
        findview();
    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);

        title = (TextView) findViewById(R.id.text_title);
        title.setText("出差详情");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");

        leaveofabsence = (EditText) findViewById(R.id.text_asfli_leaveofabsence);
        company = (EditText) findViewById(R.id.text_asfli_company);
        starttime = (EditText) findViewById(R.id.text_asfli_starttime);
        endtime = (EditText) findViewById(R.id.text_asfli_endtime);
        goon = (EditText) findViewById(R.id.text_asfli_goon);
        tel = (EditText) findViewById(R.id.text_asfli_tel);
        body = (EditText) findViewById(R.id.text_asfli_body);

        view_back = (LinearLayout) findViewById(R.id.view_back);
        leaveback = (EditText) findViewById(R.id.text_asfli_back);


        leaveofabsence.setText(data.getUserId());
//        company.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getCompanyName());
        company.setText("");
        starttime.setText(data.getLeaveStartTime());
        endtime.setText(data.getLeaveEndTime());
        goon.setText(data.getLeaveToAddress());
        tel.setText(data.getUserTel());
        body.setText(data.getLeaveDes());
        leaveback.setText(data.getCheckDes());
        if (data.getChecker() != null && data.equals("3")) {
            view_back.setVisibility(View.VISIBLE);
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
