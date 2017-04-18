package com.example.myapplication.danding;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

/**
 * Created by le.xin on 2017/2/23.
 */

public class HeheActivity extends Activity {

    public static final String ANIMATOR_PROPERTY_ALPHA = "alpha";
    private Context mContext;
    private ListView mListView;
    private View mView;
    private TextView mMoreText;

    private boolean isShowed;

    private Drawable recommendMoreDrawable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hehe);

        mMoreText = (TextView) findViewById(R.id.tv_more);
        recommendMoreDrawable = ContextCompat.getDrawable(this , R.drawable.main_recommend_more);
        int top = -dp2px(this ,2);
        recommendMoreDrawable.setBounds(0, top, recommendMoreDrawable.getMinimumWidth(), recommendMoreDrawable.getMinimumHeight() + top);
        mMoreText.setCompoundDrawables(null , null ,recommendMoreDrawable ,null);

        mContext = this;

        mListView = (ListView) findViewById(R.id.listview);

        final ArrayList<String> arrayList = new ArrayList<String>() {
            {
                add("淡定");
            }
        };
        for (int i = 0; i < 1000; i++) {
            arrayList.add("淡定" + i);
        }
        mListView.setAdapter(new ArrayAdapter<String>(this ,android.R.layout.simple_expandable_list_item_1 , android.R.id.text1 , arrayList));

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(lastObjectAnimator != null) {
                    lastObjectAnimator.cancel();
                }

                System.out.println("danding  ===  " + (scrollState == SCROLL_STATE_IDLE));
                if(scrollState == SCROLL_STATE_IDLE) {
                    lastObjectAnimator = startAlphaObjectAnimator(mView, 300 ,mView.getAlpha() , 1.0f);
                } else {
                    lastObjectAnimator = startAlphaObjectAnimator(mView, 500 ,mView.getAlpha(), 0.6f);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        mView = findViewById(R.id.view);

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View viewById = findViewById(R.id.lineaLayout);
                viewById.setBackgroundResource(R.drawable.bg_album_batch_downloaded_selector);
            }
        });

        View viewById = findViewById(R.id.lineaLayout);
        viewById.setBackgroundResource(R.drawable.bg_album_batch_downloaded_selector);
    }

    private ObjectAnimator lastObjectAnimator;

    public static final ObjectAnimator startAlphaObjectAnimator(View target, long duration, float... values) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(target, ANIMATOR_PROPERTY_ALPHA, values);
        objectAnimator.setDuration(duration);
        objectAnimator.start();
        return objectAnimator;
    }



    private View getView() {
        return findViewById(R.id.constraint);
    }

    public static int dp2px(Context context, float dipValue) {
        if (context == null)
            return 0;
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("HeheActivity.onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("HeheActivity.onResume");
    }
}
