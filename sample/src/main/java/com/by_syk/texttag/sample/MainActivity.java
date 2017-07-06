/*
 * Copyright 2017 By_syk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.by_syk.texttag.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.by_syk.lib.texttag.TextTag;

/**
 * Created by By_syk on 2016-07-16.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView) findViewById(R.id.tv1)).setText(new TextTag.Builder()
                .text("快图浏览")
                .tag(" BETA ")
                .build().render());

        TextTag textTag = new TextTag.Builder()
                .text("快图浏览")
                .tag(" GET ")
                .bgColor(0xff2196f3)
                .color(Color.WHITE)
                .sizeRatio(0.5f)
                .pos(TextTag.POS_START)
                .build();
        ((TextView) findViewById(R.id.tv2))
                .setText(textTag.render());

        setTitle(new TextTag.Builder()
                .fastTag(getString(R.string.app_name_tag))
                .bgColor(0xff707070)
                .sizeRatio(0.7f)
                .build().render());
    }
}
