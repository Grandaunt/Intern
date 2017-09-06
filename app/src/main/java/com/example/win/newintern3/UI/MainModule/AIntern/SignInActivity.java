package com.example.win.newintern3.UI.MainModule.AIntern;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.Entity.DPMode;
import com.example.win.newintern3.NewEntity.Signinfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Service.LocationService;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.decors.DPDecor;
import com.example.win.newintern3.Utils.logger.Logger;
import com.example.win.newintern3.Widgets.DatePicker;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/***
 * 签到
 */
public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = this.getClass().getSimpleName();
    //设置所需的权限
    private static String[] PERMISSIONS_CONTACT = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };
    private static final int REQUEST_LOCATION = 0;

    private LocationService locationService;//定位服务

    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private DatePicker datePicker;
    private ImageButton signin;

    private MyApplication application;
    private AlertDialog mAlertDialog;

    private String addressText = "北京";
    private String signAddress = "0,0";
    private String Today="";

    private List<String> tmpTR = new ArrayList<>();//记录今天签到
    private List<String> tmpB = new ArrayList<>();//记录到以前签到时间的

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        application = (MyApplication) getApplication();
        Today=TimeUtils.getToday();
        findview();
        initview();
        initdata(application.getUserid(), String.valueOf(application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId()), application.getUserLoginMainEntity().getUserPracticeInfo().getBasePlanStartTime(), application.getUserLoginMainEntity().getUserPracticeInfo().getBasePlanEndTime());
        initpermissions();
    }

    private void initview() {
        DPCManager.getInstance().initCacheAll();
        datePicker.setDate(TimeUtils.getDate().get(Calendar.YEAR), TimeUtils.getDate().get(Calendar.MONTH) + 1);
        datePicker.setFestivalDisplay(false);//节气
        datePicker.setTodayDisplay(true);//今天
        datePicker.setHolidayDisplay(false);//假日
        datePicker.setDeferredDisplay(false);//补假
        datePicker.setMode(DPMode.NONE);
        datePicker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorTL(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorTL(canvas, rect, paint, data);
                paint.setColor(Color.RED);
                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
            }

            @Override
            public void drawDecorTR(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorTR(canvas, rect, paint, data);
                paint.setColor(0x40deff);
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_signin),//资源bitmap
                        null, //图片的裁剪区域
                        rect,//绘制区域
                        null);//画笔
//                DPCManager.getInstance().initCache();
//                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
            }
            @Override
            public void drawDecorB(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorB(canvas, rect, paint, data);
                paint.setColor(0x40deff);
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_signed),//资源bitmap
                        null, //图片的裁剪区域
                        rect,//绘制区域
                        null);//画笔
//                DPCManager.getInstance().initCache();
//                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
            }
            @Override
            public void drawDecorT(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorT(canvas, rect, paint, data);
                paint.setColor(0x40deff);
                canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_signed),//资源bitmap
                        null, //图片的裁剪区域
                        rect,//绘制区域
                        null);//画笔
//                DPCManager.getInstance().initCache();
//                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
            }
        });
    }


    private void initpermissions() {
        //监测所需的权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(SignInActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(SignInActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {
            showAlertDialog("请求获取权限", "手机进行定位需要获取权限",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(SignInActivity.this, PERMISSIONS_CONTACT, REQUEST_LOCATION);
                        }
                    }, "继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "取消", SignInActivity.this);

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
            signAddress =  location.getLatitude()+ "," + location.getLongitude();
            locationService.stop();

        }
    };


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

    //签到历史
    private void initdata(String userId, String practiceId, String startTime, String endTime) {
        //http://114.55.2.134:8080/trial/userpractice.do?action=getsignbytime&userId=1&practiceId=1&startTime=2016-4-10&endTime=2016-7-20
        startTime="2016-06-06";
        endTime=Today;
        Logger.i("Today："+Today);
        RequestParams params = new RequestParams(URLConfig.SinginHistoryAPI);
        params.addParameter("startDate", startTime);
        params.addParameter("endDate", endTime);
//        params.addParameter("userId", userId);
        params.addParameter("userId", application.getUserid());
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Logger.d(result);
                ServiceListEntity<Signinfo> Entity  = JsonUtils.getServiceListEntity(result, Signinfo.class);

                if (Entity != null) {
                    if (Entity.getCode().equals("200")) {
                        for (int i = 0; i < Entity.getList().size(); i++) {
                            if(Today.equals(GetTimeNot0(Entity.getList().get(i).getSignDateTime()))){
                                DPCManager.getInstance().initCacheAll();
                                tmpTR.add(Today);
                            }
                            else{
                                //2017-8-1
                                tmpB.add(GetTimeNot0(Entity.getList().get(i).getSignDateTime()));
                                Logger.i(TAG,"已签到日期："+Entity.getList().get(i).getSignDateTime());
                            }

                        }
                        setDecor(tmpB);
                        setDecorTR(tmpTR);
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



    }

    //以前签到标记
    private void setDecor(List<String> list) {
        DPCManager.getInstance().initCache();
        DPCManager.getInstance().setDecorB(list);
        datePicker.invalidate();//请求刷新布局(坑爹的一行代码 2016年4月27日00:52:44)
    }
    //今天的签到标记
    private void setDecorTR(List<String> list) {
        DPCManager.getInstance().initCache();
        DPCManager.getInstance().setDecorTR(list);
        datePicker.invalidate();//请求刷新布局(坑爹的一行代码 2016年4月27日00:52:44)
    }

    /**
     * 签到
     *
     * @param userId
     * @param practiceId
     * @param signAddress 经纬度
     * @param addressText 城市
     */
    private void DoSignin(String userId, int practiceId, String signAddress, String addressText) {
        RequestParams requestparams = new RequestParams(URLConfig.SinginAPI);
        requestparams.addParameter("signType", "1");
        requestparams.addParameter("userId",  application.getUserid());
        requestparams.addParameter("signAddress", signAddress);
        requestparams.addParameter("practiceId", application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId());
//        requestparams.addParameter("addressText", addressText);
        Logger.i( "hasAcc_params：" + requestparams);
        x.http().post(requestparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Logger.i(result);
                if (result.equals("{\"code\":\"200\"}")) {
                        Toast.makeText(SignInActivity.this, "签到成功", Toast.LENGTH_SHORT).show();
                        Logger.i(TAG,"签到成功");
                        DPCManager.getInstance().initCacheAll();
                        tmpTR.add(Today);
                        setDecor(tmpTR);
                    } else if (result.equals("{\"code\":\"450\"}")) {
                        Toast.makeText(SignInActivity.this, "今天已签到过", Toast.LENGTH_SHORT).show();
                        Logger.i(TAG,"今天已签到过");
                    } else if (result.equals("{\"code\":\"505\"}")) {
                        Toast.makeText(SignInActivity.this, "签到失败", Toast.LENGTH_SHORT).show();
                        Logger.i(TAG,"签到失败");
                    }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }




    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("签到");
        save= (TextView) findViewById(R.id.text_save);
        save.setText("");
        back.setOnClickListener(this);

        datePicker = (DatePicker) findViewById(R.id.date_asi_sign_in);
        signin = (ImageButton) findViewById(R.id.btn_asi_sign_in);
        signin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_asi_sign_in:
                DoSignin(application.getUserid(), application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId(), signAddress, addressText);
                break;
        }
    }


    /**
     * 去除月份和日 前面的0
     *
     * @param time
     * @return
     */
    private static String GetTimeNot0(String time) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }
}
