package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.R;

/***
 * 我的实习
 */
public class MyInternActivity extends AppCompatActivity  implements View.OnClickListener {
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView  save;


    private LinearLayout journal;               //我的日志
    private LinearLayout weekly;               //我的周报
    private LinearLayout questions;             //我的问答
    private LinearLayout leave;                 //我的请假
    private LinearLayout businesstrip;          //我的出差
//    private TextView summary;               //我的总结


    private Intent intent;
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intern);

        application = (MyApplication)getApplication();
        findview();


    }


    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        save =  (TextView) findViewById(R.id.text_save);
        back.setOnClickListener(this);
        title.setText("我的实习");

        save.setText("");
        journal = (LinearLayout) findViewById(R.id.text_fm_journal);
        weekly = (LinearLayout) findViewById(R.id.text_fm_weekly);
        questions = (LinearLayout) findViewById(R.id.text_fm_questions);
        leave = (LinearLayout) findViewById(R.id.text_fm_leave);
        businesstrip = (LinearLayout)findViewById(R.id.text_fm_businesstrip);
//        summary = (TextView) findViewById(R.id.text_fm_summary);


        journal.setOnClickListener(this);
        weekly.setOnClickListener(this);
        questions.setOnClickListener(this);
        leave.setOnClickListener(this);
        businesstrip.setOnClickListener(this);
//        summary.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
               finish();
                break;

            case R.id.text_fm_journal:
                intent = new Intent(MyInternActivity.this, JournalListActivity.class);
                startActivity(intent);
                break;

            case R.id.text_fm_weekly:
                intent = new Intent(MyInternActivity.this, WeeklyListActivity.class);
                startActivity(intent);
                break;
            case R.id.text_fm_questions:
                intent = new Intent(MyInternActivity.this, QuestionsListActivity.class);
                startActivity(intent);
                break;
            case R.id.text_fm_leave:
                intent = new Intent(MyInternActivity.this, AskForLeaveListActivity.class);
                startActivity(intent);
                break;
            case R.id.text_fm_businesstrip:
                intent = new Intent(MyInternActivity.this, BusinessTripListActivity.class);
                startActivity(intent);
                break;
//            case R.id.text_fm_summary:
//                intent = new Intent(MyInternActivity.this, MySummaryActivity.class);
//                startActivity(intent);
//                break;



        }
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {//进入个人信息，不管里面进行过什么操作，这里的更新头像等数据

        }

    }
}


