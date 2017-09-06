package com.example.win.newintern3.Widgets.FastList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.win.newintern3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class SideBar extends View {

    public static String[] INDEX_STRING = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private List<String> indexStrings;
    private int choose = -1;
    private Paint paint = new Paint();
    private TextView mTextDialog;
    private boolean showBg = false;

    private int outcharHeight = 0;

    private int touchstart = 0;

    public SideBar(Context context) {
        this(context, null);
    }

    public SideBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SideBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
//        setBackgroundColor(Color.WHITE);
        indexStrings = Arrays.asList(INDEX_STRING);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBg) {
            canvas.drawColor(Color.TRANSPARENT);
        }

        int height = getHeight();
        int width = getWidth();
        int singleHeight = height / 26;
        outcharHeight = (26 - indexStrings.size()) / 2 * singleHeight;

        for (int i = 0; i < indexStrings.size(); i++) {
//            paint.setColor(Color.parseColor("#00BFFF"));
//            paint.setTypeface(Typeface.DEFAULT_BOLD);

            paint.setTextSize(getResources().getDimension(R.dimen.side_letter_bar_letter_size));
            paint.setColor(getResources().getColor(R.color.gray8));
            paint.setAntiAlias(true);
            if (i == choose) {
                paint.setColor(getResources().getColor(R.color.colorPrimary));
//                paint.setFakeBoldText(true);
            }

            float xPos = width / 2 - paint.measureText(indexStrings.get(i)) / 2;
            float yPos = singleHeight * i + singleHeight + outcharHeight;
            canvas.drawText(indexStrings.get(i), xPos, yPos, paint);
            paint.reset();
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        final int action = event.getAction();
        final float y = event.getY();
        final int oldChoose = choose;
        final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
        final int c = (int) (y / getHeight() * 26);
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                showBg = true;
                if (oldChoose != c && listener != null) {
                    if (c >= touchstart && c < touchstart + indexStrings.size()) {
                        listener.onTouchingLetterChanged(indexStrings.get(c - touchstart));
                        choose = c - touchstart;
                        invalidate();
                        if (mTextDialog != null) {
                            mTextDialog.setVisibility(VISIBLE);
                            mTextDialog.setText(indexStrings.get(c - touchstart));
                        }
                    }
                }

                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null) {
                    if (c >= touchstart && c < touchstart + indexStrings.size()) {
                        listener.onTouchingLetterChanged(indexStrings.get(c - touchstart));
                        choose = c - touchstart;
                        invalidate();
                        if (mTextDialog != null) {
                            mTextDialog.setVisibility(VISIBLE);
                            mTextDialog.setText(indexStrings.get(c - touchstart));
                        }
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                showBg = false;
                choose = -1;
                invalidate();
                if (mTextDialog != null) {
                    mTextDialog.setVisibility(View.GONE);
                }
                break;
//            default:
//                if (oldChoose != c) {
//                    if (c >= 0 && c < indexStrings.size()) {
//                        if (listener != null) {
//                            listener.onTouchingLetterChanged(indexStrings.get(c));
//                        }
//                        if (mTextDialog != null) {
//                            mTextDialog.setText(indexStrings.get(c));
//                            mTextDialog.setVisibility(View.VISIBLE);
//                        }
//
//                        choose = c;
//                        invalidate();
//                    }
//                }
//
//                break;
        }
        return true;
    }

    public void setIndexText(ArrayList<String> indexStrings) {
        this.indexStrings = indexStrings;
        touchstart = (int) Math.abs(this.indexStrings.size() - 26) / 2;
        invalidate();
    }


    public void setTextView(TextView mTextDialog) {
        this.mTextDialog = mTextDialog;
    }

    public void setOnTouchingLetterChangedListener(
            OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener {
        void onTouchingLetterChanged(String s);
    }

}