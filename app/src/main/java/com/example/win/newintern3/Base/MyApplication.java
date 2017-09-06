package com.example.win.newintern3.Base;

/**
 * Created by win on 2017/8/9.
 */


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.win.newintern3.NewEntity.UserLoginMainEntity;
import com.example.win.newintern3.R;
import com.example.win.newintern3.UI.FourModule.MyUserInfoActivity;
import com.example.win.newintern3.Utils.ACache;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;
import com.example.win.newintern3.Widgets.ActionSheetDialog;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;


/**
 * MyApplication
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    private static FunctionConfig mFunctionConfig;
    public static FunctionConfig.Builder mFunctionConfigBuilder;
    public Vibrator mVibrator;
    public static final String userinfo = "userinfo";
    public final int REQUEST_CODE_CAMERA = 1000;
    public final int REQUEST_CODE_GALLERY = 1001;
    public final int REQUEST_CODE_CROP = 1002;
    public final int REQUEST_CODE_EDIT = 1003;
    public static final int REQUEST_STORAGE_READ_ACCESS_PERMISSION = 101;
    public static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 102;
    private String userid;
    public String url;

    private UserLoginMainEntity userLoginMainEntity;
    private ACache aCache;
//    public DisplayImageOptions options;
    private ArrayList<Activity> activityList = new ArrayList<Activity>();
    public static ImageOptions options;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        instance = this;
        initGalleryFinal();
        initACache();
        initOKHttp();
        //头像
                options = new ImageOptions.Builder()
                //设置圆形
                .setCircular(true)
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_com_logo)
//设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_com_logo)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
    }

    private void initOKHttp() {
//        //必须调用初始化
//        OkHttpUtils.init(this);
//        //以下都不是必须的，根据需要自行选择
//        OkHttpUtils.getInstance()//
//                .debug("okhttp:")                                                     //是否打开调试
//                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的连接超时时间
//                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                     //全局的读取超时时间
//                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS);                   //全局的写入超时时间
//        //.setCookieStore(new MemoryCookieStore())                            //cookie使用内存缓存（app退出后，cookie消失）
//        //.setCookieStore(new PersistentCookieStore())                        //cookie持久化存储，如果cookie不过期，则一直有效
////                .addCommonHeaders(headers)                                          //设置全局公共头
////                .addCommonParams(params);                                           //设置全局公共参数

    }

    private void initACache() {
        //用户登录相关
        aCache = ACache.get(this);
        setUserLoginMainEntity((UserLoginMainEntity) aCache.getAsObject(userinfo));

    }

    /***
     * 初始化GalleryFinal
     */
    private void initGalleryFinal() {
        mFunctionConfigBuilder = new FunctionConfig.Builder();
        //设置主题
        //ThemeConfig.CYAN
        ThemeConfig theme = new ThemeConfig.Builder()
                //标题栏背景颜色
                .setTitleBarBgColor(Color.rgb(0xff, 0xff, 0xff))
                //标题栏文本字体颜色43bc53
                .setTitleBarTextColor(Color.rgb(0x43,0xbc,0x53))
                //标题栏icon颜色，如果设置了标题栏icon，设置setTitleBarIconColor将无效
                . setTitleBarIconColor(Color.rgb(0x43,0xbc,0x53))
                //设置Floating按钮Nornal状态颜色
                .setFabNornalColor(Color.rgb(0xDD, 0xDD, 0xDD))
                //设置Floating按钮Pressed状态颜色
                .setFabPressedColor(Color.rgb(0x43, 0xbc, 0x53))
                //选择框未选颜色
                .setCheckSelectedColor(Color.rgb(0xEE, 0xEE, 0xEE))
                //设置裁剪控制点和裁剪框颜色
                .setCropControlColor(Color.rgb(0xEE, 0xEE, 0xEE))

                .build();
        // mFunctionConfigBuilder.setSelected(mPhotoList);//添加过滤集合
        //配置功能
        mFunctionConfig = mFunctionConfigBuilder
                .setEnableEdit(true)//开启编辑功能
                .setEnableCamera(true)//开启相机功能
                .setEnableCrop(true)//开启裁剪功能
                .setEnableRotate(true)//开启旋转功能
                .setCropSquare(true)//裁剪正方形
                .setEnablePreview(true)//是否开启预览功能
                .setRotateReplaceSource(true)//配置选择图片时是否替换原始图片，默认不替换
                .build();

        //配置imageloader
        ImageLoader imageloader = new XUtilsImageLoader();

        CoreConfig coreConfig = new CoreConfig.Builder(getInstance(), imageloader, theme)

                .setFunctionConfig(mFunctionConfig)
                .build();
        GalleryFinal.init(coreConfig);
    }


    public static MyApplication getInstance(){
        return instance;
    }
    public static FunctionConfig getFunctionConfig() {
        return mFunctionConfig;
    }
    public static FunctionConfig.Builder getFunctionConfigBuilder() {
        return mFunctionConfigBuilder;
    }

    public UserLoginMainEntity getUserLoginMainEntity() {
        return userLoginMainEntity;
    }

    public void setUserLoginMainEntity(UserLoginMainEntity userLoginMainEntity) {
        this.userLoginMainEntity = userLoginMainEntity;
    }

    public void SetMajorId(int MajorId) {
        this.userLoginMainEntity.getUserLogin().getUserBaseInfo().setMajorId(MajorId);
    }

    public String getUserid() {
        return String.valueOf(getUserLoginMainEntity().getUserLogin().getUserId());
    }



    //Activity相关
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }
    /**
     *     遍历所有Activity并finish
     */
    public void exit() {
        try {
            for (Activity activity : activityList) {
                activity.finish();
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *     杀进程
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }



}
