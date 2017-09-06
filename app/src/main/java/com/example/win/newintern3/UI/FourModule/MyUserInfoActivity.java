package com.example.win.newintern3.UI.FourModule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.BaseActivity;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.Entity.BaseSchoolEntity;
import com.example.win.newintern3.Entity.SchoolDepartmentEntity;
import com.example.win.newintern3.Entity.SchoolGradesEntity;
import com.example.win.newintern3.Entity.SchoolMajorEntity;
import com.example.win.newintern3.NewEntity.UserBaseInfo;
import com.example.win.newintern3.NewEntity.UserLogin;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.KeyBoardUtil;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.YMDatePickerDialog;
import com.example.win.newintern3.Utils.logger.Logger;
import com.example.win.newintern3.Widgets.ActionSheetDialog;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/***
 * 个人基础信息
 */
public class MyUserInfoActivity extends BaseActivity implements View.OnClickListener {

    private Intent intent;
    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;

    private ImageView usericon;              //用户头像
    private EditText username;                      //姓名
    private RadioGroup male;                        //性别
    private EditText nicename;                      //昵称
    private EditText birthday;                      //出生年月
    private EditText IDcare;                        //身份证号
    private EditText school;                        //学校
    private EditText inschool;                      //入学年份
    private EditText college;                       //院系
    private EditText profession;                    //专业
    private EditText userclass;                     //班级
    private EditText schoolcode;                    //学号
    private EditText outschool;                     //离校年份
    private RadioButton radioButton1;                //男

    private static final int REQUEST_SELECT_PICTURE = 0x01;

    private BaseSchoolEntity.SchoollistEntity schoolinfo;//学校信息

    private SchoolDepartmentEntity.DepartmentEntity d;//院系信息
    private SchoolMajorEntity.MajorEntity m;//专业信息
    private SchoolGradesEntity.GradesEntity g;//班级信息

    private MyApplication application;


    private ImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_user_info);
        application = (MyApplication) getApplication();

        //头像
        options = new ImageOptions.Builder()
                //设置圆形
                .setCircular(true)
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_launcher)
//设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_launcher)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
        getuserinfo();
        findview();
    }
    private void findview() {
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("个人基本信息");
        save = (TextView) findViewById(R.id.text_save);
        save.setText("保存");

        back.setOnClickListener(this);
        save.setOnClickListener(this);

        usericon = (ImageView) findViewById(R.id.riv_userinfo_icon);
        username = (EditText) findViewById(R.id.text_userinfo_name);
        male = (RadioGroup) findViewById(R.id.radiogroup_userinfo_male);
        nicename = (EditText) findViewById(R.id.text_userinfo_nice_name);
        birthday = (EditText) findViewById(R.id.text_userinfo_birthday);
        IDcare = (EditText) findViewById(R.id.text_userinfo_IDcard);
        school = (EditText) findViewById(R.id.text_userinfo_school);
        inschool = (EditText) findViewById(R.id.text_userinfo_inschooldate);
        college = (EditText) findViewById(R.id.text_userinfo_college);
        profession = (EditText) findViewById(R.id.text_userinfo_profession);
        userclass = (EditText) findViewById(R.id.text_userinfo_class);
        schoolcode = (EditText) findViewById(R.id.text_userinfo_school_code);
        outschool = (EditText) findViewById(R.id.text_userinfo_outschooldate);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);

        usericon.setOnClickListener(this);
        school.setOnClickListener(this);
        birthday.setOnClickListener(this);
        inschool.setOnClickListener(this);
        outschool.setOnClickListener(this);
        college.setOnClickListener(this);
        profession.setOnClickListener(this);
        userclass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                KeyBoardUtil.getInstance(MyUserInfoActivity.this).hide();
//                if (checkuserinfo()) {
                    RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
                    params.addParameter("action","weekreportlist");
                    /***
                     *        用户头像上传...
                     */
                    params.addParameter("userId",application.getUserid());
                    params.addParameter("trueName",username.getText().toString());
                    params.addParameter("male",radioButton1.isChecked()?"1":"0");
                    params.addParameter("nickName",nicename.getText().toString());
                    params.addParameter("schoolId",String.valueOf(schoolinfo.getSchoolId()));
                    params.addParameter("intoSchool",inschool.getText().toString());
                    params.addParameter("majorId",String.valueOf(m.getMajorId()));
                    params.addParameter("departmentId",String.valueOf(d.getDepartmentId()));
                    params.addParameter("gradesId",String.valueOf(g.getGradesId()));
                    params.addParameter("leftSchool",outschool.getText().toString());
                    params.addParameter("userBirth",birthday.getText().toString());
                    params.addParameter("userIDCard",IDcare.getText().toString());
                    params.addParameter("userCode",schoolcode.getText().toString());
                    Logger.d(params);
                    x.http().post(params, new Callback.CacheCallback<String>() {
                        @Override
                        public boolean onCache(String result) {

                            return false;
                        }

                        @Override
                        public void onSuccess(String result) {

                            Logger.d(result);
                            ServiceListEntity<UserLogin> Entity  = JsonUtils.getServiceListEntity(result, UserLogin.class);

                            if (Entity != null) {
                                if (Entity.getCode().equals("200")) {
                                    intouserinfo(Entity.getList().get(0).getUserBaseInfo());
                                    Toast.makeText(MyUserInfoActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(MyUserInfoActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
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
//                }

                break;
            case R.id.riv_userinfo_icon:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                        && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                            "选择头像时需要用到读取文件权限",
                            REQUEST_STORAGE_READ_ACCESS_PERMISSION);
                } else {
                    showSheetDialog();
                }
                break;
            case R.id.text_userinfo_school://选择学校
                intent = new Intent(MyUserInfoActivity.this, SearchSchoolActivity.class);
                startActivityForResult(intent, 0);
                break;
            case R.id.text_userinfo_birthday://选择生日
                Calendar c = Calendar.getInstance();
                new YMDatePickerDialog(MyUserInfoActivity.this, 0, new YMDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                          int startDayOfMonth) {
                        String textString = String.format("%d-%02d", startYear,
                                startMonthOfYear + 1);
                        birthday.setText(textString);
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE)).show();

                break;
            case R.id.text_userinfo_inschooldate://入学时间
                Calendar intoschool = Calendar.getInstance();
                new YMDatePickerDialog(MyUserInfoActivity.this, 1, new YMDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                          int startDayOfMonth) {
                        String textString = String.format("%d", startYear);
                        inschool.setText(textString);
                        //清除院系专业班级信息
                        d = null;
                        m = null;
                        g = null;
                        college.setText("");
                        profession.setText("");
                        userclass.setText("");
                    }
                }, intoschool.get(Calendar.YEAR), intoschool.get(Calendar.MONTH), intoschool.get(Calendar.DATE)).show();
                break;

            case R.id.text_userinfo_outschooldate:
                Calendar outschoold = Calendar.getInstance();
                new YMDatePickerDialog(MyUserInfoActivity.this, 1, new YMDatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                          int startDayOfMonth) {
                        String textString = String.format("%d", startYear);
                        outschool.setText(textString);
                    }
                }, outschoold.get(Calendar.YEAR), outschoold.get(Calendar.MONTH), outschoold.get(Calendar.DATE)).show();
                break;
            case R.id.text_userinfo_college://院系
                if (school.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择学校",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (inschool.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择入校时间",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent = new Intent(MyUserInfoActivity.this, SchoolInfoActivity.class);
                intent.putExtra(SchoolInfoActivity.IntentLink, SchoolInfoActivity.departmentResult);
                intent.putExtra(SchoolInfoActivity.SchoolIdLink, String.valueOf(schoolinfo.getSchoolId()));
                intent.putExtra(SchoolInfoActivity.intoSchoolLink, inschool.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.text_userinfo_profession:
                if (inschool.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择入校时间",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (college.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择院系",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent = new Intent(MyUserInfoActivity.this, SchoolInfoActivity.class);
                intent.putExtra(SchoolInfoActivity.IntentLink, SchoolInfoActivity.majorResult);
                intent.putExtra(SchoolInfoActivity.intoSchoolLink, inschool.getText().toString());
                intent.putExtra(SchoolInfoActivity.DepartmentIdLink, String.valueOf(d.getDepartmentId()));
                startActivityForResult(intent, 0);
                break;
            case R.id.text_userinfo_class:
                if (inschool.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择入校时间",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (college.getText().length() <= 0) {
                    Toast.makeText(MyUserInfoActivity.this,"还没有选择院系",Toast.LENGTH_SHORT).show();
                    return;
                }
                intent = new Intent(MyUserInfoActivity.this, SchoolInfoActivity.class);
                intent.putExtra(SchoolInfoActivity.IntentLink, SchoolInfoActivity.gradesResult);
                intent.putExtra(SchoolInfoActivity.intoSchoolLink, inschool.getText().toString());
                intent.putExtra(SchoolInfoActivity.DepartmentIdLink, String.valueOf(d.getDepartmentId()));
                startActivityForResult(intent, 0);
                break;
        }
    }

    /**
     * 网络数据
     */
    private void getuserinfo() {
        RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
        params.addParameter("action","getbaseinfo");
        params.addParameter("userId", application.getUserid());
        Logger.d(params);
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Logger.d(result);
                ServiceListEntity<UserLogin> Entity  = JsonUtils.getServiceListEntity(result, UserLogin.class);
                if (Entity != null) {
                    intouserinfo(Entity.getList().get(0).getUserBaseInfo());
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

    }

    /**
     * 检查用户信息的完整性
     * @return
     */
    private boolean checkuserinfo() {
        if (username.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有填写姓名",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (nicename.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有填写昵称",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (birthday.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择出生年月",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (school.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择学校",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (inschool.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择入学年份",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (college.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择院系",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (profession.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择专业",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (userclass.getText().length() <= 0) {
            Toast.makeText(MyUserInfoActivity.this,"还没有选择班级",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void intouserinfo(UserBaseInfo userinfo) {
        //先设置好各信息
        schoolinfo = new BaseSchoolEntity.SchoollistEntity();
        schoolinfo.setSchoolId(userinfo.getSchoolId());
        schoolinfo.setSchoolName(userinfo.getSchoolName());

        d = new SchoolDepartmentEntity.DepartmentEntity();
        d.setDepartmentId(userinfo.getDepartmentId());
        d.setDepartmentName(userinfo.getDepartmentName());

        m = new SchoolMajorEntity.MajorEntity();
        m.setMajorId(userinfo.getMajorId());
        m.setMajorName(userinfo.getMajorName());

        g = new SchoolGradesEntity.GradesEntity();
        g.setGradesId(userinfo.getGradesId());
        g.setGradesName(userinfo.getGradeName());
        x.image().bind(usericon, userinfo.getIcon(), options);
//        Picasso.with(this).load(userinfo.getIcon()).error(R.mipmap.ic_company_def_logo).placeholder(R.mipmap.ic_company_def_logo).into(usericon);

        username.setText(userinfo.getTrueName());
        if (userinfo.getMale() == 0) {
            male.check(R.id.radio2);
        }else{
            male.check(R.id.radio1);
        }
        nicename.setText(userinfo.getNickName());
        birthday.setText(userinfo.getUserBirth());
        IDcare.setText(userinfo.getUserIDCard());
        school.setText(userinfo.getSchoolName());
        inschool.setText(userinfo.getIntoSchool());
        college.setText(userinfo.getDepartmentName());
        profession.setText(userinfo.getMajorName());
        userclass.setText(userinfo.getGradeName());
        schoolcode.setText(userinfo.getUserCode());
        outschool.setText(userinfo.getLeftSchool());
    }


//
//    /**
//     * 当权限请求已完成回调。
//     */
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch (requestCode) {
//            case REQUEST_STORAGE_READ_ACCESS_PERMISSION:
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                 showSheetDialog();
//                }
//                break;
//            default:
//                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        }
//    }



//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            if (requestCode == REQUEST_SELECT_PICTURE) {
//                final Uri selectedUri = data.getData();
//                if (selectedUri != null) {
//                    startCropActivity(data.getData());
//                } else {
//                    Logger.d("error");
//                }
//            } else if (requestCode == UCrop.REQUEST_CROP) {
//                //头像上传操作
//                final Uri resultUri = UCrop.getOutput(data);
//                RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
//                params.addParameter("icon",new File(resultUri.getPath()));
//                params.addParameter("userId", application.getUserid());
//                Logger.d(params);
//                x.http().post(params, new Callback.CacheCallback<String>() {
//                    @Override
//                    public boolean onCache(String result) {
//                        return false;
//                    }
//
//                    @Override
//                    public void onSuccess(String result) {
//                        Logger.d(result);
//                        UserInfoEntity userInfoEntity = JsonUtils.getPerson(result, UserInfoEntity.class);
//                        if (userInfoEntity != null) {
//                            if(userInfoEntity.getCode().equals("200")){
//                                usericon.setImageURI(resultUri);
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        Logger.d(ex);
//                    }
//
//                    @Override
//                    public void onCancelled(CancelledException cex) {
//                    }
//
//                    @Override
//                    public void onFinished() {
//                    }
//                } );
//
//            }
//        }else if (resultCode == UCrop.RESULT_ERROR) {
//            Logger.d("error");
//        }else if (resultCode == SearchSchoolActivity.resultCode) {//学校信息返回
//            schoolinfo = (BaseSchoolEntity.SchoollistEntity) data.getSerializableExtra(SearchSchoolActivity.resultData);
//            school.setText(schoolinfo.getSchoolName());
//            //清除院系专业班级信息
//            d = null;
//            m = null;
//            g = null;
//            college.setText("");
//            profession.setText("");
//            userclass.setText("");
//
//        } else if (resultCode == SchoolInfoActivity.departmentResult) {//院系信息返回
//            d = (SchoolDepartmentEntity.DepartmentEntity) data.getSerializableExtra(SchoolInfoActivity.department);
//            college.setText(d.getDepartmentName());
//        } else if (resultCode == SchoolInfoActivity.majorResult) {//专业信息返回
//            m = (SchoolMajorEntity.MajorEntity) data.getSerializableExtra(SchoolInfoActivity.major);
//            profession.setText(m.getMajorName());
//        }else if (resultCode == SchoolInfoActivity.gradesResult) {//班级信息返回
//            g = (SchoolGradesEntity.GradesEntity) data.getSerializableExtra(SchoolInfoActivity.grades);
//            userclass.setText(g.getGradesName());
//        }
//    }





    //头像选择
    private void showSheetDialog() {

        new ActionSheetDialog(MyUserInfoActivity.this).builder()
                .setCanceledOnTouchOutside(true)
                .addSheetItem("拍照", ActionSheetDialog.SheetItemColor.DEFAULT,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
//                                Toast.makeText(MainActivity.this,"paizhao",Toast.LENGTH_LONG).show();
                                GalleryFinal.openCamera(application.REQUEST_CODE_CAMERA, mOnHanlderResultCallback);


                            }
                        })
                .addSheetItem("相册", ActionSheetDialog.SheetItemColor.DEFAULT,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                GalleryFinal.openGallerySingle(application.REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
                            }
                        }).show();
    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {

        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {


            ImageOptions options = new ImageOptions.Builder()
                    //设置圆形
                    .setCircular(true)
                    //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                    .setAutoRotate(true)
                    //等比例缩放居中显示
                    .setImageScaleType(ImageView.ScaleType.FIT_XY)
                    .build();

            if (resultList != null) {
                //获取图片路径
                String photoPath= resultList.get(0).getPhotoPath();

//                x.image().bind(usericon,photoPath, options);

                //存储头像到服务器
                RequestParams params = new RequestParams(URLConfig.UploadImageAPI);
                params.addBodyParameter("upfile",new File(photoPath));
                params.addBodyParameter("path","Vep");
                params.addBodyParameter("type", "0");
                params.setMultipart(true);
                Logger.d(params);
                Logger.d("photoPath"+photoPath);
                x.http().post(params, new Callback.CacheCallback<String>() {
                    @Override
                    public boolean onCache(String result) {
                        return false;
                    }

                    @Override
                    public void onSuccess(String result) {
                        Logger.d(result);
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
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(MyUserInfoActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };

}
