package com.desperado.customerbehavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
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
 * 创建日期 :2016/9/21  16:17
 *
 * 描 述 :自定义简单的behavior
 *
 * 修订日期 :
 */

public class SimpleBehavior extends CoordinatorLayout.Behavior<View> {
    /**此构造函数必须要重写，否则就会报错*/
    public SimpleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**某个view监听另一个view的状态变化，例如大小、位置、显示状态 重要的就会调用下面的两个方法 layoutDependsOn 和onDependentViewChanaged**/
    /***
     * @param child      哪个控件设置当前的behavior
     * @param dependency 我们需要关心的view
     *                   layoutDependsOn指定了我们需要关心的是哪个view
     *                   这里指定了我们需要观察的view是TextView
     **/
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    /***
     * 这个函数就是当我们关心的view发生改变的时候就回调这个函数
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int offset = dependency.getTop() - child.getTop();
        Log.e("offset", offset + "");
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}
