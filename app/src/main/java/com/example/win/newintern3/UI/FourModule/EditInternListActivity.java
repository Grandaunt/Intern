package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.NewEntity.ExperiencePractice;
import com.example.win.newintern3.NewEntity.QuestionInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.logger.Logger;

import java.util.List;

public class EditInternListActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private TextView save;
    private ImageView back;
    public static  String intenttag1 = "EditInternId";
    private List<ExperiencePractice> mData;
    private RecyclerView recyclerView;
    private EditInternListAdapter adapter;
    private  Intent  intent;
    private Button btn_add_pra_exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_intern_list);
        mData = (List<ExperiencePractice>) getIntent().getSerializableExtra(intenttag1);
        findview();

    }



    private void findview() {

        title = (TextView) findViewById(R.id.text_title);
        title.setText("实习经历");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);

        btn_add_pra_exp = (Button) findViewById(R.id.btn_add_pra_exp);
        btn_add_pra_exp.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_resume_intern);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter = new EditInternListAdapter(mData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_add_pra_exp:
                intent = new Intent(EditInternListActivity.this, EditInternInfoActivity.class);
//                            intent.putExtra("type", 3);
                startActivity(intent);

                break;
        }
    }



    private class EditInternListAdapter extends BaseQuickAdapter<ExperiencePractice> {
        public EditInternListAdapter( List<ExperiencePractice> data) {
            super(R.layout.item_edit_pra_list, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final ExperiencePractice item, int positions) {

            helper.setText(R.id.item_deit_intern_list_time, item.getPracticeStartTime()+"-"+item.getPracticeEndTime())
                    .setText(R.id.item_deit_intern_list_com_wprk, item.getCompanyName()+"/"+item.getPracticePost())
                    .setText(R.id.item_deit_intern_list_desc, item.getPracticeDes())
                    .setOnClickListener(R.id.lv_item_pra_eit, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Logger.e(item.toString());
                            intent = new Intent(EditInternListActivity.this, EditInternInfoActivity.class);
//                            intent.putExtra("type", 3);
                            intent.putExtra(intenttag1, item);
                            startActivity(intent);
                        }
                    });
        }
    }
}
