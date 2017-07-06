# TextTag

[![](https://jitpack.io/v/by-syk/TextTag.svg)](https://jitpack.io/#by-syk/TextTag)
[![](https://img.shields.io/badge/Download%20aar-1.0.9-brightgreen.svg)](out/texttag-1.0.9.aar)

A simple library to add text tag.


### Adding to your project

This library is available through [**JitPack.io**](https://jitpack.io/).

**Step 1.** Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency:

```
dependencies {
    compile 'com.github.by-syk:TextTag:1.0.9'
}
```


### How to use

```java
textView.setText(new TextTag.Builder()
    .text("快图浏览")
    .tag(" BETA ")
    .build().render());
```

```java
textView.setText(new TextTag.Builder()
    .fastTag("快图浏览 ${ BETA }")
    .build().render());
```

![Demo 1](art/demo1.png)

```java
TextTag tt = new TextTag.Builder()
    .text("快图浏览")
    .tag(" GET ")
    .bgColor(0xff2196f3)
    .color(Color.WHITE)
    .sizeRatio(0.5f)
    .pos(TextTag.POS_START)
    .build();
SpannableString ss = tt.render();
textView.setText(ss);
```

![Demo 2](art/demo2.png)

> You could use tag in
> + text  
>   `textView.setText(ss)`
> + app title  
>   `actionbar.setTitle(ss)`
> + dialog title  
>   `alertDialogBuilder.setTitle(ss)`
> + and so on.


### Demo APP

[Get it](out/TextTagSample.apk)


### License

    Copyright 2017 By_syk

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


*Copyright &#169; 2017 By_syk. All rights reserved.*