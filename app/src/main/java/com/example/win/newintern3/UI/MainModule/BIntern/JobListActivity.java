package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.BasePost;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class JobListActivity extends AppCompatActivity implements View.OnClickListener, BaseQuickAdapter.OnRecyclerViewItemClickListener<BasePost>{
    public static  String intenttag1 = "JobListId";
private TextView title;
private ImageView back;
private TextView menu;

private RecyclerView recycle;
private BaseJobAdapter adapter;
private int index = -10;
private int Count = 10;
private Intent intent;
private String baseId="";

//    private SubmitResultsActivity submitResultsActivity;
private MyApplication application;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_list);
        application = (MyApplication) getApplication();
         Intent intent1 = this.getIntent();
        baseId = intent1.getStringExtra(intenttag1);
        getdata();
        findview();


        }

private void findview() {

        title = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.img_back);
        menu = (TextView) findViewById(R.id.text_save);
        menu.setText("");
        title.setText("岗位列表");
        back.setOnClickListener(this);
//        menu.setOnClickListener(this);

        recycle = (RecyclerView) findViewById(R.id.recycler_com_list);
        recycle.setLayoutManager(new LinearLayoutManager(this));
//        recycle.addItemDecoration(new com.example.win.newintern3.Utils.DividerItemDecoration(this, com.example.win.newintern3.Utils.DividerItemDecoration.VERTICAL_LIST));
        adapter = new BaseJobAdapter(null);
        adapter.setOnRecyclerViewItemClickListener(this);
        recycle.setAdapter(adapter);
        }



/**
 * 获得列表数据
 */
private void getdata() {
        RequestParams params = new RequestParams(URLConfig.GetBasePostAPI);
        params.addParameter("BaseId",baseId);
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
@Override
public void onSuccess(String result) {
        Logger.d(result);
        ServiceListEntity<BasePost> Entity  = JsonUtils.getServiceListEntity(result, BasePost.class);
        if (Entity.getCode().equals("200")) {
        adapter.setPageSize(adapter.getItemCount() + Entity.getList().size());
        adapter.addData(Entity.getList());

        if (Entity.getList().size() < Count) {
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




@Override
public void onItemClick(View view, int position, BasePost item) {//列表的点击事件
//        intent = new Intent(ComListActivity.this, ComInfoActivity.class);
//        intent.putExtra(ComInfoActivity.intenttag1, item);
//        startActivity(intent);
        intent = new Intent();
        intent.putExtra("job", item);
        setResult(NewInternActivity.jobresult, intent);
        finish();
        }

private class BaseJobAdapter extends BaseQuickAdapter<BasePost> {


    public BaseJobAdapter(List<BasePost> data) {
        super(R.layout.item_base_info, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BasePost item,int positions) {
        //   text_office_name = (TextView) findViewById(R.id.text_alop_practice_office_name);
//        text_peoplenum = (TextView) findViewById(R.id.text_alop_practice_people_num);
//        text_treatment = (TextView) findViewById(R.id.text_alop_practice_treatment);
//        text_claim = (TextView) findViewById(R.id.text_alop_practice_claim);
        helper.setText(R.id.text_alop_practice_office_name, "职位名称: " + item.getPostName())
                .setText(R.id.text_alop_practice_people_num, "招聘人数: " + item.getPostNum() + "人")
                .setText(R.id.text_alop_practice_treatment, "公司待遇: " + item.getPostPay())
                .setText(R.id.text_alop_practice_claim, "职位要求: \n" + item.getPostOrder())
                .setText(R.id.text_alop_practice_post_claim, "岗位职责: \n" + item.getPostDuty())
                .setText(R.id.text_alop_practice_welfare, "公司福利: \n" + item.getPostDuty());

    }
}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpUtils.getInstance().cancelTag(this);
    }




}
