package com.wonderingwall.dialogflow.view.impl;

import android.view.ViewGroup;

import com.wonderingwall.dialogflow.view.base.BasicLayoutParamsProvider;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/22
 *
 * @param <LPB> builder who one of implements from BasicLayoutParamsProvider
 */
public class MarginLayoutParamsBuilder<LPB extends BasicLayoutParamsProvider, LP extends ViewGroup.MarginLayoutParams> extends LayoutParamsBuilder<LPB, LP> {

    public MarginLayoutParamsBuilder(LPB LPB, Class<LP> clazz) {
        super(LPB, clazz);
    }

    public LayoutParamsBuilder<LPB, LP> setMargin(int left, int top, int right, int bottom) {
        getLayoutParams().setMargins(left, top, right, bottom);
        return this;
    }

    public LayoutParamsBuilder<LPB, LP> setLayoutDirection(int layoutDirection) {
        getLayoutParams().setLayoutDirection(layoutDirection);
        return this;
    }

    @Override
    public LPB create() {
        return super.create();
    }
}
