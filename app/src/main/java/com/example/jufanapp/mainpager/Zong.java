package com.example.jufanapp.mainpager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.AllAdapter;
import com.example.jufanapp.bean.AllBean;
import com.example.jufanapp.bean.WeekBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by w8888 on 2016/10/20.
 */
public class Zong extends android.support.v4.app.Fragment {

    private String allurl="http://api.vas.jufan.tv/cgi/rank/sendTopAll?r=atzo&page=1&user_id=500059702&sign=19A3502607C983AED110878B0BF592EF0CEDBC2B";
    private ListView lv_all;


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            AllBean allBean= (AllBean) msg.obj;


            lv_all= (ListView) getActivity().findViewById(R.id.list_all);

            List<AllBean.ContentEntity.DataEntity> list=allBean.getContent().getData();
            lv_all.setAdapter(new AllAdapter(getActivity(),list));

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.all_item,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL(allurl);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200) {

                        InputStream inputStream = httpURLConnection.getInputStream();

                        //解析Gson
                        Gson gson = new Gson();
                        AllBean allbean = gson.fromJson(new InputStreamReader(inputStream), AllBean.class);
                        Log.i("-------", allbean.toString());
                        Message msg = Message.obtain();
                        msg.obj = allbean;

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
