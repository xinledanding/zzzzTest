package com.example.myapplication.danding;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;
import com.example.myapplication.SpiralProgressView;

/**
 * Created by le.xin on 2017/2/21.
 */

public class TestProgressActivity extends Activity {
    private SpiralProgressView progressView1;
    private int currentCount = 0;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_pro);

        progressView1 = (SpiralProgressView) findViewById(R.id.spring_progress_view2);
        SpiralProgressView.ProgressAttrs attrs = new SpiralProgressView.ProgressAttrs(TestProgressActivity
                .this);

        progressView1.setProgressAttrs(attrs);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressView1.setProgress(currentCount);

                SpiralProgressView.ProgressAttrs attrs = new SpiralProgressView.ProgressAttrs(TestProgressActivity
                        .this);
                attrs.mMax = 1000;
                attrs.mProgress = 500;
                attrs.mBackgroudColor = Color.BLUE;
                attrs.mLineColor = Color.GREEN;
                progressView1.setProgressAttrs(attrs);

                currentCount += 10;
                mHandler.postDelayed(this , 100);
            }
        } , 1000);
    }
}
