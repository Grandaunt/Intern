package com.example.win.newintern3.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.win.newintern3.R;

import java.lang.reflect.Field;


/**
 * 只允许选择年月
 * Created by TAO_SX on 2016/7/13/013.
 */
public class YMDatePickerDialog extends AlertDialog implements DialogInterface.OnClickListener, DatePicker.OnDateChangedListener {
    private static final String START_YEAR = "start_year";
    private static final String START_MONTH = "start_month";
    private static final String START_DAY = "start_day";

    private final DatePicker mDatePickerStart;
    private final OnDateSetListener mCallBack;


    public interface OnDateSetListener {
        void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear, int startDayOfMonth);
    }

    //showmd = 1;//1为显示年,0为只显示年月
    public YMDatePickerDialog(Context context, int showmd, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        this(context,0, showmd, callBack, year, monthOfYear, dayOfMonth,0,0);
    }

    public YMDatePickerDialog(Context context, int showmd, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth, Long min, Long max) {
        this(context,0, showmd, callBack, year, monthOfYear, dayOfMonth,min,max);
    }

    public YMDatePickerDialog(Context context, int theme,
                              int showmd, OnDateSetListener callBack,
                              int year, int monthOfYear,
                              int dayOfMonth, long min,
                              long max) {
        super(context, theme);

        mCallBack = callBack;

        Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, "确 定", this);
        setButton(BUTTON_NEGATIVE, "取 消", this);
        setIcon(0);

        LayoutInflater inflater = (LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate( R.layout.dialog_date_picker, null);
        setView(view);
        mDatePickerStart = (DatePicker) view.findViewById(R.id.datePickerStart);
        if (min > 0) {
            mDatePickerStart.setMinDate(min);
        }
        if (max > 0) {
            mDatePickerStart.setMaxDate(max);
        }
        mDatePickerStart.init(year, monthOfYear, dayOfMonth, this);
        switch (showmd) {
            case 1:
                hideMonth(mDatePickerStart);
            case 0:
                hideDay(mDatePickerStart);
                break;
            default:
                break;
        }


    }


    private void hideDay(DatePicker mDatePicker) {
        try {
            /* 处理android5.0以上的特殊情况 */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
                if (daySpinnerId != 0) {
                    View daySpinner = mDatePicker.findViewById(daySpinnerId);
                    if (daySpinner != null) {
                        daySpinner.setVisibility(View.GONE);
                    }
                }
            } else {
                Field[] datePickerfFields = mDatePicker.getClass().getDeclaredFields();
                for (Field datePickerField : datePickerfFields) {
                    if ("mDaySpinner".equals(datePickerField.getName()) || ("mDayPicker").equals(datePickerField.getName())) {
                        datePickerField.setAccessible(true);
                        Object dayPicker = new Object();
                        try {
                            dayPicker = datePickerField.get(mDatePicker);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        ((View) dayPicker).setVisibility(View.GONE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void hideMonth(DatePicker mDatePicker) {
        try {
            /* 处理android5.0以上的特殊情况 */
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int monthSpinnerId = Resources.getSystem().getIdentifier("month", "id", "android");
                if (monthSpinnerId != 0) {
                    View monthSpinner = mDatePicker.findViewById(monthSpinnerId);
                    if (monthSpinner != null) {
                        monthSpinner.setVisibility(View.GONE);
                    }
                }
            } else {
                Field[] datePickerfFields = mDatePicker.getClass().getDeclaredFields();
                for (Field datePickerField : datePickerfFields) {
                    if ("mMonthSpinner".equals(datePickerField.getName()) || ("mMonthPicker").equals(datePickerField.getName())) {
                        datePickerField.setAccessible(true);
                        Object monthPicker = new Object();
                        try {
                            monthPicker = datePickerField.get(mDatePicker);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        }
                        ((View) monthPicker).setVisibility(View.GONE);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void onClick(DialogInterface dialog, int which) {
        if (which == BUTTON_POSITIVE)
            tryNotifyDateSet();
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int month, int day) {
        if (view.getId() == R.id.datePickerStart)
            mDatePickerStart.init(year, month, day, this);
    }

    public DatePicker getDatePickerStart() {
        return mDatePickerStart;
    }


    public void updateStartDate(int year, int monthOfYear, int dayOfMonth) {
        mDatePickerStart.updateDate(year, monthOfYear, dayOfMonth);
    }


    private void tryNotifyDateSet() {
        if (mCallBack != null) {
            mDatePickerStart.clearFocus();
            mCallBack.onDateSet(mDatePickerStart, mDatePickerStart.getYear(), mDatePickerStart.getMonth(),
                    mDatePickerStart.getDayOfMonth());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(START_YEAR, mDatePickerStart.getYear());
        state.putInt(START_MONTH, mDatePickerStart.getMonth());
        state.putInt(START_DAY, mDatePickerStart.getDayOfMonth());
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int start_year = savedInstanceState.getInt(START_YEAR);
        int start_month = savedInstanceState.getInt(START_MONTH);
        int start_day = savedInstanceState.getInt(START_DAY);
        mDatePickerStart.init(start_year, start_month, start_day, this);

    }
}
