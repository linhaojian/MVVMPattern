package com.lhj.mvvmpattern.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/2/28.
 */

public class CustomView extends View {
    private float width,height;
    private float minWidth = 100,minHeight=100;
    private float rount;
    private Paint paint;
    private OnTouchListeners onTouchListeners;

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getWidth();
        height = getHeight();
        rount = width / 10.f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = width;
        rectF.bottom = height;
        canvas.drawRoundRect(rectF,rount,rount,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(onTouchListeners!=null) {
            onTouchListeners.onTouch(event.getX(),event.getY());
        }
        return true;
    }

    public void setOnTouchListeners(OnTouchListeners onTouchListeners){
        this.onTouchListeners = onTouchListeners;
    }

    public interface OnTouchListeners{
        void onTouch(float x,float y);
    }

}
