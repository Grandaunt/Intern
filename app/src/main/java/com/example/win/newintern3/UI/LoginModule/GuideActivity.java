package com.example.win.newintern3.UI.LoginModule;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.example.win.newintern3.Adpter.GuideFragmentAdapter;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.FourModule.BusinessTripListActivity;
import com.example.win.newintern3.UI.FourModule.JournalInfoActivity;
import com.example.win.newintern3.UI.FourModule.JournalListActivity;
import com.example.win.newintern3.UI.FourModule.MyInternActivity;
import com.example.win.newintern3.UI.FourModule.MyResumeActivity;
import com.example.win.newintern3.UI.FourModule.MyUserInfoActivity;
import com.example.win.newintern3.UI.FourModule.QuestionsListActivity;
import com.example.win.newintern3.UI.FourModule.WeeklyListActivity;
import com.example.win.newintern3.UI.MainModule.AIntern.AMainActivity;
import com.example.win.newintern3.UI.MainModule.AIntern.BusinessTripActivity;
import com.example.win.newintern3.UI.MainModule.AIntern.JournalActivity;
import com.example.win.newintern3.UI.MainModule.AIntern.SignInActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.BMainActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.BaseListActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.ComListActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.FastCityActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.LookOverBasePracticeActivity;
import com.example.win.newintern3.UI.MainModule.BIntern.NewInternActivity;
import com.example.win.newintern3.UI.MainModule.MainActivity;
import com.example.win.newintern3.Utils.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class GuideActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    private ViewPager mViewPager;
    private CircleIndicator indicator;
    private static final int REQUEST_CODE = 1;
    private static final int TIME = 3000;
    private static final int GO_HOME = 15000;
    private static final int GO_MAIN = 15001;
    private final int SDK_PERMISSION_REQUEST = 127;
    private String permissionInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
//暂时测试用/////////////////////////////////////////////////////////
        Intent intent = new Intent(GuideActivity.this,  MyResumeActivity.class);
        startActivity(intent);
        finish();
/////////////////////////////////////////////////////////////////////

//        initWindow();
//        getPersimmions();
//        goPage();
    }

    private void goPage() {

        SharedPreferences sharedPrefs = getSharedPreferences("NewIntern3Share", Context.MODE_PRIVATE);
        String error=sharedPrefs.getString("AUTH_TOKEN", "error");
        Log.i(TAG,"sharedPrefs.getString(AUTH_TOKEN, error)="+sharedPrefs.getString("AUTH_TOKEN", "error"));

        if( sharedPrefs.getString("AUTH_TOKEN", "error").equals("error")||sharedPrefs.getString("AUTH_TOKEN", "error").equals(""))
        {
            Log.i(TAG,"LoadingActivity欢迎。。。");
            mViewPager = (ViewPager) findViewById(R.id.viewpager);
            indicator = (CircleIndicator) findViewById(R.id.indicator);

            List<Fragment> list = new ArrayList<Fragment>();
            for(int i=0;i<3;i++){
//            ViewFragment fragment0= new ViewFragment();
                Fragment fragment0 = ViewFragment.newInstance(i);
                list.add(fragment0);
            }
            mViewPager.setAdapter(new GuideFragmentAdapter(getSupportFragmentManager(), list));
            indicator.setViewPager(mViewPager);
            //页面切换动画
            mViewPager.setPageTransformer(true, new DepthPageTransformer());
        }
        else {
            goMain();
        }

    }


    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

//    private void goHome(){
//        Log.i("LoadingActivity","LoadingActivity欢迎。。。Intent");
//        Intent intent = new Intent(GuideActivity.this,LoginActivity.class);
//        startActivity(intent);
//        finish();
//    }
    private void goMain(){
        Log.i("LoadingActivity","LoadingActivity欢迎。。。Intent");
        Intent intent = new Intent(GuideActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @TargetApi(23)
    private void getPersimmions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ArrayList<String> permissions = new ArrayList<String>();
            /***
             * 定位权限为必须权限，用户如果禁止，则每次进入都会申请
             */
            // 定位精确位置
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.CAMERA);
            }
            if(checkSelfPermission(Manifest.permission.WRITE_SETTINGS) != PackageManager.PERMISSION_GRANTED){
                permissions.add(Manifest.permission.WRITE_SETTINGS);
            }


			/*
			 * 读写权限和电话状态权限非必要权限(建议授予)只会申请一次，用户同意或者禁止，只会弹一次
			 */
            // 读写权限
            if (addPermission(permissions, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                permissionInfo += "Manifest.permission.WRITE_EXTERNAL_STORAGE Deny \n";
            }
            // 读取电话状态权限
//            if (addPermission(permissions, Manifest.permission.READ_PHONE_STATE)) {
//                permissionInfo += "Manifest.permission.READ_PHONE_STATE Deny \n";
//            }

            if (permissions.size() > 0) {
                requestPermissions(permissions.toArray(new String[permissions.size()]), SDK_PERMISSION_REQUEST);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
//            checkPermission();
        }
    }

    @TargetApi(23)
    private boolean addPermission(ArrayList<String> permissionsList, String permission) {
        if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) { // 如果应用没有获得对应权限,则添加到列表中,准备批量申请
            if (shouldShowRequestPermissionRationale(permission)){
                return true;
            }else{
                permissionsList.add(permission);
                return false;
            }

        }else{
            return true;
        }
    }

//    //6.0以上才能调用
//    @TargetApi(23)
//    void checkPermission(){
//        if(!Settings.System.canWrite(this)){
//            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS,
//                    Uri.parse("package:" + getPackageName()));
//            startActivityForResult(intent, REQUEST_CODE);
//        }
//    }

}
