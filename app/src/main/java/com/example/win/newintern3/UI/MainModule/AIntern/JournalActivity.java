package com.example.win.newintern3.UI.MainModule.AIntern;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClientOption;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Service.LocationService;
import com.example.win.newintern3.Utils.TimeUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.calendars.DPCManager;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/***
 * 日志
 */
public class JournalActivity extends AppCompatActivity implements View.OnClickListener {

    //设置所需的权限
    private static String[] PERMISSIONS_CONTACT = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private static final int REQUEST_LOCATION = 0;

    private LocationService locationService;//定位服务
    private AlertDialog mAlertDialog;

    private String signAddress = "0,0";


    private Toolbar toolbar;
    private ImageView back;
    private TextView title;
    private TextView save;
    private TextView date;
    private EditText company;
    private EditText address;
    private EditText body;
    private EditText summary;
    private Button submit;
    private MyApplication application;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private String Today="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);
        application = (MyApplication) getApplication();
        Today= TimeUtils.getDate().get(Calendar.YEAR) + "-"
                + (TimeUtils.getDate().get(Calendar.MONTH) + 1) + "-"
                + TimeUtils.getDate().get(Calendar.DAY_OF_MONTH);
        findview();
        initpermissions();
    }

    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        back = (ImageView) findViewById(R.id.img_back);
        title = (TextView) findViewById(R.id.text_title);
        save = (TextView) findViewById(R.id.text_save);
        back.setOnClickListener(this);
        title.setText("日志");
        save.setText("提交");
        save.setOnClickListener(this);
//        date = (TextView) findViewById(R.id.text_aj_date);
//        date.setText(df.format(Calendar.getInstance().getTime()));
//        date.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getBasePlanStartTime());
        company = (EditText) findViewById(R.id.text_aj_company);
//        company.setText(application.getUserLoginMainEntity().getUserpracticeinfo().getCompanyName());
        company.setText("");
        address = (EditText) findViewById(R.id.text_aj_address);
        body = (EditText) findViewById(R.id.edt_aj_body);
        summary = (EditText) findViewById(R.id.edt_aj_summary);
//        submit = (Button) findViewById(R.id.btn_aj_submit);
//        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
//            case R.id.btn_aj_submit:
//                DoJournal();
//                break;
            case R.id.text_save:
                DoJournal();
                break;
        }
    }

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
     * 发布日志
     */
    private void DoJournal() {
        if (address.getText().length() > 0
                && summary.getText().length() > 0
                && body.getText().length() > 0) {
            RequestParams params = new RequestParams(URLConfig.JournalAPI);
//            params.addParameter("action", "publishdayreport");
            params.addParameter("userId",  application.getUserid());
            params.addParameter("practiceId", String.valueOf(application.getUserLoginMainEntity().getUserPracticeInfo().getUserPracticeId()));
            params.addParameter("dayReportContent",  body.getText().toString());
            params.addParameter("dayReportExperience", summary.getText().toString());
            params.addParameter("dayreportDes", "");
            params.addParameter("dayReportAddress", signAddress);
//            params.addParameter("dayReportAddress",  address.getText().toString());
//            params.addParameter("date", Today);
            Logger.d(params);
            x.http().post(params, new Callback.CommonCallback<String>() {
                @Override
                public void onSuccess(String s) {
                    Logger.d(s);

                        if (!TextUtils.isEmpty(s)) {
                            if (s.equals("{\"code\":\"200\"}")) {
                                Toast.makeText(JournalActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }  if (s.equals("{\"code\":\"450\"}")) {
                                Toast.makeText(JournalActivity.this, "重复提交", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(JournalActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
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

        }else{
            Toast.makeText(JournalActivity.this, "请完善信息后提交", Toast.LENGTH_SHORT).show();
        }

    }


    private void initpermissions() {
        //监测所需的权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN // Permission was added in API Level 16
                && ActivityCompat.checkSelfPermission(JournalActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(JournalActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                ) {
            showAlertDialog("请求获取权限", "手机进行定位需要获取权限",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(JournalActivity.this, PERMISSIONS_CONTACT, REQUEST_LOCATION);
                        }
                    }, "继续", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }, "取消", JournalActivity.this);

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
        mOption.setIsNeedAddress(false);                                             //可选，设置是否需要地址信息，默认不需要
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
            signAddress = location.getLatitude() + "," + location.getLongitude();
            locationService.stop();

        }
    };

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
