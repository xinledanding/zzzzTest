package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static android.webkit.WebSettings.LayoutAlgorithm.SINGLE_COLUMN;

/**
 * Created by le.xin on 2016/10/25.
 * 支持显示的富文本webView
 */

public class RichWebView extends WebView implements View.OnTouchListener {

    public static final int NO_IMG_LOAD_TIME = 10000;   // 没有图片时的加载时长
    public static final int HAVE_IMG_LOAD_TIME = 30000;
    private ViewTreeObserver.OnScrollChangedListener mListener;

    public RichWebView(Context context) {
        super(context);
    }

    public RichWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RichWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private String js = "\n" +
            "<script type=\"text/javascript\">\n" +
            "  var x =document.getElementsByTagName(\"img\");\n" +
            "  for (var i = 0; i < x.length; i++) {\n" +
            "  \tif(x[i].getAttribute(\"data-large\") != null) {\n" +
            "  \t\tx[i].setAttribute(\"src\" ,x[i].getAttribute(\"data-large\"));\n" +
            "  \t}\n" +
            "  }\n" +
            "  javascript:(function() {\n" +
            " \t window.imageClick.loadover();\n" +
            "  })()\n" +
            "</script>\n";

    public void setURLClickListener(URLClickListener URLClickListener) {
        mURLClickListener = URLClickListener;
    }

    public interface URLClickListener {
        boolean urlClick(String url);
    }

    private URLClickListener mURLClickListener;
    private boolean pageFinished = false;

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            pageFinished = true;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(mURLClickListener != null) {
                if(mURLClickListener.urlClick(url)) {
                    return true;
                }
            }
            // 这里表示此webView默认不处理点击事件
            return true;
        }
    };


    private boolean haveImg = false;
    private boolean scrollAndLoading = false;
    private long setDataTime;
    private static Pattern IMAGE_TAG_PATTERN = Pattern.compile("\\<img(.*?)\\>");
    public void setData(String richStr ,RichWebViewAttr attr) {
        setWebViewClient(mWebViewClient);
//        getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true); // 让图片自适应屏幕
        settings.setLayoutAlgorithm(SINGLE_COLUMN);
        settings.setLoadsImagesAutomatically(false);
        settings.setBlockNetworkImage(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDomStorageEnabled(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setAppCacheEnabled(true);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR1) {
            try {
                settings.setMediaPlaybackRequiresUserGesture(false);
            } catch (Exception e) {
            }
        }

        setDataTime = System.currentTimeMillis();
        pageFinished = false;
        if(!TextUtils.isEmpty(richStr)) {
            if(IMAGE_TAG_PATTERN.matcher(richStr).find()) {
                haveImg = true;
            }
        }

        scrollAndLoading = true;

        setOnTouchListener(this);
        addJavascriptInterface(new JsInterface(), "imageClick"); //JS交互
        if(attr == null) {
            attr = new RichWebViewAttr();
        }
        loadDataWithBaseURL(null, getCss(attr) + richStr + js, "text/html", "utf-8", null);
        setFocusable(false);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        mListener = new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                scrollAndLoading = true;
                setDataTime = System.currentTimeMillis() - (haveImg ? NO_IMG_LOAD_TIME / 2 : HAVE_IMG_LOAD_TIME / 2);
                postInvalidate();
            }
        };
        getViewTreeObserver().addOnScrollChangedListener(mListener);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if(mListener != null) {
            getViewTreeObserver().removeOnScrollChangedListener(mListener);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        System.out.println("RichWebView.draw" + this);
        if((pageFinished && scrollAndLoading) || System.currentTimeMillis() - setDataTime < (haveImg ? NO_IMG_LOAD_TIME : HAVE_IMG_LOAD_TIME)) {
            scrollAndLoading = false;
            super.draw(canvas);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setData(String richStr) {
        setData(richStr ,new RichWebViewAttr());
    }

    private void clickImage(float touchX, float touchY) {
        //通过触控的位置来获取图片URL
        String js =
                "javascript:(function() {\n" +
                        "\tvar imgs = '';\n" +
                        "\tvar obj=document.elementFromPoint("+touchX+", "+touchY+");\n" +
                        "\tif(obj.src == null) {" +
                        "\t\treturn;"+
                        "\t}"+
                        "\tvar x =document.getElementsByTagName(\"img\");\n" +
                        "\tvar index = -1;\n" +
                        "\tfor (var i = 0; i < x.length; i++) {\t\t\n" +
                        "\t\tif(x[i] == obj) {\n" +
                        "\t\t\tindex = i;\n" +
                        "\t\t}\n" +
                        "\t\tif(x[i].getAttribute('data-large') != null) {\n" +
                        "\t\t\timgs += x[i].getAttribute('data-large') + ',';\n" +
                        "\t\t} else if(x[i].getAttribute('src') != null) {\n" +
                        "\t\t\timgs += x[i].getAttribute('src') + ',';\n" +
                        "\t\t}\n" +
                        "\t}\n" +
                        "\timgs += index;\n" +
                        "\twindow.imageClick.click(imgs);\n" +
                        "})();";

        loadUrl(js);
    }

    float x,y;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(onImageClick == null) {
            return false;
        }
        //通过wenview的touch来响应web上的图片点击事件
        float density = getResources().getDisplayMetrics().density; //屏幕密度
        float touchX = event.getX() / density;  //必须除以屏幕密度
        float touchY = event.getY() / density;
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x = touchX;
            y = touchY;
        }

        if(event.getAction() == MotionEvent.ACTION_UP){
            float dx = Math.abs(touchX-x);
            float dy = Math.abs(touchY-y);
            if(dx<10.0/density&&dy<10.0/density){
                clickImage(touchX,touchY);
            }
        }
        return false;
    }


    class JsInterface{
        @JavascriptInterface
        public void click(final String url){
            if(TextUtils.isEmpty(url)) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    if(onImageClick != null) {
                        String[] split = url.split(",");

                        int index = -1;
                        if(split.length > 1) {
                            ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
                            try {
                                index = Integer.parseInt(strings.get(strings.size() - 1));
                                strings.remove(strings.size() - 1);
                            } catch (Exception e ){
                                e.printStackTrace();
                            }
                            if(index < 0) {
                                index = 0;
                            }
                            if(index >= strings.size()) {
                                index = strings.size() - 1;
                            }

                            onImageClick.onClick(strings , index);
                        }
                    }
                }
            });
        }

        @JavascriptInterface
        public void loadover(){
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    WebSettings settings = getSettings();
                    if(settings != null) {
                        settings.setLoadsImagesAutomatically(true);
                        settings.setBlockNetworkImage(false);
                    }
                }
            });
        }
    }

    public interface IOnImageClick {
        void onClick(List<String> imgs ,int index);
    }

    public void setOnImageClick(IOnImageClick onImageClick) {
        this.onImageClick = onImageClick;
    }

    private IOnImageClick onImageClick;
    @Override
    public void destroy() {
        release();
        super.destroy();
    }

    private void release() {
        loadUrl("about:blank");
        removeJavascriptInterface("imageClick");
        getSettings().setJavaScriptEnabled(false);
        if(getParent() != null && getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private String getCss(RichWebViewAttr attr) {
        String bodyCss = "";
        if(attr != null) {
            if(!attr.color.startsWith("#")) {
                attr.color = "#" + attr.color;
            }
            bodyCss  = new StringBuilder()
                    .append("font-size : ").append(attr.fontSize).append("px;")
                    .append("color :").append(attr.color).append(";")
                    .append("line-height : ").append(attr.lineHeight).append("px;")

                    .append("padding-top:").append(attr.paddingTop).append("px;")
                    .append("padding-right:").append(attr.paddingRight).append("px;")
                    .append("padding-bottom:").append(attr.paddingBottom).append("px;")
                    .append("padding-left:").append(attr.paddingLeft).append("px;")

                    .append("margin-top:").append(attr.marginTop).append("px;")
                    .append("margin-right:").append(attr.marginRight).append("px;")
                    .append("margin-bottom:").append(attr.marginBottom).append("px;")
                    .append("margin-left:").append(attr.marginLeft).append("px;")
                    .toString();
        }

        String htmlCss =  "    <head>\n" +
                "        <style type=\"text/css\">\n" +
                "*{text-align:justify;text-justify:distribute-all-lines;}\n" +
                "            body { "+bodyCss+" word-wrap : break-word }\n" +
                "            p { margin: 0px; }\n" +
                "            img { margin: 10px 0px; max-width: 100%;}\n" +
                "            .xbtn { margin: 5px 15px; }\n" +
                "            body\n" +
                "            {\n" +
                "                -webkit-touch-callout:none ;\n" +
                "                -webkit-user-select:none ;\n" +
                "            }\n" +
                "        </style>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "            <title>preview</title>\n" +
                "            <meta name=\"viewport\" content=\"initial-scale=1.0,user-scalable=no,maximum-scale=1,width=device-width\"></head>";

        return htmlCss;
    }

    public static class RichWebViewAttr {
        public int fontSize = 18;
        public String color = "#333";
        public int lineHeight = 30;

        public int marginRight = 20;
        public int marginLeft = 20;
        public int marginBottom = 0;
        public int marginTop = 0;

        public int paddingRight = 0;
        public int paddingLeft = 0;
        public int paddingBottom = 0;
        public int paddingTop = 0;
    }

}
