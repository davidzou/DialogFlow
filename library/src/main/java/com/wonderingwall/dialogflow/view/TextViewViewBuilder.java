package com.wonderingwall.dialogflow.view;

import android.content.Context;
import android.widget.TextView;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.abt.AbstractTextViewViewBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/1/29
 */
public class TextViewViewBuilder extends AbstractTextViewViewBuilder<TextViewViewBuilder, TextView> {

    private TextView textView;

    public TextViewViewBuilder(Context context, DialogFlow.ContentBuilder contentBuilder) {
        super(context, contentBuilder);
        textView = new TextView(context);
        /// TODO: 2019/1/29 添加自定义Custom布局调整
    }

    @Override
    protected TextView getView() {
        return textView;
    }

}
