package com.wonderingwall.dialogflow.view;

import android.content.Context;
import android.widget.Button;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.abt.AbstractButtonViewBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/2/21
 */
public class ButtonViewBuilder extends AbstractButtonViewBuilder<ButtonViewBuilder, Button> {
    private Button button;

    public ButtonViewBuilder(Context context, DialogFlow.ContentBuilder contentBuilder) {
        super(context, contentBuilder);
        button = new Button(context);
    }


    @Override
    protected Button getView() {
        return button;
    }

}
