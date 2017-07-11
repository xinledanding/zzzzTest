package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static android.view.View.MeasureSpec.getSize;

/**
 * Created by Cuneyt on 4.10.2015.
 * Gifview
 * 这个只能使用在开屏等少量使用的界面 如果在listView 可能有性能问题
 * @author le.xin
 */
public class GifView extends View {

    private static final int DEFAULT_MOVIE_VIEW_DURATION = 1000;

    private Movie movie;

    private long mMovieStart;
    private int mCurrentAnimationTime;
    private boolean isOnlyLoadOne = false;
    private boolean isFullImageView = true;

    /**
     * Position for drawing animation frames in the center of the view.
     */
    private float mLeft;
    private float mTop;

    /**
     * Scaling factor to fit the animation within view bounds.
     */
    private float mScaleX;
    private float mScaleY;

    /**
     * Scaled movie frames width and height.
     */
    private int mMeasuredMovieWidth;
    private int mMeasuredMovieHeight;

    private volatile boolean mPaused;
    private boolean mVisible = true;

    public GifView(Context context) {
        this(context, null);
    }

    public GifView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GifView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setViewAttributes(context, attrs, defStyle);
    }

    private void setViewAttributes(Context context, AttributeSet attrs, int defStyle) {

        /**
         * Starting from HONEYCOMB(Api Level:11) have to turn off HW acceleration to draw
         * Movie on Canvas.
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

    }

    public void setGifSource(File file) {
        try {
            movie = Movie.decodeStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestLayout();
    }

    public void setGifSource(int drawableId) {
        try {
            movie = Movie.decodeStream(getResources().openRawResource(drawableId));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        requestLayout();
    }

    public void setGifSource(byte [] stream) {
        movie = Movie.decodeByteArray(stream ,0 ,stream.length);
        requestLayout();
    }

    public void setGifSource(InputStream inputStream) {
        movie = Movie.decodeStream(inputStream);
        requestLayout();
    }


    public void setGifSource(Bitmap bitmap) {
        try {
            movie = Movie.decodeStream(Bitmap2InputStream(bitmap ,100));
        } catch (Exception e) {
            e.printStackTrace();
        }
        requestLayout();
    }


    private InputStream Bitmap2InputStream(Bitmap bm, int quality) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        return is;
    }

    public void play() {
        if (this.mPaused) {
            this.mPaused = false;

            /**
             * Calculate new movie start time, so that it resumes from the same
             * frame.
             */
            mMovieStart = android.os.SystemClock.uptimeMillis() - mCurrentAnimationTime;

            invalidate();
        }
    }

    public void pause() {
        if (!this.mPaused) {
            this.mPaused = true;

            invalidate();
        }

    }


    public boolean isPaused() {
        return this.mPaused;
    }

    public boolean isPlaying() {
        return !this.mPaused;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (movie != null) {
            int movieWidth = movie.width();
            int movieHeight = movie.height();

			/*
             * Calculate horizontal scaling
			 */
            int measureModeWidth = MeasureSpec.getMode(widthMeasureSpec);

            if (measureModeWidth != MeasureSpec.UNSPECIFIED) {
                mMeasuredMovieWidth = getSize(widthMeasureSpec);
            }

			/*
             * calculate vertical scaling
			 */
            int measureModeHeight = MeasureSpec.getMode(heightMeasureSpec);

            if (measureModeHeight != MeasureSpec.UNSPECIFIED) {
                mMeasuredMovieHeight = MeasureSpec.getSize(heightMeasureSpec);
            }

            if(!isFullImageView && movieHeight != 0 && mMeasuredMovieHeight != 0) {
                int scaleMovie = movieWidth / movieHeight;
                mMeasuredMovieHeight = mMeasuredMovieWidth / scaleMovie;
            }
            if(measureModeWidth != MeasureSpec.UNSPECIFIED) {
                mScaleX = (float)mMeasuredMovieWidth  / (float)movieWidth ;
            }

            if(measureModeHeight != MeasureSpec.UNSPECIFIED) {
                mScaleY = (float) mMeasuredMovieHeight  / (float) movieHeight;
            }

            setMeasuredDimension(mMeasuredMovieWidth, mMeasuredMovieHeight);
        } else {
			/*
			 * No movie set, just set minimum available size.
			 */
            setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
		/*
		 * Calculate mLeft / mTop for drawing in center
		 */
        mLeft = (getWidth() - mMeasuredMovieWidth) / 2f;
        mTop = (getHeight() - mMeasuredMovieHeight) / 2f;

        mVisible = getVisibility() == View.VISIBLE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (movie != null) {
            if (!mPaused) {
                updateAnimationTime();
                drawMovieFrame(canvas);
                invalidateView();
            } else {
                drawMovieFrame(canvas);
            }
        }
    }

    /**
     * Invalidates view only if it is mVisible.
     * <br>
     * {@link #postInvalidateOnAnimation()} is used for Jelly Bean and higher.
     */
    private void invalidateView() {
        if (mVisible) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                postInvalidateOnAnimation();
            } else {
                invalidate();
            }
        }
    }

    /**
     * Calculate current animation time
     */
    private void updateAnimationTime() {
        long now = android.os.SystemClock.uptimeMillis();

        if (mMovieStart == 0) {
            mMovieStart = now;
        }

        int dur = movie.duration();
        int realDur = dur;
        if(dur < 1000) {
            dur = 1000;
        }

        if (dur == 0) {
            dur = DEFAULT_MOVIE_VIEW_DURATION;
        }

        if(isOnlyLoadOne && now - mMovieStart > dur) {
            pause();
            if(playOnceCallBack != null) {
                playOnceCallBack.playOver(this);
            }
            return;
        }

        mCurrentAnimationTime = (int) ((now - mMovieStart) * 1.0f  % dur * (realDur * 1.0f / dur));
    }

    /**
     * Draw current GIF frame
     */
    private void drawMovieFrame(Canvas canvas) {

        if(movie == null) {
            return;
        }

        movie.setTime(mCurrentAnimationTime);

        canvas.save(Canvas.MATRIX_SAVE_FLAG);
        canvas.scale(mScaleX, mScaleY);

        movie.draw(canvas, mLeft / mScaleX, mTop / mScaleY);

        canvas.restore();
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mVisible = screenState == SCREEN_STATE_ON;
        }else{
            mVisible = screenState == 1;
        }
        invalidateView();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == View.VISIBLE;
        invalidateView();
    }

    public boolean isOnlyLoadOne() {
        return isOnlyLoadOne;
    }

    public void setOnlyLoadOne(boolean onlyLoadOne) {
        isOnlyLoadOne = onlyLoadOne;
    }

    public boolean isFullImageView() {
        return isFullImageView;
    }

    public void setFullImageView(boolean fullImageView) {
        isFullImageView = fullImageView;
    }

    public interface IPlayOnceCallBack {
        void playOver(GifView gifView);
    }

    private IPlayOnceCallBack playOnceCallBack;
    public void setPlayOnceCallBack(IPlayOnceCallBack playOnceCallBack) {
        this.playOnceCallBack = playOnceCallBack;
    }

    public void release() {
        movie = null;
    }

    public boolean haveSource() {
        return movie != null;
    }
}