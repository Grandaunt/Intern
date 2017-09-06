package com.example.win.newintern3.UI.MainFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.NewEntity.UserBaseInfo;
import com.example.win.newintern3.R;
//import com.example.win.newintern3.UI.FourModule.MyApplyActivity;
import com.example.win.newintern3.UI.FourModule.MyInternActivity;
import com.example.win.newintern3.UI.FourModule.MyResumeActivity;
import com.example.win.newintern3.UI.FourModule.MyUserInfoActivity;
import com.example.win.newintern3.UI.FourModule.SettingActivity;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/***
     * 我的
     */
    public class FourFragment extends Fragment implements View.OnClickListener {
        //    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//    private String mParam1;
//    private String mParam2;
        private LinearLayout info;              //用户信息
        private ImageView icon;
        private TextView name;                  //名字
        private TextView nicename;              //昵称
        private ImageView QRcode;               //二维码

        private LinearLayout resume;                //我的简历

        //    private TextView plan;                  //我的计划
//    private TextView find;                  //我的职位
        private LinearLayout apply;           //我的申请
        private LinearLayout collect;               //我的收藏

        private LinearLayout InCom;               //我的实习
        private LinearLayout  cricle;
//    private TextView journal;               //我的日志
//    private TextView weekly;               //我的周报
//    private TextView questions;             //我的问答
//    private TextView leave;                 //我的请假
//    private TextView businesstrip;          //我的出差
//    private TextView summary;               //我的总结

        private LinearLayout setting;               //设置
//    private TextView about;                 //关于

        private Intent intent;
//    private Toolbar toolbar;
//    private TextView save;
//    private TextView title;

        private MyApplication application;
        private UserBaseInfo userInfoEntity;
    private    ImageOptions options;
    public FourFragment() {
            // Required empty public constructor
        }

        public static FourFragment newInstance() {
            FourFragment fragment = new FourFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_four, container, false);
            application = (MyApplication) getActivity().getApplication();
            getuserinfo();
            findview(view);

            return view;
        }


        private void findview(View view) {
//        toolbar=(Toolbar)view.findViewById(R.id.toolbar);
//        getActivity().setSupportActionBar(toolbar);
//        save = (TextView) view.findViewById(R.id.text_save);
//        save.setText("");
//        title = (TextView) view.findViewById(R.id.text_title);
            info = (LinearLayout) view.findViewById(R.id.view_fm_info);
            icon = (ImageView) view.findViewById(R.id.iv_fm_icon);
            name = (TextView) view.findViewById(R.id.text_fm_name);
            nicename = (TextView) view.findViewById(R.id.text_fm_nick_name);
//        QRcode = (ImageView) view.findViewById(R.id.iv_fm_qrcode);


            resume = (LinearLayout) view.findViewById(R.id.text_fm_resume);

            apply = (LinearLayout) view.findViewById(R.id.text_fm_apply);
            collect = (LinearLayout) view.findViewById(R.id.text_fm_collect);

            InCom= (LinearLayout) view.findViewById(R.id.text_fm_internship);
            cricle= (LinearLayout) view.findViewById(R.id.text_fm_cricle);
//        journal = (TextView) view.findViewById(R.id.text_fm_journal);
//        weekly = (TextView) view.findViewById(R.id.text_fm_weekly);
//        questions = (TextView) view.findViewById(R.id.text_fm_questions);
//        leave = (TextView) view.findViewById(R.id.text_fm_leave);
//        businesstrip = (TextView) view.findViewById(R.id.text_fm_businesstrip);
//        summary = (TextView) view.findViewById(R.id.text_fm_summary);

            setting = (LinearLayout) view.findViewById(R.id.text_fm_setting);
//        about = (TextView) view.findViewById(R.id.text_fm_about);
//        plan = (TextView) view.findViewById(R.id.text_fm_plan);
//        find = (TextView) view.findViewById(R.id.text_fm_find);

            info.setOnClickListener(this);
//        QRcode.setOnClickListener(this);
            resume.setOnClickListener(this);
//        plan.setOnClickListener(this);
//        find.setOnClickListener(this);
            apply.setOnClickListener(this);
            collect.setOnClickListener(this);

            InCom.setOnClickListener(this);
//        journal.setOnClickListener(this);
//        weekly.setOnClickListener(this);
//        questions.setOnClickListener(this);
//        leave.setOnClickListener(this);
//        businesstrip.setOnClickListener(this);
//        summary.setOnClickListener(this);

            setting.setOnClickListener(this);
//        about.setOnClickListener(this);
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

        private void getuserinfo() {
            RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
            params.addParameter("userId",application.getUserid());
            params.addParameter("action","getbaseinfo");
            Logger.d(params);
            x.http().post(params, new Callback.CacheCallback<String>() {
                @Override
                public boolean onCache(String result) {

                    return false;
                }

                @Override
                public void onSuccess(String result) {

                    Logger.d(result);
                    userInfoEntity = JsonUtils.getPerson(result, UserBaseInfo.class);
                    if (userInfoEntity != null) {
//                       头像
                        x.image().bind(icon, userInfoEntity.getIcon(), options);
//                        Picasso.with(FourFragment.this.getContext()).load(userInfoEntity.getUserbaseinfo().getIcon()).error(R.mipmap.ic_user).placeholder(R.mipmap.ic_user).into(icon);
                        name.setText(userInfoEntity.getTrueName());
                        nicename.setText(userInfoEntity.getNickName());
                        application.SetMajorId(userInfoEntity.getMajorId());//保存专业数据，找实习中用到
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

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){

//                // 头像
//                case R.id.iv_fm_icon:
//                    showSheetDialog();
//                    break;
                // 我的个人基本信息
                case R.id.view_fm_info:
                    intent = new Intent(getActivity(), MyUserInfoActivity.class);
                    startActivityForResult(intent, 0);
                    break;
//            case R.id.iv_fm_qrcode:
//                break;
                //我的简历
                case R.id.text_fm_resume:
                    intent = new Intent(getActivity(), MyResumeActivity.class);
                    startActivity(intent);
                    break;
                //我的申请列表
                case R.id.text_fm_apply:
//                    intent = new Intent(getActivity(), MyApplyActivity.class);
                    startActivity(intent);
                    break;
                //我的收藏
                case R.id.text_fm_collect:
                    break;
                //我的实习
                case R.id.text_fm_internship:
                    intent = new Intent(getActivity(), MyInternActivity.class);
                    startActivity(intent);
                    break;
//            case R.id.text_fm_journal:
//                intent = new Intent(MyFragment.this.getContext(), JournalListActivity.class);
//                startActivity(intent);
//                break;
//
//            case R.id.text_fm_weekly:
//                intent = new Intent(MyFragment.this.getContext(), WeeklyListActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.text_fm_questions:
//                intent = new Intent(MyFragment.this.getContext(), QuestionsListActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.text_fm_leave:
//                intent = new Intent(MyFragment.this.getContext(), AskForLeaveListActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.text_fm_businesstrip:
//                intent = new Intent(MyFragment.this.getContext(), BusinessTripListActivity.class);
//                startActivity(intent);
//                break;
//
                //设置
                case R.id.text_fm_setting:
                    intent = new Intent(getActivity(), SettingActivity.class);
                    startActivity(intent);
                    break;
//            case R.id.text_fm_about:
//                break;

            }
        }





        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 0) {//进入个人信息，不管里面进行过什么操作，这里的更新头像等数据
                getuserinfo();
            }

        }
    }
