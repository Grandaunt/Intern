package com.example.win.newintern3.UI.FourModule;

import android.content.Intent;
import android.os.Bundle;
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

import com.example.win.newintern3.Adpter.DepartmentAdapter;
import com.example.win.newintern3.Adpter.GradesAdapter;
import com.example.win.newintern3.Adpter.MajorAdapter;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Entity.SchoolDepartmentEntity;
import com.example.win.newintern3.Entity.SchoolGradesEntity;
import com.example.win.newintern3.Entity.SchoolMajorEntity;
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


/**
 * 学生学校/专业/班级选择
 */
public class SchoolInfoActivity extends AppCompatActivity implements View.OnClickListener{
    public static String IntentLink = "schoolinfo";
    public static int IntentIndex = 0;

    public static String intoSchool = "";
    public static String intoSchoolLink = "intoSchool";

    public static String SchoolIdLink = "SchoolId";
    public static String SchoolId = "";
    public static String DepartmentIdLink = "DepartmentId";
    public static String DepartmentId = "";

    public static String department = "department";
    public static String major = "major";
    public static String grades = "grades";

    public static int departmentResult = 0x03;
    public static int majorResult = 0x04;
    public static int gradesResult = 0x05;

    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private EditText search;
    private ImageView searchclean;
    private RecyclerView recyclerView;

    private static SchoolDepartmentEntity schoolDepartmentEntity;//院系数据
    private SchoolMajorEntity schoolMajorEntity;//专业数据
    private SchoolGradesEntity schoolGradesEntity;//班级数据

    private DepartmentAdapter dadapter;
    private MajorAdapter madapter;
    private GradesAdapter gadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        findview();
        IntentIndex = getIntent().getIntExtra(IntentLink, 0x03);
        intoSchool = getIntent().getStringExtra(intoSchoolLink);
        switch (IntentIndex) {
            case 0x03:
                SchoolId = getIntent().getStringExtra(SchoolIdLink);
                title.setText("选择院系");

                dadapter = new DepartmentAdapter(null);
//                dadapter.openLoadAnimation();
                dadapter.setOnRecyclerViewItemClickListener(this);
                recyclerView.setAdapter(dadapter);
                RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
                params.addParameter("action","getD");
                params.addParameter("schoolId", SchoolId);
                params.addParameter("intoSchool", intoSchool);
                Logger.d(params);
                x.http().post(params, new Callback.CacheCallback<String>() {
                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }

                    @Override
                    public void onSuccess(String result) {
                        Logger.d(result);
                        SchoolDepartmentEntity schoolDepartmentEntity = JsonUtils.getPerson(result, SchoolDepartmentEntity.class);
                        if (schoolDepartmentEntity != null) {
                            SchoolInfoActivity.this.schoolDepartmentEntity = schoolDepartmentEntity;
                            dadapter.setNewData(schoolDepartmentEntity.getDepartment());
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
                        //存储缓存
                    }
                });
                break;
            case 0x04:
                DepartmentId = getIntent().getStringExtra(DepartmentIdLink);
                title.setText("选择专业");
                madapter = new MajorAdapter(null);
//                madapter.openLoadAnimation();

                madapter.setOnRecyclerViewItemClickListener(this);
                recyclerView.setAdapter(madapter);

                RequestParams paramsM= new RequestParams(URLConfig.UserInfoAPI);
                paramsM.addParameter("action","getM");
                paramsM.addParameter("departmentId", DepartmentId);
                paramsM.addParameter("intoSchool", intoSchool);
                Logger.d(paramsM);
                x.http().post(paramsM, new Callback.CacheCallback<String>() {
                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }

                    @Override
                    public void onSuccess(String result) {
                        Logger.d(result);
                        SchoolMajorEntity schoolMajorEntity = JsonUtils.getPerson(result, SchoolMajorEntity.class);
                        if (schoolMajorEntity != null) {
                            SchoolInfoActivity.this.schoolMajorEntity = schoolMajorEntity;
                            madapter.setNewData(schoolMajorEntity.getMajor());
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
                        //存储缓存
                    }
                });
                break;
            case 0x05:
                DepartmentId = getIntent().getStringExtra(DepartmentIdLink);
                title.setText("选择班级");

                gadapter = new GradesAdapter(null);
//                gadapter.openLoadAnimation();
                gadapter.setOnRecyclerViewItemClickListener(this);
                recyclerView.setAdapter(gadapter);

                RequestParams paramsG = new RequestParams(URLConfig.UserInfoAPI);
                paramsG.addParameter("action","getG");
                paramsG.addParameter("schoolId", DepartmentId);
                paramsG.addParameter("intoSchool", intoSchool);
                Logger.d(paramsG);
                x.http().post(paramsG, new Callback.CacheCallback<String>() {
                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }

                    @Override
                    public void onSuccess(String result) {
                        Logger.d(result);
                        SchoolGradesEntity schoolGradesEntity= JsonUtils.getPerson(result, SchoolGradesEntity.class);
                        if (schoolGradesEntity != null) {
                            SchoolInfoActivity.this.schoolGradesEntity = schoolGradesEntity;
                            gadapter.setNewData(schoolGradesEntity.getGrades());
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
                        //存储缓存
                    }
                });
                break;
        }
    }

    private void findview() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.text_title);
        search = (EditText) findViewById(R.id.et_search);
        searchclean = (ImageView) findViewById(R.id.iv_search_clear);
        searchclean.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_asi_data);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    searchclean.setVisibility(View.GONE);
                    switch (IntentIndex) {
                        case 0x03:
                            dadapter.setNewData(schoolDepartmentEntity.getDepartment());
                            break;
                        case 0x04:
                            madapter.setNewData(schoolMajorEntity.getMajor());
                            break;
                        case 0x05:
                            gadapter.setNewData(schoolGradesEntity.getGrades());
                            break;
                    }


                }else{
                    searchclean.setVisibility(View.VISIBLE);
                    switch (IntentIndex) {
                        case 0x03:
                            if (schoolDepartmentEntity != null) {
                                List<SchoolDepartmentEntity.DepartmentEntity> cacheschSchoolDepartmentEntity = new ArrayList<SchoolDepartmentEntity.DepartmentEntity>();
                                for (SchoolDepartmentEntity.DepartmentEntity item : schoolDepartmentEntity.getDepartment()) {
                                    if (item.getDepartmentName().contains(s)) {
                                        cacheschSchoolDepartmentEntity.add(item);
                                    }
                                }
                                dadapter.setNewData(cacheschSchoolDepartmentEntity);

                            }
                        break;
                        case 0x04:
                            if (schoolMajorEntity != null) {
                                List<SchoolMajorEntity.MajorEntity> cacheMajorEntities = new ArrayList<SchoolMajorEntity.MajorEntity>();
                                for (SchoolMajorEntity.MajorEntity item : schoolMajorEntity.getMajor()) {
                                    if (item.getMajorName().contains(s)) {
                                        cacheMajorEntities.add(item);
                                    }
                                }
                                madapter.setNewData(cacheMajorEntities);
                            }

                            break;
                        case 0x05:
                            if (schoolGradesEntity != null) {
                                List<SchoolGradesEntity.GradesEntity> cachegrGradesEntities = new ArrayList<SchoolGradesEntity.GradesEntity>();
                                for (SchoolGradesEntity.GradesEntity item : schoolGradesEntity.getGrades()) {
                                    if (item.getGradesName().contains(s)) {
                                        cachegrGradesEntities.add(item);
                                    }
                                }
                                gadapter.setNewData(cachegrGradesEntities);
                            }
                            break;
                    }
                }

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.iv_search_clear:
                searchclean.setVisibility(View.GONE);
                search.setText("");
                break;
        }
    }

    private Intent intent;
//    @Override
//    public void onItemClick(View view, int position, Object item) {
//        KeyBoardUtil.getInstance(SchoolInfoActivity.this).hide();
//        switch (IntentIndex) {
//            case 0x03:
//                intent = new Intent();
//                intent.putExtra(department, (SchoolDepartmentEntity.DepartmentEntity) item);
//                setResult(departmentResult,intent);
//                finish();
//                break;
//            case 0x04:
//                intent = new Intent();
//                intent.putExtra(major, (SchoolMajorEntity.MajorEntity) item);
//                setResult(majorResult,intent);
//                finish();
//                break;
//            case 0x05:
//                intent = new Intent();
//                intent.putExtra(grades, (SchoolGradesEntity.GradesEntity) item);
//                setResult(gradesResult,intent);
//                finish();
//                break;
//        }
//    }
//
//    //院系相关
//    private class DepartmentAdapter extends BaseQuickAdapter<SchoolDepartmentEntity.DepartmentEntity> {
//
//        public DepartmentAdapter( List<SchoolDepartmentEntity.DepartmentEntity> data) {
//            super(R.layout.item_base, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, SchoolDepartmentEntity.DepartmentEntity item) {
//            helper.setText(R.id.item_title, item.getDepartmentName());
//        }
//    }
//
//    private abstract class DepartmentCallBack extends AbsCallback<SchoolDepartmentEntity> {
//        @Override
//        public SchoolDepartmentEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s,SchoolDepartmentEntity.class);
//        }
//    }
//
//    //专业相关
//    private class MajorAdapter extends BaseQuickAdapter<SchoolMajorEntity.MajorEntity> {
//
//        public MajorAdapter( List<SchoolMajorEntity.MajorEntity> data) {
//            super(R.layout.item_base, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, SchoolMajorEntity.MajorEntity item) {
//            helper.setText(R.id.item_title, item.getMajorName());
//        }
//    }
//    private abstract class MajorCallBack extends AbsCallback<SchoolMajorEntity> {
//        @Override
//        public SchoolMajorEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s,SchoolMajorEntity.class);
//        }
//    }
//
//    //班级相关
//    private class GradesAdapter extends BaseQuickAdapter<SchoolGradesEntity.GradesEntity> {
//
//        public GradesAdapter( List<SchoolGradesEntity.GradesEntity> data) {
//            super(R.layout.item_base, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, SchoolGradesEntity.GradesEntity item) {
//            helper.setText(R.id.item_title, item.getGradesName());
//        }
//    }
//    private abstract class GradesCallBack extends AbsCallback<SchoolGradesEntity> {
//        @Override
//        public SchoolGradesEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s,SchoolGradesEntity.class);
//        }
//    }
}
