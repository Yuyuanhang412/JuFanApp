package com.example.jufanapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.jufanapp.mainpager.MainActivity;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    //封装属性
    private ImageView image;
    private Timer timer;
    private  int i=5;
    private String biaozhi;

    //Handler接收小息
    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //得到传值
            int i = msg.what;
            //判断i是否为0，如果为0跳转进入viewPager滑动界面
            if (i == 0) {

                //判断保存值是否为第一次，如果是第一次进行ViewPager滑动
                if ("0".equals(biaozhi)) {

                    //保存数据
                    SharedPreferences sp = getSharedPreferences("confi",
                            MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    //储存数据为1
                    edit.putString("biaozhi", "1");
                    edit.commit();

                        Intent intent = new Intent(LoginActivity.this,
                                LoginActivity02.class);
                        startActivity(intent);
                        finish();

                } else {
                    //不是第一次直接跳转到第三方登录界面
                if("0".equals(biaozhi)){
                    Intent intent = new Intent(LoginActivity.this,
                            EntryActivity.class);
                    startActivity(intent);
                    finish();
                }else if("1".equals(biaozhi)){
                    Intent intent = new Intent(LoginActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();
                }



                }


            }
        };
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //得到控件ID
        image= (ImageView) findViewById(R.id.iv_login01);
        //进行数据保存
        SharedPreferences sp = getSharedPreferences("confi", MODE_PRIVATE);
        biaozhi = sp.getString("biaozhi", "0");

        Log.e("biaozhi","0");
        //开启线程
        new Thread(){

            @Override
            public void run() {
                //循环判断
               for (int i=3;i>=0;i--){
                   //传值到主线程
                   handler.sendEmptyMessage(i);
                   try {
                       //线程休眠
                       sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }.start();

    }
}
