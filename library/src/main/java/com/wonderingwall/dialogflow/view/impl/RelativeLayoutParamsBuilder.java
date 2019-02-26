package com.wonderingwall.dialogflow.view.impl;

import android.support.annotation.IdRes;
import android.widget.RelativeLayout;

import com.wonderingwall.dialogflow.view.base.BasicLayoutParamsProvider;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/22
 */
public class RelativeLayoutParamsBuilder<LPB extends BasicLayoutParamsProvider> extends MarginLayoutParamsBuilder<LPB, RelativeLayout.LayoutParams> {

    public RelativeLayoutParamsBuilder(LPB LPB, Class<RelativeLayout.LayoutParams> clazz) {
        super(LPB, clazz);
    }

    public RelativeLayoutParamsBuilder<LPB> setLayoutDirection(int layoutDirection) {
        getLayoutParams().setLayoutDirection(layoutDirection);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> addRule(int verb) {
        getLayoutParams().addRule(verb);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> addRule(int verb, int subject) {
        getLayoutParams().addRule(verb, subject);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> above(@IdRes int subject) {
        getLayoutParams().addRule(RelativeLayout.ABOVE, subject);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> below(@IdRes int subject) {
        getLayoutParams().addRule(RelativeLayout.BELOW, subject);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> leftOf(@IdRes int subject) {
        getLayoutParams().addRule(RelativeLayout.LEFT_OF, subject);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> rightOf(@IdRes int subject) {
        getLayoutParams().addRule(RelativeLayout.RIGHT_OF, subject);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignLeft() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_LEFT);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignTop() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_TOP);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignRight() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_RIGHT);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignBottom() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_BOTTOM);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignParentLeft() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignParentTop() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_PARENT_TOP);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignParentRight() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> alignParentBottom() {
        getLayoutParams().addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> centerInParent() {
        getLayoutParams().addRule(RelativeLayout.CENTER_IN_PARENT);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> centerHorizontal() {
        getLayoutParams().addRule(RelativeLayout.CENTER_HORIZONTAL);
        return this;
    }

    public RelativeLayoutParamsBuilder<LPB> centerVertical() {
        getLayoutParams().addRule(RelativeLayout.CENTER_VERTICAL);
        return this;
    }
}
