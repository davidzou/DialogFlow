package com.wonderingwall.dialogflow.view.abt;

import android.content.Context;
import android.widget.Button;

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
public abstract class AbstractButtonViewBuilder<B extends BaseViewBuilder, V extends Button> extends AbstractTextViewViewBuilder<B, V> {

    public AbstractButtonViewBuilder(Context context, DialogFlow.ContentBuilder contentBuilder) {
        super(context, contentBuilder);
    }
}
