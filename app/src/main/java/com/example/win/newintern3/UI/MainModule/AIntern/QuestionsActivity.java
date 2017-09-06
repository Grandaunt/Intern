package com.example.win.newintern3.UI.MainModule.AIntern;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;



/***
 * 问答
 */
public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private Toolbar toolbar;
    private TextView title;
    private TextView save;
    private ImageView back;

    private EditText mTitle;
    private EditText body;
    private RadioGroup group;

//    private Button submit;

    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        application = (MyApplication) getApplication();
        findview();
    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("问答");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("提交");
        save.setOnClickListener(this);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        mTitle = (EditText) findViewById(R.id.edt_aq_title);
        body = (EditText) findViewById(R.id.edt_aq_body);
        group = (RadioGroup) findViewById(R.id.radio_urgent);
        group.setOnCheckedChangeListener(this);

//
//        submit = (Button) findViewById(R.id.btn_aq_submit);
//        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                if (mTitle.getText().toString().length() > 0
                        && body.getText().toString().length() > 0) {
                    RequestParams params = new RequestParams(URLConfig.QuestionsAPI);
//                    params.addParameter("action", "publishquestion");
                    params.addParameter("questionUserId",  application.getUserid());
                    params.addParameter("questionTitle", mTitle.getText().toString());
                    params.addParameter("questionContent",body.getText().toString());
                    params.addParameter("isOver","0");
                    params.addParameter("questionLevel",group.getCheckedRadioButtonId()==R.id.radio1?"2":"0");
                    Logger.d(params);
                    x.http().post(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            Logger.d(s);
                            if (!TextUtils.isEmpty(s)) {
                                if (s.equals("{\"code\":\"200\"}")) {
                                    Toast.makeText(QuestionsActivity.this, "问题提交成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                }else{
                                    Toast.makeText(QuestionsActivity.this, "问题提交失败", Toast.LENGTH_SHORT).show();
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
                else {
                    Toast.makeText(QuestionsActivity.this, "请完善信息后提交", Toast.LENGTH_SHORT).show();

                }


                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio1:
                ((RadioButton)findViewById(R.id.radio1)).setTextColor(getResources().getColor(R.color.colorPrimary));
                ((RadioButton)findViewById(R.id.radio2)).setTextColor(getResources().getColor(R.color.gray9));
                break;
            case R.id.radio2:
                ((RadioButton)findViewById(R.id.radio2)).setTextColor(getResources().getColor(R.color.colorPrimary));
                ((RadioButton)findViewById(R.id.radio1)).setTextColor(getResources().getColor(R.color.gray9));
                break;
        }
    }
}
