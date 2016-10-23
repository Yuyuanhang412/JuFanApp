package com.example.jufanapp.mainpager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.MyRemenListAdapter;
import com.example.jufanapp.adapter.MyRemenPagerAdapter;
import com.example.jufanapp.bean.Bean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/8.
 * author:于远航
 */
public class ReMen extends android.support.v4.app.Fragment {

    private String path="http://live.jufan.tv/cgi/hall/get?sign=85D6E5ADDDBFE1FDBB21BEDD57E4C9DBCDAEA0A7&userid=500056511&type=hot&r=gxnixovao&page=0";
    private ViewPager vp;
    private ListView lv_remen;
    private TextView tv_des;
    private LinearLayout ll_dot;
    private List<Bean.ContentEntity.ListEntity> list1;
    private List<Bean.ContentEntity.BannerEntity> listdata;
    private List<ImageView> ivlist=new ArrayList<ImageView>();
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    Bean bean= (Bean) msg.obj;
                    listdata=bean.getContent().getBanner();
                    vp.setAdapter(new MyRemenPagerAdapter(getActivity(),listdata,handler));

                    list1=bean.getContent().getList();
                    lv_remen.setAdapter(new MyRemenListAdapter(getActivity(),list1));

                    lv_remen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent=new Intent(getActivity(),RemenVideoActivity.class);
                            intent.putExtra("video",list1.get(position).getVideo());
                            intent.putExtra("imagehelder",list1.get(position).getSmallheadimg());
                            intent.putExtra("name",list1.get(position).getName());
                            intent.putExtra("online",list1.get(position).getOnline());
                            startActivity(intent);

                        }
                    });



                    Log.i("..........", listdata.toString());
                    initDot();
                    vp.setCurrentItem(10000);
                    sendDelayMasage();
                    //滑动监听事件
                    ViewpagerListent();
                    break;
                case 1:
                    int position=vp.getCurrentItem();
                    position++;
                    vp.setCurrentItem(position);
                    sendDelayMasage();
                    break;

                default:
                    break;
            }
        };
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.remen_item,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vp = (ViewPager) getActivity().findViewById(R.id.vp);
        //tv_des = (TextView)getActivity(). findViewById(R.id.tv_des);
        lv_remen= (ListView) getActivity().findViewById(R.id.lv_remen);


        ll_dot = (LinearLayout) getActivity().findViewById(R.id.ll_dot);
        new Thread(){
            public void run() {

                URL url = null;
                try {
                    url = new URL(path);

                    HttpURLConnection openConnection = (HttpURLConnection) url
                            .openConnection();

                    openConnection.setRequestMethod("GET");

                    openConnection.connect();

                    if (openConnection.getResponseCode() == 200) {

                        InputStream inputStream = openConnection
                                .getInputStream();

                        // 解析json
                        Gson gson = new Gson();

                        Bean beans = gson.fromJson(new InputStreamReader(
                                inputStream), Bean.class);
                        Log.i("11111111111111111111111", beans.toString());

                        // 发送给handler
                        Message msg = Message.obtain();

                        msg.obj = beans;

                        handler.sendMessage(msg);


                }

                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                } ;
        }.start();


    }


    protected void ViewpagerListent() {
        // TODO Auto-generated method stub
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                for (int i = 0; i < ivlist.size(); i++) {
                    if(arg0%listdata.size()==i){
                        ivlist.get(arg0%listdata.size()).setImageResource(R.drawable.li_icon_dot_selected);

                    }
                    else{
                        ivlist.get(i).setImageResource(R.drawable.li_icon_dot_normal);
                    }
                    //tv_des.setText(listdata.get(arg0%listdata.size()).title);
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
    protected void sendDelayMasage() {
        // TODO Auto-generated method stub
        handler.sendEmptyMessageDelayed(1, 2000);
    }
    //初始化小圆点
    protected void initDot() {
        // TODO Auto-generated method stub
        if(ivlist!=null){
            ivlist.clear();
        }
        for (int i = 0; i < listdata.size(); i++) {
            ImageView iv=new ImageView(getActivity());
            if(i==0){
                iv.setImageResource(R.drawable.li_icon_dot_selected);
            }else{
                iv.setImageResource(R.drawable.li_icon_dot_normal);
            }
           // tv_des.setText(listdata.get(i).title);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(10,10);
            params.setMargins(5, 0, 5, 0);
            ivlist.add(iv);
            ll_dot.addView(iv,params);
        }
    }
    //得到json解析数据
    protected void jsonData(String json) {
        // TODO Auto-generated method stub
        Gson gson=new Gson();
        Bean viewbean=gson.fromJson(json, Bean.class);
        listdata = viewbean.getContent().getBanner();
    }



}
