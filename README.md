DialogFlow
==========

这是一个快速创建Dialog的类。旨在对Dialog类似step by step的方式去创建，以适应不同的变化。

> 如何创建

```
DialogFlow
        // 初始化默认布局
        .init(MainActivity.this)
        // 显示内容
        .show("Sample", "Hello Everyone!!! This is super single Dialog."); 
```

> 如何自定义

```
DialogFlow
        .custom(MainActivity.this)
        .customLayout(relativeLayout)
            .customRelativeLayoutParams()
                .alignParentRight()
                .create()
            .create()
        .customTextView()
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
```

## License

Copyright 2018 DavidZou

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.