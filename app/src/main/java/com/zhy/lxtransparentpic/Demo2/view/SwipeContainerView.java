package com.zhy.lxtransparentpic.Demo2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by david on 15-11-27.
 */
public class SwipeContainerView extends FrameLayout {

    private View mChildView;

    private float mActionDownX;
    SwipeView mSwipeView;
    public SwipeContainerView(Context context) {
        this(context, null);
        mSwipeView = (SwipeView) context;
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

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    float oldDx;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mActionDownX = event.getX();
                oldDx = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getX() - mActionDownX;
                if(dx>0){
                    Log.e("lx", "dx:" + dx + ", event.getX():" + event.getX() + ",mActionDownX:" + mActionDownX + ",getChildView().getLeft():" + (getChildView().getLeft()));
                    getChildView().offsetLeftAndRight((int) (dx - oldDx));
                    oldDx = dx;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_UP:

                if(getChildView().getLeft()>(getWidth()/5)){
                    getChildView().offsetLeftAndRight((int) (getWidth() - getChildView().getLeft()));
                    mSwipeView.finishActivity();
                }



                break;
        }
        return true;
    }


    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean result = super.drawChild(canvas, child, drawingTime);
//        if (getChildView() != null && getChildView().getLeft() > 0) {
//            canvas.clipRect(0, 0, getChildView().getLeft(), getChildView().getHeight());
//            canvas.drawColor(Color.TRANSPARENT);
//        }
//        if (getChildView().getLeft() > 0 && getChildView().getLeft() >= getChildView().getWidth() + getChildView().getPaddingLeft() + getChildView().getPaddingBottom()) {
//            Context context = getContext();
//            if (context != null && context instanceof Activity) {
//                ((Activity) context).finish();
//            }
//        }
        return result;
    }

    private View getChildView() {
        if (mChildView == null) {
            mChildView = getChildAt(0);
        }
        return mChildView;
    }


}
