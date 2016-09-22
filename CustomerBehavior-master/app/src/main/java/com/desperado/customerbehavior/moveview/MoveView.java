package com.desperado.customerbehavior.moveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

/*
 *
 *
 * 版 权 :@Copyright 北京******科技有限公司版权所有
 *
 * 作 者 :desperado
 *
 * 版 本 :1.0
 *
 * 创建日期 :2016/9/22  10:01
 *
 * 描 述 :可以自由移动的
 *
 * 修订日期 :
 */

public class MoveView extends View {
    private int mLastX;
    private int mLasty;
    private DisplayMetrics mDisplayMetrics;
    private int mWidthPixels;
    private int mHeightPixels;
    private Paint paint;        //定义画笔
    private float cx = 50;      //圆点默认X坐标
    private float cy = 50;      //圆点默认Y坐标
    private int radius = 20;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public MoveView(Context context) {
        super(context);
    }

    private void initPaint() {
        paint = new Paint();
        //设置消除锯齿
        paint.setAntiAlias(true);
        //设置画笔颜色
        paint.setColor(getResources().getColor(android.support.design.R.color.material_blue_grey_800));
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(cx, cy, radius, paint);
    }

    public MoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Point p = new Point();
        wm.getDefaultDisplay().getSize(p);
        mWidthPixels = p.x;
        mHeightPixels = p.y;
//        initPaint();
    }

    public MoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {

                break;
            }

            case MotionEvent.ACTION_MOVE: {
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                int offsetX = x - mLastX;
                int offsetY = y - mLasty;
//                ViewCompat.offsetTopAndBottom(this,offsetY);
//                ViewCompat.offsetLeftAndRight(this,offsetX);
//                layoutParams.leftMargin += offsetX;
//                layoutParams.topMargin += offsetY;
//                setLayoutParams(layoutParams);
//                requestLayout();
                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
                break;
            }

            case MotionEvent.ACTION_UP: {

                break;
            }

        }

        mLastX = x;
        mLasty = y;
        return true;
    }
}
