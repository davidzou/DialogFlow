package com.wonderingwall.dialogflow;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.widget.RelativeLayout.BELOW;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFlow.custom(MainActivity.this)
                        .createLayout()
                        .setTitle("Title")
                        .createTextView("Message")
                        .customTextView()
                            .setText("Text")
                            .setTextColor(Color.BLACK)
                            .setTextSize(18)
                            .setHint("Hint")
                            .setHintTextColor(Color.RED)
                            .setPadding(10, 50, 10, 10)
                            .create()
                        .customEditText()
                        .setText("")
                        .setHint("type it")
                        .create()
                        .createEmptyLine()
                        .createEmptyLine(5)
                        .createLine(2, Color.YELLOW)
//                        .setBackgroundColor(Color.GRAY)
                        .setNegativeButton("OK", new DialogFlow.OnNegativeButtonClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, ViewGroup parent, View... views) {

                            }
                        })
                        .customRadioButton().setText("1").setChecked(false).create()
                        .customRadioButton().setText("2").setChecked(false).create()
                        .customRadioButton().setText("3").setChecked(false).create()
                        .show();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    public void onClickSingleButton(View view) {
        // 简单对话框，包含标题，内容
        DialogFlow
                // 初始化默认布局
                .init(MainActivity.this)
                // 显示内容
                .show("Sample", "Hello Everyone!!! This is super single Dialog.");
    }

    public void onClickSingleButtonWithCallback(View view) {
        // 简单对话框，包含标题，内容，和一个按钮及回调处理
        DialogFlow
                // 初始化默认布局
                .init(MainActivity.this)
                // 设置标题
                .setTitle("Sample")
                // 创建内容显示
                .createTextView("Hello Everyone!! This is a single Dialog.")
                // 创建按钮
                .setPositiveButton("OK", new DialogFlow.OnPositiveButtonClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, ViewGroup parent, View... views) {
                        Toast.makeText(MainActivity.this, "You click it ok!!", Toast.LENGTH_SHORT).show();
                    }
                })
                // 显示
                .show();
    }

    public void onClickBackgroundSet(View view) {
        DialogFlow
                .init(MainActivity.this)
                .setTitle("")
                // 设置背景
                .setBackgroundColor(Color.RED)
                .createTextView("Hello Everyone!! This is a custom background")
                .setPositiveButton("Ok", null)
                .show();
    }

    public void onClickLoginInput(View view) {
        DialogFlow
                .init(MainActivity.this)
                .setTitle("用户注册")
                .createEmptyLine(5)
                .createTextView("用户名：")
                .customEditText()
                    .setId(R.id.edit_username)
                    .setPadding(50,0,0,0)
                    .create()
                .createEmptyLine(5)
                .createTextView("密码：")
                .customEditText()
                    .setId(R.id.edit_password)
                    .setPadding(50,0,0,0)
                    .setBackground(null)
//                    .setInpuType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                    .setTransformationMethod(PasswordTransformationMethod.getInstance())
                    .setMaxLines(1)
                    .create()
                .setPositiveButton("OK", new DialogFlow.OnPositiveButtonClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, ViewGroup parent, View... views) {
                        String username = "";
                        String password = "";
                        for (View view: views) {
                            if (view instanceof EditText && view.getId() == R.id.edit_username) {
                                username = ((EditText) view).getText().toString();
                            } else
                            if (view instanceof EditText && view.getId() == R.id.edit_password) {
                                password = ((EditText) view).getText().toString();
                            }

                        }
                        Toast.makeText(getApplicationContext(), "username:" + username + ", password:" + password, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Cancel", null)
                .show();
    }

    public void onClickRelativeLayout(View view) {
        RelativeLayout relativeLayout = new RelativeLayout(view.getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        RelativeLayout.LayoutParams usernameLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        usernameLayoutParams.addRule(BELOW, R.id.edit_password);
        DialogFlow
                .custom(MainActivity.this)
//                .customLayout(relativeLayout)
                .createRelativeLayoutParams()
                    .customRelativeLayoutParams()
                        .alignParentRight()
                        .create()
                    .create()
                .customTextView()
//                    .customRelativeLayoutParams()
//                        .create()
                    .createRelativeLayoutParams()
                    .setId(R.id.edit_password)
                    .setText("Above")
                    .setBackgroundColor(Color.GRAY)
                    .create()
                .customTextView()
                    .customRelativeLayoutParams()
                        .addRule(BELOW, R.id.edit_password)
                        .create()
                    .setId(R.id.edit_username)
                    .setText("below")
                    .setBackgroundColor(Color.RED)
                    .create()
                .show();
    }
}
