package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DividerItemDecoration;
import com.example.win.newintern3.Utils.KeyBoardUtil;


/**
 * 个人信息----->学校
 * 搜索学校信息
 *
 * @author taoshixiong
 */
public class SearchSchoolActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int resultCode = 0x02;
    public static final String resultData = "schoolinfo";
    private Toolbar toolbar;
    private ImageView back;
    private EditText searchtext;        //搜索文本
    private ImageView clear;            //搜索清空按钮
    private TextView serach;            //搜索按钮
    private RecyclerView recyclerView;  //展示结果

//    private SchoolAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_school);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);

        findview();
    }

    private void findview() {
        searchtext = (EditText) findViewById(R.id.et_search);
        clear = (ImageView) findViewById(R.id.iv_search_clear);
        serach = (TextView) findViewById(R.id.text_search);
        clear.setOnClickListener(this);
        serach.setOnClickListener(this);
        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    clear.setVisibility(View.GONE);
                    serach.setEnabled(false);
                } else {
                    clear.setVisibility(View.VISIBLE);
                    serach.setEnabled(true);
                }
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.recycler_ass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

//        adapter = new SchoolAdapter(null);
//        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<BaseSchoolEntity.SchoollistEntity>() {
//            @Override
//            public void onItemClick(View view, int position, BaseSchoolEntity.SchoollistEntity item) {
//                Intent intent = new Intent();
//                intent.putExtra(resultData, item);
//                setResult(resultCode, intent);
//                finish();
//
//            }
//        });
//        recyclerView.setAdapter(adapter);
    }

    /**
     * 搜索数据
     *

     */
//    private void searchdata(String s) {
//        OkHttpUtils.post(BuildConfig.UserInfoAPI)
//                .tag(this)
//                .params("action", "getschoolbykw")
//                .params("kw", s)
//                .execute(new SearchCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, BaseSchoolEntity baseSchoolEntity, Request request, @Nullable Response response) {
//                        if (baseSchoolEntity != null) {
//                            adapter.setNewData(baseSchoolEntity.getSchoollist());
//                        }
//                    }
//
//                    @Override
//                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(isFromCache, call, response, e);
//                        Toast.makeText(SearchSchoolActivity.this, getString(R.string.network_error), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private abstract class SearchCallBack extends AbsCallback<BaseSchoolEntity> {
//        @Override
//        public BaseSchoolEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s, BaseSchoolEntity.class);
//        }
//    }
//
//    private class SchoolAdapter extends BaseQuickAdapter<BaseSchoolEntity.SchoollistEntity> {
//        public SchoolAdapter(List<BaseSchoolEntity.SchoollistEntity> data) {
//            super(R.layout.item_base, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, BaseSchoolEntity.SchoollistEntity item) {
//            helper.setText(R.id.item_title, item.getSchoolName());
//
//        }
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.iv_search_clear:
                searchtext.setText("");
                clear.setVisibility(View.GONE);
                serach.setEnabled(false);
                break;
            case R.id.text_search:
                KeyBoardUtil.getInstance(SearchSchoolActivity.this).showOrHide();
//                searchdata(searchtext.getText().toString());
                break;
        }
    }
}
