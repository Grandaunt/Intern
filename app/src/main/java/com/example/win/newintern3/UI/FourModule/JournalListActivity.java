package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
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

import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.DayReportinfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DividerItemDecoration;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


/***
 * 日志列表
 */
public class JournalListActivity extends AppCompatActivity {
//    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private RecyclerView recycler;
    private JournalAdapter adapter;

    private int start = -10;
    private int count = 10;

    private MyApplication application;
    private Intent intent;
    private List<DayReportinfo> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);
        application = (MyApplication) getApplication();
        mData = new ArrayList<DayReportinfo>();
        getdate();
        findview();

    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("我的日志");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recycler = (RecyclerView) findViewById(R.id.recycler_ajl_journal);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter = new JournalAdapter(null);
        recycler.setAdapter(adapter);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<DayReportinfo>() {
            @Override
            public void onItemClick(View view, int position, DayReportinfo item) {
                intent = new Intent(JournalListActivity.this, JournalInfoActivity.class);
                intent.putExtra(JournalInfoActivity.intenttag1, item);
                startActivity(intent);
            }
        });

    }





    private void getdate() {
        RequestParams params = new RequestParams(URLConfig.JournalListAPI);
//        params.addParameter("action","dayreportlist");
//        params.addParameter("userId", application.getUserid());
//        params.addParameter("practiceId",String.valueOf(application.getUserLoginMainEntity().getUserpracticeinfo().getUserpracticeId()));
        params.addParameter("StudentId",application.getUserid());
        params.addParameter("pageNumber","1");
//        params.addParameter("start", String.valueOf(start += 10));
//        params.addParameter("rownum",String.valueOf(count));
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceListEntity<DayReportinfo> Entity  = JsonUtils.getServiceListEntity(result, DayReportinfo.class);

                if (Entity != null) {
                    adapter.setPageSize(adapter.getItemCount() + Entity.getList().size());
                    adapter.addData(Entity.getList());
                    if (Entity.getList().size() < count) {
                        adapter.notifyDataChangedAfterLoadMore(false);
                    } else {
                        adapter.notifyDataChangedAfterLoadMore(true);
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


    private class JournalAdapter extends BaseQuickAdapter<DayReportinfo> {

        public JournalAdapter(List<DayReportinfo> data) {
            super(R.layout.item_journal, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, DayReportinfo item,int positions) {
            helper.setText(R.id.text_item_titleOne, item.getDayReportTime())
                    .setText(R.id.text_item_titleTwo,  application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName());


        }
    }
}
