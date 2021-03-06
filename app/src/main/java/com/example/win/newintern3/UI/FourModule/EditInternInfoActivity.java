

package com.example.win.newintern3.UI.FourModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Entity.CodeEntity;
import com.example.win.newintern3.NewEntity.ExperiencePractice;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.YMDatePickerDialog;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EditInternInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private EditText name;
    private EditText post;
    private EditText starttime;
    private EditText endtime;
    private TextView tv_edit_pro_desc;

    private EditText des;

    private Button del;


    //0是编辑，1是添加
    private int type = 0;
    private ExperiencePractice internEntity;
    private MyApplication application;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_intern_info);
        application = (MyApplication) getApplication();
//        type = getIntent().getIntExtra("type", 0);
        findview();
        getData();
    }

    private void setinfo(){
        name.setText(internEntity.getCompanyName());
        post.setText(internEntity.getPracticePost());
        starttime.setText(internEntity.getPracticeStartTime()+" 入职");
        endtime.setText(internEntity.getPracticeEndTime()+" 离职");
        des.setText(internEntity.getPracticeDes());

    }


    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("实习信息");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("保存");
        save.setOnClickListener(this);

        name = (EditText) findViewById(R.id.edit_apei_name);
        post = (EditText) findViewById(R.id.edit_apei_post);
        starttime = (EditText) findViewById(R.id.edit_apei_starttime);
        starttime.setOnClickListener(this);
        endtime = (EditText) findViewById(R.id.edit_apei_endtime);
        endtime.setOnClickListener(this);
        tv_edit_pro_desc = (TextView) findViewById(R.id.tv_edit_pro_desc);
        tv_edit_pro_desc.setText("项目描述");
        des = (EditText) findViewById(R.id.edit_apei_des);

        del = (Button) findViewById(R.id.btn_apei_del);
        del.setText("删除实习信息");
        del.setOnClickListener(this);

//        add = (Button) findViewById(R.id.btn_apei_add);
//        add.setOnClickListener(this);
    }
    public void getData() {;
        if (getIntent().getSerializableExtra(EditInternListActivity.intenttag1)!= null) {
            internEntity = (ExperiencePractice) getIntent().getSerializableExtra(EditInternListActivity.intenttag1);
            setinfo();
            type = 0;
        }
        else {
            type = 1;
            del.setVisibility(View.GONE);

        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.edit_apei_starttime:
                Calendar intoschool = Calendar.getInstance();
                new YMDatePickerDialog(EditInternInfoActivity.this, 0, new YMDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                          int startDayOfMonth) {
                        String textString = String.format("%d-%02d", startYear,
                                startMonthOfYear + 1);
                        starttime.setText(textString+" 入职");
                        endtime.setText("");
                    }
                }, intoschool.get(Calendar.YEAR), intoschool.get(Calendar.MONTH), intoschool.get(Calendar.DATE)).show();

                break;
            case R.id.edit_apei_endtime:
                Calendar outschoold = Calendar.getInstance();
                Long min = 0L;
                try {
                    min = new SimpleDateFormat("yyyy-MM").parse(starttime.getText().toString()).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                new YMDatePickerDialog(EditInternInfoActivity.this, 0, new YMDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                          int startDayOfMonth) {
                        String textString = null;
                        textString = String.format("%d-%02d", startYear,
                                startMonthOfYear + 1);
                        endtime.setText(textString+" 离职");
                    }
                }, outschoold.get(Calendar.YEAR), outschoold.get(Calendar.MONTH), outschoold.get(Calendar.DATE), min, 0L).show();
                break;
            case R.id.btn_apei_del:
                RequestParams params = new RequestParams(URLConfig.DelInternErAPI);
                params.addParameter("practiceId",internEntity.getPracticeId());

                Logger.d(params);
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Logger.d(result);
                        CodeEntity code = JsonUtils.getPerson(result, CodeEntity.class);
                        if (code.getCode().equals("200")) {
                            setResult(1004);
                            finish();
                        }else{
                            Toast.makeText(EditInternInfoActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
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

                break;
            case R.id.text_save:
                if(type == 0) {
                    if (check()) {
                        //编辑
                        RequestParams params2 = new RequestParams(URLConfig.AddInternErAPI);
                        params2.addParameter("userId", application.getUserid());
                        params2.addParameter("userPracticeId", internEntity.getPracticeId());
                        params2.addParameter("companyId", "");
                        params2.addParameter("companyName", name.getText().toString().trim());
                        params2.addParameter("practicePost", post.getText().toString().trim());
                        params2.addParameter("practiceStartTime", starttime.getText().toString().trim());
                        params2.addParameter("practiceEndTime", endtime.getText().toString().trim());
                        params2.addParameter("practiceDes", des.getText().toString().trim());
                        Logger.d(params2);
                        x.http().post(params2, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {

                                Logger.d(result);
                                CodeEntity code = JsonUtils.getPerson(result, CodeEntity.class);
                                if (code.getCode().equals("200")) {
//                                    setResult(1004);
                                    Toast.makeText(EditInternInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(EditInternInfoActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
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
                }
                else{
                        if(check()) {
                            //新增
                            RequestParams params2 = new RequestParams(URLConfig.AddInternErAPI);
                            params2.addParameter("userId", application.getUserid());
                            params2.addParameter("companyName", name.getText().toString().trim());
                            params2.addParameter("practicePost", post.getText().toString().trim());
                            params2.addParameter("practiceStartTime", starttime.getText().toString().trim());
                            params2.addParameter("practiceEndTime", endtime.getText().toString().trim());
                            params2.addParameter("practiceDes", des.getText().toString().trim());
                            Logger.d(params2);
                            x.http().post(params2, new Callback.CommonCallback<String>() {
                                @Override
                                public void onSuccess(String result) {

                                    Logger.d(result);
                                    CodeEntity code = JsonUtils.getPerson(result, CodeEntity.class);
                                    if (code.getCode().equals("200")) {
//                                        setResult(1004);
                                        Toast.makeText(EditInternInfoActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                                        finish();
                                    } else {
                                        Toast.makeText(EditInternInfoActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
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

                   }
                break;

            default:
                break;
        }
    }

    private boolean check() {
        if (name.getText().length() > 0) {

        }else{
            Toast.makeText(EditInternInfoActivity.this, "信息不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (post.getText().length() > 0) {

        }else{
            Toast.makeText(EditInternInfoActivity.this, "信息不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (starttime.getText().length() > 0) {

        }else{
            Toast.makeText(EditInternInfoActivity.this, "信息不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (endtime.getText().length() > 0) {

        }else{
            Toast.makeText(EditInternInfoActivity.this, "信息不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
