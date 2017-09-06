package com.example.win.newintern3.UI.FourModule;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ParentActivity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.LoginModule.LoginActivity;
import com.example.win.newintern3.Utils.ACache;


/***
 * 设置
 */
public class SettingActivity  extends AppCompatActivity implements View.OnClickListener{
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView  save;
    private  LinearLayout clear;
    private  LinearLayout about;
    private  LinearLayout out;
    private MyApplication application;
    private ACache acache;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        application = (MyApplication) getApplication();
        initView();
        acache = ACache.get(this);
    }

    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        save =  (TextView) findViewById(R.id.text_save);
        back.setOnClickListener(this);
        title.setText("设置");

        save.setText("");
        clear = (LinearLayout)findViewById(R.id.ly_clear);
        about = (LinearLayout)findViewById(R.id.ly_about);
        out = (LinearLayout)findViewById(R.id.ly_out);
        clear.setOnClickListener( this);
        out.setOnClickListener( this);
        about.setOnClickListener(this);

    }



    private void clear() {
        Toast.makeText(this,"缓存0.0",Toast.LENGTH_SHORT).show();
    }

    private void out() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
//        builder.setMessage("您确认退出应用？");
//        builder.setTitle("提示");
//        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
////                SharedPreferences.Editor editor = sharedPrefs.edit();
////                editor.putString("AUTH_TOKEN","error");
////                editor.commit();
//                System.exit(0);
//
//            }
//        });
//
//        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        builder.create().show();
        acache.remove(MyApplication.userinfo);
        Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    private void about() {
        Intent intent = new Intent(SettingActivity.this, AboutActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
             case R.id.img_back:
                 finish();
                 break;
         case R.id.ly_about:
             about();
             break;
         case R.id.ly_clear:
             clear();
             break;
         case R.id.ly_out:
             out();
             break;
         default:
             break;
         }

     }


}
