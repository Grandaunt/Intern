package com.example.win.newintern3.UI.FourModule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;

import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.ExperienceEducation;
import com.example.win.newintern3.NewEntity.ExperiencePractice;
import com.example.win.newintern3.NewEntity.ExperienceProject;
import com.example.win.newintern3.NewEntity.Experiencework;

import com.example.win.newintern3.NewEntity.Resumeinfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;
import com.example.win.newintern3.Widgets.ActionSheetDialog;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;

/***
 * 我的简历
 */
public class MyResumeActivity extends AppCompatActivity implements View.OnClickListener {
    private MyApplication application;

    private Intent intent;

    //    private Toolbar toolbar;
    private TextView title;
    private ImageView back;
    private TextView edit;

    private View info;
    private ImageView logo;
    private TextView name;
    private TextView sex;
    private TextView office;
    private TextView city;
    private TextView phonenub;
    private TextView email;
    private LinearLayout lv_edit_add_base_info;

    private RecyclerView SxRecycler;//实习经历
    private SxAdapter sxAdapter;

    private RecyclerView wexperience;//工作经历
    private WExpAdapter wexpAdapter;

    private RecyclerView jyrecycler;//教育经历
    private JyAdapter jyAdapter;

    private RecyclerView Xmrecycler;//项目经历
    private XmAdapter Xmadapter;
    private Drawable drawable;



//    private RecyclerView Trecycler;//培训经历
//    private TrAdapter trAdapter;
//
//    private RecyclerView CerRecycler;//添加证书
//    private CerAdapter cerAdapter;

    private LinearLayout lv_edit_add_myself_edit;
    private TextView self_evaluation;//自我评价

    private Resumeinfo resumeEntity = new Resumeinfo();
    private List<ExperiencePractice> internlist;
    private List<Experiencework> worklist;
    private List<ExperienceEducation> edulist;
    private List<ExperienceProject> projectlist;
    private ImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_resume);
        application = (MyApplication) getApplication();
        internlist = new ArrayList<>();
        worklist =  new ArrayList<>();
        edulist =  new ArrayList<>();
        projectlist =  new ArrayList<>();
        findview();
        getData();
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

    }

    private void findview() {
        /////////////////ToolBar//////////////////
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("我的简历");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        edit = (TextView) findViewById(R.id.text_save);
        edit.setText("预览");
        edit.setOnClickListener(this);
        ////////////////////////////////////////////

        /////////////////个人信息//////////////////
//        info = findViewById(R.id.view_ar_info);
//        info.setOnClickListener(this);
        logo = (ImageView) findViewById(R.id.iv_ar_icon);
        logo.setOnClickListener(this);
        name = (TextView) findViewById(R.id.tv_re_name);
        sex = (TextView) findViewById(R.id.tv_re_sex);
        office = (TextView) findViewById(R.id.tv_re_work);
        city = (TextView) findViewById(R.id.tv_re_city);
        phonenub = (TextView) findViewById(R.id.tv_re_tel);
        email = (TextView) findViewById(R.id.tv_re_email);
        lv_edit_add_base_info = (LinearLayout) findViewById(R.id.lv_edit_add_base_info);
        lv_edit_add_base_info.setOnClickListener(this);
        //////////////////////////////////////////
        //////////////////////实习经历////////////////////
        SxRecycler = (RecyclerView) findViewById(R.id.recycler_ar_practice);
        SxRecycler.setLayoutManager(new LinearLayoutManager(this));
        SxRecycler.setNestedScrollingEnabled(false);
        sxAdapter = new SxAdapter(null);
//        sxAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<ExperiencePractice>() {
//            @Override
//            public void onItemClick(View view, int position, ExperiencePractice item) {
//                intent = new Intent(MyResumeActivity.this, PracticeExperienceInfoActivity.class);
//                intent.putExtra("type", 1);
//                intent.putExtra("practicelistEntity", item);
//                startActivityForResult(intent, 0);
//            }
//        });
        sxAdapter.setEmptyView(getmptyView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MyResumeActivity.this, EditInternListActivity.class);
                intent.putExtra("type", 2);
                startActivityForResult(intent, 0);
            }
        }, "添加实习经历"));
        SxRecycler.setAdapter(sxAdapter);

        ///////////////////工作经历/////////////
        wexperience = (RecyclerView) findViewById(R.id.recycler_ar_work_experience);
        wexperience.setLayoutManager(new LinearLayoutManager(this));
        wexperience.setNestedScrollingEnabled(false);
        wexpAdapter = new WExpAdapter(null);

        wexpAdapter.setEmptyView(getmptyView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MyResumeActivity.this, EditWorkListActivity.class);
                intent.putExtra("type", 2);
                startActivityForResult(intent, 0);
            }
        },"添加工作经历"));
        wexperience.setAdapter(wexpAdapter);
        ///////////////////////////////////////////

        /////////////////////教育经历/////////////
        jyrecycler = (RecyclerView) findViewById(R.id.recycler_ar_edu_experience);
        jyrecycler.setLayoutManager(new LinearLayoutManager(this));
        jyrecycler.setNestedScrollingEnabled(false);
        jyAdapter = new JyAdapter(null);
//        jyAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<ExperienceEducation>() {
//            @Override
//            public void onItemClick(View view, int position, ExperienceEducation item) {
//                intent = new Intent(MyResumeActivity.this, EduExperienceInfoActivity.class);
//                intent.putExtra("type", 1);
//                intent.putExtra("educationlistEntity", item);
//                startActivity(intent);
//            }
//        });

        jyAdapter.setEmptyView(getmptyView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MyResumeActivity.this, EditEduInfoActivity.class);
                intent.putExtra("type", 2);
                startActivityForResult(intent, 0);
            }
        },  "添加教育经历"));
        jyrecycler.setAdapter(jyAdapter);
        ///////////////////////////////////////////

        ////////////////////项目经历///////////////////
        Xmrecycler = (RecyclerView) findViewById(R.id.recycler_ar_project);
        Xmrecycler.setLayoutManager(new LinearLayoutManager(this));
        Xmrecycler.setNestedScrollingEnabled(false);
        Xmadapter = new XmAdapter(null);
//        Xmadapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<ExperiencePractice>() {
//            @Override
//            public void onItemClick(View view, int position, ExperiencePractice item) {
//                intent = new Intent(MyResumeActivity.this, EditProjectInfoActivity.class);
//                intent.putExtra("type", 1);
//                intent.putExtra("projectlistEntity", item);
//                startActivity(intent);
//            }
//        });
        Xmadapter.setEmptyView(getmptyView(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MyResumeActivity.this, EditProInfoActivity.class);
                intent.putExtra("type", 2);
                startActivityForResult(intent, 0);
            }
        }, "添加实习经历"));
        Xmrecycler.setAdapter(Xmadapter);
        /////////////////////////////////////////////


        //////////////////////培训经历////////////////////
//        Trecycler  = (RecyclerView) findViewById(R.id.recycler_ar_training);
//        Trecycler.setLayoutManager(new LinearLayoutManager(this));
//        Trecycler.setNestedScrollingEnabled(false);
//        trAdapter = new TrAdapter(null);
//        trAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<ExperiencePractice>() {
//            @Override
//            public void onItemClick(View view, int position, ExperiencePractice item) {
//                intent = new Intent(MyResumeActivity.this, PracticeExperienceInfoActivity.class);
//                intent.putExtra("type", 1);
//                intent.putExtra("traininglistEntity", item);
//                startActivityForResult(intent, 0);
//            }
//        });
//        trAdapter.setEmptyView(getmptyView(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent = new Intent(MyResumeActivity.this, PracticeExperienceInfoActivity.class);
//                intent.putExtra("type", 2);
//                startActivityForResult(intent, 0);
//            }
//        }, "添加培训经历"));
//        Trecycler.setAdapter(trAdapter);


        //////////////////////添加证书////////////////////
//        CerRecycler = (RecyclerView) findViewById(R.id.recycler_ar_cer);
//        CerRecycler.setLayoutManager(new LinearLayoutManager(this));
//        CerRecycler.setNestedScrollingEnabled(false);
//        cerAdapter = new CerAdapter(null);
//        cerAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<ExperiencePractice>() {
//            @Override
//            public void onItemClick(View view, int position, ExperiencePractice item) {
//                intent = new Intent(MyResumeActivity.this, PracticeExperienceInfoActivity.class);
//                intent.putExtra("type", 1);
//                intent.putExtra("certificatelistEntity", item);
//                startActivityForResult(intent, 0);
//            }
//        });
//        sxAdapter.setEmptyView(getmptyView(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent = new Intent(MyResumeActivity.this, PracticeExperienceInfoActivity.class);
//                intent.putExtra("type", 2);
//                startActivityForResult(intent, 0);
//            }
//        }, "添加证书"));
//        SxRecycler.setAdapter(sxAdapter);

        //////////////////////自我评价////////////////////

        self_evaluation = (TextView) findViewById(R.id.edt_ar_self_evaluation);
        lv_edit_add_myself_edit = (LinearLayout) findViewById(R.id.lv_edit_add_myself_edit);

    }


    //初始化简历
    private void getData() {
        RequestParams params = new RequestParams(URLConfig.ResumeInfoAPI);
//        params.addParameter("StudentId",application.getUserid());
        params.addParameter("StudentId",application.getUserid());
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceEntity<Resumeinfo> entity = JsonUtils.getServiceEntity(result, Resumeinfo.class);
                internlist = entity.getEntity().getExperiencePracticeList() ;
                worklist = entity.getEntity().getExperienceworkList() ;
                edulist = entity.getEntity().getExperienceEducationList() ;
                projectlist = entity.getEntity().getExperienceProjectList() ;
//                Resumeinfo r  = JsonUtils.getPerson(result, Resumeinfo.class)
//                resumeEntity = r;
                resumeEntity = entity.getEntity();
                initdata(entity.getEntity());

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

    private void initdata(Resumeinfo r) {
        x.image().bind(logo, r.getResumeUserIcon(), options);
        name.setText(r.getUserName());
        if (r.getResumepost() != null && !r.getResumepost().equals("")) {
            office.setText(r.getResumepost());
        } else {
            office.setText("暂无");
        }
        if (r.getResumepost() != null && !r.getResumeTrade().equals("")) {
            sex.setText(r.getResumeTrade());
        } else {
            sex.setText("暂无");
        }
        phonenub.setText(r.getResumeTel());
        city.setText(r.getResumeAddress());
        email.setText(r.getResumeEmile());

        //实习
        sxAdapter.setNewData(r.getExperiencePracticeList());
        //工作
        wexpAdapter.setNewData(r.getExperienceworkList());
        //教育
        jyAdapter.setNewData(r.getExperienceEducationList());
        //项目
        Xmadapter.setNewData(r.getExperienceProjectList());

        //培训
//        trAdapter.setNewData(r.getExperiencePracticeList());
        //证书
//        cerAdapter.setNewData(r.getExperiencePracticeList());
        //自我评价

            self_evaluation.setText(r.getResumeSelfDes());
            lv_edit_add_myself_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent = new Intent(MyResumeActivity.this, EditMyselfInfoActivity.class);
                    intent.putExtra(EditWorkListActivity.intenttag1, resumeEntity.getResumeSelfDes());
                    startActivity(intent);
                }
            });


    }

    /**
     * 实习经历
     */
    private class SxAdapter extends BaseQuickAdapter<ExperiencePractice> {
        public SxAdapter(List<ExperiencePractice> data) {
            super(R.layout.item_edit_experience, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, final ExperiencePractice item, int positions) {

            if (positions == 0) {
                helper.setVisible(R.id.lv_item_main_intern_eit, true)
                        .setOnClickListener(R.id.lv_item_main_intern_eit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent = new Intent(MyResumeActivity.this, EditInternListActivity.class);
                                intent.putExtra(EditInternListActivity.intenttag1, (Serializable)  internlist);
                                startActivity(intent);
                            }
                        });
            } else {
                helper.setVisible(R.id.lv_item_main_intern_eit, false);
            }
            helper.setText(R.id.item_main_intern_name, item.getCompanyName())
                    .setText(R.id.item_main_intern_time, item.getPracticeStartTime() + " ~ " + item.getPracticeEndTime())
                    .setText(R.id.item_main_intern_other, item.getPracticeDes());
        }
    }

    /**
     * 工作经历
     */
    private class WExpAdapter extends BaseQuickAdapter<Experiencework> {
        public WExpAdapter(List<Experiencework> data) {
            super(R.layout.item_edit_experience, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, Experiencework item, int positions) {
            if (positions == 0) {
                helper.setVisible(R.id.lv_item_main_intern_eit, true)
                        .setOnClickListener(R.id.lv_item_main_intern_eit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent = new Intent(MyResumeActivity.this, EditWorkListActivity.class);
                                intent.putExtra(EditWorkListActivity.intenttag1, (Serializable)  worklist);
                                startActivity(intent);
                            }
                        });
            } else {
                helper.setVisible(R.id.lv_item_main_intern_eit, false);
            }
            helper.setText(R.id.item_main_intern_name, item.getCompanyName())
                    .setText(R.id.item_main_intern_time, item.getWorkStartTime() + " ~ " + item.getWorkEndTime())
                    .setText(R.id.item_main_intern_other, item.getWorkDes());

        }
    }

    /**
     * 教育经历
     */
    private class JyAdapter extends BaseQuickAdapter<ExperienceEducation> {

        public JyAdapter(List<ExperienceEducation> data) {
            super(R.layout.item_edit_experience, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ExperienceEducation item, int positions) {
            if (positions == 0) {
                helper.setVisible(R.id.lv_item_main_intern_eit, true)
                        .setOnClickListener(R.id.lv_item_main_intern_eit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent = new Intent(MyResumeActivity.this, EditEduListActivity.class);
                                intent.putExtra(EditEduListActivity.intenttag1, (Serializable)  edulist);
                                startActivity(intent);
                            }
                        });
            } else {
                helper.setVisible(R.id.lv_item_main_intern_eit, false);
            }
            helper.setText(R.id.item_main_intern_name, item.getSchoolName())
                    .setText(R.id.item_main_intern_time, item.getEducationStartTime() + " ~ " + item.getEducationEndTime())
                    .setText(R.id.item_main_intern_other, item.getEducationMajor());
        }
    }


    /**
     * 项目经历
     */
    private class XmAdapter extends BaseQuickAdapter<ExperienceProject> {

        public XmAdapter(List<ExperienceProject> data) {
            super(R.layout.item_edit_experience, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ExperienceProject item, int positions) {
            if (positions == 0) {
                helper.setVisible(R.id.lv_item_main_intern_eit, true)
                        .setOnClickListener(R.id.lv_item_main_intern_eit, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                intent = new Intent(MyResumeActivity.this, EditProListActivity.class);
                                intent.putExtra(EditProListActivity.intenttag1, (Serializable)  projectlist);
                                startActivity(intent);
                            }
                        });
            } else {
                helper.setVisible(R.id.lv_item_main_intern_eit, false);
            }
            helper.setText(R.id.item_main_intern_name, item.getProjectName())
                    .setText(R.id.item_main_intern_time, item.getProjectStartTime() + " ~ " + item.getProjectEndTime())
                    .setText(R.id.item_main_intern_other, item.getProjectDes());


            //( •̀ ω •́ )✧ 老司机  带带我  我要去云南啊~

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.text_save:
                if (resumeEntity != null) {
//                        intent = new Intent(MyResumeActivity.this, EditResumeActivity.class);
//                        intent.putExtra("resumeEntity", resumeEntity);
//                        startActivityForResult(intent, 0);
                }

                break;
                case R.id.iv_ar_icon:
                        showSheetDialog();
                break;
            case R.id.lv_edit_add_base_info:
                intent = new Intent(MyResumeActivity.this, EditUserBaseInfoActivity.class);
                intent.putExtra(EditUserBaseInfoActivity.intenttag1, resumeEntity);
                startActivity(intent);

                break;
        }
    }


    /**
     * 列表缺省
     *
     * @param onClickListener
     * @param text
     * @return
     */
    private View getmptyView(View.OnClickListener onClickListener, String text) {
//        View view = LayoutInflater.from(this).inflate(R.layout.view_mpty_resume, null);
//        TextView textView = (TextView) view.findViewById(R.id.empy_add);
//        textView.setText(text);
//        textView.setOnClickListener(onClickListener);

        LinearLayout ll = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
        ll.setGravity(Gravity.CENTER);
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setOnClickListener(onClickListener);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_moving_add);
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(drawable,null,null,null);
        tv.setCompoundDrawablePadding(10);
        tv.setTextColor(getResources().getColor(R.color.colorAccent));
        ll.setLayoutParams(params);
        ll.addView(tv);
        return ll;
    }

    //头像选择
    private void showSheetDialog() {

        new ActionSheetDialog(MyResumeActivity.this).builder()
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
            Toast.makeText(MyResumeActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 1000:
                resumeEntity = (Resumeinfo) data.getSerializableExtra("resumeEntity");
                initdata(resumeEntity);
                break;
            case 1001:
                RequestParams params = new RequestParams(URLConfig.ResumeInfoAPI);
                params.addParameter("action", "educationlist");
                params.addParameter("userId", application.getUserid());
//                params.addParameter("userId",application.getUserid());
                Logger.d(params);
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Logger.d(result);
//                        ExperienceEducation educationlistEntity = JsonUtils.getPerson(result, ExperienceEducation.class);
                        ServiceListEntity<ExperienceEducation> listEntity = JsonUtils.getServiceListEntity(result, ExperienceEducation.class);
                        resumeEntity.setExperienceEducationList(listEntity.getList());
                        initdata(resumeEntity);

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


                break;
            case 1002:
                RequestParams params2 = new RequestParams(URLConfig.Resume_API);
                params2.addParameter("action", "worklist");
                params2.addParameter("userId", application.getUserid());
                Logger.d(params2);
                x.http().post(params2, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Logger.d(result);
//                        Experiencework workExpEntity = JsonUtils.getPerson(result, Experiencework.class);
                        ServiceListEntity<Experiencework> listEntity = JsonUtils.getServiceListEntity(result, Experiencework.class);
                        resumeEntity.setExperienceworkList(listEntity.getList());
                        initdata(resumeEntity);
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

                break;

            case 1003:
                RequestParams params3 = new RequestParams(URLConfig.Resume_API);
                params3.addParameter("action", "projectlist");
                params3.addParameter("userId", application.getUserid());
                Logger.d(params3);
                x.http().post(params3, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Logger.d(result);
//                        experienceProjectList proExpEntity = JsonUtils.getPerson(result, experienceProjectList.class);
                        ServiceListEntity<ExperienceProject> listEntity = JsonUtils.getServiceListEntity(result, ExperienceProject.class);
                        resumeEntity.setExperienceProjectList(listEntity.getList());
                        initdata(resumeEntity);
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
                break;
            case 1004:
                RequestParams params4 = new RequestParams(URLConfig.Resume_API);
                params4.addParameter("action", "practicelist");
                params4.addParameter("userId", application.getUserid());
                Logger.d(params4);
                x.http().post(params4, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Logger.d(result);
//                        experiencePracticeList practiceExpEntity = JsonUtils.getPerson(result, experiencePracticeList.class);
                        ServiceListEntity<ExperiencePractice> listEntity = JsonUtils.getServiceListEntity(result, ExperiencePractice.class);
                        resumeEntity.setExperiencePracticeList(listEntity.getList());
                        initdata(resumeEntity);

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
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
