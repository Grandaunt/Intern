package com.example.win.newintern3.UI.MainModule.BIntern;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.win.newintern3.Base.BaseQuickAdapter;
import com.example.win.newintern3.Base.BaseViewHolder;
import com.example.win.newintern3.Base.MyApplication;
import com.example.win.newintern3.Base.ServiceListEntity;
import com.example.win.newintern3.NewEntity.PracticeBase;
import com.example.win.newintern3.R;
import com.example.win.newintern3.Utils.JsonUtils;
import com.example.win.newintern3.Utils.URLConfig;
import com.example.win.newintern3.Utils.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;
/**
 * 基地实习列表
 */
public class BaseListActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private TextView title;
    private ImageView back;
    private TextView menu;

    private RecyclerView recycle;
    private BasePracticeAdapter adapter;
    private int index = -10;
    private int Count = 10;
    private Intent intent;
    private String planId = "";//区别是否为筛选，如果为筛选时，在加载更多数据时根据此此段来判断

//    private MentRecycleAdapter menuadapter;

    private PopupWindow popupWindowMenu;

//    private SubmitResultsActivity submitResultsActivity;
    private MyApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_list);
        application = (MyApplication) getApplication();
        getdata();
        findview();
        initdata();

//        getMenudata();
    }


    private void findview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        title = (TextView) findViewById(R.id.text_title);
        back = (ImageView) findViewById(R.id.img_back);
        menu = (TextView) findViewById(R.id.text_save);
        menu.setText("");
        title.setText("基地实习");
        back.setOnClickListener(this);
//        menu.setOnClickListener(this);

        recycle = (RecyclerView) findViewById(R.id.recycler_com_list);
        recycle.setLayoutManager(new LinearLayoutManager(this));
//        recycle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        adapter = new BasePracticeAdapter(null);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<PracticeBase>() {
            @Override
            public void onItemClick(View view, int position, PracticeBase item) {
//                intent = new Intent(BaseListActivity.this, LookOverBasePracticeActivity.class);
//                intent.putExtra(LookOverBasePracticeActivity.intenttag1, item);
//                startActivity(intent);
                 intent = new Intent();
                intent.putExtra("base", item);
                setResult(NewInternActivity.baseresult, intent);
                finish();
            }
        });
        recycle.setAdapter(adapter);
    }

    //初始工作
    private void initdata() {

        //筛选菜单
//        menuadapter = new MentRecycleAdapter(null);
//        menuadapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener<BaseMenuPlanEntity.PracticeplanlistEntity>() {
//            @Override
//            public void onItemClick(View view, int position, BaseMenuPlanEntity.PracticeplanlistEntity item) {
//                if (null != popupWindowMenu) {
//                    popupWindowMenu.dismiss();
//                }
//                planId = String.valueOf(item.getPlanId());
//
//                adapter = new BasePracticeAdapter(null);
////                adapter.openLoadAnimation();
//                adapter.setOnLoadMoreListener(BaseListActivity.this);
//                adapter.openLoadMore(10, true);
//                adapter.setOnRecyclerViewItemClickListener(BaseListActivity.this);
//                recycle.setAdapter(adapter);
//
//                filterData(planId);
//
//
//            }
//        });

//        //新增回调，为了刷新数据
//        submitResultsActivity = new SubmitResultsActivity();
//        submitResultsActivity.setonCallBackRefresh(new SubmitResultsActivity.onCallBackRefresh() {
//            @Override
//            public void Refresh() {
//                index = -10;
//
//                adapter = new BasePracticeAdapter(null);
//                adapter.openLoadAnimation();
//                adapter.setOnLoadMoreListener(BasePracticeActivity.this);
//                adapter.openLoadMore(10, true);
//                adapter.setOnRecyclerViewItemClickListener(BasePracticeActivity.this);
//                recycle.setAdapter(adapter);
//
//                //如果planId为null或者为0时，则列表为全部的数据，所以加载全部数据的分页
//                if (null == planId || planId.equals("") || planId.equals("0")) {
//                    getdata();
//                } else {
//                    filterData(planId);
//                }
//            }
//        });

    }

//    @Override
//    public void onLoadMoreRequested() {//加载更多
//        //如果planId为null或者为0时，则列表为全部的数据，所以加载全部数据的分页
//        if (planId.equals("")||planId.equals("0")) {
//            getdata();
//        }else{
////            filterData(planId);
//        }
//
//    }

    /**
     * 获得列表数据
     */
    private void getdata() {
        RequestParams params = new RequestParams(URLConfig.BaseInfoAPI);
        params.addParameter("StudentId",application.getUserid());
        params.addParameter("pageNumber","0");
        params.addParameter("PlanId","4");
        Logger.d(params);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Logger.d(result);
                ServiceListEntity<PracticeBase> Entity  = JsonUtils.getServiceListEntity(result, PracticeBase.class);

                if (Entity.getCode().equals("200")) {
                    Logger.d("Entity.getCode() == "+Entity.getCode());
                    adapter.setPageSize(adapter.getItemCount() + Entity.getList().size());
                    adapter.addData(Entity.getList());
                    Logger.i("Entity.getList()="+Entity.getList().size());
                    if (Entity.getList().size() < Count) {
                        adapter.notifyDataChangedAfterLoadMore(false);
                    } else {
                        adapter.notifyDataChangedAfterLoadMore(true);
                    }
                }
                else
                {
                    Toast.makeText(BaseListActivity.this,"用户已申请基地岗位，不可以重复申请",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Logger.d(ex);
                Toast.makeText(BaseListActivity.this,"用户已申请基地岗位，不可以重复申请",Toast.LENGTH_SHORT).show();
                finish();
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }

    /**
     * 获得菜单筛选数据
     */
//    private void getMenudata() {
//        OkHttpUtils.post(BuildConfig.BasePracticeAPI)
//                .tag(this)
//                .cacheKey("BasePracticemenu")
//                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)
//                .params("action","practiceplan")
//                .params("userId",application.getUserid())
//                .execute(new MenuCallBack() {
//                    @Override
//                    public void onResponse(boolean isFromCache, BaseMenuPlanEntity baseMenuPlanEntity, Request request, @Nullable Response response) {
//                        if (null != baseMenuPlanEntity && baseMenuPlanEntity.getPracticeplanlist() != null) {
//                            menuadapter.setNewData(baseMenuPlanEntity.getPracticeplanlist());
//
//                            //添加全部的选项
//                            BaseMenuPlanEntity.PracticeplanlistEntity all = new BaseMenuPlanEntity.PracticeplanlistEntity();
//                            all.setPracticeName("全部");
//                            menuadapter.add(0,all);
//                        }
//                    }
//
//                    @Override
//                    public void onError(boolean isFromCache, Call call, @Nullable Response response, @Nullable Exception e) {
//                        super.onError(isFromCache, call, response, e);
//                        Logger.e(e.getMessage());
//                        Toast.makeText(BasePracticeActivity.this, getResources().getString(R.string.network_error), Toast.LENGTH_LONG).show();
//                    }
//                });
//
//    }

    /**
     * 加载筛选数据
     * @param
     */
//    private void filterData(String planId) {
//        index = -10;
//        if (planId.equals("0")) {
//
//            adapter = new BasePracticeAdapter(null);
////            adapter.openLoadAnimation();
//            adapter.setOnLoadMoreListener(BaseListActivity.this);
//            adapter.openLoadMore(10, true);
//            adapter.setOnRecyclerViewItemClickListener(this);
//            recycle.setAdapter(adapter);
//
//            getdata();
//        }else{
//            RequestParams params = new RequestParams(URLConfig.UserInfoAPI);
//            params.addParameter("StudentId","4060");
//            params.addParameter("PlanId","4");
//            params.addParameter("pageNumbe","0");
//            Logger.d(params);
//            x.http().post(params, new Callback.CommonCallback<String>() {
//                @Override
//                public void onSuccess(String result) {
//
//                    Logger.d(result);
//                    ServiceListEntity<PracticeBase> Entity  = JsonUtils.getServiceListEntity(result, PracticeBase.class);
//                    if (Entity.getCode() == "200") {
//                        adapter.setPageSize(adapter.getItemCount() + Entity.getList().size());
//                        adapter.addData(Entity.getList());
//                        if (Entity.getList().size() < Count) {
//                            adapter.notifyDataChangedAfterLoadMore(false);
//                        } else {
//                            adapter.notifyDataChangedAfterLoadMore(true);
//                        }
//                    }
//
//                }
//
//                @Override
//                public void onError(Throwable ex, boolean isOnCallback) {
//                    Logger.d(ex);
//                }
//                @Override
//                public void onCancelled(CancelledException cex) {
//                }
//                @Override
//                public void onFinished() {
//                }
//            });
//
//        }
//
//    }



//    private abstract class MenuCallBack extends AbsCallback<BaseMenuPlanEntity>{
//        @Override
//        public BaseMenuPlanEntity parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s, BaseMenuPlanEntity.class);
//        }
//    }
//
//    private abstract class BaseCallBase extends AbsCallback<PracticeBase> {
//        @Override
//        public PracticeBase parseNetworkResponse(Response response) throws Exception {
//            String s = response.body().string();
//            if (TextUtils.isEmpty(s)) {
//                return null;
//            }
//            return JsonUtils.getPerson(s, PracticeBase.class);
//        }
//    }


    private class BasePracticeAdapter extends BaseQuickAdapter<PracticeBase> {

        public BasePracticeAdapter(List<PracticeBase> data) {
//            super(R.layout.item_base_private, data);
            super(R.layout.item_office_practice_page, data);
        }
        @Override
        public void convert(BaseViewHolder helper, PracticeBase item,int positions) {
            Logger.i("convert");

            ImageView icon = (ImageView) helper.itemView.findViewById(R.id.item_com_icon);
            x.image().bind(icon, item.getBaseIcon(), application.options);
            helper.setText(R.id.item_com_title,  item.getBaseName())
                    .setText(R.id.item_com_name, item.getCompanyName())
                    .setText(R.id.item_post_type,  item.getPracticePlan().getPlanStartTime() + "~" + item.getPracticePlan().getPlanEndTime())
                    .setText(R.id.item_com_money, "")
                    .setText(R.id.item_com_posted_time, "");

//            helper.setText(R.id.item_train_title, item.getBaseName())
//                    .setText(R.id.item_train_company_name, item.getCompanyName())
//                    .setText(R.id.item_train_other, item.getPracticePlan().getPlanStartTime() + "~" + item.getPracticePlan().getPlanEndTime());


//                    .setText(R.id.item_train_people_num, "人数: " + item.getBasePlanNum() + "人");
//
//            ImageView icon = helper.getView(R.id.item_train_icon);
//            x.image().bind(icon, item.getBaseIcon(), options);

//            Picasso.with(helper.convertView.getContext()).load(item.getCompanyIcon()).into(icon);

//      TextView ltv = helper.getView(R.id.label);
//            switch (item.getIsApply()) {
//                case 0:
//                    ltv.setVisibility(View.GONE);
//                    break;
//                case 1:
//                case 2:
//                    break;
//                case 3:
//                    ltv.setLabelBackgroundColor(getResources().getColor(R.color.color_lable_other));
//                    ltv.setLabelText("已驳回");
//                    break;
//            }

//            if(item.equals("1")){
//                LabelTextView ltv = helper.getView(R.id.label);
//                ltv.setLabelBackgroundColor(getResources().getColor(R.color.color_lable_other));
//                ltv.setLabelText("已驳回");
//            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
//            case R.id.img_menu://Menu弹出PopWindow
//                getPopupWindow();
//
//                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        OkHttpUtils.getInstance().cancelTag(this);
    }

    /**
     * 获取PopipWinsow实例
     */
//    private void getPopupWindow() {
//        if (null != popupWindowMenu) {
//            popupWindowMenu.dismiss();
//            popupWindowMenu = null;
//        } else {
//            initpopupWindow();
//            popupWindowMenu.showAsDropDown(toolbar, 0, 0);
//        }
//    }

    private int fromYDelta;
//    protected void initpopupWindow() {
//        //获得自定义布局
//        final View view_popup_menu = LayoutInflater.from(this).inflate(R.layout.view_popupwindow_menu, null);
//        //创建popupwindow实例
//        popupWindowMenu = new PopupWindow(view_popup_menu, ViewGroup.LayoutParams.MATCH_PARENT,getWindowManager().getDefaultDisplay().getHeight()*6/10 );
//        //设置动画效果
//        //获取popupwindow高度确定动画开始位置
//        int contentHeight= ViewUtils.getViewMeasuredHeight(view_popup_menu);
//        fromYDelta=-contentHeight-50;
//        popupWindowMenu.getContentView().startAnimation(AnimationUtil.createInAnimation(this, fromYDelta));
//
////        popupWindowMenu.setAnimationStyle(R.style.AnimationFade);
//        //点击其他地方消失
////        popupWindowMenu.setOutsideTouchable(true);
////        view_popup_menu.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                if (view_popup_menu != null && view_popup_menu.isShown()) {
////                    popupWindowMenu.dismiss();
////                    popupWindowMenu = null;
////                }
////                return false;
////            }
////        });
//        popupWindowMenu.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow_background));
////        popupWindowMenu.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
//        //这里来设置View的数据填充以及事件
//        RecyclerView recyclerView = (RecyclerView) view_popup_menu.findViewById(R.id.popup_recucler_menu);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//        recyclerView.setAdapter(menuadapter);
//
//        popupWindowMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            @Override
//            public void onDismiss() {
////                view.setVisibility(View.GONE);
//                popupWindowMenu.dismiss();
//                popupWindowMenu = null;
//            }
//        });
//    }
//
//
//
//    private class MentRecycleAdapter  extends BaseQuickAdapter<BaseMenuPlanEntity.PracticeplanlistEntity>{
//
//        public MentRecycleAdapter(List<BaseMenuPlanEntity.PracticeplanlistEntity> data) {
//            super(R.layout.item_text, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, BaseMenuPlanEntity.PracticeplanlistEntity item) {
//            helper.setText(R.id.item_title, item.getPracticeName());
//        }
//    }


    public static final int submitresultCode = 1000;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case submitresultCode:
//                Logger.e("/////////////////////////////////////////////////////////"+planId);
//                index = -10;
//                //如果planId为null或者为0时，则列表为全部的数据，所以加载全部数据的分页
//                if (planId.equals("")||planId.equals("0")) {
//                    getdata();
//                }else{
//                    filterData(planId);
//                }
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }

    }


}
