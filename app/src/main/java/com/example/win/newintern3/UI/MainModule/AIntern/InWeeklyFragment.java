package com.example.win.newintern3.UI.MainModule.AIntern;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.win.newintern3.R;


/***
 * 周报_每天
 */

public class InWeeklyFragment extends Fragment implements TextWatcher, View.OnTouchListener {
    private static final String ARG_PARAM1 = "type";
    private static final String ARG_PARAM2 = "text";
    private static final String ARG_PARAM3 = "textfocusable";

    private int mParam1;
    private String mParam2;
    private boolean mParam3;

    private static OnFragmentInteractionListener mListener;

    private EditText text;

    public InWeeklyFragment() {
    }

    /**
     * @param param1    这个参数是个标识，回调的时候根据此标识判断相应的操作
     * @param param2    写入文本框的数据
     * @param param3    文本框是否可编辑 true为不可编辑
     * @param mListener 文本输入数据监听
     * @return
     */
    public static InWeeklyFragment newInstance(int param1, String param2,boolean param3, OnFragmentInteractionListener mListener) {
        InWeeklyFragment fragment = new InWeeklyFragment();

        InWeeklyFragment.mListener = mListener;

        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putBoolean(ARG_PARAM3,param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getBoolean(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_weekly, container, false);
        text = (EditText) view.findViewById(R.id.edt_fiw_work);
        if (mParam3) {
            text.setFocusable(false);
        }
        if (null != mParam2) {
            text.setText(mParam2);
        }
        text.addTextChangedListener(this);
        text.setOnTouchListener(this);
        return view;
    }

    public void onButtonPressed(String s) {
        if (mListener != null) {
            mListener.onFragmentInteraction(mParam1, s);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    public void OnTouch() {
//        text.getParent().requestDisallowInterceptTouchEvent(false);
//    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        onButtonPressed(editable.toString());
    }

    private int lastX;
    private int lastY;

    //解决滑动事件冲突，参考http://www.jianshu.com/p/8bc0765dffc9
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        int x = (int) motionEvent.getRawX();//获得事件位置
        int y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;//记录按下的位置
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaY = y - lastY;
                int deltaX = x - lastX;
                if (Math.abs(deltaX) <0) {//只要是滑动就拦截,同时也会拦截掉viewpager左右滑动的事件
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }

//                if (Math.abs(deltaX) < Math.abs(deltaY)) {
//                    view.getParent().requestDisallowInterceptTouchEvent(false);
//                }else {
//
////                    carouselView.getParent().requestDisallowInterceptTouchEvent(true);
//                }

            case MotionEvent.ACTION_UP:
                view.getParent().requestDisallowInterceptTouchEvent(true);
                break;
            default:
                break;
        }
        return false;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int type, String s);
    }

}
