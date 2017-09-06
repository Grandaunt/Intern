package com.example.win.newintern3.UI.ThreeModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win.newintern3.R;

public class CMainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private ImageView back;
    private TextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmain);
        findview();
    }
    private void findview() {
        /////////////////ToolBar//////////////////
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.text_title);
        title.setText("圈子");
        back = (ImageView) findViewById(R.id.img_back);
        back.setOnClickListener(this);
        edit = (TextView) findViewById(R.id.text_save);
        edit.setText("");
        ////////////////////////////////////////////
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;

        }
    }
}
