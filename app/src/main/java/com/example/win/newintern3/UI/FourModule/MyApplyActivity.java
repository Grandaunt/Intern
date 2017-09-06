//package com.example.win.newintern3.UI.FourModule;
//
//import android.content.Intent;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.win.newintern3.Base.MyApplication;
//import com.example.win.newintern3.Entity.MyApplyEntity;
//import com.example.win.newintern3.Entity.UserInfoEntity;
//import com.example.win.newintern3.R;
//import com.example.win.newintern3.Utils.DividerItemDecoration;
//import com.example.win.newintern3.Utils.JsonUtils;
//import com.example.win.newintern3.Utils.URLConfig;
//import com.example.win.newintern3.Utils.logger.Logger;
//
//import org.xutils.common.Callback;
//import org.xutils.http.RequestParams;
//import org.xutils.x;
//
//import java.util.List;
//
///***
// * 我的申请
// */
//
//public class MyApplyActivity extends AppCompatActivity implements View.OnClickListener{
//
//    private Toolbar toolbar;
//    private ImageView back;
//    private TextView title;
//    private RecyclerView recyclerView;
//    private ApplyAdapter adapter;
//
//    private int index = -10;
//    private int count = 10;
//
//    private Intent intet;
//
//    private MyApplication application;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_apply);
//        application = (MyApplication) getApplication();
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        back = (ImageView) findViewById(R.id.img_back);
//        title = (TextView) findViewById(R.id.text_title);
//        title.setText("我的申请");
//        back.setOnClickListener(this);
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycle_amc_apply);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//
//        adapter = new ApplyAdapter(null);
////        adapter.openLoadAnimation();
////        adapter.openLoadMore(10, true);
//        adapter.setOnRecyclerViewItemClickListener(this);
//        adapter.setOnLoadMoreListener(this);
//        recyclerView.setAdapter(adapter);
//
//        getdata();
//    }
//
//    private void getdata() {
//        RequestParams params = new RequestParams(URLConfig.MyAPI);
//        params.addParameter("action","myapply");
//        params.addParameter("userId", application.getUserid());
//        Logger.d(params);
//        x.http().post(params, new Callback.CacheCallback<String>() {
//            @Override
//            public boolean onCache(String result) {
//                return false;
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                Logger.d(result);
//                UserInfoEntity userInfoEntity = JsonUtils.getPerson(result, UserInfoEntity.class);
//                if (userInfoEntity != null) {
//                    intouserinfo(userInfoEntity.getUserbaseinfo());
//                }
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                Logger.d(ex);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//            }
//
//            @Override
//            public void onFinished() {
//                //存储缓存
//            }
//        });
//    }
//
//    @Override
//    public void onItemClick(View view, int position, MyApplyEntity.ApplylistEntity item) {
//        intet = new Intent(MyApply.this, LookOverApplyPracticeActivity.class);
//        intet.putExtra(LookOverApplyPracticeActivity.AppyId, String.valueOf(item.getApplyId()));
//        startActivity(intet);
//    }
//
//    @Override
//    public void onLoadMoreRequested() {
//        getdata();
//    }
//
//
//private abstract class ApplyCallBack extends AbsCallback<MyApplyEntity> {
//    @Override
//    public MyApplyEntity parseNetworkResponse(Response response) throws Exception {
//        String s = response.body().string();
//        if (TextUtils.isEmpty(s)) {
//            return null;
//        }
//        return JsonUtils.getPerson(s, MyApplyEntity.class);
//    }
//}
//
//private class ApplyAdapter extends BaseQuickAdapter<MyApplyEntity.ApplylistEntity> {
//
//    public ApplyAdapter(List<MyApplyEntity.ApplylistEntity> data) {
//        super(R.layout.item_apply, data);
//    }
//
//    @Override
//    protected void convert(BaseViewHolder helper, MyApplyEntity.ApplylistEntity item) {
//        RoundedImageView icon = helper.getView(R.id.img_item_icon);
//        if (TextUtils.isEmpty(item.getCompanyIcon())) {
//            item.setCompanyIcon("null");
//        }
//        if (TextUtils.isEmpty(item.getCompanyName())) {
//            item.setCompanyName("");
//        }
//        if(TextUtils.isEmpty(item.getChecker())){
//            item.setChecker("");
//        }
//        if(TextUtils.isEmpty(item.getCheckTime())){
//            item.setCheckTime("");
//        }
//        Picasso.with(helper.convertView.getContext())
//                .load(item.getCompanyIcon())
//                .error(R.mipmap.ic_company_def_logo)
//                .placeholder(R.mipmap.ic_company_def_logo).into(icon);
//        helper.setText(R.id.text_item_name, item.getPracticeName())
//                .setText(R.id.text_item_other, "审批人: " + item.getChecker() + "    " + "审批时间: " + item.getCheckTime())
//                .setText(R.id.text_item_time, item.getApplyTime());
//        if (item.getPracticeType() == 1) {
//            helper.setText(R.id.text_item_type, "实习类别: 基地");
//        }else if (item.getPracticeType() == 1) {
//            helper.setText(R.id.text_item_type, "实习类别: 自主");
//        }
//
//        ImageView imgstatus = helper.getView(R.id.img_item_status);
//        switch (item.getApplyStatus()) {
//            case 1://待审核
//                Picasso.with(helper.convertView.getContext()).load(R.mipmap.ic_currently_applying).into(imgstatus);
//                break;
//            case 2://审核通过
//                Picasso.with(helper.convertView.getContext()).load(R.mipmap.ic_apply_through).into(imgstatus);
//                break;
//            case 3://审核驳回
//                Picasso.with(helper.convertView.getContext()).load(R.mipmap.ic_apply_dismissed).into(imgstatus);
//                break;
//        }
//
//
//    }
//}
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.img_back:
//                finish();
//                break;
//
//        }
//    }
//}
