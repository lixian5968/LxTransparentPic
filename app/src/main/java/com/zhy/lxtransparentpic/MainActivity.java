package com.zhy.lxtransparentpic;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setBackgroundDrawable(null);
        setContentView(R.layout.activity_main);


        mImageView = (ImageView) findViewById(R.id.mImageView);
        mEditText = (EditText) findViewById(R.id.mEditText);

    }

    public void hide(View v) {
        try {
            if (containerView != null) {
                int number = Integer.parseInt(mEditText.getText().toString().trim());
                containerView.hide(number);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
//        // 允许当前窗口保存缓存信息
//        containerView.setDrawingCacheEnabled(true);
//        // 去掉状态栏
//        Bitmap bmp = Bitmap.createBitmap(containerView.getDrawingCache(), 0, 0, containerView.getWidth(), containerView.getHeight());
//// 销毁缓存信息
//        containerView.destroyDrawingCache();
//        mImageView.setImageBitmap(bmp);

    }

    SwipeContainerView containerView;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        View childView = decorView.getChildAt(0);
        TypedArray a = getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.windowBackground
        });
        int background = a.getResourceId(0, 0);
        a.recycle();
        childView.setBackgroundResource(background);
        decorView.removeView(childView);
        containerView = new SwipeContainerView(this);
        containerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        containerView.addView(childView);
        decorView.addView(containerView);


    }


}
