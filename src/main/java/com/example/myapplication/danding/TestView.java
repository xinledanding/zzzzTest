package com.example.myapplication.danding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by le.xin on 2017/2/12.
 */

public class TestView extends View {
    public TestView(Context context) {
        super(context);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        TextPaint mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.RED);

        int start = 0;
        int line = 0;

        String text = "asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332asda1232124332";
        do {

            line =  mTextPaint.breakText(text ,start ,text.length() , false ,getWidth() ,null);
            if(text.length() < line) {
                return;
            }
            if(start > text.length()) {
                return;
            }
            if(start > line) {
                return;
            }
            System.out.println(start + "    " + line + "    淡定"  + "   " +mTextPaint.getFontMetrics().leading);
            canvas.drawText(text , start , start + line , 0 , mTextPaint.getFontMetrics(null) , mTextPaint);
            start += line;
        } while (line > 0);
    }
}
