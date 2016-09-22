package com.desperado.customerbehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

/*
 *
 *
 * 版 权 :@Copyright 北京******科技有限公司版权所有
 *
 * 作 者 :desperado
 *
 * 版 本 :1.0
 *
 * 创建日期 :2016/9/22  14:20
 *
 * 描 述 :自定义的behavior样式
 *
 * 修订日期 :
 */

public class OtherBehavior extends CoordinatorLayout.Behavior<TextView> {
    private int width;
    private int height;
    private int mLastX;
    private int mLastY;

    public OtherBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
        height = display.heightPixels;
    }

    /***
     * 指定需要依赖的控件
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency.getId() == R.id.mv_other_target;
    }

    /**
     * 当依赖的控件的布局发生变化时就会调用该方法
     **/
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        int top = dependency.getTop();
        int left = dependency.getLeft();
        int offsetX = mLastX -left;
        int offsetY =mLastY-top;
        setPosition(child, offsetX, offsetY);
        mLastX = left;
        mLastY = top;
        return true;
    }

    private void setPosition(View v, int x, int y) {
        ViewCompat.offsetLeftAndRight(v, x);
        ViewCompat.offsetTopAndBottom(v, y);
    }
}
