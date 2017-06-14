package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

        TextView textView = (TextView) findViewById(R.id.text);

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