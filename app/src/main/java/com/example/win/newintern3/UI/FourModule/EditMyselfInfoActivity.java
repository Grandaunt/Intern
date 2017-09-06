package com.example.win.newintern3.UI.FourModule;

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
import com.example.win.newintern3.Entity.CodeEntity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class EditMyselfInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private EditText  et_edit_myself_des;
    private String content;
    private MyApplication application;
    public static  String intenttag1 = "EditMyselfId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_myself_info);
        application = (MyApplication) getApplication();
        if (getIntent().getStringExtra(intenttag1)!= null) {
            content = getIntent().getStringExtra(intenttag1);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("自我评价");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("保存");
        save.setOnClickListener(this);
        et_edit_myself_des  = (EditText) findViewById(R.id.et_edit_myself_des);
        et_edit_myself_des.setText(content);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:

//                     //保存操作
                if (!TextUtils.isEmpty(et_edit_myself_des.getText())) {
                    RequestParams params = new RequestParams(URLConfig.AddResumeBaseInfoAPI);
                    params.addParameter("userId", application.getUserid());
                    params.addParameter("resumeSelfDes", et_edit_myself_des.getText());
                    Logger.d(params);
                    x.http().post(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            Logger.d(result);
                            if (result.equals("{\"code\":\"200\"}")) {
                                Toast.makeText(EditMyselfInfoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                                setResult(1000);
                                finish();
                            } else if (result.equals("{\"code\":\"450\"}")) {
                                Toast.makeText(EditMyselfInfoActivity.this, "重复提交", Toast.LENGTH_SHORT).show();
                            } else if (result.equals("{\"code\":\"505\"}")) {
                                Toast.makeText(EditMyselfInfoActivity.this, "信息更新失败", Toast.LENGTH_SHORT).show();
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

            default:
                break;
        }
    }
}
