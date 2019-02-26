package com.wonderingwall.dialogflow.view.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.wonderingwall.dialogflow.DialogFlow;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/21
 *
 * @param <B> builder who one of implements from BaseViewBuilder, implements self.
 * @param <V> view who be created it from builder.
 */
public abstract class BaseViewBuilder<B extends BaseViewBuilder, V extends View> extends BasicLayoutParamsProvider<B, B> implements BasicBuilder<DialogFlow.ContentBuilder> {
    private DialogFlow.ContentBuilder contentBuilder;
    private Context context;

    public BaseViewBuilder(Context context, DialogFlow.ContentBuilder contentBuilder){
        this.context = context;
        this.contentBuilder = contentBuilder;

        setLayoutParams(new LinearLayout.MarginLayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    /**
     * view who to build it.
     * @return {@link V}
     */
    protected abstract V getView();

    /**
     * Sets the identifier for this view. The identifier does not have to be
     * unique in this view's hierarchy. The identifier should be a positive
     * number.
     *
     * @see View#NO_ID
     * @see View#getId()
     * @see View#findViewById(int)
     *
     * @param id a number used to identify the view
     * @return B
     */
    public B setId(@IdRes int id) {
        getView().setId(id);
        return (B) this;
    }

    public B setTag(Object tag) {
        getView().setTag(tag);
        return (B) this;
    }

    public B setTag(int key, Object tag) {
        getView().setTag(key, tag);
        return (B) this;
    }

    /**
     * Set the text direction.
     *
     * @param textDirection the direction to set. Should be one of:
     *
     * {@link View#TEXT_DIRECTION_INHERIT},
     * {@link View#TEXT_DIRECTION_FIRST_STRONG},
     * {@link View#TEXT_DIRECTION_ANY_RTL},
     * {@link View#TEXT_DIRECTION_LTR},
     * {@link View#TEXT_DIRECTION_RTL},
     * {@link View#TEXT_DIRECTION_LOCALE}
     * {@link View#TEXT_DIRECTION_FIRST_STRONG_LTR},
     * {@link View#TEXT_DIRECTION_FIRST_STRONG_RTL},
     *
     * Resolution will be done if the value is set to TEXT_DIRECTION_INHERIT. The resolution
     * proceeds up the parent chain of the view to get the value. If there is no parent, then it will
     * return the default {@link View#TEXT_DIRECTION_FIRST_STRONG}.
     *
     * @return B
     */
    public B setTextDirection(int textDirection) {
        getView().setTextDirection(textDirection);
        return (B) this;
    }

    /**
     * Set the text alignment.
     *
     * @param textAlignment The text alignment to set. Should be one of
     *
     * {@link View#TEXT_ALIGNMENT_INHERIT},
     * {@link View#TEXT_ALIGNMENT_GRAVITY},
     * {@link View#TEXT_ALIGNMENT_CENTER},
     * {@link View#TEXT_ALIGNMENT_TEXT_START},
     * {@link View#TEXT_ALIGNMENT_TEXT_END},
     * {@link View#TEXT_ALIGNMENT_VIEW_START},
     * {@link View#TEXT_ALIGNMENT_VIEW_END}
     *
     * Resolution will be done if the value is set to TEXT_ALIGNMENT_INHERIT. The resolution
     * proceeds up the parent chain of the view to get the value. If there is no parent, then it
     * will return the default {@link View#TEXT_ALIGNMENT_GRAVITY}.
     *
     * @return B
     */
    public B setTextAlignment(int textAlignment) {
        getView().setTextAlignment(textAlignment);
        return (B) this;
    }

    /**
     * Sets the background color for this view.
     * @param color the color of the background
     * @return B
     */
    public B setBackgroundColor(@ColorInt int color) {
        getView().setBackgroundColor(color);
        return (B) this;
    }

    public B setBackground(Drawable background) {
        getView().setBackground(background);
        return (B) this;
    }

    public B setBackgroundResource(@DrawableRes int resId) {
        getView().setBackgroundResource(resId);
        return (B) this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public B setBackgroundTintList(@NonNull ColorStateList tint) {
        getView().setBackgroundTintList(tint);
        return (B) this;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public B setBackgroundTintMode(@NonNull PorterDuff.Mode mode) {
        getView().setBackgroundTintMode(mode);
        return (B) this;
    }

    /**
     * @param visibility One of {@link View#VISIBLE}, {@link View#INVISIBLE}, or {@link View#GONE}.
     * @return  B
     */
    public B setVisibility(int visibility) {
        getView().setVisibility(visibility);
        return (B) this;
    }

    /**
     * Sets the padding. The view may add on the space required to display
     * the scrollbars, depending on the style and visibility of the scrollbars.
     * So the values returned from {@link View#getPaddingLeft}, {@link View#getPaddingTop},
     * {@link View#getPaddingRight} and {@link View#getPaddingBottom} may be different
     * from the values set in this call.
     *
     * @param left the left padding in pixels
     * @param top the top padding in pixels
     * @param right the right padding in pixels
     * @param bottom the bottom padding in pixels
     * @return B
     */
    public B setPadding(int left, int top, int right, int bottom) {
        getView().setPadding(left, top, right, bottom);
        return (B) this;
    }

//    /**
//     * Sets the margins, in pixels. A call to {@link android.view.View#requestLayout()} needs
//     * to be done so that the new margins are taken into account. Left and right margins may be
//     * overriden by {@link android.view.View#requestLayout()} depending on layout direction.
//     * Margin values should be positive.
//     *
//     * @param left the left margin size
//     * @param top the top margin size
//     * @param right the right margin size
//     * @param bottom the bottom margin size
//     *
//     * @return B
//     */
//    public B setMargin(int left, int top, int right, int bottom) {
//        getLayoutParams().setMargins(left, top, right, bottom);
//        return (B) this;
//    }

    public B setMinimumHeight(int minHeight) {
        getView().setMinimumHeight(minHeight);
        return (B) this;
    }

    public B setMinimumWidth(int minWidth) {
        getView().setMinimumWidth(minWidth);
        return (B) this;
    }

    public B setAnimation(Animation animation) {
        getView().setAnimation(animation);
        return (B) this;
    }

    public B setOnClickListener(View.OnClickListener clickListener) {
        getView().setOnClickListener(clickListener);
        return (B) this;
    }

    protected DialogFlow.ContentBuilder getContentBuilder() {
        return contentBuilder;
    }

    protected Context getContext() {
        return context;
    }

    /**
     * End custom build with add to layout for show.
     * @return {@link DialogFlow.ContentBuilder}
     */
    @Override
    public DialogFlow.ContentBuilder create(){
        getView().setLayoutParams(getLayoutParams());
        getContentBuilder().getLayout().addView(getView());
        return getContentBuilder();
    }
}
