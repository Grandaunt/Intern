package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.CompanyInfo;
import com.example.win.newintern3.NewEntity.CompanyPracticePost;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ComListActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnRecyclerViewItemClickListener<CompanyPracticePost>{

    private TextView title;
    private ImageView back;
    private TextView menu;

    private RecyclerView recycle;
    private BasePracticeAdapter adapter;
    private int index = -10;
    private int Count = 10;
    private Intent intent;
    private String planId = "";//区别是否为筛选，如果为筛选时，在加载更多数据时根据此此段来判断
   private ServiceListEntity<CompanyPracticePost> listEntity;
    private CompanyPracticePost addComPost;
    private CompanyInfo addCominfo;
    private    List<CompanyPracticePost> addComPostlist;
    //    private SubmitResultsActivity submitResultsActivity;
    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_list);
        application = (MyApplication) getApplication();
        NewInternActivity.point = 3;
        addComPostlist = new ArrayList<>();
        getdata();
        findview();


    }

    private void findview() {

        title = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.img_back);
        menu = (TextView) findViewById(R.id.text_save);
        menu.setText("添加");
        title.setText("企业列表");
        back.setOnClickListener(this);
        menu.setOnClickListener(this);
//        menu.setOnClickListener(this);

        recycle = (RecyclerView) findViewById(R.id.recycler_com_list);
        recycle.setLayoutManager(new LinearLayoutManager(this));
//        recycle.addItemDecoration(new com.example.win.newintern3.Utils.DividerItemDecoration(this, com.example.win.newintern3.Utils.DividerItemDecoration.VERTICAL_LIST));
        adapter = new BasePracticeAdapter(null);
//        adapter.openLoadAnimation();
        adapter.setOnLoadMoreListener(this);
        adapter.openLoadMore(10, true);
        adapter.setOnRecyclerViewItemClickListener(this);
        recycle.setAdapter(adapter);
    }



    @Override
    public void onLoadMoreRequested() {//加载更多
        //如果planId为null或者为0时，则列表为全部的数据，所以加载全部数据的分页
        if (planId.equals("")||planId.equals("0")) {
            getdata();
        }else{
//            filterData(planId);
        }

    }

    /**
     * 获得列表数据
     */
    private void getdata() {
        RequestParams params = new RequestParams(URLConfig.ComInfoAPI);
        params.addParameter("StudentId",application.getUserid());
        params.addParameter("pageNumber","0");
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                  listEntity  = JsonUtils.getServiceListEntity(result, CompanyPracticePost.class);
                if (listEntity.getCode().equals("200")) {
                    addComPostlist =listEntity.getList();
                    adapter.setPageSize(adapter.getItemCount() + listEntity.getList().size());
                    adapter.addData(listEntity.getList());

                    if (listEntity.getList().size() < Count) {
                        adapter.notifyDataChangedAfterLoadMore(false);
                    } else {
                        adapter.notifyDataChangedAfterLoadMore(true);
                    }
                }
                else{
                    Toast.makeText(ComListActivity.this,"无企业",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.d(ex);
                Toast.makeText(ComListActivity.this,"无企业",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }




    @Override
    public void onItemClick(View view, int position, CompanyPracticePost item) {//列表的点击事件
//        intent = new Intent(ComListActivity.this, ComInfoActivity.class);
//        intent.putExtra(ComInfoActivity.intenttag1, item);
//        startActivity(intent);
        intent = new Intent();
        Logger.i("item"+item);
        intent.putExtra("enterprise", item);
        setResult(NewInternActivity.enterprisenresult, intent);
        finish();
    }

    private class BasePracticeAdapter extends BaseQuickAdapter<CompanyPracticePost> {

        public BasePracticeAdapter(List<CompanyPracticePost> data) {
            super(R.layout.item_office_practice_page, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, CompanyPracticePost item,int positions) {
            ImageView icon = (ImageView) helper.itemView.findViewById(R.id.item_com_icon);
            x.image().bind(icon, item.getCompanyInfo().getCompanyIcon(), application.options);

            helper.setText(R.id.item_com_title, item.getPostName())
                    .setText(R.id.item_com_name, item.getCompanyInfo().getCompanyName())
                    .setText(R.id.item_post_type, item.getIntentionTrade()+" | "+item.getPostNum()+"人")

                    .setText(R.id.item_com_money, item.getPostMoney())
                    .setText(R.id.item_com_posted_time, item.getPostStartTime());
            if(item.getIntentionTrade()==null || item.getIntentionTrade().length() <= 0){
                helper.setText(R.id.item_post_type, +item.getPostNum()+"人");
            }



        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                Intent intent =  new Intent(ComListActivity.this,AddComInfoActivity.class);
                startActivityForResult(intent, 0);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpUtils.getInstance().cancelTag(this);
    }




    public static final int addcomresultCode = 2000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case addcomresultCode:
                addComPost = new CompanyPracticePost();
//                addCominfo = new CompanyInfo();
//                addCominfo = (CompanyInfo) data.getSerializableExtra("addCom");
//                addComPost.setCompanyInfo(addCominfo);
                addComPost = (CompanyPracticePost) data.getSerializableExtra("addCom");
//                listEntity.getList().add(addComPost);

//                adapter.DelData();

                addComPostlist.add(addComPost);
//                adapter = new BasePracticeAdapter(addComPostlist);
                adapter.addData(addComPostlist);
                if (addComPostlist.size() < Count) {
                    adapter.notifyDataChangedAfterLoadMore(false);
                } else {
                    adapter.notifyDataChangedAfterLoadMore(true);
                }
                recycle.setAdapter(adapter);
//                findview();
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }

    }


}
