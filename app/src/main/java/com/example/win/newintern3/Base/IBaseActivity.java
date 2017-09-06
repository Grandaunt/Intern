package com.example.win.newintern3.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.R;


/**
 * Created by 李江涛 on 2017/6/29.
 * 说明:
 */

public abstract class IBaseActivity extends AppCompatActivity implements View.OnClickListener{
    private long lastClick = 0;
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addActivity(this);
        setContentView(getLayoutId());
        initView();
        loadData();
        setListener();
    }

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }


    @Override
    public void finish() {
        MyApplication.getInstance().removeActivity(this);
        super.finish();
    }

    /**
     * 设置ContentView
     * @return R.layout.xxx
     */
    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    protected abstract void initView();
    /**
     * add Listener
     */
    protected abstract void setListener();

    /**
     * 下载数据
     */
    protected abstract void loadData();
    /**
     * 将数据更新到View
     */
    protected abstract void initDateToView();
    /**
     * view点击
     * @param v
     */
    public abstract void widgetClick(View v);

    /**
     * 防止快速点击
     * @return
     */
    private boolean fastClick() {
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * 通用ToolBar 当存在是调用 布局文件 必须包含 single_toolbar.xml
     * @param title 标题内容
     * @param isBack 是否存在反回功能
     * @param save
     */
    protected void setToolBar(String title, boolean isBack, String save) {
        toolbar = $findViewById(R.layout.toolbar);
//        toolbar.setVisibility(View.VISIBLE);
        TextView tv_title = $findViewById(R.id.text_title);
        tv_title.setText(title);
        TextView tv_save = $findViewById(R.id.text_save);
        tv_title.setText(save);
        ImageView back = $findViewById(R.id.img_back);
//        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (isBack) {
            back.setImageResource(R.mipmap.ic_back);
//            toolbar.setNavigationIcon(R.mipmap.ic_back);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
    protected void setToolBarIm(String title, boolean isBack, int iconId) {
        toolbar = $findViewById(R.layout.toolbar_collect);
//        toolbar.setVisibility(View.VISIBLE);
        TextView tv_title = $findViewById(R.id.text_title);
        tv_title.setText(title);
        toolbar.setTitle("");
        ImageView rightIm = $findViewById(R.id.too_im_coll);
//        rightIm.setImageResource(iconId);
//        setSupportActionBar(toolbar);
        if (isBack) {
            toolbar.setNavigationIcon(R.mipmap.ic_back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
    /**
     * findViewById
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T $findViewById(int resId) {
        return (T) findViewById(resId);
    }

    /**
     *  Toast
     * @param msg 消息
     */
    protected void $toast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * startActivity
     * @param cls 需要启动的Activity
     */
    protected void $startActivity(Class<?> cls) {
        $startActivity(cls, null);
    }

    /**
     * startActivity 存在Bundle
     * @param cls 需要启动的Activity
     * @param bundle Bundle数据
     */
    protected void $startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivityForResult
     * @param cls 需要启动的Activity
     * @param requestCode 请求码
     */
    protected void $startActivityForResult(Class<?> cls, int requestCode) {
        $startActivityForResult(cls, null, requestCode);
    }

    /**
     * startActivityForResult 存在Bundle
     * @param cls 需要启动的Activity
     * @param bundle Bundle数据
     * @param requestCode 请求码
     */
    protected void $startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 获取 传入 Bundle
     * @return
     */
    protected Bundle $getIntentExtra() {
        Intent intent = getIntent();
        Bundle bundle = null;
        if (null != intent)
            bundle = intent.getExtras();
        return bundle;
    }

}
