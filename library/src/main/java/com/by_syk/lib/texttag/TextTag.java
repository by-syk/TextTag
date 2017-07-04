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

package com.by_syk.lib.texttag;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;

/**
 * Created by By_syk on 2017-07-03.
 */

public class TextTag {
    @NonNull
    private String text = "";

    @NonNull
    private String tag = "";

    @ColorInt
    private int bgColor = Color.GRAY;

    @ColorInt
    private int color = Color.WHITE;

    private float sizeRatio = 0.5f;

    @Pos
    private int pos = POS_END;

    /**
     * Put tag at start of text.
     */
    public static final int POS_START = 0;

    /**
     * Put tag at end of text.
     */
    public static final int POS_END = 1;

    @IntDef({POS_START, POS_END})
    public @interface Pos {}

    /**
     * Use Builder to get TextTag instance.
     */
    private TextTag() {}

    /**
     * Get the SpannableString result.
     * <br />
     * Notice: if some parameters are invalid, empty SpannableString is returned.
     */
    @NonNull
    public SpannableString render() {
        if (text.isEmpty()) {
            return new SpannableString("");
        }
        if (TextUtils.isEmpty(tag)) {
            return new SpannableString(text);
        }
        SpannableString ssText;
        int indexStart;
        int indexEnd;
        if (pos == POS_START) {
            ssText = new SpannableString(tag + " " + text);
            indexStart = 0;
            indexEnd = tag.length();
        } else {
            ssText = new SpannableString(text + " " + tag);
            indexStart = text.length() + 1;
            indexEnd = ssText.length();
        }
        ssText.setSpan(new RelativeSizeSpan(sizeRatio),
                indexStart, indexEnd, SpannableString.SPAN_COMPOSING);
        ssText.setSpan(new TextTagSpan(bgColor, color, sizeRatio),
                indexStart, indexEnd, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssText;
    }

    public static class Builder {
        private TextTag textTag;

        /**
         * Builder to create TextTag instance.
         */
        public Builder() {
            textTag = new TextTag();
        }

        /**
         * Set normal text.
         */
        public Builder text(@Nullable String text) {
            textTag.text = text == null ? "" : text;
            return this;
        }

        /**
         * Set tag text.
         * <br />
         * Add spaces at the beginning and end (like " xxx ") is recommended.
         */
        public Builder tag(@Nullable String tag) {
            textTag.tag = tag == null ? "" : tag;
            return this;
        }

        /**
         * Set tag background color.
         * <br />
         * The default is gray(0xff888888).
         */
        public Builder bgColor(@ColorInt int bgColor) {
            textTag.bgColor = bgColor;
            return this;
        }

        /**
         * Set tag text color.
         * <br />
         * The default is white(0xffffffff).
         */
        public Builder color(@ColorInt int color) {
            textTag.color = color;
            return this;
        }

        /**
         * Set tag size ratio, from 0.1 ~ 1.0. (1.0 if same as normal text size)
         * <br />
         * The default is 0.5.
         */
        public Builder sizeRatio(@FloatRange(from = 0.1, to = 1.0) float sizeRatio) {
            if (sizeRatio <= 0.1f) {
                textTag.sizeRatio = 0.1f;
            } else if (sizeRatio >= 1.0f) {
                textTag.sizeRatio = 1.0f;
            } else {
                textTag.sizeRatio = sizeRatio;
            }
            return this;
        }

        /**
         * Set tag pos, {@link #POS_START} or {@link #POS_END}.
         * <br />
         * The default is {@link #POS_END}.
         */
        public Builder pos(@Pos int pos) {
            textTag.pos = pos;
            return this;
        }

        /**
         * Get TextTag instance.
         */
        public TextTag build() {
            return textTag;
        }
    }
}
