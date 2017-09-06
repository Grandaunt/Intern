package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.win.newintern3.Adpter.SortAdapter;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.Db.SQLiteHelper;
import com.example.win.newintern3.Entity.CityEntity;
import com.example.win.newintern3.NewEntity.CityInfo;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;
import com.example.win.newintern3.Widgets.FastList.CharacterParser;
import com.example.win.newintern3.Widgets.FastList.PinyinComparator;
import com.example.win.newintern3.Widgets.FastList.SideBar;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class FastCityActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog;
    private SortAdapter adapter;
    private CharacterParser characterParser;
    private List<CityEntity.CitylistEntity> SourceDateList;
    private List<CityEntity.CitylistEntity> SourceDatecache;
    private List<CityEntity.CitylistEntity> result;//搜索
    private EditText searchBox;
    private ImageView clearBtn;
    private TextView title;
    private TextView save;
    private ImageView back;
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_city);
        SourceDateList = new ArrayList<>();
        SourceDatecache = new ArrayList<>();
        sqLiteHelper = SQLiteHelper.getInstance(this);
//        getcitydata();
          initViews();


    }

    private void initViews() {
        title = (TextView) findViewById(R.id.text_title);
        save = (TextView) findViewById(R.id.text_save);
        back = (ImageView) findViewById(R.id.img_back);
        title.setText("选择城市");
        save.setText("");
        back.setOnClickListener(this);
//        ((TextView) findViewById(R.id.text_title)).setText("选择城市");
//        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(this);
        characterParser = CharacterParser.getInstance();

        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView) findViewById(R.id.dialog);
        sideBar.setTextView(dialog);
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    sortListView.setSelection(position);
                }

            }
        });

        sortListView = (ListView) findViewById(R.id.country_lvcountry);
//        sortListView.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Toast.makeText(getApplication(),
//                        ((CitySortModel) adapter.getItem(position - 1)).getName(),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
        SourceDateList = new ArrayList<>();
//        SourceDateList = filledData(getResources().getStringArray(R.array.provinces));
        SourceDatecache = new ArrayList<>();
        Cursor cursor = sqLiteHelper.query(sqLiteHelper.TB_City, null, null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            CityEntity.CitylistEntity citylistEntity = new CityEntity.CitylistEntity();
            citylistEntity.setCityName(cursor.getString(cursor.getColumnIndex(sqLiteHelper.TB_CityName)));
            citylistEntity.setCityCode(cursor.getInt(cursor.getColumnIndex(sqLiteHelper.TB_CityCode)));
            citylistEntity.setFirstChar(cursor.getString(cursor.getColumnIndex(sqLiteHelper.TB_FirstChar)));
            citylistEntity.setParentCode(cursor.getString(cursor.getColumnIndex(sqLiteHelper.TB_ParentCode)));
            SourceDateList.add(citylistEntity);
        }
        Logger.i("SourceDateList="+SourceDateList.get(0)+SourceDateList.size());
        SourceDatecache.addAll(SourceDateList);
        cursor.close();
        if(SourceDateList.size() == 0){
            getcitydata();
        }
        selectchar(SourceDateList);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        adapter.setOnCityClickListener(new SortAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(CityEntity.CitylistEntity item) {
                Intent intent = new Intent();
                intent.putExtra("city", item);
                setResult(NewInternActivity.cityresult, intent);
                finish();
            }
        });
//        sortListView.addHeaderView(initHeadView());
        sortListView.setAdapter(adapter);


        clearBtn = (ImageView) findViewById(R.id.iv_search_clear);
        clearBtn.setOnClickListener(this);
        searchBox = (EditText) findViewById(R.id.et_search);
        searchBox.setHint("请输入城市");
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String keyword = s.toString();
                SourceDateList = SourceDatecache;

                if (TextUtils.isEmpty(keyword)) {
                    clearBtn.setVisibility(View.GONE);
//                    emptyView.setVisibility(View.GONE);
                    sortListView.setVisibility(View.VISIBLE);
                    selectchar(SourceDateList);
                    Collections.sort(SourceDateList, new PinyinComparator());
                    adapter.changeData(SourceDateList);
                } else {
                    clearBtn.setVisibility(View.VISIBLE);
                    sortListView.setVisibility(View.VISIBLE);
                    result = new ArrayList<CityEntity.CitylistEntity>();
                    for(int i=0;i<SourceDateList.size();i++) {
                        if (SourceDateList.get(i).getCityName().contains(keyword)) {
                            result.add(SourceDateList.get(i));
                        }
                    }
                    if (result == null || result.size() == 0) {
                        //没有数据
//                        emptyView.setVisibility(View.VISIBLE);
                        sortListView.setVisibility(View.GONE);
                    } else {
//                        emptyView.setVisibility(View.GONE);
                        sortListView.setVisibility(View.VISIBLE);
                        selectchar(result);
                        Collections.sort(result, new PinyinComparator());
                        adapter.changeData(result);
                    }
                }

            }
        });
    }



    private void selectchar(List<CityEntity.CitylistEntity> list) {
        ArrayList<String> indexString = new ArrayList<>();
        for(CityEntity.CitylistEntity item:list){
//            indexString.add(item.getFirstChar());
            if (!indexString.contains(item.getFirstChar())) {
                indexString.add(item.getFirstChar());
            }
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_search_clear:
                searchBox.setText("");
                clearBtn.setVisibility(View.GONE);
//                emptyView.setVisibility(View.GONE);
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }
    //城市数据写入数据库
    private void getcitydata() {
//
        RequestParams params = new RequestParams(URLConfig.CityAPI);
        params.addParameter("pageNumber", "0");
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String s) {
                Logger.d(s);
                ServiceListEntity<CityInfo> cityEntity = JsonUtils.getServiceListEntity(s, CityInfo.class);
                if (null != cityEntity && null != cityEntity.getList()) {
                    List<ContentValues> listcontent = new ArrayList<ContentValues>();
                    for (CityInfo item : cityEntity.getList()) {

                        ContentValues contentValues = new ContentValues();
                        contentValues.put("firstChar", item.getFirstChar());
                        contentValues.put("cityName", item.getCityName());
                        contentValues.put("parentCode", item.getParentCode());
                        contentValues.put("cityCode", item.getCityCode());
                        listcontent.add(contentValues);
                        Log.d("name", item.getCityName());
                    }

                    sqLiteHelper.deleteCityAll();
                    Log.d("listcontent", String.valueOf(listcontent.get(0).get("firstChar")));
                    sqLiteHelper.insert(sqLiteHelper.TB_City, listcontent);
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