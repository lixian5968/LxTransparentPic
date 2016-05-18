package com.zhy.lxtransparentpic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by david on 15-11-27.
 */
public class SwipeContainerView extends FrameLayout {

    private View mChildView;


    public SwipeContainerView(Context context) {
        this(context, null);
    }

    public SwipeContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }



    public void hide(int number) {
        int width = getWidth();
        getChildView().offsetLeftAndRight(number);


    }


    private View getChildView() {
        if (mChildView == null) {
            mChildView = getChildAt(0);
        }
        return mChildView;
    }


}
