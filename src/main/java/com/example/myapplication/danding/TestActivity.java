package com.example.myapplication.danding;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.FlutterFlakeView;
import com.example.myapplication.R;


/**
 * Created by le.xin on 2017/1/15.
 */

public class TestActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_lay);

        final FlutterFlakeView view = (FlutterFlakeView) findViewById(R.id.flutter);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setRepeatCount(1);
                view.setFlutterItems(BitmapFactory.decodeResource(getResources() , R.drawable.ic_launcher) ,20);
                view.start();
            }
        });
        view.setRepeatCount(1);
        view.setFlutterItems(BitmapFactory.decodeResource(getResources() , R.drawable.ic_launcher) ,8);
        view.start();
        view.setItemClick(new FlutterFlakeView.FlutterItemClick() {
            @Override
            public boolean onClick(FlutterFlakeView.FlutterItem item) {
                Toast.makeText(TestActivity.this, "item被点击了"+item.hashCode(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
