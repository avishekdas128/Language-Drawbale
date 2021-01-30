package com.avishekdas128.languageDrawable;

public class LanguageModel {

    float fraction, start, end;
    int color;

    public LanguageModel(float fraction, int color) {
        this.fraction = fraction;
        this.color = color;
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getStart() {
        return start;
    }

    public void setStart(float start) {
        this.start = start;
    }

    public float getEnd() {
        return end;
    }

    public void setEnd(float end) {
        this.end = end;
    }
}
