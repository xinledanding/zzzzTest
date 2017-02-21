package com.example.myapplication;

/**
 * Created by le.xin on 2017/1/10.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import static android.graphics.PathMeasure.POSITION_MATRIX_FLAG;

/**
 * 飘落的动画
 */
public class FlutterFlakeView extends SurfaceView implements SurfaceHolder.Callback {
    public static final int SLEEP_TIME = 10;
    private SurfaceHolder mSurfaceHolder;
    private Paint mCleanPaint;
    private Matrix mMatrix;
    private Interpolator mInterpolator;
    private DrawThread mDrawThread;

    private List<FlutterItem> mFlutterItems;
    private FlutterItemClick mItemClick;

    private int mRepeatCount = 1;
    int playCount = 0;
    private boolean mIsCreated = false;

    public FlutterFlakeView(Context context) {
        super(context);
        init();
    }

    public FlutterFlakeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlutterFlakeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setZOrderOnTop(true);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);

        getHolder().addCallback(this);
        mMatrix = new Matrix();
        mCleanPaint = new Paint();
        mInterpolator = new LinearInterpolator();
    }

    public void setFlutterItems(final Bitmap bitmap, int count) {
        if (bitmap == null || count <= 0) {
            mFlutterItems = null;
            playCount = 0;
            return;
        }
        List<FlutterItem> flutterItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            flutterItems.add(new FlutterItem(bitmap));
        }
        setFlutterItems(flutterItems);
    }

    public void setFlutterItemsByBitmaps(List<Bitmap> bitmaps) {
        if(bitmaps != null) {
            List<FlutterItem> flutterItems = new ArrayList<>();
            for (Bitmap bitmap : bitmaps) {
                flutterItems.add(new FlutterItem(bitmap));
            }
            setFlutterItems(flutterItems);
        } else {
            mFlutterItems = null;
        }
        playCount = 0;
    }

    public void setFlutterItems(List<FlutterItem> flutterItems) {
        if(flutterItems != null) {
            mFlutterItems = new CopyOnWriteArrayList<>(flutterItems);
        } else {
            mFlutterItems = null;
        }
        playCount = 0;
    }

    public void setRepeatCount(int repeatCount) {
        mRepeatCount = repeatCount;
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public void setItemClick(FlutterItemClick itemClick) {
        mItemClick = itemClick;
    }

    public void start() {
        if(mDrawThread == null || !mDrawThread.isAlive()) {
            mDrawThread = new DrawThread();
            mDrawThread.start();
        } else {
            mDrawThread.pause(false);
        }
    }

    public void pause() {
        if(mDrawThread != null) {
            mDrawThread.pause(true);
        }
    }

    public void stop() {
        if(mDrawThread != null) {
            mDrawThread.pause(true);
            mDrawThread.interrupt();
            mDrawThread = null;
        }

        if(mIsCreated) {
            try {
                Canvas canvas = mSurfaceHolder.lockCanvas();
                if (canvas != null) {
                    mCleanPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                    canvas.drawPaint(mCleanPaint);
                    mCleanPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

                    mSurfaceHolder.unlockCanvasAndPost(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mSurfaceHolder = holder;
        mIsCreated = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsCreated = false;
        stop();
        mItemClick = null;
    }

    private class DrawThread extends Thread {

        @Override
        public void run() {
            super.run();
            boolean isReseted = true;
            try {
                while (!isInterrupted()) {
                    if (mSurfaceHolder == null || mSurfaceHolder.isCreating() || mFlutterItems == null || mFlutterItems.isEmpty() || isPaused) {
                        Thread.sleep(SLEEP_TIME * 3);
                        continue;
                    }

                    Canvas canvas = null;

                    try {
                        canvas = mSurfaceHolder.lockCanvas();
                        if (canvas == null) {
                            continue;
                        }

                        mCleanPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        canvas.drawPaint(mCleanPaint);
                        mCleanPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

                        if(playCount / mFlutterItems.size() >= mRepeatCount) {
                            return;
                        }

                        if(!isReseted && playCount % mFlutterItems.size() == 0) {
                            for (FlutterItem item : mFlutterItems) {
                                item.mPath = null;
                            }
                            isReseted = true;
                        }

                        for (FlutterItem item : mFlutterItems) {
                            if(item.mPath == null && getWidth() > 0 && getHeight() > 0) {
                                item.mPath = new Path();
                                int bitmapWidth = item.mBitmap.getWidth();
                                int bitmapHeight = item.mBitmap.getHeight();
                                item.mPath.moveTo(getRandom(0 ,getWidth() - bitmapWidth), 0 - bitmapHeight);
                                item.mPath.cubicTo(
                                        getRandom(getWidth()), getRandom(getHeight()),
                                        getRandom(getWidth()), getRandom(getHeight()),
                                        getRandom(0, getWidth() - bitmapWidth), getHeight());
                                item.mPathMeasure = new PathMeasure(item.mPath , false);
                                if(item.mDropRate <= 0) {
                                    item.mDropRate = getRandom(0.003f, 0.006f);
                                }
                                item.mIsDrawOver = false;
                                item.mDropValue = 0;
                                item.mDelayCreateTime = getRandom(100 * SLEEP_TIME);
                            }

                            item.mDelayCreateTime -= SLEEP_TIME;
                            if(item.mDelayCreateTime > 0) {
                                continue;
                            }

                            item.mDropValue += item.mDropRate;
                            if (item.mDropValue >= 1) {
                                item.mDropValue = 0;
                                item.mIsDrawOver = true;
                                playCount ++;
                                isReseted = false;
                            }

                            if(item.mIsDrawOver) {
                                continue;
                            }

                            float interpolation = item.mDropValue;
                            if(mInterpolator != null) {
                                interpolation = mInterpolator.getInterpolation(item.mDropValue);
                            }

                            item.mPathMeasure.getMatrix(item.mPathMeasure.getLength() * interpolation, mMatrix, POSITION_MATRIX_FLAG);
                            canvas.drawBitmap(item.mBitmap, mMatrix, null);

                            float[] values = new float[9];
                            mMatrix.getValues(values);
                            item.mRect.set(values[2] , values[5] ,item.mBitmap.getWidth() * values[0] + values[2], item.mBitmap.getHeight() * values[0] + values[5]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (canvas != null) {
                            try {
                                mSurfaceHolder.unlockCanvasAndPost(canvas);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private boolean isPaused;

        public void pause(boolean pause) {
            isPaused = pause;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if(mItemClick != null) {
                for (FlutterItem item : mFlutterItems) {
                    if(item.mRect.contains(event.getX() , event.getY())) {
                        mItemClick.onClick(item);
                        break;
                    }
                }
            }
        }
        return super.onTouchEvent(event);
    }

    public interface FlutterItemClick {
        boolean onClick(FlutterItem item);
    }

    public static class FlutterItem {
        private Bitmap mBitmap;
        private Path mPath;
        private PathMeasure mPathMeasure;
        private float mDropRate;        // 速率
        private float mDropValue;       // 下降到什么位置了
        private boolean mIsDrawOver;
        private int mDelayCreateTime;   // 延时产生的时间
        public RectF mRect = new RectF();

        public FlutterItem(Bitmap bitmap) {
            mBitmap = bitmap;
        }

        public void setDropRate(float dropRate) {
            mDropRate = dropRate;
        }
    }

    private static final Random RANDOM = new Random();

    public static float getRandom(float lower, float upper) {
        return getRandom(upper - lower) + lower;
    }

    public static float getRandom(float upper) {
        return RANDOM.nextFloat() * upper;
    }

    public static int getRandom(int upper) {
        return RANDOM.nextInt(upper);
    }

}
