package com.example.win.newintern3.UI.TwoModule;


import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.Util;
import com.example.win.newintern3.Widgets.ObservableWebView;


public class WebBrowseStudyFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM2 = "body";
    private static final String ARG_PARAM3 = "id";
    ProgressBar progressbarWeb;
    ObservableWebView webBrowse;
    FloatingActionButton fab;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;


    private int mLastScrollY;//记录滚动
    private int mScrollThreshold;

    private FrameLayout frameLayout;

    /**
     * 这是容器的布局之前全屏模式已被输入。
     * 当我们离开全屏模式，我们的容器的布局恢复此布局。
     */
    private ViewGroup.LayoutParams originalContainerLayoutParams;
    private boolean isFull = false;

    public WebBrowseStudyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebBrowseStudyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebBrowseStudyFragment newInstance(String param1, String param2, int param3) {
        WebBrowseStudyFragment fragment = new WebBrowseStudyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_browse_study, container, false);
        progressbarWeb = (ProgressBar) view.findViewById(R.id.progressbar_w_web);
        webBrowse = (ObservableWebView) view.findViewById(R.id.web_browse);
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);
        frameLayout=(FrameLayout) getActivity().findViewById(mParam3);//获得宿主的布局方式
        this.originalContainerLayoutParams = frameLayout.getLayoutParams();
        mScrollThreshold = getResources().getDimensionPixelOffset(com.melnykov.fab.R.dimen.fab_scroll_threshold);

        webBrowse.setOnScrollChangedListener(new ObservableWebView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(ObservableWebView who, int l, int t, int oldl, int oldt) {
                //滑动隐藏fab
                boolean isSignificantDelta = Math.abs(t - mLastScrollY) > mScrollThreshold;
                if (isSignificantDelta && isFull) {
                    if (t > mLastScrollY) {
                        fab.show();
                    } else {
                        fab.hide();
                    }
                }
                mLastScrollY = t;
            }
        });
        WebSettings mWebSettings = webBrowse.getSettings();
        mWebSettings.setSupportZoom(true);//支持缩放，默认为true。
        mWebSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        mWebSettings.setUseWideViewPort(true);//将图片调整到适合webview的大小
        mWebSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        mWebSettings.setLoadsImagesAutomatically(true);//支持自动加载图片

        //调用JS方法.安卓版本大于17,加上注解 @JavascriptInterface
        mWebSettings.setJavaScriptEnabled(true);
        saveData(mWebSettings);
        newWin(mWebSettings);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            webBrowse.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        webBrowse.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webBrowse.setWebChromeClient(webChromeClient);
        webBrowse.setWebViewClient(webViewClient);
        webBrowse.loadUrl(mParam2);


        return view;
    }

    @Override
    public void onDestroyView() {
        if (webBrowse != null) {
            webBrowse.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            webBrowse.clearHistory();

            ((ViewGroup) webBrowse.getParent()).removeView(webBrowse);
            webBrowse.destroy();
            webBrowse = null;
        }
        super.onDestroyView();
    }


    /**
     * 多窗口的问题
     */
    private void newWin(WebSettings mWebSettings) {
        //html中的_bank标签就是新建窗口打开，有时会打不开，需要加以下
        //然后 复写 WebChromeClient的onCreateWindow方法
        mWebSettings.setSupportMultipleWindows(false);
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    }


    /**
     * HTML5数据存储
     */
    private void saveData(WebSettings mWebSettings) {
        //有时候网页需要自己保存一些关键数据,Android WebView 需要自己设置
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setAppCacheEnabled(true);
        String appCachePath = getContext().getApplicationContext().getCacheDir().getAbsolutePath();
        mWebSettings.setAppCachePath(appCachePath);
    }

    WebViewClient webViewClient = new WebViewClient() {

        /**
         * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    };

    WebChromeClient webChromeClient = new WebChromeClient() {

        //获得网页的加载进度，显示在右上角的TextView控件中
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            if (newProgress < 100) {
////                String progress = newProgress + "%";
//                progressbarWeb.setVisibility(View.VISIBLE);
//                progressbarWeb.setProgress(newProgress);
//            } else {
//                progressbarWeb.setVisibility(View.GONE);
//            }
        }

        //=========HTML5定位==========================================================
        //需要先加入权限
        //<uses-permission android:name="android.permission.INTERNET"/>
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            super.onGeolocationPermissionsHidePrompt();
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(final String origin, final GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);//注意个函数，第二个参数就是是否同意定位权限，第三个是是否希望内核记住
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
        //=========HTML5定位==========================================================


        //=========多窗口的问题==========================================================
        @Override
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
            transport.setWebView(webBrowse);
            resultMsg.sendToTarget();
            return true;
        }
        //=========多窗口的问题==========================================================
    };

    public boolean goback(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webBrowse.canGoBack()) {
            webBrowse.goBack();
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onClick(View view) {
        if (!isFull) {
            frameLayout.setLayoutParams(Util.getLayoutParamsBasedOnParent(
                    frameLayout,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            ));
            fab.setImageResource(R.mipmap.ic_action_return_from_full_screen);
            isFull = true;
        } else {
            frameLayout.setLayoutParams(originalContainerLayoutParams);
            fab.setImageResource(R.mipmap.ic_action_full_screen);
            isFull = false;
        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && webBrowse.canGoBack()) {
//            webBrowse.goBack();
//            return true;
//        }
//
//        return super.onKeyDown(keyCode, event);
//    }


}
