package com.example.win.newintern3.UI.FourModule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;

import com.example.win.newintern3.NewEntity.DayReportBack;
import com.example.win.newintern3.NewEntity.DayReportinfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DividerItemDecoration;

import java.util.List;


/***
 * 日志详情
 */
public class JournalInfoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String intenttag1 = "JournalId";
//    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private TextView date;          //实习日期
    private TextView company;       //实习单位
    private TextView address;       //实习地点
    private TextView body;          //实习内容
    private TextView summary;       //工作总结
    private TextView evaluationnum; //教师点评条数
    private RecyclerView recycler;  //教师点评

    private EvaluationAdapter adapter;

    private DayReportinfo data = null;

    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_info);
        application = (MyApplication) getApplication();
        data = (DayReportinfo) getIntent().getSerializableExtra(intenttag1);
        if (data == null) {
            data = new DayReportinfo();
        }
        findview();
    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("日志详情");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");


        date = (TextView) findViewById(R.id.text_aji_date);
        date.setText(data.getDayReportTime());

        company = (TextView) findViewById(R.id.text_aji_company);
        company.setText( application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName());

        address = (TextView) findViewById(R.id.text_aji_address);
        address.setText(data.getDayReportAddressText());

        body = (TextView) findViewById(R.id.edt_aji_body);
        body.setText(data.getDayReportContent());

        summary = (TextView) findViewById(R.id.edt_aji_summary);
        summary.setText(data.getDayReportExperience());

        evaluationnum = (TextView) findViewById(R.id.text_evaluation_num);
        evaluationnum.setText("共" + data.getDayReportBackList().size() + "条评论");

        recycler = (RecyclerView) findViewById(R.id.recycler_aji_evaluation);
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter = new EvaluationAdapter(data.getDayReportBackList());
        recycler.setAdapter(adapter);



    }
    private class EvaluationAdapter extends BaseQuickAdapter<DayReportBack> {
        public EvaluationAdapter( List<DayReportBack> data) {
            super(R.layout.item_journal_evaluation, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, DayReportBack item,int positions) {
            helper
//                    .setText(R.id.text_evaluation_name, item.getUserName())
//                    .setText(R.id.text_evaluation_time, item.getBackTime())
                    .setText(R.id.text_evaluation_body, item.getBackContent());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
