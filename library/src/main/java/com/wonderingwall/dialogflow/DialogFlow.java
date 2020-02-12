package com.wonderingwall.dialogflow;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

import com.wonderingwall.dialogflow.view.base.LayoutBuilder;
import com.wonderingwall.dialogflow.view.ButtonViewBuilder;
import com.wonderingwall.dialogflow.view.EditTextBuilder;
import com.wonderingwall.dialogflow.view.RadioButtonViewBuilder;
import com.wonderingwall.dialogflow.view.TextViewViewBuilder;
import com.wonderingwall.dialogflow.view.base.BasicBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <em>Dialog View</em>
 * <pre>
 *     +--------------------------------+
 *     |   Icon | Title                 |
 *     +--------------------------------+
 *     |   Message                      |
 *     +--------------------------------+
 *     |   Content View                 |
 *     |   (TextView, EditView ...)     |
 *     +----------------+-------+-------+
 *     |    1           |   2   |   3   |
 *     +----------------+-------+-------+
 *
 *     &#42; 1, NeutralButton
 *     &#42; 2, NegativeButton
 *     &#42; 3, PositiveButton
 * </pre>
 *
 * <p></p>
 * <em>Single</em>
 * <pre>
 *  DialogFlow.init(MainActivity.this)
 *              .setTitle("Tip")
 *              .createTextView("Hello Everyone!! This is a single Dialog.")
 *              .setPositiveButton("OK", null)
 *              .show();
 * </pre>
 *
 * <p></p>
 * <em>Custom</em>
 * <pre>
 *   DialogFlow
 *          .custom(MainActivity.this)
 *          .createRelativeLayoutParams()
 *              .customRelativeLayoutParams()
 *                  .alignParentRight()
 *                  .create()
 *              .create()
 *          .customTextView()
 *              .createRelativeLayoutParams()
 *              .setId(R.id.edit_password)
 *              .setText("Above")
 *              .setBackgroundColor(Color.GRAY)
 *              .create()
 *          .customTextView()
 *              .customRelativeLayoutParams()
 *                  .addRule(BELOW, R.id.edit_password)
 *                  .create()
 *              .setId(R.id.edit_username)
 *              .setText("below")
 *              .setBackgroundColor(Color.RED)
 *              .create()
 *          .show();
 * </pre>
 * <p>
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/1/29
 */
public class DialogFlow {
    private static final String TAG_NAME_EMPTY = "empty";
    /**
     * 默认过滤条件<br>
     *     不对View过滤，全部传递。
     */
    public static final ViewFilter DEFAULT_FILTER = new ViewFilter() {
        @Override
        public boolean match(View view) {
            // 不过滤
            if (TAG_NAME_EMPTY.equals(view.getTag())) {
                return true;
            }
            return false;
        }
    };

    /**
     * 创建初始化默认布局<br>
     *     <pre>
     *
     *     </pre>
     * @param context   {@link Context}
     * @return  {@link ContentBuilder}
     */
    public static final ContentBuilder init(Context context) {
        return new LayoutBuilder(context).createLayout();
    }

    /**
     * 创建自定义的Dialog布局<br>
     * @param context   {@link Context}
     * @return  {@link LayoutBuilder}
     */
    public static final LayoutBuilder custom(Context context) {
        return new LayoutBuilder(context);
    }

    public static class ContentBuilder implements BasicBuilder.Builder {
        /** Dialog content view layout(root view) */
        private ViewGroup layout;

        /** title by Dialog */
        private String title;

        /** message by Dialog */
        private String message;

        /** icon by Dialog */
        private Drawable icon;

        /** PositiveButton */
        private String positiveButtonName;
        private OnPositiveButtonClickListener positiveButtonClickListener;
        /** NegativeButton */
        private String negativeButtonName;
        private OnNegativeButtonClickListener negativeButtonClickListener;
        /** NeutralButton */
        private String neutralButtonName;
        private OnNeutralButtonClickListener neutralButtonClickListener;

        /** Filter match in ButtonClickListener */
        private ViewFilter viewFilter = DEFAULT_FILTER;

        public ContentBuilder(ViewGroup parent) {
            this.layout = parent;
        }

        public ContentBuilder setViewFilter(ViewFilter viewFilter) {
            this.viewFilter = viewFilter;
            return ContentBuilder.this;
        }

        /**
         * A line what 1 pixel height.
         * @return {@link ContentBuilder}
         */
        public ContentBuilder createEmptyLine() {
            View view = new View(layout.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
            view.setBackgroundColor(Color.TRANSPARENT);
            view.setTag(TAG_NAME_EMPTY);
            layout.addView(view);
            return ContentBuilder.this;
        }

        /**
         * A line what 1 pixel height.
         * @return {@link ContentBuilder}
         */
        public ContentBuilder createEmptyLine(int height) {
            View view = new View(layout.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height <=0 ? 1 : height));
            view.setBackgroundColor(Color.TRANSPARENT);
            view.setTag(TAG_NAME_EMPTY);
            layout.addView(view);
            return ContentBuilder.this;
        }


        public ContentBuilder createLine(int height, int backgroundColor) {
            View view = new View(layout.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));
            view.setBackgroundColor(backgroundColor);
            layout.addView(view);
            return ContentBuilder.this;
        }

        /**
         * @param text
         * @return
         */
        public ContentBuilder createTextView(String text) {
            return createTextView(text, 18, Color.BLACK);
        }

        public ContentBuilder createTextView(String text, float size, int color) {
            TextView textView = new TextView(layout.getContext());
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setText(text);
            textView.setTextSize(size);
            textView.setTextColor(color);
            textView.setPadding(50, 10, 10, 50);
            layout.addView(textView);
            return ContentBuilder.this;
        }

        /**
         * 添加输入框<br>
         * @param text  输入框内容
         * @return  {@link ContentBuilder}
         */
        public ContentBuilder createEditText(@StringRes int text) {
            return createEditText(layout.getResources().getString(text));
        }

        /**
         * 添加输入框<br>
         * @param text  输入框内容
         * @return  {@link ContentBuilder}
         */
        public ContentBuilder createEditText(@NonNull String text) {
            return createEditText(text, "");
        }

        /**
         * 添加输入框<br>
         * @param text  输入框内容
         * @param hint  输入框提示内容
         * @return  {@link ContentBuilder}
         */
        public ContentBuilder createEditText(@StringRes int text, @StringRes int hint) {
            return createEditText(layout.getResources().getString(text), layout.getResources().getString(hint));
        }

        /**
         * 添加输入框<br>
         * @param text  输入框内容
         * @param hint  输入框提示内容
         * @return  {@link ContentBuilder}
         */
        public ContentBuilder createEditText(String text, String hint) {
            return new EditTextBuilder(layout.getContext(), ContentBuilder.this).setText(text).setHint(hint).create();
        }

        /**
         * 创建单选控件
         * @param resId     资源ID
         * @param checked   是否默认被选中
         * @return  {@link ContentBuilder}
         */
        public ContentBuilder createRadioButton(@StringRes int resId, boolean checked) {
            return createRadioButton(layout.getResources().getString(resId), checked);
        }

        public ContentBuilder createRadioButton(String text, boolean checked) {
            RadioButton button = new RadioButton(layout.getContext());
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            button.setPadding(5, 5,5, 5);
            button.setText(text);
            button.setChecked(checked);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        if (view instanceof RadioButton) {
                            ((RadioButton) view).setChecked(false);
                        }
                    }
                    if (v instanceof RadioButton) {
                        ((RadioButton) v).setChecked(true);
                    }
                }
            });
            layout.addView(button);
            return ContentBuilder.this;
        }

        /**
         * A text view with custom param.
         *
         * <pre>
         *    customTextView()
         *      .setId(id)
         *      .setText("")
         *      .setTextColor(Color.Black)
         *      ...          // Set what you think.
         *      .create()    // end must
         * </pre>
         * @return  {@link ContentBuilder}
         * @see android.widget.TextView
         */
        public TextViewViewBuilder customTextView() {
            return new TextViewViewBuilder(layout.getContext(), ContentBuilder.this);
        }

        /**
         * A edit text view with custom param.
         *
         * <pre>
         *    customEditText()
         *      .stId(id)
         *      .setText("")
         *      .setHint("")
         *      ...         // Set what you think.
         *      .create()   // end must
         * </pre>
         * @return  {@link ContentBuilder}
         * @see android.widget.EditText
         */
        public EditTextBuilder customEditText() {
            return new EditTextBuilder(layout.getContext(), ContentBuilder.this);
        }

        /**
         * <pre>
         *    customButton()
         *      .setId(id)
         *      .setText("")
         *      ...             // Set what you think.
         *      .create()       // end must
         * </pre>
         * @return  {@link ContentBuilder}
         * @see android.widget.RadioButton
         */
        public ButtonViewBuilder customButton() {
            return new ButtonViewBuilder(layout.getContext(), ContentBuilder.this);
        }

        /**
         * <pre>
         *    customRadioButton()
         *      .setId(id)
         *      .setText("")
         *      .setChecked(false)
         *      ...             // Set what you think.
         *      .create()       // end must
         * </pre>
         * @return  {@link ContentBuilder}
         * @see android.widget.RadioButton
         */
        public RadioButtonViewBuilder customRadioButton() {
            return new RadioButtonViewBuilder(layout.getContext(), ContentBuilder.this);
        }


        public ContentBuilder setPositiveButton(@StringRes int resId, OnPositiveButtonClickListener listener) {
            return setPositiveButton(layout.getResources().getString(resId), listener);
        }

        public ContentBuilder setPositiveButton(String name, OnPositiveButtonClickListener listener) {
            this.positiveButtonName = name;
            this.positiveButtonClickListener = listener;
            return ContentBuilder.this;
        }

        public ContentBuilder setNegativeButton(@StringRes int resId, OnNegativeButtonClickListener listener) {
            return setNegativeButton(layout.getResources().getString(resId), listener);
        }

        public ContentBuilder setNegativeButton(String name, OnNegativeButtonClickListener listener) {
            this.negativeButtonName = name;
            this.negativeButtonClickListener = listener;
            return ContentBuilder.this;
        }

        public ContentBuilder setNeutralButton(@StringRes int resId, OnNeutralButtonClickListener listener) {
            return setNeutralButton(layout.getResources().getString(resId), listener);
        }

        public ContentBuilder setNeutralButton(String name, OnNeutralButtonClickListener listener) {
            this.neutralButtonName = name;
            this.neutralButtonClickListener = listener;
            return ContentBuilder.this;
        }

        public ContentBuilder setTitle(@StringRes int resId) {
            this.title = layout.getResources().getString(resId);
            return ContentBuilder.this;
        }

        public ContentBuilder setTitle(String title) {
            this.title = title;
            return ContentBuilder.this;
        }

        public ContentBuilder setIcon(@DrawableRes int id) {
            this.icon = layout.getResources().getDrawable(id);
            return ContentBuilder.this;
        }

        public ContentBuilder setIcon(Drawable drawable) {
            this.icon = drawable;
            return ContentBuilder.this;
        }

        public ContentBuilder setMessage(@StringRes int resId) {
            this.message = layout.getResources().getString(resId);
            return ContentBuilder.this;
        }

        public ContentBuilder setMessage(String message) {
            this.message = message;
            return ContentBuilder.this;
        }

        public ViewGroup getLayout() {
            return layout;
        }

        public ContentBuilder setBackground(Drawable drawable) {
            layout.setBackground(drawable);
            return ContentBuilder.this;
        }

        public ContentBuilder setBackgroundResource(@DrawableRes int res) {
            layout.setBackgroundResource(res);
            return ContentBuilder.this;
        }

        public ContentBuilder setBackgroundColor(int color) {
            layout.setBackgroundColor(color);
            return ContentBuilder.this;
        }

        public void show() {
            build().show();
        }

        public void show(String title, String message) {
            build().setTitle(title).setMessage(message).show();
        }

        protected AlertDialog.Builder build() {
            AlertDialog.Builder builder = new AlertDialog.Builder(layout.getContext());
            if (layout.getChildCount() > 0) {
                builder.setView(layout);
            }
            if (!TextUtils.isEmpty(positiveButtonName)) {
                builder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBuilder.this.onClick(layout, viewFilter, dialog, which, positiveButtonClickListener);
                    }
                });

            }
            if (!TextUtils.isEmpty(negativeButtonName)) {
                builder.setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBuilder.this.onClick(layout, viewFilter, dialog, which, negativeButtonClickListener);
                    }
                });
            }
            if (!TextUtils.isEmpty(neutralButtonName)) {
                builder.setNeutralButton(neutralButtonName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ContentBuilder.this.onClick(layout, viewFilter, dialog, which, neutralButtonClickListener);
                    }
                });
            }
            if (!TextUtils.isEmpty(title)) {
                builder.setTitle(title);
            }
            if (!TextUtils.isEmpty(message)) {
                builder.setMessage(message);
            }
            if (icon != null) {
                builder.setIcon(icon);
            }
            return builder;
        }

        private void onClick(@NonNull ViewGroup layout, @NonNull ViewFilter viewFilter, DialogInterface dialog, int which, OnGlobalButtonClickListener listener) {
            List<View> views = new ArrayList<>();
            for(int i = 0 ; i < layout.getChildCount();  i++) {
                View view = layout.getChildAt(i);
                if (viewFilter != null && viewFilter.match(view)) {
                    continue;
                }
                views.add(view);
            }

            if (listener != null) {
                View[] arrays = new View[views.size()];
                listener.onClick(dialog, which, layout, views.toArray(arrays));
            }
        }
    }

    /**
     * 过滤
     */
    public interface ViewFilter {
        /**
         * 匹配过滤条件，如果符合过滤的则返回true，将不会再回调函数中被传递，也无法被获取
         * @param view  do match view.
         * @return  if false that it not filter, otherwise exclude it in param views::View[] from one of
         *              {@link OnPositiveButtonClickListener#onClick(DialogInterface, int, ViewGroup, View[])} and
         *              {@link OnNeutralButtonClickListener#onClick(DialogInterface, int, ViewGroup, View[])} and
         *              {@link OnNegativeButtonClickListener#onClick(DialogInterface, int, ViewGroup, View[])}
         */
        boolean match(View view);
    }

    interface OnGlobalButtonClickListener {
        /**
         *
         * @param dialog    对话框接口
         * @param which     对话框
         * @param parent    对话框布局RootView
         * @param views     对话框中的过滤后的View
         */
        void onClick(DialogInterface dialog, int which, ViewGroup parent, View... views);
    }

    /**
     * @see AlertDialog.Builder#setPositiveButton(int, DialogInterface.OnClickListener)
     */
    public interface OnPositiveButtonClickListener extends OnGlobalButtonClickListener{
    }

    /**
     * @see AlertDialog.Builder#setNegativeButton(int, DialogInterface.OnClickListener)
     */
    public interface OnNegativeButtonClickListener extends OnGlobalButtonClickListener{
    }

    /**
     * @see AlertDialog.Builder#setNeutralButton(int, DialogInterface.OnClickListener)
     */
    public interface OnNeutralButtonClickListener extends OnGlobalButtonClickListener{
    }

}
