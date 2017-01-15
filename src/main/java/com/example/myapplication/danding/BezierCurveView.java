package com.example.myapplication.danding;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BezierCurveView extends View{
	
	/**
	 * 画笔
	 */
	private Paint paint;
	
	/**
	 * 路径
	 */
	private Path path;
	
	/**
	 * 贝塞尔曲线四点
	 */
	private Point[] mPoints;
	
	
	public Point[] getmPoints() {
		return mPoints;
	}

	public void setmPoints(Point[] mPoints) {
		this.mPoints = mPoints;
		invalidate();
	}

	public BezierCurveView(Context context, AttributeSet attrs){
		super(context,attrs);
		init();
	}
	
	public BezierCurveView(Context context){
		super(context);
		init();
	}
	
	private void init(){		
		paint = new Paint();
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(0.3f);
		
		path = new Path();
	}
	
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.v("ee", "width = " + MeasureSpec.getSize(widthMeasureSpec) + "| height = " + MeasureSpec.getSize(heightMeasureSpec));
	}
		
	public void onDraw(Canvas canvas){
		canvas.drawColor(Color.WHITE);
		path.reset();
		path.moveTo(mPoints[0].x,mPoints[0].y);
		path.cubicTo(mPoints[1].x, mPoints[1].y, mPoints[2].x, mPoints[2].y,mPoints[3].x, mPoints[3].y);
		Log.d("ee", getHeight()+"    "+getWidth()+"      getMeasuredWidth:"+getMeasuredWidth()+"      getMeasuredHeight:"+getMeasuredHeight());
		canvas.drawPath(path, paint);
	}

}
