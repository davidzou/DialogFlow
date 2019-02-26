package com.wonderingwall.dialogflow.view.impl;

import android.widget.FrameLayout;

import com.wonderingwall.dialogflow.view.base.BaseViewBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/22
 */
public class FrameLayoutParamsBuilder<T extends BaseViewBuilder> extends MarginLayoutParamsBuilder<T, FrameLayout.LayoutParams> {

    public FrameLayoutParamsBuilder(T t, Class<FrameLayout.LayoutParams> clazz) {
        super(t, clazz);
    }
}
