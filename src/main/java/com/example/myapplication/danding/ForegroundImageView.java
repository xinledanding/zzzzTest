package com.example.myapplication.danding;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ForegroundImageView extends ImageView {
    private final int mArrowYSide;
    private final int mArrowXSide;
    private final int mArrowYOffset;
    private final Paint mStrokePaint;
    private Drawable foreground;
    private int mRadius;
    private boolean mIsRight = true;

    public ForegroundImageView(Context context) {
    this(context, null);
  }

  public ForegroundImageView(Context context, AttributeSet attrs) {
    super(context, attrs);

      mPath = new Path();
      mRect = new RectF();
      mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
      mStrokePaint.setStyle(Paint.Style.STROKE);
      mStrokePaint.setStrokeWidth(1);
      mStrokePaint.setColor(Color.parseColor("#d8d8d8"));
      mRadius = dp2px(getContext(), 4);
      mArrowYOffset = dp2px(getContext(), 7);
      mArrowYSide = dp2px(getContext(), 4);
      mArrowXSide = dp2px(getContext(), 5);
  }

    public static int dp2px(Context context, float dipValue)
    {
        if(context==null)
            return 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public void setArrowIsRight(boolean isRight) {
        mIsRight = isRight;
    }
  /**
   * Supply a drawable resource that is to be rendered on top of all of the child
   * views in the frame layout.
   *
   * @param drawableResId The drawable resource to be drawn on top of the children.
   */
  public void setForegroundResource(int drawableResId) {
    setForeground(getContext().getResources().getDrawable(drawableResId));
  }

  /**
   * Supply a Drawable that is to be rendered on top of all of the child
   * views in the frame layout.
   *
   * @param drawable The Drawable to be drawn on top of the children.
   */
  public void setForeground(Drawable drawable) {
    if (foreground == drawable) {
      return;
    }
    if (foreground != null) {
      foreground.setCallback(null);
      unscheduleDrawable(foreground);
    }

    foreground = drawable;

    if (drawable != null) {
      drawable.setCallback(this);
      if (drawable.isStateful()) {
        drawable.setState(getDrawableState());
      }
    }
    requestLayout();
    invalidate();
  }

  @Override protected boolean verifyDrawable(Drawable who) {
    return super.verifyDrawable(who) || who == foreground;
  }

  @Override public void jumpDrawablesToCurrentState() {
    super.jumpDrawablesToCurrentState();
    if (foreground != null) foreground.jumpToCurrentState();
  }

  @Override protected void drawableStateChanged() {
    super.drawableStateChanged();
    if (foreground != null && foreground.isStateful()) {
      foreground.setState(getDrawableState());
    }
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      mPath.reset();
      if (mIsRight) {
          mRect.left = 1;
          mRect.top = 1;
          mRect.right = getMeasuredWidth() - mArrowXSide;
          mRect.bottom = getMeasuredHeight() - 1;

          mPath.addRoundRect(mRect, mRadius, mRadius, Path.Direction.CCW);

//          mPath.addArc(0, 0, mRadius, mRadius, -180f, 90f);
//          mPath.addArc(mRect.right - mRadius, 0, mRect.right, mRadius, -90, 90);
//          mPath.addArc(mRect.right - mRadius, mRect.bottom - mRadius, mRect.right, mRect.bottom, 0, 90);
//          mPath.addArc(0, mRect.bottom - mRadius, mRadius, mRect.bottom, 90, 90);
//
//          mPath.moveTo(mRadius, 0);
//          mPath.lineTo(mRect.right - mRadius, 0);
//          mPath.moveTo(mRect.right, mRadius);
//          mPath.lineTo(mRect.right, mArrowYOffset);

          mPath.moveTo(mRect.right, mArrowYOffset);
          mPath.lineTo(getMeasuredWidth(), mArrowYOffset + mArrowYSide);
          mPath.lineTo(mRect.right, mArrowYOffset + mArrowYSide + mArrowYSide);

//          mPath.moveTo(mRect.right, mArrowYOffset + 2 * mArrowYSide);
//          mPath.lineTo(mRect.right, mRect.bottom - mRadius);
//          mPath.lineTo(mRadius, mRect.bottom);
//          mPath.moveTo(0, mRect.bottom - mRadius);
//          mPath.lineTo(0, mRadius);


//          mPath.op(mReversePath, Path.Op.REVERSE_DIFFERENCE);
      } else {
          mRect.left = mArrowXSide;
          mRect.top = 1;
          mRect.right = getMeasuredWidth() - 1;
          mRect.bottom = getMeasuredHeight() - 1;

          mPath.addRoundRect(mRect, mRadius, mRadius, Path.Direction.CCW);
          mPath.moveTo(mArrowXSide, mArrowYOffset);
          mPath.lineTo(0, mArrowYOffset + mArrowYSide);
          mPath.lineTo(mArrowXSide, mArrowYOffset + mArrowYSide + mArrowYSide);
      }
      mPath.close();

    if (foreground != null) {
      foreground.setBounds(getPaddingLeft(), getPaddingTop(),
              getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
      invalidate();
    }
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    if (foreground != null) {
      foreground.setBounds(getPaddingLeft(), getPaddingTop(), w - getPaddingRight(), h - getPaddingBottom());
      invalidate();
    }
  }

  @Override public void draw(Canvas canvas) {
      //canvas.drawPath(mPath, mStrokePaint);
      int count = canvas.saveLayer(0, 0, getWidth(), getHeight(), null,
              Canvas.MATRIX_SAVE_FLAG |
                      Canvas.CLIP_SAVE_FLAG |
                      Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                      Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                      Canvas.CLIP_TO_LAYER_SAVE_FLAG);


    super.draw(canvas);

      if (foreground != null) {
          foreground.draw(canvas);
      }
      if (Build.VERSION.SDK_INT >= 14) {
          mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          canvas.drawPath(mPath, mPaint);

//          paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
//          canvas.drawPath(mReversePath, paint);
      } else {
          int width = getMeasuredWidth();
          int height = getMeasuredHeight();

          Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

          (new Canvas(bitmap)).drawPath(mPath, mPaint);

          mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          canvas.drawBitmap(bitmap, 0, 0, mPaint);

          mPaint.setXfermode(null);
      }

      canvas.restoreToCount(count);
//      canvas.drawPath(mPath, mStrokePaint);
//      PathShape shape = new PathShape(mPath, getWidth(), getHeight());
//      shape.draw(canvas, mStrokePaint);


  }

//    Paint paint = new Paint();
    /*@Override
    protected void onDraw(Canvas canvas) {
//        canvas.setDrawFilter(pdf);
        canvas.drawColor(Color.TRANSPARENT);
        super.onDraw(canvas);
        makePath();
//        Bitmap bitmap = null;
//        Drawable drawable = getDrawable();
//        if (drawable instanceof BitmapDrawable) {
//            bitmap = ((BitmapDrawable) drawable).getBitmap();
//            final Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//            mPaint.setShader(shader);
//            canvas.drawPath(mPath, mPaint);
//        }

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawPath(mPath, mPaint);
//        canvas.clipPath(mPath);

    }*/

    private Path mPath;
    private Paint mPaint;
    private RectF mRect;

}
