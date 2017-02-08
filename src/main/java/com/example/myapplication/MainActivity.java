package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.List;


/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {

    private RichWebView mRichWebView1;
    private RichWebView mRichWebView2;
    private RichWebView mRichWebView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mRichWebView1 = (RichWebView) findViewById(R.id.web_view1);
        mRichWebView2 = (RichWebView) findViewById(R.id.web_view2);
        mRichWebView3 = (RichWebView) findViewById(R.id.web_view3);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRichWebView1.setData("<img data-key=\"0\" src=\"http://fdfs.xmcdn" +
                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_large.jpg\" alt=\"\" " +
                        "data-origin=\"http://fdfs.xmcdn.com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628.jpg\" " +
                        "data-large=\"http://fdfs.xmcdn" +
                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_large.jpg\" " +
                        "data-large-width=\"750\" data-large-height=\"5837\" data-preview=\"http://fdfs.xmcdn" +
                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_small.jpg\" " +
                        "data-preview-width=\"140\" data-preview-height=\"1089\" " +
                        "/><p><b>喜欢我的：</b></p><p><b>小姿专属会员适合每一个爱我的你，和未来会爱上我的你</b></p><br " +
                        "/><p><b>恋爱中的：</b></p><p><b>情感生活出现各种迷茫困惑的</b><b>女生&男生</b></p><br " +
                        "/><p><b>单身中的：</b></p><p><b>有真诚交友需求的单身女生&男生</b></p><br " +
                        "/><strong>*（此专辑为小姿粉丝的专属VIP会员的特别福利专辑）</strong><br /><p><u>快来一起参与情感互动解密吧！</u></p>" +
                        "<br /><img data-key=\"1\" " +
                        "src=\"http://fdfs.xmcdn.com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_large" +
                        ".jpg\" alt=\"\" data-origin=\"http://fdfs.xmcdn" +
                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667.jpg\" data-large=\"http://fdfs.xmcdn" +
                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_large.jpg\" " +
                        "data-large-width=\"750\" data-large-height=\"5891\" data-preview=\"http://fdfs.xmcdn" +
                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_small.jpg\" " +
                        "data-preview-width=\"140\" data-preview-height=\"1099\" />...<span style=\"display:none\" " +
                        "data-preview=\"true\"></span>");
            }
        });

        mRichWebView1.setData("<p><b>喜欢我的：</b></p><p><b>小姿专属会员适合每一个爱我的你，和未来会爱上我的你</b></p><br " +
                "/><p><b>恋爱中的：</b></p><p><b>情感生活出现各种迷茫困惑的</b><b>女生&男生</b></p><br " +
                "/><p><b>单身中的：</b></p><p><b>有真诚交友需求的单身女生&男生</b></p><br " +
                "/><strong>*（此专辑为小姿粉丝的专属VIP会员的特别福利专辑）</strong><br /><p><u>快来一起参与情感互动解密吧！</u></p>");
        mRichWebView1.setOnImageClick(new RichWebView.IOnImageClick() {
            @Override
            public void onClick(List<String> imgs, int index) {
                System.out.println("看看  ===  " + imgs);
            }
        });

        mRichWebView2.setData("<p><b>喜欢我的：</b></p><p><b>小姿专属会员适合每一个爱我的你，和未来会爱上我的你</b></p><br " +
                "/><p><b>恋爱中的：</b></p><p><b>情感生活出现各种迷茫困惑的</b><b>女生&男生</b></p><br " +
                "/><p><b>单身中的：</b></p><p><b>有真诚交友需求的单身女生&男生</b></p><br " +
                "/><strong>*（此专辑为小姿粉丝的专属VIP会员的特别福利专辑）</strong><br /><p><u>快来一起参与情感互动解密吧！</u></p>");
        mRichWebView3.setData("<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
    }


    @Override
    public void onPause() {
        super.onPause();
        mRichWebView1.onPause();
        mRichWebView2.onPause();
        mRichWebView3.onPause();
    }

    /**
     * Called when the fragment is no longer resumed. Pauses the WebView.
     */
    @Override
    public void onResume() {
        mRichWebView1.onResume();
        mRichWebView2.onResume();
        mRichWebView3.onResume();
        super.onResume();
    }


}