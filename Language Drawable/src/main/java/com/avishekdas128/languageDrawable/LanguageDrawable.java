package com.avishekdas128.languageDrawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

import java.util.List;

public class LanguageDrawable extends Drawable {

    private final Paint mPaint;
    private final List<LanguageModel> codeColors;
    private float mFraction;

    public LanguageDrawable(List<LanguageModel> codeColors) {
        mPaint = new Paint();
        this.codeColors = codeColors;
        setFraction(codeColors.get(0));
    }

    public void setFraction(LanguageModel color) {
        mFraction = color.getFraction();
        invalidateSelf();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect b = getBounds();
        for (int i = 0; i < codeColors.size(); i++) {
            mPaint.setColor(codeColors.get(i).getColor());
            setFraction(codeColors.get(i));
            float x = b.width() * mFraction;
            if (i == 0) {
                codeColors.get(i).setStart(0);
                codeColors.get(i).setEnd(x);
                if(codeColors.size() == 1)
                    canvas.drawPath(RoundedRect(codeColors.get(i).getStart(), codeColors.get(i).getEnd(), b.height(), true, true, true, true), mPaint);
                else
                    canvas.drawPath(RoundedRect(codeColors.get(i).getStart(), codeColors.get(i).getEnd(), b.height(), false, true, false, true), mPaint);
            } else if (i == codeColors.size() - 1) {
                codeColors.get(i).setStart(codeColors.get(i - 1).getEnd());
                codeColors.get(i).setEnd(b.width());
                canvas.drawPath(RoundedRect(codeColors.get(i).getStart() + 10, codeColors.get(i).getEnd(), b.height(), true, false, true, false), mPaint);
            } else {
                codeColors.get(i).setStart(codeColors.get(i - 1).getEnd());
                codeColors.get(i).setEnd(codeColors.get(i).getStart() + x);
                canvas.drawPath(RoundedRect(codeColors.get(i).getStart() + 10, codeColors.get(i).getEnd(), b.height(), false, false, false, false), mPaint);
            }
        }
    }

    private Path RoundedRect(float left, float right, float bottom, boolean tr, boolean tl, boolean br, boolean bl) {
        float rx = bottom / 2;
        float ry = bottom / 2;
        Path path = new Path();
        float width = right - left;
        float height = bottom - (float) 0;
        if (rx > width / 2) rx = width / 2;
        if (ry > height / 2) ry = height / 2;
        float widthMinusCorners = (width - (2 * rx));
        float heightMinusCorners = (height - (2 * ry));
        path.moveTo(right, (float) 0 + ry);
        if (tr)
            path.rQuadTo(0, -ry, -rx, -ry); //Top-Right corner
        else {
            path.rLineTo(0, -ry);
            path.rLineTo(-rx, 0);
        }
        path.rLineTo(-widthMinusCorners, 0);
        if (tl)
            path.rQuadTo(-rx, 0, -rx, ry); //Top-Left corner
        else {
            path.rLineTo(-rx, 0);
            path.rLineTo(0, ry);
        }
        path.rLineTo(0, heightMinusCorners);
        if (bl)
            path.rQuadTo(0, ry, rx, ry); //Bottom-Left corner
        else {
            path.rLineTo(0, ry);
            path.rLineTo(rx, 0);
        }
        path.rLineTo(widthMinusCorners, 0);
        if (br)
            path.rQuadTo(rx, 0, rx, -ry); //Bottom-Right corner
        else {
            path.rLineTo(rx, 0);
            path.rLineTo(0, -ry);
        }
        path.rLineTo(0, -heightMinusCorners);
        path.close();
        return path;
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
