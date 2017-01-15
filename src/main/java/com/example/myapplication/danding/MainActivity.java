package com.example.myapplication.danding;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity extends Activity {
	
	/**
	 * 动画
	 */
	private ValueAnimator mAnimator;
	
	/**
	 * 移动物体
	 */
	private Button mView;
	
	/**
	 * 三次贝塞尔曲线起始点，2控制点，终点
	 */
	private Point[] mPoints=new Point[4];
	/**
	 * 屏幕宽
	 */
	private int w_screen;
	/**
	 * 屏幕高
	 */
	private int h_screen;
	/**
	 * 贝塞尔曲线
	 */
	private BezierCurveView mBezierCurveView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
        
        DisplayMetrics dm =getResources().getDisplayMetrics();  
        w_screen = dm.widthPixels;  
        h_screen = dm.heightPixels;  
        Log.i("ee", "屏幕尺寸：宽度 = " + w_screen + "高度 = " + h_screen + "密度 = " + dm.densityDpi);
        
		for (int i = 0; i < 4; i++) {
			Point point=new Point();
			point.x=new Random().nextInt(w_screen-20);
			if (i==0) {
				point.y=0;//控制起点在屏幕最上方
			}else if (i==3) {
				point.y=h_screen;//控制终点在屏幕最下方
			}else {
				point.y= new Random().nextInt( h_screen);
			}
			mPoints[i]=point;
			Log.d("ee", i+":("+point.x+"."+point.y);
		}
		
		mBezierCurveView=(BezierCurveView) findViewById(R.id.bezierView);
		mBezierCurveView.setmPoints(mPoints);
		mView = (Button) findViewById(R.id.button1);
		mView.setX(mPoints[0].x);
		mView.setY(mPoints[0].y);
		mView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {	
				for (int i = 0; i < 4; i++) {
					Point point=new Point();
					point.x=new Random().nextInt( w_screen-20);
					if (i==0) {
						point.y=0;//控制起点在屏幕最上方
					}else if (i==3) {
						point.y= h_screen;//控制终点在屏幕最下方
					}else {
						point.y=new Random().nextInt( h_screen);
					}
					mPoints[i]=point;
					Log.d("ee", i+":("+point.x+"."+point.y);
				}
				mBezierCurveView.setmPoints(mPoints);
				
				mView.setX(mPoints[0].x);
				mView.setY(mPoints[0].y);
				startAnimator();
			}
		});		
	}

	protected void startAnimator() {
		mAnimator = ValueAnimator.ofObject(new BezierEvaluator(), new PointF(mPoints[0].x,mPoints[0].y),new PointF( mPoints[3].x,mPoints[3].y));
		mAnimator.setDuration(2000);		
		mAnimator.addUpdateListener(new AnimatorUpdateListener() {			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				PointF pointF = (PointF)animation.getAnimatedValue();
				mView.setX(pointF.x);
				mView.setY(pointF.y);
			}
		});
		mAnimator.setTarget(mView);
		mAnimator.setRepeatCount(1);
		mAnimator.setRepeatMode(ValueAnimator.REVERSE);
		mAnimator.start();
	}


	class BezierEvaluator implements TypeEvaluator<PointF>{

		@Override
		public PointF evaluate(float fraction, PointF startValue,
				PointF endValue) {
			Log.d("ee", "fraction:"+fraction+"  startValue:("+startValue.x+"."+startValue.y+")   endValue:("+endValue.x+"."+endValue.y+")");
			final float t = fraction;
			float oneMinusT = 1.0f - t;
			PointF point = new PointF();
			
			PointF point0 = (PointF)startValue;
			
			PointF point1 = new PointF();
			point1.set(mPoints[1].x, mPoints[1].y);
			
			PointF point2 = new PointF();
			point2.set(mPoints[2].x, mPoints[2].y);
			
			PointF point3 = (PointF)endValue;
			
			point.x = oneMinusT * oneMinusT * oneMinusT * (point0.x) 
					+ 3 * oneMinusT * oneMinusT * t * (point1.x)
					+ 3 * oneMinusT * t * t * (point2.x)
					+ t * t * t * (point3.x);
			
			point.y = oneMinusT * oneMinusT * oneMinusT * (point0.y) 
					+ 3 * oneMinusT * oneMinusT * t * (point1.y)
					+ 3 * oneMinusT * t * t * (point2.y)
					+ t * t * t * (point3.y);			
			return point;
		}	
	}
	public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density; 
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }  
	
}
