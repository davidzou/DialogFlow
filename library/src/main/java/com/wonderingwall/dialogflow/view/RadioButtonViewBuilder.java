package com.wonderingwall.dialogflow.view;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.abt.AbstractButtonViewBuilder;

/**
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/1/29
 */
public class RadioButtonViewBuilder extends AbstractButtonViewBuilder<RadioButtonViewBuilder, RadioButton> {

    private RadioButton radioButton;

    public RadioButtonViewBuilder(Context context, final DialogFlow.ContentBuilder contentBuilder){
        super(context, contentBuilder);
        radioButton = new RadioButton(context);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < contentBuilder.getLayout().getChildCount(); i++) {
                    View view = contentBuilder.getLayout().getChildAt(i);
                    if (view instanceof RadioButton) {
                        ((RadioButton) view).setChecked(false);
                    }
                }
                if (v instanceof RadioButton) {
                    ((RadioButton) v).setChecked(true);
                }
            }
        });
    }

    @Override
    protected RadioButton getView() {
        return radioButton;
    }

    public RadioButtonViewBuilder setChecked(boolean checked) {
        getView().setChecked(checked);
        return RadioButtonViewBuilder.this;
    }

}
