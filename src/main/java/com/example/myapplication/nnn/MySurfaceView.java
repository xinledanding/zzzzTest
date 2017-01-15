//package com.example.myapplication.nnn;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//
//public class MySurfaceView extends SurfaceView implements
//        SurfaceHolder.Callback {
//
//    public static final String TAG = "MySurfaceView";
//
//    private DrawThread mThread = null;
//
//    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init();
//    }
//
//    public MySurfaceView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public MySurfaceView(Context context) {
//        super(context);
//        init();
//    }
//
//    private void init() {
//        Log.d(TAG, "init");
//
//        SurfaceHolder holder = getHolder();
//        holder.addCallback(this);
//
//        mThread = new DrawThread(holder);
//
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        Log.d(TAG, "onSizeChanged");
//        super.onSizeChanged(w, h, oldw, oldh);
//
//    }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//        Log.d(TAG, "surfaceCreated");
//        mThread.setRun(true);
//        mThread.start();
//
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width,
//                               int height) {
//        Log.d(TAG, "surfaceChanged");
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//        Log.d(TAG, "surfaceDestroyed");
//        mThread.setRun(false);
//    }
//
//    /**
//     * 绘制线程类
//     */
//    public class DrawThread extends Thread {
//        private SurfaceHolder mHolder = null;
//        private boolean isRun = false;
//
//        public DrawThread(SurfaceHolder holder) {
//            Log.d(TAG, "DrawThread Constructor");
//            mHolder = holder;
//
//        }
//
//        public void setRun(boolean isRun) {
//            Log.d(TAG, "DrawThread setRun: " + isRun);
//            this.isRun = isRun;
//        }
//
//        @Override
//        public void run() {
//            Log.d(TAG, "DrawThread run");
//            int count = 0;
//
//            while (isRun) {
//                Canvas canvas = null;
//                synchronized (mHolder) {
//                    try {
//                        Log.d(TAG, "Drawing-------------");
//                        canvas = mHolder.lockCanvas();
//                        canvas.drawColor(Color.WHITE);
//                        Paint p = new Paint();
//                        p.setColor(Color.BLACK);
//
//                        Rect r = new Rect(100, 50, 300, 250);
//                        canvas.drawRect(r, p);
//                        canvas.drawText("这是第" + (count++) + "秒", 100, 310, p);
//
//                        Thread.sleep(1000);// 睡眠时间为1秒
//
//                    } catch (Exception e) {
//                        Log.d(TAG, "throw Exception in run");
//                        e.printStackTrace();
//
//                    } finally {
//                        if (null != canvas) {
//                            mHolder.unlockCanvasAndPost(canvas);
//                        }
//                    }
//
//                }
//
//            }
//        }
//
//    }
//
//}