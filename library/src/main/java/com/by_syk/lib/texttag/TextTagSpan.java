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

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

/**
 * Created by By_syk on 2017-07-03.
 */

public class TextTagSpan extends ReplacementSpan {
    private int bgColor = Color.GRAY;
    private int textColor = Color.WHITE;
    private float textSizeRatio = 1.0f;

    public TextTagSpan(int bgColor, int textColor, float textSizeRatio) {
        super();

        this.bgColor = bgColor;
        this.textColor = textColor;
        this.textSizeRatio = textSizeRatio;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float height = bottom - top;
        float textHeight = height * textSizeRatio;
        float minus = (height - textHeight) / 2;
        RectF rect = new RectF(x, top + minus, x + measureText(paint, text, start, end), bottom - minus);
        paint.setColor(bgColor);
        canvas.drawRect(rect, paint);

        paint.setColor(textColor);
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        canvas.drawText(text, start, end,
                x, y - ((y + fm.ascent + y + fm.descent) / 2 - (bottom + top) / 2), paint);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return Math.round(paint.measureText(text, start, end));
    }

    private float measureText(Paint paint, CharSequence text, int start, int end) {
        return paint.measureText(text, start, end);
    }
}