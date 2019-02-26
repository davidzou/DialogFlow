package com.wonderingwall.dialogflow.view.impl;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wonderingwall.dialogflow.view.base.BasicLayoutParamsProvider;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/22
 *
 * @param <LPB> builder who one of implements from BasicLayoutParamsProvider
 * @param <LP> LayoutParams who one of implements
 */
public abstract class LayoutParamsBuilder<LPB extends BasicLayoutParamsProvider, LP extends ViewGroup.LayoutParams> {

    /***/
    private LPB LPB;

    private ViewGroup.LayoutParams layoutParams;

    public LayoutParamsBuilder(LPB LPB, Class<LP> clazz) {
        this.LPB = LPB;

        if (LinearLayout.LayoutParams.class.getName().equals(clazz.getName())) {
            layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        } else if (RelativeLayout.LayoutParams.class.getName().equals(clazz.getName())) {
            layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        } else if (FrameLayout.LayoutParams.class.getName().equals(clazz.getName())) {
            layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        } else {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    LP getLayoutParams() {
        return (LP) layoutParams;
    }


    public LayoutParamsBuilder<LPB, LP> setWidth(int width) {
        layoutParams.width = width;
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> setHeight(int height) {
        layoutParams.height = height;
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> matchWidth() {
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> wrapWidth() {
        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> matchHeight() {
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> wrapHeight() {
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return this;
    }

    public LPB create() {
        LPB.setLayoutParams(layoutParams);
        return LPB;
    }
}
