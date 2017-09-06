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
import com.example.win.newintern3.NewEntity.QuestionInfo;
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
 * 问答列表
 */
public class QuestionsListActivity extends AppCompatActivity implements View.OnClickListener , BaseQuickAdapter.RequestLoadMoreListener{
//    private Toolbar toolbar;
    private TextView title;
    private TextView save;
    private ImageView back;
    private RecyclerView recyclerView;

    private QuestionsAdapter adapter;
    private MyApplication application;
    private List<QuestionInfo> mData;
    private int start = -10;
    private int count = 10;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        application = (MyApplication) getApplication();
        mData = new ArrayList<QuestionInfo>();

        getdata();
        findview();
    }

    private void findview() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("问答列表");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_questions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        adapter = new QuestionsAdapter(null);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<QuestionInfo>() {
            @Override
            public void onItemClick(View view, int position, QuestionInfo item) {
                intent = new Intent(QuestionsListActivity.this, QuestionsInfoActivity.class);
                intent.putExtra(QuestionsInfoActivity.intenttag1, item);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    }



    private void getdata() {
        RequestParams params = new RequestParams(URLConfig.QuestionsListAPI);
//        params.addParameter("action","questionlist");
        params.addParameter("StudentId", application.getUserid());
        params.addParameter("pageNumber","1");
        Logger.d(params);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {

                return false;
            }

            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceListEntity<QuestionInfo> Entity  = JsonUtils.getServiceListEntity(result, QuestionInfo.class);
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

    private class QuestionsAdapter extends BaseQuickAdapter<QuestionInfo> {

        public QuestionsAdapter(List<QuestionInfo> data) {
            super(R.layout.item_questions, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, QuestionInfo item,int positions) {
            helper.setText(R.id.text_questions_title, item.getQuestionTitle())
                    .setText(R.id.text_questions_name, "提问人 : " + item.getQuestionUserId())
                    .setText(R.id.text_questions_time, item.getQuestionTime())
                    .setText(R.id.text_questions_num,"已回复")
                    .setTextColor(R.id.text_questions_num, R.color.colorAcc);


        }
    }
}
