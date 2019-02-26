package com.wonderingwall.dialogflow.view.impl;

import android.widget.LinearLayout;

import com.wonderingwall.dialogflow.view.base.BaseViewBuilder;
import com.wonderingwall.dialogflow.view.base.BasicBuilder;
import com.wonderingwall.dialogflow.view.base.BasicLayoutParamsProvider;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/22
 *
 * @param <LPB> builder who one of implements from BaseViewBuilder
 */
public class LinearLayoutParamsBuilder<LPB extends BasicLayoutParamsProvider> extends MarginLayoutParamsBuilder<LPB, LinearLayout.LayoutParams> {

    public LinearLayoutParamsBuilder(LPB LPB, Class<LinearLayout.LayoutParams> clazz) {
        super(LPB, clazz);
    }

    public LinearLayoutParamsBuilder<LPB> setLayoutDirection(int layoutDirection) {
        getLayoutParams().setLayoutDirection(layoutDirection);
        return this;
    }
}
