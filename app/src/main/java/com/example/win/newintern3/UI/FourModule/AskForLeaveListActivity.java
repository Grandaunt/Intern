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
import com.example.win.newintern3.NewEntity.LeaveInfo;
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
 * 请假列表
 */
public class AskForLeaveListActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener{
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private RecyclerView recyclerView;

    private LeaveAndBusinessTripAdapter adapter;
    private Intent intent;
    private int start = -10;
    private int count = 10;

    private MyApplication application;
    private List<LeaveInfo> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_leave_list);
        mData = new ArrayList<LeaveInfo>();
        application = (MyApplication) getApplication();
        getdata();
        findview();
    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("请假列表");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_afll);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        adapter = new LeaveAndBusinessTripAdapter(null);
        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<LeaveInfo>() {
            @Override
            public void onItemClick(View view, int position, LeaveInfo item) {
                intent = new Intent(AskForLeaveListActivity.this, AskForLeaveInfoActivity.class);
                intent.putExtra(AskForLeaveInfoActivity.intenttag1, item);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onLoadMoreRequested() {
        getdata();
    }

    private void getdata() {
        RequestParams params = new RequestParams(URLConfig.AskForLeaveListAPI);
//        params.addParameter("action","leavelist");
//        params.addParameter("userId", application.getUserid());
        params.addParameter("StudentId", application.getUserid());
        params.addParameter("pageNumber","1");
//        params.addParameter("rownum",String.valueOf(count));
//        params.addParameter("leaveType", "1");
        Logger.d(params);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {

                return false;
            }

            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceListEntity<LeaveInfo> Entity  = JsonUtils.getServiceListEntity(result, LeaveInfo.class);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }


    private class LeaveAndBusinessTripAdapter extends BaseQuickAdapter<LeaveInfo> {

        public LeaveAndBusinessTripAdapter(List<LeaveInfo> data) {
            super(R.layout.item_weekly, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, LeaveInfo item,int positions) {
            helper.setText(R.id.text_item_name, item.getApplyTime())
                    .setText(R.id.text_item_company, application.getUserLoginMainEntity().getUserPracticeInfo().getCompanyName())
                    .setText(R.id.text_item_time,item.getLeaveStartTime()+"-"+item.getLeaveEndTime());
//            ImageView icon = (ImageView) helper.itemView.findViewById(R.id.img_ij_type);
            Logger.e(item.getCheckStatus());
            /** 审核状态	1：待审核；2：请假批准；3：请假驳回；4：主动撤销 */
            if(item.getCheckStatus().equals("1")){
                helper.setImageResource(R.id.img_ij_type,R.mipmap.ic_apply_ing);
                helper.setText(R.id.text_item_apply_status, "待审核");
                helper.setTextColor(R.id.text_item_apply_status, R.color.colorAcc);
            } else  if(item.getCheckStatus().equals("2")){
                helper.setImageResource(R.id.img_ij_type,R.mipmap.ic_apply_through);
                helper.setText(R.id.text_item_apply_status, "请假批准");
                helper.setTextColor(R.id.text_item_apply_status, R.color.colorAcc);
            }else  if(item.getCheckStatus().equals("3")){
                helper.setImageResource(R.id.img_ij_type,R.mipmap.ic_apply_reject);
                helper.setText(R.id.text_item_apply_status, "请假驳回");
                helper.setTextColor(R.id.text_item_apply_status, R.color.colorAcc);
            }else  if(item.getCheckStatus().equals("4")){
                helper.setImageResource(R.id.img_ij_type,R.mipmap.ic_apply_dismissed);
                helper.setText(R.id.text_item_apply_status,"主动撤销");
                helper.setTextColor(R.id.text_item_apply_status, R.color.colorAcc);
            }



        }
    }
}
