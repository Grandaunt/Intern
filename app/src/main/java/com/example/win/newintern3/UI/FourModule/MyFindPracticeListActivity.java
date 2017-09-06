//package com.example.win.newintern3.UI.FourModule;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.chad.library.adapter.base.BaseViewHolder;
//import com.example.win.newintern3.Base.MyApplication;
//import com.lzy.okhttputils.OkHttpUtils;
//import com.lzy.okhttputils.callback.AbsCallback;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//import cn.czhj.intern.BaseApplication;
//import cn.czhj.intern.Entity.MyFindPracticeListEntity;
//import cn.czhj.intern.R;
//import cn.czhj.intern.UI.Practice.FindPractice.LookOverFindPracticeActivity;
//import cn.czhj.intern.Utils.BuildConfig;
//import cn.czhj.intern.Utils.DividerItemDecoration;
//import cn.czhj.intern.Utils.JsonUtils;
//import cn.czhj.intern.Widgets.roundedimageview.RoundedImageView;
//import okhttp3.Call;
//import okhttp3.Request;
//import okhttp3.Response;
//
///***
// * 我的职位列表
// */
//public class MyFindPracticeListActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener {
//    private Toolbar toolbar;
//    private ImageView back;
//    private TextView title;
//    private RecyclerView recycler;
//    private MyFindPracticeAdapter adapter;
//    private MyApplication application;
//    private int start = -10;
//    private int count = 10;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_find_practice_list);
//        application = (MyApplication) getApplication();
//        findview();
//
//    }
//
//    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        back = (ImageView) findViewById(R.id.img_back);
//        back.setOnClickListener(this);
//        title = (TextView) findViewById(R.id.text_title);
//        title.setText("我的职位");
//
//        recycler = (RecyclerView) findViewById(R.id.recycler_ampl);
//        recycler.setLayoutManager(new LinearLayoutManager(this));
//        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//
//        adapter = new MyFindPracticeAdapter(null);
//        adapter.openLoadAnimation();
//        adapter.openLoadMore(10, true);
//        adapter.setOnLoadMoreListener(this);
//        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<MyFindPracticeListEntity.CompanyapplylistEntity>() {
//            @Override
//            public void onItemClick(View view, int position, MyFindPracticeListEntity.CompanyapplylistEntity item) {
//                Intent intent = new Intent(MyFindPracticeListActivity.this, LookOverFindPracticeActivity.class);
//                intent.putExtra(LookOverFindPracticeActivity.postid, String.valueOf(item.getPostId()));
//                intent.putExtra(LookOverFindPracticeActivity.posttype, 1);//传此参数隐藏提交按钮
//                startActivity(intent);
//            }
//        });
//        recycler.setAdapter(adapter);
//
//        getdata();
//    }
//
//
//    private void getdata() {
//        OkHttpUtils.post(BuildConfig.MyAPI)
//                .params("action","mycompanyapply")
//                .params("userId",application.getUserid())
//                .params("start",String.valueOf(start+=10))
//                .params("rownum",String.valueOf(count))
//                .execute(new FindPracticeCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, MyFindPracticeListEntity myFindPracticeListEntity, Request request, @Nullable Response response) {
//                        if (myFindPracticeListEntity != null) {
//                            if (myFindPracticeListEntity.getCode().equals("200")) {
//                                adapter.setPageSize(myFindPracticeListEntity.getCompanyapplylist().size() + adapter.getItemCount());
//                                adapter.addData(myFindPracticeListEntity.getCompanyapplylist());
//                                if (myFindPracticeListEntity.getCompanyapplylist().size() < 10) {
//                                    adapter.notifyDataChangedAfterLoadMore(false);
//                                }else{
//                                    adapter.notifyDataChangedAfterLoadMore(true);
//                                }
//                            }else{
//                                adapter.notifyDataChangedAfterLoadMore(false);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(isFromCache, call, response, e);
//                        Toast.makeText(MyFindPracticeListActivity.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
//
//    @Override
//    public void onLoadMoreRequested() {
//        getdata();
//    }
//
//    private abstract class FindPracticeCallBack extends AbsCallback<MyFindPracticeListEntity> {
//        @Override
//        public MyFindPracticeListEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s,MyFindPracticeListEntity.class);
//        }
//    }
//
//
//    private class MyFindPracticeAdapter extends BaseQuickAdapter<MyFindPracticeListEntity.CompanyapplylistEntity> {
//
//        public MyFindPracticeAdapter(List<MyFindPracticeListEntity.CompanyapplylistEntity> data) {
//            super(R.layout.item_find_practice, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, MyFindPracticeListEntity.CompanyapplylistEntity item) {
//            Picasso.with(helper.getConvertView().getContext()).load(item.getCompanyIcon()).placeholder(R.mipmap.ic_company_def_logo).error(R.mipmap.ic_company_def_logo).into(((RoundedImageView) helper.getView(R.id.img_item_icon)));
//            helper.setText(R.id.text_item_name, item.getPostName())
//                    .setText(R.id.text_item_type, item.getCompanyName())
//                    .setText(R.id.text_item_time, item.getApplyTime());
//
//            ImageView img = (ImageView) helper.getView(R.id.img_item_status);
//            if (item.getApplyStatus() == 1) {
//                img.setImageResource(R.mipmap.ic_currently_applying);
//            }else if (item.getApplyStatus() == 2) {
//                img.setImageResource(R.mipmap.ic_apply_through);
//            }else if (item.getApplyStatus() == 3) {
//                img.setImageResource(R.mipmap.ic_apply_dismissed);
//            }
//
//        }
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.img_back:
//                finish();
//                break;
//        }
//    }
//}
