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
import com.example.win.newintern3.NewEntity.QuestionAnswer;
import com.example.win.newintern3.NewEntity.QuestionInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DividerItemDecoration;

import org.xutils.x;

import java.util.List;




/***
 * 问答详情
 */
public class QuestionsTestActivity extends AppCompatActivity implements View.OnClickListener {
    public static  String intenttag1 = "QuestionsInfoId";
//    private Toolbar toolbar;
    private TextView title;
    private TextView save;
    private ImageView back;

    private ImageView img;
    private TextView mtitle;
    private TextView name;
    private TextView time;
    private TextView num;
    private TextView body;

    private RecyclerView recyclerView;
    private QuestionsAdapter adapter;
    private QuestionInfo mData;
    private List<QuestionAnswer> mQuestionAnswerData;

    private String questionId = "";

    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_info);
        application = (MyApplication) getApplication();
        mData = (QuestionInfo) getIntent().getSerializableExtra(intenttag1);
//        questionId = getIntent().getStringExtra("data");
        findview();
        initdata();
    }

    private void initdata() {
//        RequestParams params = new RequestParams(URLConfig.PracticeAPI);
//        params.addParameter("action","questioninfo");
//        params.addParameter("questionId",questionId);
//        Logger.d(params);
//        x.http().post(params, new Callback.CacheCallback<String>() {
//            @Override
//            public boolean onCache(String result) {
//
//                return false;
//            }
//
//            @Override
//            public void onSuccess(String result) {
//
//                Logger.d(result);
//                QuestionInfo questionsInfoEntity = JsonUtils.getPerson(result, QuestionInfo.class);
//                if (questionsInfoEntity != null) {
//                    if (questionsInfoEntity.getQuestioninfo().getQuestionLevel() == 2) {
//                        img.setVisibility(View.VISIBLE);
//                    }else{
//                        img.setVisibility(View.GONE);
//                    }
                    mtitle.setText(mData.getQuestionTitle());
                    name.setText(application.getUserid());
                    time.setText(mData.getQuestionTime());
                    body.setText(mData.getQuestionContent());
                    num.setText("共" + mData.getQuestionAnswerList().size() + "条回复");
//                    adapter.addData(questionsInfoEntity.getQuestionanswer());
                  mQuestionAnswerData =  mData.getQuestionAnswerList();
//                }
//                findview();
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
//            }
//        } );
    }


    private void findview() {

        title = (TextView) findViewById(R.id.text_title);
        title.setText("问答详情");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);

        img = (ImageView) findViewById(R.id.riv_aqi_icon);
        mtitle = (TextView) findViewById(R.id.text_aqi_title);
        name = (TextView) findViewById(R.id.text_aqi_name);
        time = (TextView) findViewById(R.id.text_aqi_time);
        num = (TextView) findViewById(R.id.text_aqi_num);
        body = (TextView) findViewById(R.id.text_aqi_body);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_aqi_questions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter = new QuestionsAdapter(null);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }



    private class QuestionsAdapter extends BaseQuickAdapter<QuestionAnswer> {
        public QuestionsAdapter( List<QuestionAnswer> data) {
            super(R.layout.item_qanda, data);
        }

        @Override
        protected void convert(BaseViewHolder helper,QuestionAnswer item,int positions) {
            //我
            if(item.getAnswerId().equals(application.getUserLoginMainEntity().getUserLogin().getUserId())){
                helper.setVisible(R.id.ly_left, false)
                        .setVisible(R.id.ly_right,true)
                        .setText(R.id.tv_right_username,"")
                        .setText(R.id.tv_right_content,"")
                        .setImageResource(R.id.tv_right_content,R.mipmap.ic_com_logo);
//                ImageView icon = (ImageView)helper.itemView.findViewById(R.id.im_right);
//                x.image().bind(icon, application.getUserLogin().getUserInfo().getUserBaseInfo().getIcon(), application.options);

            }
            //教师
            else{
                helper.setVisible(R.id.ly_right, false)
                        .setVisible(R.id.ly_left,true)
                        .setText(R.id.tv_left_username,"")
                        .setText(R.id.tv_left_content,"")
                        .setImageResource(R.id.tv_right_content,R.mipmap.ic_com_logo);
//                ImageView icon = (ImageView)helper.itemView.findViewById(R.id.im_right);
//                x.image().bind(icon, userinfo.getIcon(), application.options);
            }

        }
    }

}
