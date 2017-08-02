package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.net.InetSocketAddress;

/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(new Runnable() {
                    public void run() {
                        System.out.println("看看1");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("看看2");
                    }
                });
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("看看");
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long time= System.currentTimeMillis();
                        new InetSocketAddress("ximalaya.gzproxy.10155.com", 8080);
                        System.out.println("时间是   =  " + (System.currentTimeMillis() - time));
                    }
                }).start();

            }
        });

    }

}