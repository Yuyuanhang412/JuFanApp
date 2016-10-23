package com.example.jufanapp.mainpager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.MyNewsAdapter;
import com.example.jufanapp.bean.GuanzhuBean;
import com.example.jufanapp.bean1.Beans;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by w8888 on 2016/10/8.
 * author:于远航
 */
public class News extends android.support.v4.app.Fragment {

    private String path="http://live.jufan.tv/cgi/hall/get?sign=CA3AF74D90F583B536C55A8148526ED1AB57F882&userid=500056511&type=new&r=cfengfj&page=0";
    private GridView gv_news_item;
    private List<Beans.ContentEntity.ListEntity>list;



    Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg) {

            Beans bean= (Beans) msg.obj;

            list=bean.getContent().getList();

            Log.i("1212121212",list.toString());
           gv_news_item.setAdapter(new MyNewsAdapter(getActivity(),list));

            gv_news_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent=new Intent(getActivity(),RemenVideoActivity.class);
                    intent.putExtra("video",list.get(position).getVideo());


                    intent.putExtra("rid",list.get(position).getRid());
                    intent.putExtra("image",list.get(position).getMidheadimg());


                    intent.putExtra("imagehelder",list.get(position).getSmallheadimg());
                    intent.putExtra("name",list.get(position).getName());
                    intent.putExtra("online",list.get(position).getOnline());
                    startActivity(intent);




                }
            });


        };
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.news_item,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        gv_news_item= (GridView) getActivity().findViewById(R.id.gv_news_item);

        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL(path);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200) {

                        InputStream inputStream = httpURLConnection.getInputStream();

                        //解析Gson
                        Gson gson = new Gson();
                        Beans bean = gson.fromJson(new InputStreamReader(inputStream), Beans.class);
                        Log.i("-------", bean.toString());
                        Message msg = Message.obtain();
                        msg.obj = bean;

                        handler.sendMessage(msg);

                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            };
        }.start();

    }
}
