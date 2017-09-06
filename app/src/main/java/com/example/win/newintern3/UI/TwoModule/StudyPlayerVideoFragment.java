package com.example.win.newintern3.UI.TwoModule;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.win.newintern3.Base.IPlayerImpl;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.OrientationUtil;
import com.example.win.newintern3.Widgets.VideoPlayer;


/**
 * 视频播放
 */
public class StudyPlayerVideoFragment extends Fragment {
    private static final String ARG_PARAM1 = "Text";
    private static final String ARG_PARAM2 = "Url";
    private static final String ARG_PARAM3 = "Preview";
    private static final String ARG_PARAM4 = "id";

    private String Text;
    private String Url;
    private String Preview;
    private int viewid;

    private VideoPlayer mVp;

    private FrameLayout frameLayout;


    public StudyPlayerVideoFragment() {
        // Required empty public constructor
    }

    private IPlayerImpl playerImpl = new IPlayerImpl() {

        @Override
        public void onNetWorkError() {
            showToast(null);
        }

        @Override
        public void onBack() {
            // 全屏播放时,单击左上角返回箭头,先回到竖屏状态,再关闭
            // 这里功能最好跟onBackPressed()操作一致
            int orientation = OrientationUtil.getOrientation(StudyPlayerVideoFragment.this.getActivity());
            if (orientation == OrientationUtil.HORIZONTAL) {
                OrientationUtil.forceOrientation(StudyPlayerVideoFragment.this.getActivity(), OrientationUtil.VERTICAL);
            } else {
                StudyPlayerVideoFragment.this.getActivity().finish();
            }
        }

        @Override
        public void onError() {
            showToast("播放器发生异常");
        }

    };


    public static StudyPlayerVideoFragment newInstance(String param1, String param2, String param3,int param4) {
        StudyPlayerVideoFragment fragment = new StudyPlayerVideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Text = getArguments().getString(ARG_PARAM1);
            Url = getArguments().getString(ARG_PARAM2);
            Preview = getArguments().getString(ARG_PARAM3);
            viewid = getArguments().getInt(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study_player_video, container, false);
        frameLayout = (FrameLayout) getActivity().findViewById(viewid);
        initView(view);
        initListener();
        return view;
    }

    private void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            msg = getResources().getString(R.string.zz_player_network_invalid);
        }
        Toast.makeText(StudyPlayerVideoFragment.this.getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mVp != null) {
            mVp.updateActivityOrientation();
        }
    }
    private void initListener() {
        mVp.setPlayerController(playerImpl);
    }

    private void initView(View view) {
        mVp = (VideoPlayer) view.findViewById(R.id.vp);
        mVp.setTitle(Text);
        mVp.loadAndStartVideo(StudyPlayerVideoFragment.this.getActivity(), Url);
        mVp.setPlayerView(frameLayout);

        //设置控制栏播放/暂停/全屏/退出全屏按钮图标
//        mVp.setIconPlay(R.drawable.play);
//        mVp.setIconPause(R.drawable.pause);
//        mVp.setIconExpand(R.drawable.expand);
//        mVp.setIconShrink(R.drawable.shrink);
        //隐藏/显示控制栏时间值信息
        // mVp.hideTimes();
        // mVp.showTimes();
        // 自定义加载框图标
//        mVp.setIconLoading(R.drawable.loading_red);

        // 设置进度条样式
//        mVp.setProgressThumbDrawable(R.drawable.progress_thumb);
//        mVp.setProgressLayerDrawables(R.drawable.biz_video_progressbar);//自定义的layer-list
//         mVp.setProgressLayerDrawables(0, 0, R.drawable.shape_progress);//逐层设置,0的话表示保持默认

//         mVp.setControlFlag(VideoPlayer.FLAG_DISABLE_VOLUME_CHANGE);
    }
    @Override
    public void onResume() {
        super.onResume();
        mVp.onHostResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mVp.onHostPause();
    }

//    @Override
//    public void onBackPressed() {
//        mVp.onHostDestroy();
//        StudyPlayerVideoFragment.this.getActivity().finish();
//    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mVp.onHostDestroy();
    }
}
