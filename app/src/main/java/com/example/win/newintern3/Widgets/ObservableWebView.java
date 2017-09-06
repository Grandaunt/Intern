package com.example.win.newintern3.Widgets;

/**
 * Created by TAO_SX on 2016/2/2/002.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;


/**
 * Created by Taosx on 15/7/16.
 */
public class ObservableWebView extends WebView {
    public interface OnScrollChangedListener {
        void onScrollChanged(ObservableWebView who, int l, int t, int oldl, int oldt);
    }
    private OnScrollChangedListener mOnScrollChangedListener;

    public ObservableWebView(final Context context) {
        super(context);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs,
                             final int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }
}