package com.wonderingwall.dialogflow.view.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.impl.LayoutParamsBuilder;

/**
 * 首先创建显示的View。构建主布局
 *
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/1/29
 */
public class LayoutBuilder extends BasicLayoutParamsProvider<LayoutBuilder, LayoutBuilder> implements BasicBuilder<DialogFlow.ContentBuilder> {
    /**
     * @see Context
     */
    private Context context;

    /**
     * Root layout
     */
    private ViewGroup root;

    /**
     * Padding
     */
    private int paddingLeft, paddingRight, paddingTop, paddingBottom;

    /**
     * Margin
     */
    private int marginLeft, marginRight, marginTop, marginBottom;


    public LayoutBuilder(Context context) {
        this.context = context;
    }

    /**
     * 创建默认布局<br>
     * @return  {@link DialogFlow.ContentBuilder}
     */
    public DialogFlow.ContentBuilder createLayout() {
        root = new LinearLayout(context);
        ((LinearLayout) root).setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        root.setLayoutParams(layoutParams);
        root.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        return new DialogFlow.ContentBuilder(root);
    }

//    public LayoutBuilder setLayoutParams(ViewGroup.LayoutParams params) {
//        this.params = params;
//        return LayoutBuilder.this;
//    }

    public DialogFlow.ContentBuilder customLayout() {
        root = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
        root.setLayoutParams(layoutParams);
        root.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        return new DialogFlow.ContentBuilder(root);
    }
//
    public LayoutBuilder customLayout(ViewGroup layout) {
        this.root = layout;
        return this;
    }

    public <T extends BaseViewBuilder, LP extends ViewGroup.LayoutParams> LayoutParamsBuilder<T, LP> createcLayout() {
        return null;
    }

    public LayoutBuilder setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setPadding(int left, int top, int right, int bottom) {
        this.paddingLeft = left;
        this.paddingTop = top;
        this.paddingRight = right;
        this.paddingBottom = bottom;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return LayoutBuilder.this;
    }

    public LayoutBuilder setMargin(int left, int top, int right, int bottom) {
        this.marginLeft = left;
        this.marginTop = top;
        this.marginRight = right;
        this.marginBottom = bottom;
        return LayoutBuilder.this;
    }

    @Override
    public DialogFlow.ContentBuilder create() {
        root.setLayoutParams(getLayoutParams());
        return new DialogFlow.ContentBuilder(root);
    }

}
