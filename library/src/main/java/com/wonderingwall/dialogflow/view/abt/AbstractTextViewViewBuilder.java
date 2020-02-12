package com.wonderingwall.dialogflow.view.abt;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.base.BaseViewBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/21
 *
 * @param <B> Builder one of implements. implements self.
 * @param <V> TextView one of implements.
 */
public abstract class AbstractTextViewViewBuilder<B extends BaseViewBuilder, V extends TextView> extends BaseViewBuilder<B, V> {

    public AbstractTextViewViewBuilder(Context context, DialogFlow.ContentBuilder contentBuilder) {
        super(context, contentBuilder);
    }

    public B setText(@StringRes int resId) {
        getView().setText(resId);
        return (B) this;
    }

    public B setText(String text) {
        getView().setText(text);
        return (B) this;
    }

    public B setText(int resId, TextView.BufferType type) {
        getView().setText(resId, type);
        return (B) this;
    }

    public B setText(String text, TextView.BufferType type) {
        getView().setText(text, type);
        return (B) this;
    }

    public B setText(char[] text, int start, int len) {
        getView().setText(text, start, len);
        return (B) this;
    }

    public B setTextColor(int color) {
        getView().setTextColor(color);
        return (B) this;
    }

    public B setTextColor(ColorStateList colors) {
        getView().setTextColor(colors);
        return (B) this;
    }

    public B setTextSize(float size) {
        getView().setTextSize(size);
        return (B) this;
    }

    public B setTextSize(int unit, float size) {
        getView().setTextSize(unit, size);
        return (B) this;
    }

    public B setHint(@StringRes int hint) {
        getView().setHint(hint);
        return (B) this;
    }

    public B setHint(String hint) {
        getView().setHint(hint);
        return (B) this;
    }

    public B setHintTextColor(@ColorInt int color) {
        getView().setHintTextColor(color);
        return (B) this;
    }

    public B setHintTextColor(ColorStateList colors) {
        getView().setHintTextColor(colors);
        return (B) this;
    }

    public B setHeight(int pixels) {
        getView().setHeight(pixels);
        return (B) this;
    }

    public B setWidth(int pixels) {
        getView().setWidth(pixels);
        return (B) this;
    }

    public B setMaxHeight(int maxPixels) {
        getView().setMaxHeight(maxPixels);
        return (B) this;
    }

    public B setMaxWidth(int maxPixels) {
        getView().setMaxWidth(maxPixels);
        return (B) this;
    }

    public B setMaxLines(int maxLines) {
        getView().setMaxLines(maxLines);
        return (B) this;
    }

    public B setEms(int ems) {
        getView().setEms(ems);
        return (B) this;
    }

    public B setMaxEms(int maxEms) {
        getView().setMaxEms(maxEms);
        return (B) this;
    }

    public B setInpuType(int type) {
        getView().setInputType(type);
        return (B) this;
    }

    public B setError(String error) {
        getView().setError(error);
        return (B) this;
    }

    public B setError(String error, Drawable icon) {
        getView().setError(error, icon);
        return (B) this;
    }

    public B setTransformationMethod(TransformationMethod method) {
        getView().setTransformationMethod(method);
        return (B) this;
    }

    public B passwordTransformationMethod() {
        getView().setTransformationMethod(PasswordTransformationMethod.getInstance());
        return (B) this;
    }

}
