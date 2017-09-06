package com.example.win.newintern3.UI.FourModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.win.newintern3.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView webview = (WebView) findViewById(R.id.web_about);

//步骤2. 选择加载方式
        //方式1. 加载一个网页：
        webview.loadUrl("http://www.google.com/");
    }
}
