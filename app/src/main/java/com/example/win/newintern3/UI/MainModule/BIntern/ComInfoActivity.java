package com.example.win.newintern3.UI.MainModule.BIntern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.NewEntity.CompanyPracticePost;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.image.ImageOptions;
import org.xutils.x;


public class ComInfoActivity extends AppCompatActivity implements View.OnClickListener {
    public static  String intenttag1 = "comInfoId";
    private CompanyPracticePost mData;

    private Toolbar toolbar;
    private TextView title;
    private ImageView coll;
    private ImageView back;

    private ImageView icon;          //图标
    private TextView name;           //职位名称
    private TextView company;        //公司名称
    private TextView internTime;     //实习开始时间-实习结束时间
    private TextView money;             //薪资待遇
    private TextView peoplenum;       //招聘人数
    private TextView address;         //工作地点
    private TextView zStartTime;      //招聘开始时间
    private TextView zEndTime;         //招聘结束时间
    private TextView conName;           //联系人
    private TextView conPhone;           //联系电话
    private TextView claim;                 //岗位要求
    private Button repost;                  //申请

    private String postId;
    private int postType;
    private ImageOptions options;
    private MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_info);
        application = (MyApplication) getApplication();
        x.view().inject(this);
        getdata();
        findview();
        initview();
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

    private void initview() {
//        icon.setImageResource(R.mipmap.ic_coll_f);
        Logger.i("mData.getCompanyInfo().getCompanyIcon()="+mData.getCompanyInfo().getCompanyIcon());
        x.image().bind(icon, mData.getCompanyInfo().getCompanyIcon(), options);


        name.setText(mData.getCompanyInfo().getCompanyName());
        company.setText(mData.getCompanyInfo().getCompanyName());
        internTime.setText(mData.getCompanyInfo().getIndustryId());
        money.setText(mData.getPostMoney());
        peoplenum.setText(mData.getPostName());
        address.setText(mData.getPosition());
        zStartTime.setText(mData.getPostStartTime());
        zEndTime.setText(mData.getPostEndTime());
        conName.setText(mData.getCompanyInfo().getCompanyContacts());
        conPhone.setText(mData.getCompanyInfo().getCompanyTel());
        claim.setText(mData.getPostDes());

    }


    private void findview() {

        back = (ImageView) findViewById(R.id.img_back_coll);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title_coll);
        title.setText("职位详情");
        coll = (ImageView) findViewById(R.id.too_im_coll);
        coll.setOnClickListener(this);

        icon = (ImageView) findViewById(R.id.im_post_info_com_icon);
        name = (TextView) findViewById(R.id.tv_post_info_post_name);
        company = (TextView) findViewById(R.id.tv_post_info_com_name);
        internTime = (TextView) findViewById(R.id.tv_post_info_item);
        money = (TextView) findViewById(R.id.tv_post_info_money);
        peoplenum = (TextView) findViewById(R.id.tv_post_info_peoplenum);
        address = (TextView) findViewById(R.id.tv_post_info_address);
        zStartTime = (TextView) findViewById(R.id.tv_post_info_start_time);
        zEndTime = (TextView) findViewById(R.id.tv_post_info_end_time);
        conName = (TextView) findViewById(R.id.tv_post_info_com_con_name);
        conPhone = (TextView) findViewById(R.id.tv_post_info_com_con_phone);
        claim = (TextView) findViewById(R.id.tv_post_info_desc);
        repost = (Button) findViewById(R.id.btn_post_repost);
        repost.setOnClickListener(this);
        if (postType == 1) {
            repost.setVisibility(View.GONE);
        }
        repost.setOnClickListener(this);


    }



    public Object getdata() {
        mData = (CompanyPracticePost) getIntent().getSerializableExtra(intenttag1);
        Logger.i("mData.getCompanyId()="+mData.getPostEndTime());
        return mData;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back_coll:
                finish();
                break;
            case R.id.too_im_coll:
//                finish();
                break;
            case R.id.btn_post_repost:
//                RequestParams params = new RequestParams(URLConfig.FindPracticeAPI);
//                params.addParameter("mobile",edt_username.getText().toString());
//                params.addParameter("action","login");
//                params.addParameter("password",edt_code.getText().toString());
//                params.addParameter("actionAddress", "0,0");
//                params.addParameter("networkType","1");
//                params.addParameter("loginType","1");
//                params.addParameter("JGID","1");
//                params.addParameter("deviceType","Android");
//                Logger.d(params);
//                x.http().post(params, new Callback.CommonCallback<String>() {
//                    @Override
//                    public void onSuccess(String result) {
//
//                        Logger.d(result);
//                        if (result.equals("{\"code\":\"200\"}")) {
//                            Toast.makeText(ComInfoActivity.this, "申请成功", Toast.LENGTH_SHORT).show();
//                            finish();
//                        } else if (result.equals("{\"code\":\"300\"}")) {
//                            Toast.makeText(ComInfoActivity.this, "已经申请过该实习了", Toast.LENGTH_SHORT).show();
//                        } else if (result.equals("{\"code\":\"505\"}")) {
//                            Toast.makeText(ComInfoActivity.this, "申请失败", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Logger.d(ex);
//                    }
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//                    }
//                    @Override
//                    public void onFinished() {
//                    }
//                });

                break;

            default:
                break;
        }
    }
}
