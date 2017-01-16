package com.example.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        final View viewById1 = findViewById(R.id.custom);
//        viewById1.setDrawingCacheEnabled(true);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap drawingCache = viewById1.getDrawingCache();

            }
        });

        CountDownTimer countDownTimer = new CountDownTimer(1000 , 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };


        Bitmap drawingCache = getViewBitmap(viewById1 , 100 , 100);
        ImageView viewById2 = (ImageView) findViewById(R.id.image);
        viewById2.setImageBitmap(drawingCache);

        RichWebView viewById = (RichWebView) findViewById(R.id.webview);
        viewById.setData("宝宝们好，我是罗希<br />又到了每周的喜马拉雅 时间<br />你们知道生活法则 吗？ 你们知道<br " +
                "/>如何才能让2016的庸碌不再延续到2017吗？<br />制定属于自己的生活法则！<br />它是一种心理暗示&行为规划，是向生活呐喊的决心！ <br /><br " +
                "/><strong>【日常生活篇】</strong><br />在2017年里，养成定期整理房间、熨衬衫、养植物 的生活习惯。这些小习惯听上去微不足道，但是却能给内心大大的抚慰。<br " +
                "/><p>其实在过去一年里，我总觉得自己过得特别赶，有时一天内都要跑好几个城市，待在家里的时间特别少，所以我家里都乱得下不去脚了（我也不怕丢人告诉大家）<span " +
                "style=\"line-height:1.5;\">我要在今年逼迫自己，就算再忙碌也打扫自己的房间，做一点生活上</span><span style=\"line-height:1.5;" +
                "\">的小改变。</span></p>前两天我在外卖APP上做了一个小测试，我发现2016年我居然一共点了两百多次外卖！（还不包括别人给我点的）<br " +
                "/>O！M！G！原来自己这一年里吃了这么多顿快餐，哎，真不知道自己吃了多少地沟油和味精啊（心疼自己3秒钟），把我拍扁了就是一张元素周期表吧……<br " +
                "/>所以，我就下定决心今年一定要多下厨房，多动手做饭！作为一个对外表有要求的女纸，我发4！<br " +
                "/>就算觉得自己还能吃下半碗饭，也要果断地离开餐桌！这是我这么多年来一直努力想要达到的高度，但是一直都没成功过……好吧，新的一年里，我一定要做到适可而止！<br " +
                "/>这条稍微有点变态，我要在新一年里去测试一下自己对于“辣”的忍耐度。<br /><a href=\"iting://blog.csdn.net/qq_33923079/article/details/52969420\">查看更改</a> <br " +
                "/>其实每个人的味蕾都是有一块盲区的，有些人特别不爱吃辣，有些人特别受不了吃苦，但是我认为越是受不了的，就越要去突破、挑战自己。<br " +
                "/>酸甜苦辣不可偏废，特别是以前没有吃过的菜式都要去勇敢地尝试一下！比如我吧，我一定要再去挑战一下重庆成都的火锅（老板，给我来一锅变态辣！）<br " +
                "/>养成每年体检1~2次的习惯，不管工作有多忙，都一定要抽出一天，去医院做一个全身的全面检查。如果你还没买保险，就一定去买一份大病险、人身险，比如我，要给自己买一份全球医疗保险（但其实我还不知道怎么买呢，有哪位宝宝是这方面的专家赶紧教教我呗）<br />因为你永远不知道明天和意外哪个先来。过去一年生活给了我一个小教训<br />去年我在出租车上丢了手机，发现手机丢了后打电话过去已经被关机<br />了，破财不说，最难过的是手机里有好多照片和个人信息啊！<br />大家给花式丢手机的行为找了个理由，叫做水逆，但是倒霉的麻烦的也是是自己啊~~~<br />所以，新的一年我要学会数据备份，如果是IPHONE用户的话，同时还要去设置Find My Iphone，如果不知道该怎么设置，就耐心点，花个十几分钟学习一下。<br /><br /><strong>【消费篇】</strong><br />相信很多人和我一样，过去一年没少买东西，买的东西多，实用的却很少，到现在我家里还囤着一堆没拆封的东东呢，新的一年买东西也需要规划规划。<br />好几年前，我就给自己指定了一条法则，千万别再因为便宜而乱买东西了，少买打折货，我们常说的“一分钱，一分货”并不是没有道理。囤在那里根本用不到，里外里亏得比别人还多呢当你觉得生活没意思，或是工作压力特别大想辞职不干的时候，就去商场买一点自己喜欢的东西，最好是能够稍微让自己心疼一下钱包，比平时心理承受价位高出百分之三十左右的东西，买完之后，你就能乖乖地投入到工作中去了。<br />每个月拿出薪水的一部分完成清单上的一个小心愿，如果那个月你的奖金特别多，就可以多买一点，这样积累下来的成就感会让你觉得特别满足、会觉得自己特别独立在自己可承受范围内，买几套贵的衣服，要品牌的、时尚的、看起来上档次的。<br />长大一岁了，不能再停留于淘便宜货穿咯。衣服在于精致，不在于多。我一直是这么要求自己哒。<br />譬如，尝试去买一副别人也许看不懂，但自己非常喜欢的油画，或者是买一块你钟意很久的地毯，一张品质极佳的沙发，花钱是为了让自己的内心有所享受，而不是买给别人看的，或者给父母买一张电动按摩椅，你的小小举动都会让父母感到特别暖心。<br /><br /><strong>【相处之道篇】</strong><br /><strong>----和父母</strong><br />养成每天给父母发一条短信，一周至少通一次电话的习惯，要坚持，不要用“忙”给自己的疏忽找借口。记住父母的生日，就像他们永远都牢记着你的生日一样。虽然现在我们看电影已经是家常便饭了，可是你是否和自己的父母去看过电影呢？<br />其实父母很少会掏钱买一张电影票的，更别提3D电影了！<br />所以大家带老人家去感受一次吧，时间不等人呐，赶紧把想法变成行动吧！别再说下次再去这种话啦！<br /><br /><p><strong>---和朋友</strong></p><p>过了二十五岁以后，生活就会慢慢给我们做减法，身边的好朋友会慢<span style=\"line-height:1.5;\">慢变少，但正因为变少，也就越显得珍贵了，越值得我们去好好经营</span><span style=\"line-height:1.5;\">。</span></p>这个时代，“宝贝”、“么么哒”都成为社交辞令了，不管认不认识，就是一句“亲爱的”（我们很熟吗？我们认识吗？）<br />朋友在于精不在于多，大家相处的时候多一点真心少一点套路，多一点付出少一点计较，你也可以数一数自己身边有几个真正值得信赖的好朋呢？<br /><br /><strong>---和爱人</strong><br />情感的稳定，是每个人好好工作学习的护城河。<br />一个感情不稳定，天天恍惚折腾的人，还有多少精力可以做好事情？爱情的状况形形色色，每个人的爱情都能写成一部小说，但是，总的一句，不要作！珍惜眼前人。<br />但是如果你的爱情非常不顺，那么我要苦口婆心给你说几条法则啦！如果一段感情结束了，姑娘们一定要控制自己，别在喝醉后给前任发微信。很多人在爱情里，都是跪着把自己感动了。何必呢，对方根本不在乎。而你在乎的其实并不是有多爱他，而是你爱上了爱情里苦苦受虐的自己。<br />无论你晚上夺么自怨自艾，无论你昨晚流下了几公升眼泪，只要早晨的闹钟一响，你就要认真地打扮自己，美美地出门。要把自己变得更好，才会有更好的人来爱你。<br />你这么美，说什么都是对的，你这么聪明，做什么我都同意<br />男人就是这么现实！<br />2017年每个人的生活和目标都是不一样的。<br />但是开年的时候给自己列一些生活法则嘛，这样才能在2017年撸起袖子加油干呐！以上这些生活法则，是我粗粗列举的，有一些适用于我，但有一些也是说给大家听的。<br />但是不知道你们有木有给自己列一些生活法则呢？<br />等到2017年12月31号的时候，不妨回头看一看，当初写下的这些，你实现了多少呢？希望每个人的2017年都是顺心快乐的，但是最后还有一条压箱底的法则，万一你碰到了什么不顺心的事情，都要学会耸耸肩，捱过去，没什么大不了的。<br /><br />人生就是需要奋斗的，如果你连苦都吃不起，你投胎做人干嘛呢？<br />去做大熊猫啊！<br />更何况，大熊猫也有烦恼啊她的夜晚没有快乐（嘿嘿嘿~~~）<br />新一年，我们一起躁起来！<br />");

        viewById.setURLClickListener(new RichWebView.URLClickListener() {
            @Override
            public boolean urlClick(String url) {
                return true;
            }
        });

    }

    /**
     * 把View绘制到Bitmap上
     * @param view 需要绘制的View
     * @param width 该View的宽度
     * @param height 该View的高度
     * @return 返回Bitmap对象
     * add by csj 13-11-6
     */
    public Bitmap getViewBitmap(View comBitmap, int width, int height) {
        Bitmap bitmap = null;
        if (comBitmap != null) {
            comBitmap.clearFocus();
            comBitmap.setPressed(false);

            boolean willNotCache = comBitmap.willNotCacheDrawing();
            comBitmap.setWillNotCacheDrawing(false);

            // Reset the drawing cache background color to fully transparent
            // for the duration of this operation
            int color = comBitmap.getDrawingCacheBackgroundColor();
            comBitmap.setDrawingCacheBackgroundColor(0);
            float alpha = comBitmap.getAlpha();
            comBitmap.setAlpha(1.0f);

            if (color != 0) {
                comBitmap.destroyDrawingCache();
            }

            int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
            comBitmap.measure(widthSpec, heightSpec);
            comBitmap.layout(0, 0, width, height);

            comBitmap.buildDrawingCache();
            Bitmap cacheBitmap = comBitmap.getDrawingCache();
            if (cacheBitmap == null) {
                Log.e("view.ProcessImageToBlur", "failed getViewBitmap(" + comBitmap + ")",
                        new RuntimeException());
                return null;
            }
            bitmap = Bitmap.createBitmap(cacheBitmap);
            // Restore the view
            comBitmap.setAlpha(alpha);
            comBitmap.destroyDrawingCache();
            comBitmap.setWillNotCacheDrawing(willNotCache);
            comBitmap.setDrawingCacheBackgroundColor(color);
        }
        return bitmap;
    }
}
