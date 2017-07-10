package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by le.xin on 2017/1/9.
 */

public class MainActivity extends Activity {

    private ListView mListView;
    private List<String> names = new ArrayList<String>() {
        {
            add("淡定");
            add("淡定");
            add("淡定");
            add("淡定");
            add("淡定");
            add("淡定");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new MyAdapter());

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            HttpURLConnection connection = (HttpURLConnection) new URL("http://www.ximalaya" +
                                    ".com/explore").openConnection();

                            System.out.println("dand == " + connection.getHeaderFields());
                            connection.setRequestMethod("GET");
                            connection.setRequestProperty("danding", "asd");
                            int responseCode = connection.getResponseCode();
                            System.out.println("看啊 ==  " + responseCode);
                            System.out.println("dand == " + connection.getHeaderFields());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

//        ImageView viewById = (ImageView) findViewById(R.id.main_play_bottom_small_icon);
//        viewById.setImageResource(R.drawable.danding);


//        Bitmap bitmap = ((BitmapDrawable)ContextCompat.getDrawable(this ,R.drawable.xiaoshuo)).getBitmap();
//
//        Bitmap srcBitmap = ((BitmapDrawable) ContextCompat.getDrawable(this, R.drawable.main_albumbox_layer))
// .getBitmap();
//        Bitmap drawingBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), srcBitmap.getConfig
// ());
//        Canvas canvas = new Canvas(drawingBitmap);
//        Paint paint = new Paint();
//        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
//                new Rect(0, 0, srcBitmap.getWidth(), srcBitmap.getHeight()), paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//        canvas.drawBitmap(srcBitmap, 0, 0, paint);
//        ((ImageView)findViewById(R.id.haha)).setImageBitmap(drawingBitmap);

        ImageView viewById = (ImageView) findViewById(R.id.large_img);
        viewById.setImageResource(R.drawable.xiaoshuo);

    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return names.size();
        }

        @Override
        public Object getItem(int position) {
            return names.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_text, null);
            TextView viewById = (TextView) inflate.findViewById(R.id.text);
            viewById.setText(names.get(position));
            return inflate;
        }
    }


}