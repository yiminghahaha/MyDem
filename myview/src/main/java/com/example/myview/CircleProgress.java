package com.example.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleProgress extends View {
    private static final String TAG = "CircleProgress";
    private int mRingColor;
    private float mRingWidth;
    private int mCiclrColor;
    private float mCircleRadius;
    private float mTextSize;
    private int mTextColor;
    private float mStartAngle;
    private float mSweepAngle;
    private RectF mRectF;
    private Paint mRingPaint;
    private float mCenterX;
    private Paint mCirclePaint;
    private Paint mTextPaint;
    private float mDy;
    private String mText = "0 %";

    public CircleProgress(Context context) {
        super(context);
    }

    public CircleProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //获取控件属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CircleProgress);
        if (array!=null){
            mRingColor = array.getColor(R.styleable.CircleProgress_ring_color, 0);
            mRingWidth = array.getDimension(R.styleable.CircleProgress_ring_width, 50);
            mCiclrColor = array.getColor(R.styleable.CircleProgress_circle_color, 0);
            mCircleRadius = array.getDimension(R.styleable.CircleProgress_circle_radius, 50);
            mTextSize = array.getDimension(R.styleable.CircleProgress_android_textSize, 20);
            mTextColor = array.getColor(R.styleable.CircleProgress_android_textColor, 0);
            mStartAngle = array.getFloat(R.styleable.CircleProgress_startAngle, -90);
            mSweepAngle = array.getFloat(R.styleable.CircleProgress_sweepAngle, 0);
        }
        //外环画笔
        mRingPaint = new Paint();
        mRingPaint.setAntiAlias(true);
        mRingPaint.setColor(mRingColor);
        mRingPaint.setStrokeWidth(mRingWidth);
        mRingPaint.setStyle(Paint.Style.STROKE);
        //内园画笔
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCiclrColor);
        //百分比显示画笔
        mTextPaint = new Paint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        //居中显示
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        mDy = fontHeight/2-fontMetrics.descent;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        float left = 0.1f * width;
        float right = 0.9f * width;
        mRectF = new RectF(left, left, right, right);
        mCenterX = width/2;
        mCircleRadius =  mCircleRadius > width/4 ? width/4 : mCircleRadius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //1.先画外环,扇形
        canvas.drawArc(mRectF,mStartAngle,mSweepAngle,false,mRingPaint);
        //2.画内圆
        canvas.drawCircle(mCenterX,mCenterX,mCircleRadius,mCirclePaint);
        //3.画文本
        canvas.drawText(mText,mCenterX,mCenterX+mDy,mTextPaint);

    }

    public  void setProgress(int progress){
        mSweepAngle = progress * 360/100;
        mText = progress+ " %";
        //重新绘制
        //必须在主线程
        //invalidate();
        //非ui线程可用
        postInvalidate();
    }
}
