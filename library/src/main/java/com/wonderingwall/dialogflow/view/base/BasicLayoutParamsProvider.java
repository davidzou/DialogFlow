package com.wonderingwall.dialogflow.view.base;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wonderingwall.dialogflow.view.impl.LinearLayoutParamsBuilder;
import com.wonderingwall.dialogflow.view.impl.RelativeLayoutParamsBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/25
 *
 * @param <B> builder who one of implements from BaseViewBuilder.
 */
public class BasicLayoutParamsProvider<B extends BasicBuilder, LPB extends BasicLayoutParamsProvider> {

    private ViewGroup.LayoutParams layoutParams;

    public ViewGroup.LayoutParams getLayoutParams() {
        return layoutParams;
    }

    public <LP extends ViewGroup.LayoutParams> B setLayoutParams(LP layoutParams) {
        this.layoutParams = layoutParams;
        return (B) this;
    }

//    protected  <LP extends ViewGroup.LayoutParams> B setLayoutParams(LayoutParamsBuilder<LPB, LP> builder) {
//        this.layoutParams = builder.getLayoutParams();
//        return (B) this;
//    }

    public LPB createLinearLayoutParams() {
        return customLinearLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT).create();
    }

    public LPB createRelativeLayoutParams() {
        return customRelativeLayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT).create();
    }


    public LinearLayoutParamsBuilder<LPB> customLinearLayoutParams() {
        return customLinearLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    public LinearLayoutParamsBuilder<LPB> customLinearLayoutParams(int width, int height) {
        LinearLayoutParamsBuilder builder = new LinearLayoutParamsBuilder<>(this, LinearLayout.LayoutParams.class);
        builder.setWidth(width);
        builder.setHeight(height);
        return builder;
    }

    public RelativeLayoutParamsBuilder<LPB> customRelativeLayoutParams() {
        return customRelativeLayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
    }

    public RelativeLayoutParamsBuilder<LPB> customRelativeLayoutParams(int width, int height) {
        RelativeLayoutParamsBuilder builder = new RelativeLayoutParamsBuilder<>(this, RelativeLayout.LayoutParams.class);
        builder.setWidth(width);
        builder.setHeight(height);
        return builder;
    }

}
