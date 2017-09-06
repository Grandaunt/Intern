package com.example.win.newintern3.UI.FourModule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.BaseActivity;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.Entity.CityEntity;
import com.example.win.newintern3.Entity.CodeEntity;
import com.example.win.newintern3.NewEntity.ExperienceEducation;
import com.example.win.newintern3.NewEntity.Resumeinfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.MainModule.AIntern.SignInActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.FastCityActivity;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.logger.Logger;


import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;

public class EditUserBaseInfoActivity extends BaseActivity implements View.OnClickListener {
    public static String intenttag1 = "EditUserBaseInfoId";
    private Resumeinfo mData = null;


    private static final int REQUEST_SELECT_PICTURE = 0x01;


    private ImageView back;
    private TextView title;
    private TextView save;

//    private ImageView icon;
    private EditText name;
    private RadioGroup gender;
    private RadioButton rb1;
    private RadioButton rb2;
    private EditText direction;//行业方向( •̀ ω •́ )✧
//    private EditText company;//公司(＃°Д°)
    private EditText post;//职位( •̀ ω •́ )y
//    private EditText position;//工作地区
    private EditText address;//详细地址
//    private CheckBox status;//是否毕业

    private EditText tel;//手机号
    private EditText email;

    private int cityId = 0;

    private Intent intent;

    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_base_info);
        mData = (Resumeinfo) getIntent().getSerializableExtra(intenttag1);
        application = (MyApplication) getApplication();
        findview();
        if (mData != null) {
            initdata();
        }
    }

    private void findview() {

        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("个人信息");
        save = (TextView) findViewById(R.id.text_save);
        save.setOnClickListener(this);
        save.setText("保存");

//        icon = (ImageView) findViewById(R.id.img_auir_icon);
//        icon.setOnClickListener(this);
        name = (EditText) findViewById(R.id.edit_auir_name);
        gender = (RadioGroup) findViewById(R.id.radio_auir_gender);
        rb1 = (RadioButton) findViewById(R.id.radio1);
        rb2 = (RadioButton) findViewById(R.id.radio2);
        direction = (EditText) findViewById(R.id.edit_auir_industry_direction);
//        company = (EditText) findViewById(R.id.edit_auir_company);
        post = (EditText) findViewById(R.id.edit_auir_post);
//        position = (EditText) findViewById(R.id.edit_auir_position);
        address = (EditText) findViewById(R.id.edit_auir_address);
//        status = (CheckBox) findViewById(R.id.chb_auir_status);
        tel = (EditText) findViewById(R.id.edit_auir_tel);
        email = (EditText) findViewById(R.id.edit_auir_email);

    }

    private void initdata() {
        if (!TextUtils.isEmpty(mData.getUserName())) {
            name.setText(mData.getUserName());
        }
        if (!TextUtils.isEmpty(mData.getResumeMale())) {
            if (mData.getResumeMale().equals("0")) {
                gender.check(R.id.radio2);
            } else {
                gender.check(R.id.radio1);
            }
        }
        if (!TextUtils.isEmpty(mData.getResumeTrade())) {
            direction.setText(mData.getResumeTrade());
        }
//        if (!TextUtils.isEmpty(mData.getCompanyName())) {
//            company.setText(mData.getCompanyName());
//        }
        if (!TextUtils.isEmpty(mData.getResumepost())) {
            post.setText(mData.getResumepost());
        }
//        if (!TextUtils.isEmpty(mData.getResumeAddress())) {
//            position.setText(mData.getResumeAddress());
//        }
//        position.setOnClickListener(this);
//        cityId = mData.getResumeCityID();
        if (!TextUtils.isEmpty(mData.getResumeAddress())) {
            address.setText(mData.getResumeAddress());
        }
//        if (mData.getUserStatus() == 1) {
//            status.setChecked(true);
//        }
        if (!TextUtils.isEmpty(mData.getResumeTel())) {
            tel.setText(mData.getResumeTel());
        }
        if (!TextUtils.isEmpty(mData.getResumeEmile())) {
            email.setText(mData.getResumeEmile());
        }

    }




    private boolean check() {
        if (name.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (direction.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (company.getText().length() > 0) {
//
//        } else {
//            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (post.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (position.getText().length() > 0) {
//
//        } else {
//            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (address.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tel.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.getText().length() > 0) {

        } else {
            Toast.makeText(this, "请检查信息完整", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                //保存操作
                if (check()) {
                        RequestParams params = new RequestParams(URLConfig.AddResumeBaseInfoAPI);
                        params.addParameter("resumeId", mData.getResumeId());
                        params.addParameter("userId", application.getUserid());
                        params.addParameter("userName", name.getText().toString().trim());
                        params.addParameter("resumeMale", rb1.isChecked() ? "1" : "0");
                        params.addParameter("resumeTrade", direction.getText().toString().trim());
                        params.addParameter("resumepost", post.getText().toString());
                        params.addParameter("resumeAddress", address.getText().toString().trim());
                        params.addParameter("resumeTel", tel.getText().toString().trim());
                        params.addParameter("resumeEmile", email.getText().toString());
                        Logger.d(params);
                        x.http().post(params, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                Logger.d(result);
                                if (result.equals("{\"code\":\"200\"}")) {
                                    Toast.makeText(EditUserBaseInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                    setResult(1000);
                                    finish();
                                } else if (result.equals("{\"code\":\"450\"}")) {
                                    Toast.makeText(EditUserBaseInfoActivity.this, "重复提交", Toast.LENGTH_SHORT).show();
                                } else if (result.equals("{\"code\":\"505\"}")) {
                                    Toast.makeText(EditUserBaseInfoActivity.this, "信息更新失败", Toast.LENGTH_SHORT).show();
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

                break;
//            case R.id.edit_auir_position:
//                intent = new Intent(this, FastCityActivity.class);
//                startActivityForResult(intent, 0);
//                break;
        }
    }


}
