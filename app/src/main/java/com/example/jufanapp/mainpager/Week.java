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
import com.example.jufanapp.bean.GiftBean;
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
public class Week extends android.support.v4.app.Fragment {

    private ListView lv_week;

    private String weekurl="http://api.vas.jufan.tv/cgi/rank/sendTopWeek?r=mvohabl&page=1&user_id=500059702&sign=1425BC86225D0897C7A2F6A63F6AD0C99933122D";

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            WeekBean weekBean= (WeekBean) msg.obj;


            lv_week= (ListView) getActivity().findViewById(R.id.list_week);

            List<WeekBean.ContentEntity.DataEntity>list=weekBean.getContent().getData();
            lv_week.setAdapter(new WeekAdapter(getActivity(),list));

        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=View.inflate(getActivity(), R.layout.week_item,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL(weekurl);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200) {

                        InputStream inputStream = httpURLConnection.getInputStream();

                        //解析Gson
                        Gson gson = new Gson();
                        WeekBean weekbean = gson.fromJson(new InputStreamReader(inputStream), WeekBean.class);
                        Log.i("-------", weekbean.toString());
                        Message msg = Message.obtain();
                        msg.obj = weekbean;

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
