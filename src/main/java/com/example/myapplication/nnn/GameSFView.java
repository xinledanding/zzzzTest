package com.example.myapplication.nnn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.example.myapplication.R;

import java.util.Random;

public class GameSFView extends SurfaceView implements Callback, Runnable {

	private SurfaceHolder surfaceHolder;
	private Random rand = new Random();
	private int dx = 0, dy = 0;

	
	public GameSFView(Context context) {
		super(context);
		surfaceHolder = this.getHolder(); // 获取SurfaceHolder对象
		surfaceHolder.addCallback(this); // 添加回调
	}

	@Override
	public void run() {
		
		while(true){
			dy -= 10; //修改下dy的坐标,方向向上，所以dy不断减,每次上移10dp
			draw(); //调用重绘
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 自定义绘制方法
	 */
	public void draw() {
		synchronized(surfaceHolder){
			// 获取Canvas对象
			Canvas canvas = surfaceHolder.lockCanvas(); // 锁住Canvas
			
			//清理背景,游戏中将换成具体的背景贴图
			canvas.drawColor(Color.BLACK);
			
			// 画笔对象，可以控制颜色和文字大小
			Paint paint = new Paint();

			// 给画笔设置系统内置的颜色：蓝色
			paint.setColor(Color.BLUE);
			// 文字左上角的坐标为(100,100)
			canvas.drawText("飞机大战", 100, 100, paint);

			// 将画笔颜色调成红色
			// paint.setColor(Color.RED);
			// ARGB : A:透明度 、R：红色、G：绿色、B：蓝色。取值范围都在：0 ~ 255
			paint.setARGB(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255),rand.nextInt(255));
			// 圆心点坐标为(100,200)
			canvas.drawCircle(100, 200, 10, paint);

			// 加载资源图片图片
			Bitmap heroBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hero1);
			// 在(100,300)处绘制图片,dy值控制在y轴上的位置
			canvas.drawBitmap(heroBitmap, 100, 300 + dy, null);
			
			surfaceHolder.unlockCanvasAndPost(canvas);  // 解锁Canvas，更新
		}
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2,int arg3) {
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// Surface创建成功启动线程
		new Thread(this).start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}

}
