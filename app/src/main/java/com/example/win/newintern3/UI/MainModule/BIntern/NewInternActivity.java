package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;


import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.BasePost;
import com.example.win.newintern3.NewEntity.CityInfo;
import com.example.win.newintern3.NewEntity.CompanyPracticePost;
import com.example.win.newintern3.NewEntity.PracticeBase;
import com.example.win.newintern3.NewEntity.PracticePlan;
import com.example.win.newintern3.NewEntity.TeacherInfo;
import com.example.win.newintern3.NewEntity.UserPractice;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.DateDialog;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.KeyBoardUtil;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class NewInternActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;

    @ViewInject(R.id.img_back)
    private ImageView back;

    @ViewInject(R.id.text_title)
    private TextView title;

    @ViewInject(R.id.text_save)
    private TextView save;

    @ViewInject(R.id.view_anp_plan_practice)
    private RelativeLayout view_plan;                //计划选择

    @ViewInject(R.id.text_anp_plan_name)
    private TextView tv_plan;                        //实习计划

    @ViewInject(R.id.spinner_way)
    private Spinner sp_way;                        //实习方式

    @ViewInject(R.id.text_anp_plan_time)
    private TextView tv_plan_time;                   //实习计划时间

    @ViewInject(R.id.text_anp_company_name)
    private TextView edt_company;                    //实习企业

    @ViewInject(R.id.text_anp_company_contacts)
    private EditText edt_company_contacts;           //企业联系人

    @ViewInject(R.id.text_anp_company_phone)
    private EditText edt_company_phone;              //企业电话

    @ViewInject(R.id.text_anp_practice_office)
    private EditText edt_office;                     //实习岗位

    @ViewInject(R.id.text_anp_practice_start_time)
    private TextView edt_start_time;                 //开始时间

    @ViewInject(R.id.text_anp_practice_end_time)
    private TextView edt_end_time;                   //结束时间

    @ViewInject(R.id.text_anp_practice_city)
    private EditText edt_selectcity;                 //选择城市

    @ViewInject(R.id.text_anp_practice_detailed_city)
    private EditText edt_detailed_address;           //详细地址

    @ViewInject(R.id.text_anp_school_people_name)
    private TextView edt_school_people;             //学校导师

    @ViewInject(R.id.text_anp_school_people_phone)
    private EditText edt_school_people_phone;       //学校导师电话

    @ViewInject(R.id.text_anp_company_people_name)
    private EditText edt_company_people;             //企业联系人

    @ViewInject(R.id.text_anp_company_people_phone)
    private EditText edt_company_people_phone;       //企业联系人电话

    @ViewInject(R.id.btn_anp_repost)
    private Button btnresults;                       //提交按钮

    @ViewInject(R.id.tv_title_info)
    private TextView tv_titl_info;                       //企业信息or基地信息


    @ViewInject(R.id.tv_title_name)
    private TextView tv_title_name;                       //实习企业or实习基地

    @ViewInject(R.id.tv_title_com_name)
    private TextView tv_title_com_name;                       //企业联系人or基地联系人

    @ViewInject(R.id.tv_title_phone)
    private TextView tv_title_phone;                       //企业电话or基地电话

//    @ViewInject(R.id.im_add_company_post)
//    private ImageView im_add_company_post;
//
//    @ViewInject(R.id.im_add_company_name)
//    private ImageView im_add_company_name;
//    @ViewInject(R.id.im_right_anp_company_name)
//    private ImageView im_right_anp_company_name;                       //企业联系人or基地联系人
//
//    @ViewInject(R.id.im_right_anp_practice_office)
//    private ImageView im_right_anp_practice_office;                       //企业电话or基地电话

    @ViewInject(R.id.tv_teacher_Id)
    private TextView teacher_id;

    private DateDialog dateDialog;
    public static int point = 0;


    private UserPractice practiceplan = null;//记录当前计划
    private CityInfo citylistEntity = null;//记录城市信息
    private CompanyPracticePost companyinfo = null;//记录当前选择的企业
    private PracticeBase baseinfo = null;//记录当前选择的基地
    private BasePost jobinfo = null;//记录当前选择的岗位
    private TeacherInfo teacherinfo = null;//记录当前选择的教师
    private MyApplication application;
    private ServiceEntity<PracticePlan> PracticePlanEntity;
//    private String[]teacherInfoList= new String[100];

    //
//    private BaseApplication application;
    private ServiceListEntity<TeacherInfo> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intern);
        x.view().inject(this);
        application = (MyApplication) getApplication();
        initview();
        getDate();

    }

    private void initview() {
        title.setText("申请实习");
        save.setText("");
        setSupportActionBar(toolbar);
        dateDialog = new DateDialog(this);
        back.setOnClickListener(this);
//        im_right_anp_company_name.setOnClickListener(this);
//        im_right_anp_practice_office.setOnClickListener(this);
        edt_company.setOnClickListener(this);
        edt_office.setOnClickListener(this);
        edt_start_time.setOnClickListener(this);
        edt_end_time.setOnClickListener(this);
        edt_selectcity.setOnClickListener(this);
        btnresults.setOnClickListener(this);
        edt_school_people.setOnClickListener(this);
//        im_add_company_post.setOnClickListener(this);
//        im_add_company_name.setOnClickListener(this);
        //资源转[]
        String meinv[] = getResources().getStringArray(R.array.meinv);
        //构造ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simple_spinner_item, meinv);
        //设置下拉样式以后显示的样式
        adapter.setDropDownViewResource(R.layout.my_drop_down_item);
        sp_way.setAdapter(adapter);
        sp_way.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                if(pos ==0){
                    //基地实习
                    point = 1;
                }else{
                    //企业实习
                    point = 3;
                }

                String[] languages = getResources().getStringArray(R.array.meinv);
                Toast.makeText(NewInternActivity.this, "你点击的是:" + pos + languages[pos], Toast.LENGTH_SHORT).show();
                if (pos == 0) {

                    edt_office.setText("");
                    edt_company_contacts.setText("");
                    edt_company_phone.setText("");
                    edt_detailed_address.setText("");
                    edt_start_time.setText("");
                    edt_end_time.setText("");
                    edt_selectcity.setText("");
                    edt_company_people.setText("");
                    edt_company.setText("");
                    edt_company_people_phone.setText("");
                    tv_titl_info.setText("基地信息");
                    tv_title_name.setText("实习基地");
                    tv_title_com_name.setText("基地联系人");
                    tv_title_phone.setText("基地电话");
//                   im_right_anp_practice_office.setVisibility(View.VISIBLE);
//                   im_right_anp_company_name.setVisibility(View.VISIBLE);
//                    edt_company.setVisibility(View.GONE);
//                    edt_office.setVisibility(View.GONE);


                } else {

                    edt_office.setText("");
                    edt_company_contacts.setText("");
                    edt_company_phone.setText("");
                    edt_detailed_address.setText("");
                    edt_start_time.setText("");
                    edt_end_time.setText("");
                    edt_selectcity.setText("");
                    edt_company_people.setText("");
                    edt_company_people_phone.setText("");
                    edt_company.setText("");
                    tv_titl_info.setText("企业信息");
                    tv_title_name.setText("实习企业");
                    tv_title_com_name.setText("企业联系人");
                    tv_title_phone.setText("企业电话");
                    edt_company.setVisibility(View.VISIBLE);
                    edt_office.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

    }

    private void getDate() {
        RequestParams params = new RequestParams(URLConfig.NewInternAPI);
//        params.addParameter("StudentId",application.getUserid());
        params.addParameter("StudentId", "4060");

        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {

                Logger.d(result);
//                PraticePlanEntity praticePlanEntity = JsonUtils.getPerson(result, PraticePlanEntity.class);
                PracticePlanEntity= JsonUtils.getServiceEntity(result, PracticePlan.class);
                if (PracticePlanEntity != null) {
                    tv_plan.setText(PracticePlanEntity.getEntity().getPracticeName());
                    tv_plan_time.setText(PracticePlanEntity.getEntity().getPlanStartTime() + "~" + PracticePlanEntity.getEntity().getPlanEndTime());
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
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
//            //新增自主实习企业
//            case R.id.im_add_company_name:
//                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
//                point = 3;
//                dateDialog.setting(edt_start_time, TimeUtils.getCurrentTimeInString(), null);
//                break;
//            //新增自主实习岗位
//            case R.id.im_add_company_post:
//                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
//                if (point == 0) {
//                    //基地
//                    intent = new Intent(this, BaseListActivity.class);
//                    startActivityForResult(intent, 0);
//                } else {
//                    //  企业
//                    intent = new Intent(this, ComListActivity.class);
//                    startActivityForResult(intent, 0);
//                }
//
//                break;
            //实习基地or企业
            case R.id.text_anp_company_name:
                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
                if (point == 1) {
                    //基地
                    intent = new Intent(this, BaseListActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    //  企业
                    intent = new Intent(this, ComListActivity.class);
                    startActivityForResult(intent, 0);
                }

                break;
            // 实习岗位
            case R.id.text_anp_practice_office:
                if(edt_company.getText()!=null) {
                    KeyBoardUtil.getInstance(NewInternActivity.this).hide();
                    if (point == 1) {
                        intent = new Intent(this, JobListActivity.class);
                        intent.putExtra(JobListActivity.intenttag1, baseinfo.getBaseId());
                        startActivityForResult(intent, 0);
                    }
                }
                else{
                    Toast.makeText(NewInternActivity.this,"请先选择实习企业",Toast.LENGTH_SHORT).show();
                }
                break;
            //开始实习时间
            case R.id.text_anp_practice_start_time:
                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
                dateDialog.setting(edt_start_time, TimeUtils.getCurrentTimeInString(), null);
                edt_end_time.setText("");
                break;
            case R.id.text_anp_practice_end_time://结束实习时间
                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
                if (edt_start_time.getText().toString().length() > 0) {
                    dateDialog.setting(edt_end_time, edt_start_time.getText().toString(), null);
                } else {
                    Toast.makeText(NewInternActivity.this, "请先选择开始实习时间", Toast.LENGTH_SHORT).show();
                }

                break;
            //实习城市
            case R.id.text_anp_practice_city:
//                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
//                intent = new Intent(this, FastCityActivity.class);
//                startActivityForResult(intent, 0);
                break;
            //教师
            case R.id.text_anp_school_people_name:
                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
//                dateDialog.setList("选择教师",edt_school_people, teacherInfoList);
               getTeacherList();

//                edt_school_people.setText("asdbasj");
//                intent = new Intent(this, TeacherList.class);
//                startActivityForResult(intent, 0);
                break;
            //提交操作
            case R.id.btn_anp_repost:
                KeyBoardUtil.getInstance(NewInternActivity.this).hide();
                if (
//                        practiceplan != null
//                        && citylistEntity != null
                        edt_company.getText().length() > 0
                        && edt_company_contacts.getText().length() > 0
                        && edt_company_phone.getText().length() > 0
                        && edt_office.getText().length() > 0
                        && edt_start_time.getText().length() > 0
                        && edt_end_time.getText().length() > 0
                        && edt_selectcity.getText().length() > 0
                        && edt_detailed_address.getText().length() > 0
                        && edt_school_people.getText().length() > 0
                        && edt_school_people_phone.getText().length() > 0
                        && edt_company_people.getText().length() > 0
                        && edt_company_people_phone.getText().length() > 0)
                {

                    RequestParams params = new RequestParams(URLConfig.AddPracticeAPI);
                    /** 用户ID */
                    params.addParameter("userId", application.getUserid());
                    /** 实习计划ID */
                    params.addParameter("planId",PracticePlanEntity.getEntity().getPlanId());
                    /** 基地计划ID */
                    params.addParameter("baseId", point==1 ? baseinfo.getBaseId() :companyinfo.getCompanyId());
                    /** 岗位ID */
                    params.addParameter("postId", point==1 ? jobinfo.getPostId() :companyinfo.getPostId());
                    /** 岗位名称 */
                    params.addParameter("practicePost",point==1 ?  jobinfo.getPostName():companyinfo.getPostName());
                    /** 学校指导教师ID */
                    params.addParameter("schoolTeacherId", teacher_id.getText());
//                    params.addParameter("schoolTeacherId","0");
                    /** 实习开始时间 */
                    params.addParameter("basePlanStartTime", edt_start_time.getText().toString());
                    /** 实习结束时间 */
                    params.addParameter("basePlanEndTime", edt_end_time.getText().toString());
                    /** 企业指导老师 */
                    params.addParameter("companyTeacher", edt_company_people.getText().toString());
                    /** 联系方式 */
                    params.addParameter("companyTeacherTel", edt_company_people_phone.getText().toString());
                    /** 实习状态	1：未开始；2：已开始；3：已转岗；4：已结束 */
                    params.addParameter("status", "1");
                    /** 实习地 */
                    params.addParameter("basePlanAddres", edt_detailed_address.getText().toString());
                    /** 实习省份ID */
                    params.addParameter("basePlanProvinceId", "0");
                    /** 实习城市ID */
//                    params.addParameter("basePlanCityId", String.valueOf(citylistEntity.getCityCode()));
                params.addParameter("basePlanCityId", "0");
                    /** 实习区县ID */
                    params.addParameter("basePlanContyId", "0");
                    /** 企业ID */
                    params.addParameter("companyId",  point==1 ? baseinfo.getBaseId() :companyinfo.getCompanyId());
                    /** 企业名称 */
                    params.addParameter("companyName", edt_company.getText().toString());
                    /** 实习方式	1：基地实习；2：自主实习；3：企业实习 */
                    params.addParameter("practiceType", point);
                    /** 公司聯繫人 */
                    params.addParameter("companyContact", edt_company_contacts.getText().toString());
                    /** 公司聯繫人電話 */
                    params.addParameter("companyPhone", edt_company_phone.getText().toString());

                    Logger.d(params);
                    x.http().post(params, new Callback.CommonCallback<String>() {

                        @Override
                        public void onSuccess(String s) {
                            Logger.d(s);
                            if (s != null && !s.equals("")) {

                                if (s.equals("{\"code\":\"200\"}")) {
                                    Toast.makeText(NewInternActivity.this, "申请成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else if (s.equals("{\"code\":\"500\"}")) {
                                    Toast.makeText(NewInternActivity.this, "申请失败", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else if (s.equals("{\"code\":\"450\"}")) {
                                        Toast.makeText(NewInternActivity.this, "不可重复申请", Toast.LENGTH_SHORT).show();
                                        finish();

                                } else if (s.equals("{\"code\":\"505\"}")) {
                                    Toast.makeText(NewInternActivity.this, "服务器错误 请稍后重试", Toast.LENGTH_SHORT).show();
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

                } else {
                    Toast.makeText(NewInternActivity.this, "信息未输入完整", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }




    //实习计划
    public final static int planresult = 1000;
    //企业
    public final static int enterprisenresult = 1001;
    //基地
    public final static int baseresult = 1002;
    //学校老师
    public final static int teacherresult = 1003;
    //城市
    public final static int cityresult = 1004;
    //岗位
    public final static int jobresult = 1005;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
//            //实习计划
//            case planresult:
//                practiceplan = (PracticePlan) data.getSerializableExtra("Practiceplan");
//                tv_plan.setText(practiceplan.getPracticeName());
//                tv_plan_time.setText(practiceplan.getPlanStartTime() + "~" + practiceplan.getPlanEndTime());
//                break;
            //企业
            case enterprisenresult:
                companyinfo = (CompanyPracticePost) data.getSerializableExtra("enterprise");

                edt_office.setText("");
                edt_company_contacts.setText("");
                edt_company_phone.setText("");
                edt_detailed_address.setText("");
                edt_start_time.setText("");
                edt_end_time.setText("");
                edt_selectcity.setText("");
                edt_company_people.setText("");
                edt_company_people_phone.setText("");
                edt_company.setText("");
                edt_company.setText(companyinfo.getCompanyInfo().getCompanyName());
                edt_company_contacts.setText(companyinfo.getCompanyInfo().getCompanyContacts());
                edt_company_phone.setText(companyinfo.getCompanyInfo().getCompanyTel());
                edt_detailed_address.setText(companyinfo.getCompanyInfo().getCompanyAddress());
                edt_office.setText(companyinfo.getPostName());
                edt_selectcity.setText("北京海淀区");
                break;
            //基地
            case baseresult:

                edt_office.setText("");
                edt_company_contacts.setText("");
                edt_company_phone.setText("");
                edt_detailed_address.setText("");
                edt_start_time.setText("");
                edt_end_time.setText("");
                edt_selectcity.setText("");
                edt_company_people.setText("");
                edt_company_people_phone.setText("");
                edt_company.setText("");
                baseinfo = (PracticeBase) data.getSerializableExtra("base");
                edt_company.setText(baseinfo.getBaseName());
                edt_company_contacts.setText(baseinfo.getContact());
                edt_company_phone.setText(baseinfo.getContactPhone());
                edt_detailed_address.setText(baseinfo.getAddress());
                edt_selectcity.setText("北京海淀区");
                break;
            //城市
            case cityresult:
                citylistEntity = (CityInfo) data.getSerializableExtra("city");
                edt_selectcity.setText(citylistEntity.getCityName());
                break;
            //岗位
            case jobresult:
                jobinfo = (BasePost) data.getSerializableExtra("job");
                edt_office.setText(jobinfo.getPostName());
                break;
//            //学校老师
            case teacherresult:
                teacherinfo = (TeacherInfo) data.getSerializableExtra("teacher");
                edt_school_people.setText(teacherinfo.getTeacherName());
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
    private void getTeacherList() {
        RequestParams params = new RequestParams(URLConfig.GetTeacherAPI);
        /** 实习计划ID */
        params.addParameter("PlanId",PracticePlanEntity.getEntity().getPlanId());
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Logger.d(result);
                list  = JsonUtils.getServiceListEntity(result, TeacherInfo.class);
                if (list.getCode().equals("200")) {

                    String[] teacherInfoList= new String[list.getList().size()];
                    for(int i=0;i<list.getList().size();i++){
                        teacherInfoList[i]=list.getList().get(i).getTeacherName();
                        Logger.d(i+teacherInfoList[i]);
//                        teacherInfoList[i][1]=Entity.getList().get(i).getTeacherId().toString();
                    }
                 dateDialog.setList("选择教师",edt_school_people,edt_school_people_phone,teacher_id, teacherInfoList,list);

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

}
