package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.NewEntity.CompanyInfo;
import com.example.win.newintern3.NewEntity.CompanyPracticePost;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.logger.Logger;

public class AddComInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private ImageView back;
    private TextView save;
    private EditText comName;
    private EditText comPeople;
    private EditText comPhone;
    private EditText comPost;
    private CompanyPracticePost item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_com_info);
        NewInternActivity.point=2;
        findview();
    }
    private void findview() {

        title = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.img_back);
        save = (TextView) findViewById(R.id.text_save);
        comName = (EditText) findViewById(R.id.tv_add_company_name) ;
        comPeople  = (EditText) findViewById(R.id.tv_add_company_people) ;
        comPhone = (EditText) findViewById(R.id.tv_add_company_people_phone) ;
        comPost = (EditText) findViewById(R.id.tv_add_company_post) ;
        save.setText("保存");
        title.setText("输入企业名称");
        back.setOnClickListener(this);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                if(comName.getText()!=null) {
                    item = new CompanyPracticePost();
                    CompanyInfo companyInfo = new CompanyInfo();
                    companyInfo.setCompanyName(comName.getText().toString());
                    companyInfo.setCompanyContacts(comPeople.getText().toString());
                    companyInfo.setCompanyTel(comPhone.getText().toString());
                    companyInfo.setCompanyIcon("asd.png");
//                    companyInfo.setCompanyId(0);
                    item.setPostName(comPost.getText().toString());
                    item.setCompanyInfo(companyInfo);
                    item.setPostId(0);
                    item.setCompanyId(0);
                    item.setIntentionTrade("");
                    item.setPostNum(0);
                    Intent intent = new Intent();
                    intent.putExtra("addCom", item);
                    setResult(ComListActivity.addcomresultCode, intent);
                    finish();
                }
                else {
                    Toast.makeText(AddComInfoActivity.this,"公司名称不能为空",Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


}
