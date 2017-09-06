package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.CompanyPracticePost;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import static com.example.win.newintern3.Utils.logger.Logger.init;


public class BMainActivity extends AppCompatActivity implements View.OnClickListener {
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.img_back)
    private ImageView back;

    @ViewInject(R.id.text_title)

    private TextView title;

    @ViewInject(R.id.text_save)
    private TextView save;

    @ViewInject(R.id.imB_newIntern)
    private ImageButton ImB_newIntern;

    @ViewInject(R.id.recycler_com_job)
    private RecyclerView recyclerView;

    private ComListAdapter adapter;
    private int index = -10;
    private int count = 10;
    private Intent intent;
    private ImageOptions options;
    private MyApplication application;

    private List<CompanyPracticePost> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmain);
        x.view().inject(this);
        application = (MyApplication) getApplication();
        mData = new ArrayList<CompanyPracticePost>();
        getdata();
        initDate();
        //头像
        options = new ImageOptions.Builder()
                //设置圆形
                .setCircular(true)
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_coll_f)
//设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_coll_f)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
    }



    private void initDate() {
        title.setText("实习");
        save.setText("");
        setSupportActionBar(toolbar);
        back.setOnClickListener(this);
        ImB_newIntern.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComListAdapter(null);
        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<CompanyPracticePost>() {
            @Override
            public void onItemClick(View view, int position, CompanyPracticePost item) {
                intent = new Intent(BMainActivity.this, ComInfoActivity.class);
                intent.putExtra(ComInfoActivity.intenttag1, item);
                startActivity(intent);
            }

        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.imB_newIntern:
                Intent intent = new Intent(BMainActivity.this, NewInternActivity.class);
                startActivityForResult(intent, 0);
                break;

        }
    }

    public void getdata() {
        RequestParams params = new RequestParams(URLConfig.RecommendPracticeAPI);
//        params.addParameter("StudentId",application.getUserid());
        params.addParameter("StudentId",application.getUserid());
        params.addParameter("pageNumber","1");
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
//                RecommendPracticeEntity Entity  = JsonUtils.getPerson(result, RecommendPracticeEntity.class);
                ServiceListEntity<CompanyPracticePost> Entity = JsonUtils.getServiceListEntity(result, CompanyPracticePost.class);
                String code = Entity.getCode();
                Logger.d(code);

                if (Entity != null) {
                    if (Entity.getCode().equals("200")) {
                            mData = Entity.getList();
                            adapter.setPageSize(adapter.getItemCount() + Entity.getList().size());
                            adapter.addData(Entity.getList());
                            if (Entity.getList().size() < count) {
                                adapter.notifyDataChangedAfterLoadMore(false);
                            } else {
                                adapter.notifyDataChangedAfterLoadMore(true);
                            }

                    } else if (Entity.getCode().equals("500")) {
//                        adapter.notifyDataChangedAfterLoadMore(false);
                        Toast.makeText(BMainActivity.this, "没有数据了", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(BMainActivity.this, "服务器错误 请稍后重试", Toast.LENGTH_SHORT).show();
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

    private class ComListAdapter extends BaseQuickAdapter<CompanyPracticePost> {

        public ComListAdapter(List<CompanyPracticePost> data) {
            super(R.layout.item_office_practice_page, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, CompanyPracticePost item,int positions) {


            ImageView icon = (ImageView) helper.itemView.findViewById(R.id.item_com_icon);
            x.image().bind(icon, item.getCompanyInfo().getCompanyIcon(), options);
            Logger.i("item.getCompanyInfo().getCompanyIcon()="+item.getCompanyInfo().getCompanyIcon());
            helper.setText(R.id.item_com_title, item.getPostName())
                    .setText(R.id.item_com_name, item.getCompanyInfo().getCompanyName())
                    .setText(R.id.item_post_type, item.getIntentionTrade()+" | "+item.getPostNum()+"人")
//                    .setText(R.id.item_post_num, item.getPostNum())
                    .setText(R.id.item_com_money, item.getPostMoney())
                    .setText(R.id.item_com_posted_time, item.getPostStartTime());

        }
    }

}
