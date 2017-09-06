package com.example.win.newintern3.UI.MainModule.AIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.x;

public class AMainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView starttime;
    private TextView endtime;
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private LinearLayout PerJob;//岗前培训
    private ImageView icon;
    private Intent intent;
    private LinearLayout signin;//签到
    private LinearLayout journal;//日志
    private LinearLayout weekly;//周报
    private LinearLayout questions;//问答
    private LinearLayout askforleave;//请假
    private LinearLayout Businesstrip;//出差
    private MyApplication application;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amain);
        application = (MyApplication) getApplication();
        findview();
    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("实习");
        save= (TextView) findViewById(R.id.text_save);
        save.setText("");
        save.setOnClickListener(this);
        icon = (ImageView) findViewById(R.id.rounded_fp_icon);
//        x.image().bind(icon,application.get);
        name = (TextView) findViewById(R.id.text_fp_name);
        name.setText(application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName());
        starttime = (TextView) findViewById(R.id.text_fp_start);
        starttime.setText("实习时间 ： "+application.getUserLoginMainEntity().getUserPracticeInfo().getBasePlanStartTime()+" - "+application.getUserLoginMainEntity().getUserPracticeInfo().getBasePlanEndTime());
//        endtime = (TextView) findViewById(R.id.text_fp_end);


//        name.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getCompanyName());
//        starttime.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getBasePlanStartTime());
//        endtime.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getBasePlanEndTime());



//        PerJob = (LinearLayout) view.findViewById(R.id.view_fp_prejob);
//        PerJob.setOnClickListener(this);
        signin = (LinearLayout)findViewById(R.id.view_fp_sigin);
        signin.setOnClickListener(this);
        journal = (LinearLayout) findViewById(R.id.view_fp_journal);
        journal.setOnClickListener(this);
        weekly = (LinearLayout) findViewById(R.id.view_fp_weekly);
        weekly.setOnClickListener(this);
        questions = (LinearLayout)findViewById(R.id.view_fp_questions);
        questions.setOnClickListener(this);
        askforleave = (LinearLayout) findViewById(R.id.view_fp_askforleaver);
        askforleave.setOnClickListener(this);
        Businesstrip = (LinearLayout) findViewById(R.id.view_fp_businesstrip);
        Businesstrip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
               finish();
                break;
//            case R.id.view_fp_prejob:
//                intent = new Intent(PracticeFragmen.this.getContext(), StudyJobActivity.class);
//                startActivity(intent);
//                break;
            //签到
            case R.id.view_fp_sigin:
                intent = new Intent(AMainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
            //日志
            case R.id.view_fp_journal:
                intent = new Intent(this, JournalActivity.class);
                startActivity(intent);
                break;
            //周报
            case R.id.view_fp_weekly:
                intent = new Intent(this, WeeklyActivity.class);
                startActivity(intent);
                break;
            //问答
            case R.id.view_fp_questions:
                intent = new Intent(this, QuestionsActivity.class);
                startActivity(intent);
                break;
            //请假
            case R.id.view_fp_askforleaver:
                intent = new Intent(this, AskForLeaveActivity.class);
                startActivity(intent);
                break;
            //出差
            case R.id.view_fp_businesstrip:
                intent = new Intent(this, BusinessTripActivity.class);
                startActivity(intent);
                break;
        }
    }
}
