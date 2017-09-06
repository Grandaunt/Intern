package com.example.win.newintern3.UI.MainModule.AIntern;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DateDialog;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


public class BusinessTripActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private TextView businesstrip_people;       //请假人
    private EditText complan;                   //实习企业
    private TextView starttime;                 //开始时间
    private TextView endtime;                   //结束时间
    private EditText goon;                      //去向
    private EditText tel;                       //联系方式
    private EditText body;                      //出差原因
//    private Button submit;                      //提交

    private MyApplication application;
    private DateDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_trip);
        application = (MyApplication) getApplication();
        findview();
    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("出差");

        businesstrip_people = (TextView) findViewById(R.id.text_abt_businesstrip_people);
        complan = (EditText) findViewById(R.id.text_abt_company);
        starttime = (TextView) findViewById(R.id.text_abt_starttime);
        endtime = (TextView) findViewById(R.id.text_abt_endtime);
        goon = (EditText) findViewById(R.id.text_abt_goon);
        tel = (EditText) findViewById(R.id.text_abt_tel);
        body = (EditText) findViewById(R.id.text_abt_body);
//        submit = (Button) findViewById(R.id.btn_abt_submit);
        save =  (TextView) findViewById(R.id.text_save);
        save.setText("提交");

        starttime.setOnClickListener(this);
        endtime.setOnClickListener(this);
//        submit.setOnClickListener(this);
        save.setOnClickListener(this);
//        goon.setOnClickListener(this);

        businesstrip_people.setText(application.getUserLoginMainEntity().getUserLogin().getUserBaseInfo().getTrueName());
        complan.setText(application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName());

        dateDialog = new DateDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_abt_starttime:
                dateDialog.setting(starttime, TimeUtils.getCurrentTimeInString(), null);
                break;
            case R.id.text_abt_endtime:
                dateDialog.setting(endtime, starttime.getText().toString(), null);
                break;
//            case R.id.btn_abt_submit:
//                DoBusinessTrip();
//                break;
            case R.id.text_save:
                DoBusinessTrip();
                break;
        }
    }

    private void DoBusinessTrip() {
        if (starttime.getText().length() > 0
                && endtime.getText().length() > 0
                && goon.getText().length() > 0
                && tel.getText().length() > 0
                && body.getText().length() > 0) {
            RequestParams params = new RequestParams(URLConfig.BudinessAPI);
            params.addParameter("UserId",  application.getUserid());
            params.addParameter("leaveDes", body.getText().toString());
            params.addParameter("leaveStartTime",  starttime.getText());
            params.addParameter("leaveEndTime",endtime.getText());
            params.addParameter("leaveToAddress", goon.getText().toString());
            params.addParameter("leaveToAddress", goon.getText().toString());
            params.addParameter("practiceId",  application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId());
            params.addParameter("userTel",  tel.getText());
            Logger.d(params);
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Logger.d(s);
                    if (!TextUtils.isEmpty(s)) {
                        if (s.equals("{\"code\":\"200\"}")) {
                            Toast.makeText(BusinessTripActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(BusinessTripActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
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

        }

        else{
            Toast.makeText(BusinessTripActivity.this, "请完善内容后提交", Toast.LENGTH_SHORT).show();
        }

    }
}
