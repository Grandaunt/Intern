package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.WeekReportInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DividerItemDecoration;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;


/***
 * 我的周报
 */
public class WeeklyListActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener{
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private RecyclerView recycler;

    private int start = -10;
    private int count = 10;

    private WeeklyAdapter adapter;

    private MyApplication application;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_list);
        application = (MyApplication) getApplication();
        getdate();
        findview();
    }


    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("我的周报");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");

        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);

        recycler = (RecyclerView) findViewById(R.id.recycler_ajl_weekly);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        adapter = new WeeklyAdapter(null);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<WeekReportInfo>() {
            @Override
            public void onItemClick(View view, int position, WeekReportInfo item) {
                intent = new Intent(WeeklyListActivity.this, WeeklyInfoActivity.class);
                intent.putExtra(WeeklyInfoActivity.intenttag1, item);
                startActivity(intent);
            }
        });
        recycler.setAdapter(adapter);
    }





    private void getdate() {
        RequestParams params = new RequestParams(URLConfig.WeekListAPI);
//        params.addParameter("action","weekreportlist");
//        params.addParameter("userId", application.getUserid());
//        params.addParameter("practiceId",String.valueOf(application.getUserLoginMainEntity().getUserpracticeinfo().getUserpracticeId()));
        params.addParameter("StudentId", application.getUserid());
        params.addParameter("pageNumber","1");
//        params.addParameter("start",String.valueOf(start += 10));
//        params.addParameter("rownum",String.valueOf(count));
        Logger.d(params);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {

                return false;
            }

            @Override
            public void onSuccess(String result) {
                Logger.d(result);
                ServiceListEntity<WeekReportInfo> Entity  = JsonUtils.getServiceListEntity(result, WeekReportInfo.class);
                if (Entity.getCode().equals("200")) {
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
        } );
    }





    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }




    @Override
    public void onLoadMoreRequested() {

    }

    private class WeeklyAdapter extends BaseQuickAdapter<WeekReportInfo> {

        public WeeklyAdapter(List<WeekReportInfo> data) {
            super(R.layout.item_weekly, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, WeekReportInfo item,int positions) {
            helper.setText(R.id.text_item_name, item.getWeekReportTime())
                    .setText(R.id.text_item_company, application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName())
                    .setText(R.id.text_item_time,item.getMondayTime()+"-"+item.getSundayTime())
                    .setImageResource(R.id.img_ij_type,R.mipmap.ic_apply_through)
                    .setText(R.id.text_item_apply_status, "已提交")
                    .setTextColor(R.id.text_item_apply_status, R.color.colorAcc);



        }
    }
}
