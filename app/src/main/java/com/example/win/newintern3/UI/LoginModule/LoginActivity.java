package com.example.win.newintern3.UI.LoginModule;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.NewEntity.UserBaseInfo;
import com.example.win.newintern3.NewEntity.UserLogin;
import com.example.win.newintern3.NewEntity.UserLoginMainEntity;
import com.example.win.newintern3.NewEntity.UserPractice;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.MainModule.MainActivity;
import com.example.win.newintern3.Utils.ACache;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  implements View.OnClickListener{
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView  save;
    private EditText edt_username;
    private EditText edt_code;
    private Button sendcode;
    private Button btn_ok;
    private MyApplication application;
    private int MessageResult = 0;
    private ACache aCache;
    private Gson gson;
    private String sendTel = "";//记录发送短信的手机号码，避免受到短信后更改手机号码


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        application = (MyApplication) getApplication();
        aCache = ACache.get(this);
        findview();

    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        save =  (TextView) findViewById(R.id.text_save);
        back.setVisibility(View.GONE);
        title.setText("登录");
        save.setText("");
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_code = (EditText) findViewById(R.id.edt_code);
        sendcode = (Button) findViewById(R.id.btn_send_code);
        btn_ok = (Button) findViewById(R.id.btn_al_ok);
        sendcode.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
          //发送短信验证码
            case R.id.btn_send_code:
                if (edt_username.getText().length() == 11) {
                    sendTel = "";
//                    sendMessage();
                }else{
                    Toast.makeText(LoginActivity.this, "不符合手机号长度", Toast.LENGTH_SHORT).show();
                }
                break;
            //登录
            case R.id.btn_al_ok:
                if (edt_username.getText().length() <= 0) {
                    Toast.makeText(LoginActivity.this, "登陆用户为空", Toast.LENGTH_SHORT).show();
                    return;
                }else
                if (edt_code.getText().length() <= 0) {
                    Toast.makeText(LoginActivity.this, "验证码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Login();
                }

                break;
               default:
                   break;
        }
    }



    /**
     * 登录
     */
    private void Login() {
        RequestParams params = new RequestParams(URLConfig.LoginAPI);
//        params.addParameter("mobile",edt_username.getText().toString());
//        params.addParameter("action","login");
//        params.addParameter("password",edt_code.getText().toString());
//        params.addParameter("actionAddress", "0,0");
//        params.addParameter("networkType","1");
//        params.addParameter("loginType","1");
//        params.addParameter("JGID","1");
//        params.addParameter("deviceType","Android");
        params.addParameter("UserName",edt_username.getText().toString());
        params.addParameter("Password",edt_code.getText().toString());
//        params.setCacheMaxAge(100000 * 60);
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
//                UserLoginEntity Entity  = JsonUtils.getPerson(result, UserLoginEntity.class);
                ServiceEntity<UserLoginMainEntity> Entity  = JsonUtils.getServiceEntity(result, UserLoginMainEntity.class);
                if (Entity.getCode().equals("200")) {
                    application.setUserLoginMainEntity(Entity.getEntity());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    if (Entity.getEntity().getIsHasUserPractice().equals("0")) {
                        intent.putExtra(MainActivity.mpracticeLink, 0);
                    } else {
                        intent.putExtra(MainActivity.mpracticeLink, 1);
                    }
                    aCache.put(MyApplication.userinfo,  Entity.getEntity());
                    Logger.d(Entity.getEntity());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    Logger.d("登陆失败");
//                    ErrorLogin();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.d(ex);
//                ErrorLogin();
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });



    }

    private void ErrorLogin() {
        //测试缓存
        UserLoginMainEntity TestEnTity = new UserLoginMainEntity();

        /***
         * 未实习
         */
        UserBaseInfo userbaseInfo = new UserBaseInfo( 4060, "张维和", 0, "Nick", 0, "2016年", 1, "icon28bdb8f3ca404110bfdb5363a282e267", 1,1, 1, 1, "2016-09-08", "2016-08-03", "120544161", "120544161", "", "北京大学", "电子商务", "计算机学院","马克思经济研究");
        UserLogin userLigin = new UserLogin( 4060,  "456",  "123456",  "1234567896412", 1,  "2017-08-31",  0, "","", "", "", 1, "eruoi21341","Android",  userbaseInfo);
        UserPractice userPractice = new UserPractice(1, 4060, 1, 1, 1,"",1, "", "","", "", 1, "", 1, 1, 1,1, "", 1, "", "", "", "", "", "");
        String IsHasUserPractice = "NO";

        /***
         * 已实习
         */
//        UserBaseInfo userbaseInfo = new UserBaseInfo( 4060, "张维和", 0, "Nick", 0, "2016年", 1, "icon28bdb8f3ca404110bfdb5363a282e267", 1,1, 1, 1, "2016-09-08", "2016-08-03", "120544161", "120544161", "", "北京大学", "电子商务", "计算机学院","马克思经济研究");
//        UserLogin userLigin = new UserLogin( 4060,  "456",  "123456",  "1234567896412", 1,  "2017-08-31",  0, "","", "", "", 1, "eruoi21341","Android",  userbaseInfo);
//        UserPractice userPractice = new UserPractice(1, 4060, 1, 1, 1,"java工程师",1, "2016-07-01", "2016-09-30","宇智波.水生", "12334423", 1, "北京海淀", 1, 1, 1,1, "北京猫屎星球有限公司", 1, "优", "北京海淀", "测试教师", "2016年暑期实习", "", "");
//        String IsHasUserPractice = "YES";

        TestEnTity.setUserLogin(userLigin);
        TestEnTity.setUserPracticeInfo(userPractice);
        TestEnTity.setIsHasUserPractice(IsHasUserPractice);

        application.setUserLoginMainEntity(TestEnTity);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        if (TestEnTity.getIsHasUserPractice().equals("0")) {
            intent.putExtra(MainActivity.mpracticeLink, 0);
        } else {
            intent.putExtra(MainActivity.mpracticeLink, 1);
        }
        aCache.put(MyApplication.userinfo, TestEnTity);
        startActivity(intent);
    }

    /**
     * 发送短信
     */
//    private void sendMessage() {
//        MessageResult = 0;//发送短信前初始结果
//        RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
//        params.addBodyParameter("action","authcode");
//        params.addParameter("mobile",edt_username.getText().toString());
//        x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                //解析result
//                MessageCodeEntity messageCodeEntity =new MessageCodeEntity();
//                if (messageCodeEntity != null) {
//                            Logger.d(messageCodeEntity.getAuthcode());
//                            if (messageCodeEntity.getStatus().equals("ok")) {
//                                Toast.makeText(LoginActivity.this, "短信发送成功", Toast.LENGTH_SHORT).show();
//                                MessageResult = Integer.parseInt(messageCodeEntity.getAuthcode());
//                                sendTel = edt_username.getText().toString();
//                                sendcode.setEnabled(false);
//
//                                new Thread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Message msg;
//                                        for (int i = 60; i >= 0; i--) {
//                                            SystemClock.sleep(1000);
//                                            msg = new Message();
//                                            msg.what = 0;
//                                            msg.arg1 = i;
//                                            handler.sendMessage(msg);
//                                        }
//                                        //更新状态
//                                        msg = new Message();
//                                        msg.what = 1;
//                                        handler.sendMessage(msg);
//                                    }
//                                }).start();
//
//                            }else{
//                                Toast.makeText(LoginActivity.this, "短信发送失败", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//
//
//            }
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//            }
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//            @Override
//            public void onFinished() {
//            }
//        });
//
//
//    }




    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0://处理刷新验证倒计时
                    sendcode.setText(String.valueOf(msg.arg1)+"s");
                    break;
                case 1://倒计时完成后更新状态
                    sendcode.setEnabled(true);
                    sendcode.setText("获取动态验证码");
                    break;
            }
        }
    };
}