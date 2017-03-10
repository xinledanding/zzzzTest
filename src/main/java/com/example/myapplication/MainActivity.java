package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {

    private RichWebView mRichWebView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        mRichWebView1 = (RichWebView) findViewById(R.id.web_view1);
//        mRichWebView1.setData("<p style=\"font-size:16px;line-height:28px;margin:20px 0px;" +
//                "color:#333333\"><span style=\"font-size:16px;line-height:28px;color:#333333\"><span " +
//                "style=\"font-size:16px;line-height:28px;color:#333333\"><strong data-flag=\"strong\" " +
//                "style=\"font-size:16px;color:#FC5832;line-height:28px;" +
//                "font-weight:normal\">（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）</strong></span></span></p><span " +
//                "style=\"font-size:16px;line-height:28px;color:#333333\"></span><p style=\"font-size:16px;" +
//                "line-height:28px;margin:20px 0px;color:#333333\"><span style=\"font-size:16px;line-height:28px;" +
//                "color:#333333\">专辑内容：</span></p><p style=\"font-size:16px;line-height:28px;margin:20px 0px;" +
//                "color:#333333\">2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：</p><p style=\"font-size:16px;line-height:28px;" +
//                "margin:20px 0px;color:#333333\">年底总结汇报怎么做？</p><p style=\"font-size:16px;line-height:28px;margin:20px" +
//                " 0px;color:#333333\">新的一年想涨涨工资，怎么向老板开口提？</p><p style=\"font-size:16px;line-height:28px;margin:20px " +
//                "0px;color:#333333\">老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？</p><p style=\"font-size:16px;line-height:28px;" +
//                "margin:20px 0px;color:#333333\">……</p><p style=\"font-size:16px;line-height:28px;margin:20px 0px;" +
//                "color:#333333\">《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！</p><span style=\"font-size:16px;" +
//                "line-height:28px;color:#333333\"></span><p style=\"font-size:16px;line-height:28px;margin:20px 0px;" +
//                "color:#333333\"><span style=\"font-size:16px;line-height:28px;" +
//                "color:#333333\">精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。</span></p>");

        final String richStr = "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t简介\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p>\n" +
                "\t<strong style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t年底总结汇报怎么做？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;line-height:28px;margin:20px 0px;color:#333333\">\n" +
                "\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>\n" +
                "<div id=\"rich_album_header\">\n" +
                "</div>\n" +
                "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t主讲人\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t年底总结汇报怎么做？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "</p>\n" +
                "<p >\n" +
                "\t<strong style=\"font-size:16px;color:#333333;\">\n" +
                "\t\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>\n" +
                "<div id=\"rich_album_header\">\n" +
                "</div>\n" +
                "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t适合谁听\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t年底总结汇报怎么做？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t<strong>\n" +
                "\t\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>\n" +
                "<div id=\"rich_album_header\">\n" +
                "</div>\n" +
                "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t你将获得\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t年底总结汇报怎么做？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t<strong>\n" +
                "\t\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>\n" +
                "<div id=\"rich_album_header\">\n" +
                "</div>\n" +
                "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t购买须知\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t年底总结汇报怎么做？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t<strong>\n" +
                "\t\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>\n" +
                "<div id=\"rich_album_header\">\n" +
                "</div>\n" +
                "<div class=\"rich_album_wrapper\">\n" +
                "\t<div class=\"rich_album_tit-con\">\n" +
                "\t\t<span class=\"rich_album_title\">\n" +
                "\t\t\t其他说明\n" +
                "\t\t</span>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t（本专辑五期音频均出自《好好说话》往期节目，切勿重复购买！）\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t专辑内容：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t2016年即将接近尾声，在职场打拼的你是否也需要面临以下情景：\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t<strong>\n" +
                "\t\t年底总结汇报怎么做？\n" +
                "\t</strong>\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t新的一年想涨涨工资，怎么向老板开口提？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t老板赶进度冲业绩，不合理的工作扔向你，该怎么拒绝？\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t……\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t《好好说话》精选专辑统统为你解决，让你在新的一年全面提升，升职加薪，走上人生巅峰！\n" +
                "</p>\n" +
                "<p style=\"font-size:16px;color:#333333;\">\n" +
                "\t精选《好好说话》中关于职场的五期话题，对职场中常见的说话场景进行全方位解析，让你了解职场秘密，成功在激烈的职场竞争抢得先机。\n" +
                "</p>\n" +
                "<div id=\"rich_album_bottom\">\n" +
                "</div>";


        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(richStr);
            }
        });

        mRichWebView1.setData(richStr);
    }


}