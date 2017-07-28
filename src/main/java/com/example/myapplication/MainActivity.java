package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {

    private boolean isOk = false;
    private Xi mXi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXi=new Xi();
                mXi.setX(new ximalaya() {
                    @Override
                    public void test() {
                        System.out.println("阿克苏达开始");
                    }
                });

            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXi.getX().test();
            }
        });

    }
    private TextView adTip;
    private RelativeLayout adTipLayout;


    /**
     * 显示广告tips
     * @param content
     */
    private void showAdTips(final CharSequence content ,boolean useAnimation) {
        if(adTip == null) {
            adTipLayout = new RelativeLayout(MainActivity.this);
            setAdTipLayoutParam();

            adTip = new TextView(MainActivity.this);
            adTip.setBackgroundResource(R.drawable.main_ad_tip_bg);
            adTip.setTextColor(ContextCompat.getColor(MainActivity.this ,android.R.color.white));
            adTip.setTextSize(14);
            adTip.setMaxLines(1);
            adTip.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            RelativeLayout.LayoutParams layoutTitleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
            adTip.setLayoutParams(layoutTitleParams);
            adTipLayout.addView(adTip);
            ((ViewGroup)findViewById(R.id.main_rela_layout)).addView(adTipLayout);
        } else {
            setAdTipLayoutParam();
        }

        adTip.setVisibility(View.VISIBLE);

        ViewGroup.LayoutParams layoutParams1 = adTip.getLayoutParams();
        layoutParams1.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        adTip.setLayoutParams(layoutParams1);
        adTip.setText(content);
        adTip.invalidate();

        adTip.measure(0 ,0);
        System.out.println("阿看那看 ===  " + adTip.getMeasuredWidth());

        adTipLayout.measure(0 , 0);
        int layoutMeasureWidth = adTipLayout.getMeasuredWidth();

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) adTip.getLayoutParams();
        layoutParams.leftMargin = (layoutMeasureWidth - adTip.getMeasuredWidth()) / 2;

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(adTip ,"width" , 0 ,adTip.getMeasuredWidth());
        objectAnimator.start();
    }

//    private void hideAdTips() {
//        if(adTip != null && adTip.getVisibility() == View.VISIBLE) {
//            if(adTip.getText() != null) {
//                final int width = adTip.getWidth();
//                ObjectAnimator objectAnimator = ObjectAnimator.ofInt(adTip ,"width" , width,0);
//                objectAnimator.setDuration(500);
//                objectAnimator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        super.onAnimationEnd(animation);
//                        adTip.setVisibility(View.INVISIBLE);
//                    }
//                });
//                objectAnimator.start();
//            } else {
//                adTip.setVisibility(View.INVISIBLE);
//            }
//        }
//    }

    private void hideAdTips() {
        if(adTip != null && adTip.getVisibility() == View.VISIBLE) {
            if(adTip.getText() != null) {
                final String text = adTip.getText().toString();
                ValueAnimator animator = ValueAnimator.ofInt(text.length() , 1);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if(valueAnimator.getAnimatedValue() != null) {
                            Integer animatedValue = (Integer) valueAnimator.getAnimatedValue();
                            if(animatedValue <= 1) {
                                adTip.setVisibility(View.INVISIBLE);
                            } else {
                                adTip.setText(text.substring(0 , animatedValue));
                            }
                        }
                    }
                });
                animator.setDuration(500);
                animator.start();
            } else {
                adTip.setVisibility(View.INVISIBLE);
            }
        }
    }


    private void setAdTipLayoutParam() {
        if(adTipLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.topMargin = 500;
            adTipLayout.setLayoutParams(layoutParams);
        }
    }

    private CharSequence getShowAdTipContent(long time) {
        String str1 = time / 1000 + "s | 去除广告声音 ";
        String str2 = "t";

        SpannableString msp = new SpannableString(str1 + str2);
        Drawable drawable = ContextCompat.getDrawable(MainActivity.this ,R.drawable.main_player_vipad_arrow);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        //居中对齐imageSpan
        CenterAlignImageSpan imageSpan = new CenterAlignImageSpan(drawable);
        msp.setSpan(imageSpan, str1.length(), str2.length() + str1.length() , ImageSpan.ALIGN_BASELINE);

        return msp;
    }

    public class CenterAlignImageSpan extends ImageSpan {

        public CenterAlignImageSpan(Drawable drawable) {
            super(drawable);

        }

        public CenterAlignImageSpan(Bitmap b) {
            super(b);
        }

        @Override
        public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom,
                         @NonNull Paint paint) {

            Drawable b = getDrawable();
            Paint.FontMetricsInt fm = paint.getFontMetricsInt();
            int transY = (y + fm.descent + y + fm.ascent) / 2 - b.getBounds().bottom / 2;//计算y方向的位移
            canvas.save();
            canvas.translate(x, transY);//绘制图片位移一段距离
            b.draw(canvas);
            canvas.restore();
        }
    }

    public static int dp2px(Context context, float dipValue)
    {
        if(context==null)
            return (int) (dipValue * 1.5);
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


}