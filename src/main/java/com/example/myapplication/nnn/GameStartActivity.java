package com.example.myapplication.nnn;

import android.app.Activity;
import android.os.Bundle;

public class GameStartActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 默认是加载XML配置文件，显示的也是XML文件中的视图组件
        //setContentView(R.layout.main);
        
        //我们需要显示自定义的View,只需要将XML文件换成自定义的View对象就可以了，如下：
        //GameView gameView = new GameView(this);
        //setContentView(gameView); 
        
        GameSFView gamesfView = new GameSFView(this);
        setContentView(gamesfView); 
     
    }
}