package com.wonderingwall.dialogflow.view;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.wonderingwall.dialogflow.DialogFlow;
import com.wonderingwall.dialogflow.view.abt.AbstractTextViewViewBuilder;

/**
 * 构建一个输入文本框<br>
 *
 * @author DavidZou -- wearecisco@gmail.com
 * @version 1.0.0
 * @date 2019/1/29
 */
public class EditTextBuilder extends AbstractTextViewViewBuilder<EditTextBuilder, EditText> {

    private EditText editText;

    public EditTextBuilder(@NonNull Context context, @NonNull DialogFlow.ContentBuilder contentBuilder) {
        super(context, contentBuilder);
        editText = new EditText(context);
        editText.setTextColor(Color.BLACK);
        editText.setTextSize(18);
        editText.setHintTextColor(Color.GRAY);
    }

    @Override
    protected EditText getView() {
        return editText;
    }

}
