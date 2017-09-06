package com.example.win.newintern3.Base;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.example.win.newintern3.Service.LocationService;


/**
 * 一个定位的基类视图
 * Created by TAO_SX on 2016/7/20/020.
 */
public class LocationBaseAvtivity extends AppCompatActivity {
    //设置所需的权限
    private static String[] PERMISSIONS_CONTACT = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private static final int REQUEST_LOCATION = 0;

    private LocationService locationService;//定位服务
    private AlertDialog mAlertDialog;

    protected String addressText = "北京";
    protected String mAddress = "0,0";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initpermissions();
    }


    private void initpermissions() {
        //监测所需的权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(LocationBaseAvtivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(LocationBaseAvtivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {
            showAlertDialog("请求获取权限", "手机进行定位需要获取权限",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(LocationBaseAvtivity.this, PERMISSIONS_CONTACT, REQUEST_LOCATION);
                        }
                    }, "继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "取消", LocationBaseAvtivity.this);

        } else {
            GetLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION:
                GetLocation();

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /**
     * 获取定位数据
     */
    private void GetLocation() {

        locationService = new LocationService(this);
        locationService.registerListener(mListener);
        LocationClientOption mOption = new LocationClientOption();
        mOption = new LocationClientOption();
        mOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);  //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        mOption.setCoorType("bd09ll");                                              //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        mOption.setScanSpan(0);                                                     //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        mOption.setIsNeedAddress(true);                                             //可选，设置是否需要地址信息，默认不需要
        mOption.setIsNeedLocationDescribe(false);                                   //可选，设置是否需要地址描述
        mOption.setOpenGps(true);                                                   //可选，默认false,设置是否使用gps
        mOption.setNeedDeviceDirect(false);                                         //可选，设置是否需要设备方向结果
        mOption.setLocationNotify(false);                                           //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        mOption.setIgnoreKillProcess(false);                                        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        mOption.setIsNeedLocationDescribe(false);                                   //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        mOption.setIsNeedLocationPoiList(false);                                    //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        mOption.SetIgnoreCacheException(false);                                     //可选，默认false，设置是否收集CRASH信息，默认收集
        locationService.setLocationOption(mOption);
        locationService.registerListener(mListener);
        //注册监听
        locationService.start();// 定位
    }

    /*****
     * 定位结果回调，重写onReceiveLocation方法
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            addressText = location.getCity();
            mAddress =  location.getLatitude()+ "," + location.getLongitude();
            locationService.stop();

        }
    };

    @Override
    public void onStop() {
        if (locationService != null) {
            locationService.unregisterListener(mListener); //注销掉监听
            locationService.stop(); //停止定位服务
        }

        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
        super.onStop();
    }

    /**
     * This method shows dialog with given title & message.
     * Also there is an option to pass onClickListener for positive & negative button.
     *
     * @param title                         - dialog title
     * @param message                       - dialog message
     * @param onPositiveButtonClickListener - listener for positive button
     * @param positiveText                  - positive button text
     * @param onNegativeButtonClickListener - listener for negative button
     * @param negativeText                  - negative button text
     */
    public void showAlertDialog(@Nullable String title,
                                @Nullable String message,
                                @Nullable DialogInterface.OnClickListener onPositiveButtonClickListener,
                                @NonNull String positiveText,
                                @Nullable DialogInterface.OnClickListener onNegativeButtonClickListener,
                                @NonNull String negativeText,
                                @NonNull Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton(positiveText, onPositiveButtonClickListener);
        builder.setNegativeButton(negativeText, onNegativeButtonClickListener);
        mAlertDialog = builder.show();
    }
}
