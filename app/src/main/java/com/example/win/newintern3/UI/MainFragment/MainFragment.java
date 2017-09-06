package com.example.win.newintern3.UI.MainFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceEntity;
import com.example.win.newintern3.NewEntity.UserLogin;
import com.example.win.newintern3.NewEntity.UserLoginMainEntity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.FourModule.MyCollectActivity;
import com.example.win.newintern3.UI.LoginModule.LoginActivity;
import com.example.win.newintern3.UI.MainModule.AIntern.AMainActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.BMainActivity;
import com.example.win.newintern3.UI.MainModule.Inform.InforMainActivity;
import com.example.win.newintern3.UI.MainModule.MainActivity;
import com.example.win.newintern3.UI.MainModule.Recruit.RMainActivity;
import com.example.win.newintern3.UI.ThreeModule.CMainActivity;
import com.example.win.newintern3.UI.TwoModule.SMainActivity;
import com.example.win.newintern3.Utils.ACache;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainFragment extends Fragment implements View.OnClickListener {


    private LinearLayout btn_one;
    private LinearLayout btn_Two;
    private LinearLayout btn_Three;
    private LinearLayout btn_Four;
    private LinearLayout btn_Five;
    private LinearLayout btn_Six;
    private Intent intent;
    private UserLoginMainEntity userLoginMainEntity;
    private ACache aCache;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private MyApplication application;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        application = (MyApplication) getActivity().getApplication();
        aCache = ACache.get(getActivity());
        findview(view);
        return view;
    }

    private void findview(View view) {
//        userLoginMainEntity= new UserLoginMainEntity();
        btn_one = (LinearLayout) view.findViewById(R.id.btn_main_intern);
        btn_Two = (LinearLayout) view.findViewById(R.id.btn_main_recruit);
        btn_Three = (LinearLayout) view.findViewById(R.id.btn_main_collect);
        btn_Four = (LinearLayout) view.findViewById(R.id.btn_main_inform);
        btn_Five = (LinearLayout) view.findViewById(R.id.btn_main_study);
        btn_Six = (LinearLayout) view.findViewById(R.id.btn_main_circle);
        btn_one.setOnClickListener(this);
        btn_Two.setOnClickListener(this);
        btn_Three.setOnClickListener(this);
        btn_Four.setOnClickListener(this);
        btn_Five.setOnClickListener(this);
        btn_Six.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_intern:
                /***
                 * NO:未申请，申请失败
                 * YES：申请成功
                 * APPLYING：申请中
                 */
                GetPractice();
                //已实习
                if (application.getUserLoginMainEntity().getIsHasUserPractice().equals("YES")) {
                    intent = new Intent(getActivity(), AMainActivity.class);
                    startActivity(intent);
                }
                //未实习
                else if(application.getUserLoginMainEntity().getIsHasUserPractice().equals("NO")){
                    intent = new Intent(getActivity(), BMainActivity.class);
                    startActivity(intent);
                }
                else{
                    //申请中

                }

                break;
            //招聘
            case R.id.btn_main_recruit:
                intent = new Intent(getActivity(), RMainActivity.class);
                startActivity(intent);
                break;
            //收藏
            case R.id.btn_main_collect:
                intent = new Intent(getActivity(), MyCollectActivity.class);
                startActivity(intent);
                break;
            //通知
            case R.id.btn_main_inform:
                intent = new Intent(getActivity(), InforMainActivity.class);
                startActivity(intent);
                break;
            //学习
            case R.id.btn_main_study:
                intent = new Intent(getActivity(), SMainActivity.class);
                startActivity(intent);
                break;
            //圈子
            case R.id.btn_main_circle:
                intent = new Intent(getActivity(), CMainActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void GetPractice() {
        RequestParams params = new RequestParams(URLConfig.GetPracticeStatusAPI);
        params.addParameter("UserId",application.getUserid());
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceEntity<UserLoginMainEntity> Entity  = JsonUtils.getServiceEntity(result, UserLoginMainEntity.class);
                if (Entity.getCode().equals("200")) {
                    UserLoginMainEntity userLoginMainEntity = new UserLoginMainEntity();
                    userLoginMainEntity = application.getUserLoginMainEntity();
                    userLoginMainEntity.setIsHasUserPractice(Entity.getEntity().getIsHasUserPractice());
                    userLoginMainEntity.setUserPracticeInfo(Entity.getEntity().getUserPracticeInfo());
                    aCache.put(MyApplication.userinfo,  userLoginMainEntity);
                    Logger.d(Entity.getEntity());
                    startActivity(intent);
                }
                else {

                    Logger.d("更新实习状态失败");
//                    ErrorLogin();
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