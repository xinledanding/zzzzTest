package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity2 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rich_web);


//                mRichWebView.setData("<img data-key=\"0\" src=\"http://fdfs.xmcdn" +
//                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_large.jpg\" alt=\"\" " +
//                        "data-origin=\"http://fdfs.xmcdn.com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628.jpg\" " +
//                        "data-large=\"http://fdfs.xmcdn" +
//                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_large.jpg\" " +
//                        "data-large-width=\"750\" data-large-height=\"5837\" data-preview=\"http://fdfs.xmcdn" +
//                        ".com/group21/M07/6E/4E/wKgJKFh1zWPw85jPAAb3YCeRvkY628_mobile_small.jpg\" " +
//                        "data-preview-width=\"140\" data-preview-height=\"1089\" /><br /><img data-key=\"1\" " +
//                        "src=\"http://fdfs.xmcdn.com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_large" +
//                        ".jpg\" alt=\"\" data-origin=\"http://fdfs.xmcdn" +
//                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667.jpg\" data-large=\"http://fdfs.xmcdn" +
//                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_large.jpg\" " +
//                        "data-large-width=\"750\" data-large-height=\"5891\" data-preview=\"http://fdfs.xmcdn" +
//                        ".com/group25/M02/6E/AD/wKgJNlh1zXbx2xVsAAfryNZNpgc667_mobile_small.jpg\" " +
//                        "data-preview-width=\"140\" data-preview-height=\"1099\" />...<span style=\"display:none\" " +
//                        "data-preview=\"true\"></span>");

        RichWebView mRichWebView1 = (RichWebView) findViewById(R.id.tv_rich_content_1);
        RichWebView mRichWebView2 = (RichWebView) findViewById(R.id.tv_rich_content_2);
        RichWebView mRichWebView3 = (RichWebView) findViewById(R.id.tv_rich_content_3);
        RichWebView  mRichWebView4 = (RichWebView) findViewById(R.id.tv_rich_content_4);
        RichWebView mRichWebView5 = (RichWebView) findViewById(R.id.tv_rich_content_5);
        RichWebView  mRichWebView6 = (RichWebView) findViewById(R.id.tv_rich_content_6);

//        setRichContentToWebView(mRichWebView1 , this ,"<p>《科学队长》是由饶毅、鲁白、谢宇三位世界级科学家创办的“知识分子”推出的科学教育产品。</p><p>最顶尖的科学家，最权威的知识，才能最正确地填满孩子的好奇心。加入科学队长，和孩子一起，听科学家讲科学。</p><br /><p>▲<b>致家长：</b></p><p>为什么苹果掉落，在科学家的眼里就是发现宇宙法则的契机，在普通人眼中却稀松平常呢？</p><p>因为思维方式不同，看待世界的角度和高度就不一样。</p><p>“科学队长”希望让我们的孩子在识事之初，就能站在科学家的肩膀上，培养他们像科学家一样看世界的眼光和思维，正确引导孩子追求真理的初心。</p><br /><p>▲<b>致孩子：</b></p><p>小朋友你好，我们即将开启一场神奇的旅程。</p><p>在这场勇敢者的探险中，你会找到别人找不到的秘密，还会认识很多有趣的新朋友。希望能满足你那总是冒出“为什么”的脑袋瓜。</p><p>相信你已经准备好了，和科学队长一起，开启这次奇妙旅程吧。旅途愉快！</p><br /><p>▲<b>大咖推荐</b>：</p><br /><p>在懵懵懂懂的孩子心中播下一颗科学的种子，让他们在成长的过程中对真理有追求的欲望，这是我们成人给孩子最好的礼物。</p><p><b>——北京大学教授、《知识分子》主编，饶毅</b></p><br /><p>让《科学队长》给孩子们塑造一种科学的人生态度，一种更理性的思维方式。我想，这是每个家庭都需要的。</p><p><b>——真格基金创始人，徐小平</b></p>");
//        setRichContentToWebView(mRichWebView2 , this ,"科学队长，科学家天团。<br/>朱进：北京天文馆馆长，带领项目组发现2728颗小行星；徐星：古生物学家，世界上命名恐龙最多的人；刘敏：长期漂泊海上的海洋生物学家；王立铭：生物学家，三十岁成为教授博导的超级奶爸。");
//        setRichContentToWebView(mRichWebView3 , this ,"<p>▲ 总爱问“为什么”的好奇宝宝。</p><p>▲ 珍惜孩子好奇心，理解思维方式重要性的爸爸妈妈。</p><p>▲ 每一个尚未泯灭探索欲和求知欲的你。</p>");
//        setRichContentToWebView(mRichWebView4 , this ,"<p>▲《科学队长》每周一至周四更新，全年共208期，定价299元。购买成功即可收听整张专辑全部节目内容。</p><p>▲在购买过程中，如果您有任何问题，可以在微信搜索公众号【xmlybest】或搜索【喜马拉雅付费精品服务号】来随时咨询问题，客服小伙伴会为您贴心解答。</p><p>▲如在充值/购买环节遇到问题，您可通过页面右上方按钮，将页面分享至微信内使用微信支付完成购买。购买成功后，请务必使用微信账号重新登录喜马拉雅FM，即可正常收听。</p>");
//        setRichContentToWebView(mRichWebView5 , this ,"<p>科学队长将不定期抽取和科学家线下见面的机会。</p><p>回答对节目末尾小问题，还有可能获得科学小礼品哦！</p>");
//        setRichContentToWebView(mRichWebView6 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");




        setRichContentToWebView(mRichWebView1 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
        setRichContentToWebView(mRichWebView2 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
        setRichContentToWebView(mRichWebView3 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
        setRichContentToWebView(mRichWebView4 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
        setRichContentToWebView(mRichWebView5 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
        setRichContentToWebView(mRichWebView6 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");




//        setRichContentToWebView(mRichWebView1 , this ,"<p>《科学队长》是由饶毅、鲁白、谢宇三位世界级科学家创办的“知识分子”推出的科学教育产品。</p><p>最顶尖的科学家，最权威的知识，才能最正确地填满孩子的好奇心。加入科学队长，和孩子一起，听科学家讲科学。</p><br /><p>▲<b>致家长：</b></p><p>为什么苹果掉落，在科学家的眼里就是发现宇宙法则的契机，在普通人眼中却稀松平常呢？</p><p>因为思维方式不同，看待世界的角度和高度就不一样。</p><p>“科学队长”希望让我们的孩子在识事之初，就能站在科学家的肩膀上，培养他们像科学家一样看世界的眼光和思维，正确引导孩子追求真理的初心。</p><br /><p>▲<b>致孩子：</b></p><p>小朋友你好，我们即将开启一场神奇的旅程。</p><p>在这场勇敢者的探险中，你会找到别人找不到的秘密，还会认识很多有趣的新朋友。希望能满足你那总是冒出“为什么”的脑袋瓜。</p><p>相信你已经准备好了，和科学队长一起，开启这次奇妙旅程吧。旅途愉快！</p><br /><p>▲<b>大咖推荐</b>：</p><br /><p>在懵懵懂懂的孩子心中播下一颗科学的种子，让他们在成长的过程中对真理有追求的欲望，这是我们成人给孩子最好的礼物。</p><p><b>——北京大学教授、《知识分子》主编，饶毅</b></p><br /><p>让《科学队长》给孩子们塑造一种科学的人生态度，一种更理性的思维方式。我想，这是每个家庭都需要的。</p><p><b>——真格基金创始人，徐小平</b></p>");
//        setRichContentToWebView(mRichWebView2 , this ,"科学队长，科学家天团。<br/>朱进：北京天文馆馆长，带领项目组发现2728颗小行星；徐星：古生物学家，世界上命名恐龙最多的人；刘敏：长期漂泊海上的海洋生物学家；王立铭：生物学家，三十岁成为教授博导的超级奶爸。");
//        setRichContentToWebView(mRichWebView3 , this ,"<p>▲ 总爱问“为什么”的好奇宝宝。</p><p>▲ 珍惜孩子好奇心，理解思维方式重要性的爸爸妈妈。</p><p>▲ 每一个尚未泯灭探索欲和求知欲的你。</p>");
//        setRichContentToWebView(mRichWebView4 , this ,"<p>▲《科学队长》每周一至周四更新，全年共208期，定价299元。购买成功即可收听整张专辑全部节目内容。</p><p>▲在购买过程中，如果您有任何问题，可以在微信搜索公众号【xmlybest】或搜索【喜马拉雅付费精品服务号】来随时咨询问题，客服小伙伴会为您贴心解答。</p><p>▲如在充值/购买环节遇到问题，您可通过页面右上方按钮，将页面分享至微信内使用微信支付完成购买。购买成功后，请务必使用微信账号重新登录喜马拉雅FM，即可正常收听。</p>");
//        setRichContentToWebView(mRichWebView5 , this ,"<p>科学队长将不定期抽取和科学家线下见面的机会。</p><p>回答对节目末尾小问题，还有可能获得科学小礼品哦！</p>");
//        setRichContentToWebView(mRichWebView6 , this ,"<span>吃得了法餐进得了大排档、背得起Fendi也穿得起帆布鞋的</span>氧气美少女罗希教你如何用最合适的钱买到最合适的东西：） <br />");
    }

    public static void setRichContentToWebView(final RichWebView tv, final Context context, String richContent) {
        RichWebView.RichWebViewAttr attr = new RichWebView.RichWebViewAttr();
        attr.fontSize = 14;
        attr.marginLeft = 0;
        attr.marginRight = 0;
        attr.color = "#666666";
        attr.lineHeight = 24;
        setRichContentToWebView(tv, context, richContent , attr);
    }

    public static void setRichContentToWebView(final RichWebView tv, final Context context, String richContent , RichWebView.RichWebViewAttr attr) {
        if (tv == null) return;
        if (context == null || richContent == null) {
            tv.setData("暂无内容" ,attr);
            return;
        }
        tv.setHorizontalScrollBarEnabled(false);
        tv.setVerticalScrollBarEnabled(false);

        tv.setData(richContent , attr);
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("奥斯卡的  == " + isFinishing());
    }
}
