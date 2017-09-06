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
import com.example.win.newintern3.Utils.KeyBoardUtil;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * 请假
 */
public class AskForLeaveActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView back;
    private TextView title;

    private MyApplication application;

    private TextView leaveofabsence;//请假人
    private EditText company;//实习企业
    private TextView starttime;//开始时间
    private TextView endtime;//结束时间
    private EditText goon;//去向
    private EditText tel;//联系方式
    private EditText body;//请假事由
    private TextView submit;//提交

    private DateDialog dateDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_leave);
        application = (MyApplication) getApplication();
        findview();
    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        setSupportActionBar(toolbar);
        title.setText("请假");
        back.setOnClickListener(this);

        dateDialog = new DateDialog(this);

        leaveofabsence = (TextView) findViewById(R.id.text_asfl_leaveofabsence);
        leaveofabsence.setText(application.getUserLoginMainEntity().getUserLogin().getUserBaseInfo().getTrueName());
        company = (EditText) findViewById(R.id.text_asfl_company);
        company.setText(application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName());
        starttime = (TextView) findViewById(R.id.text_asfl_starttime);
        endtime = (TextView) findViewById(R.id.text_asfl_endtime);
        goon = (EditText) findViewById(R.id.text_asfl_goon);
        tel = (EditText) findViewById(R.id.text_asfl_tel);
        body = (EditText) findViewById(R.id.text_asfl_body);
        submit = (TextView) findViewById(R.id.text_save);
        submit.setText("提交");
        starttime.setOnClickListener(this);
        endtime.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
//            case R.id.btn_asfl_submit:
//                DoSubmit();
//                break;
            case R.id.text_save:
                DoSubmit();
                break;
            case R.id.text_asfl_starttime:
                KeyBoardUtil.getInstance(AskForLeaveActivity.this).hide();
                dateDialog.setting(starttime, TimeUtils.getCurrentTimeInString(), null);
                break;
            case R.id.text_asfl_endtime:

                KeyBoardUtil.getInstance(AskForLeaveActivity.this).hide();
                dateDialog.setting(endtime, starttime.getText().toString(), null);
                break;
        }
    }

    private void DoSubmit() {
        if (leaveofabsence.getText().length() > 0
                && company.getText().length() > 0
                && starttime.getText().length() > 0
                && endtime.getText().length() > 0
                && goon.getText().length() > 0
                && tel.getText().length() > 0
                && body.getText().length() > 0) {
            RequestParams params = new RequestParams(URLConfig.AskForLeaveAPI);
            params.addParameter("userId",  application.getUserid());
            params.addParameter("leaveDes", body.getText().toString());
            params.addParameter("leaveStartTime",  starttime.getText());
            params.addParameter("leaveEndTime",endtime.getText());
            params.addParameter("leaveToAddress", goon.getText().toString());
            params.addParameter("leaveToAddress", goon.getText().toString());
            params.addParameter("checker","0");
            params.addParameter("checkStatus","0");
            params.addParameter("practiceId",  application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId());
            params.addParameter("userTel",  tel.getText());
            Logger.d(params);
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Logger.d(s);
                    if (!TextUtils.isEmpty(s)) {

                        if (s.equals("{\"code\":\"200\"}")) {
                            Toast.makeText(AskForLeaveActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(AskForLeaveActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(AskForLeaveActivity.this, "请完善内容后提交", Toast.LENGTH_SHORT).show();
        }

    }
}
