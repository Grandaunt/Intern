package com.example.win.newintern3.UI.TwoModule;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.example.win.newintern3.Adpter.ViewPageAdapter;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Entity.StudyContentEntity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;

//视频播放
public class SMainActivity extends AppCompatActivity {

        FrameLayout frameStudy;
        TabLayout tabStudy;
        ViewPager pagerStudy;

        private String data;
        private MyApplication application;


        private FragmentManager fragmentManager;
        private FragmentTransaction fragmentTransaction;

        private StudyPlayerVideoFragment playfragment;
        private WebBrowseStudyFragment webfragment;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            data = getIntent().getStringExtra("data");
            application = (MyApplication) getApplication();
            fragmentManager = getSupportFragmentManager();

//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
            setContentView(R.layout.activity_smain);
            initview();
            initdata();
        }

    private void initdata() {
        playfragment = StudyPlayerVideoFragment.newInstance(
                                       "课程",
                                       "http://114.55.2.134:8080/images/education/创业与战略设计.mp4",
                                       "http://114.55.2.134:8080/images/education/images/C10421世界五百强管理方法工具原则-3.gif",
                                        R.id.frame_study);
        RevFragment(playfragment);

        //Tab页设置
//        tabStudy.setTabMode(TabLayout.MODE_FIXED);
//        pagerStudy.setOffscreenPageLimit(4);
//        tabStudy.addTab(tabStudy.newTab().setText("详情"));
//        tabStudy.addTab(tabStudy.newTab().setText("评论"));

//        OkHttpUtils.post(BuildConfig.Pro_jpbAPI)
//                .params("action","educationlick")
//                .params("userId",application.getUserid())
//                .params("educationId",data)
//                .execute(new InfoStudyCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, StudyContentEntity studyContentEntity, Request request, @Nullable Response response) {
//                        if (studyContentEntity.getCode().equals("200")) {
//                            //视频播放显示的fragment
//                            if (studyContentEntity.getEducation().get(0).getEducationContentType() == 1) {

//                                playfragment = StudyPlayerVideoFragment.newInstance(
//                                        studyContentEntity.getEducation().get(0).getEducationTitle(),
//                                        studyContentEntity.getEducation().get(0).getEducationPath(),
//                                        studyContentEntity.getEducation().get(0).getEducationPic(),
//                                        R.id.frame_study

//                                );
//                                RevFragment(playfragment);
//                            }else if(studyContentEntity.getEducation().get(0).getEducationContentType() == 2){
//                                webfragment=WebBrowseStudyFragment.newInstance(
//                                        studyContentEntity.getEducation().get(0).getEducationTitle(),
//                                        studyContentEntity.getEducation().get(0).getEducationPath(),
//                                        R.id.frame_study
//                                );
//                                RevFragment(webfragment);
//                            }
//                            //设置Tab数据
////                            setupViewPager(pagerStudy,studyContentEntity);
//                            tabStudy.setupWithViewPager(pagerStudy);
//                        }
//                    }
//                });
    }

    private void initview() {
        frameStudy = (FrameLayout) findViewById(R.id.frame_study);
//        tabStudy = (TabLayout) findViewById(R.id.tab_study);
//        pagerStudy = (ViewPager) findViewById(R.id.pager_study);

    }



    private void RevFragment(Fragment f) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameStudy.getId(), f);
        fragmentTransaction.commit();
    }
//
//    private void setupViewPager(ViewPager mViewPager,StudyContentEntity data) {
//        //如果Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
//        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());
//        adapter.addFragment(StudyInfoFragment.newInstance(data.getEducation().get(0).getEducationDes()),"详情");
//        adapter.addFragment(StudyCommentFragment.newInstance(String.valueOf(data.getEducation().get(0).getEducationId())),"评论");
//        mViewPager.setAdapter(adapter);
//
//    }


//    private abstract class InfoStudyCallBack extends AbsCallback<StudyContentEntity>{
//        @Override
//        public StudyContentEntity parseNetworkResponse(Response response) throws Exception {
//            return JsonUtils.getPerson(response.body().string(), StudyContentEntity.class);
//        }
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (webfragment != null) {

        } else if (webfragment != null) {
            if(webfragment.goback(keyCode, event))
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }


//    /**
//     * 这就是我的野心
//     * @return
//     */
//    private Object getObject() {
//        while (true) {
//            return new Object();
//        }
//    }


}


