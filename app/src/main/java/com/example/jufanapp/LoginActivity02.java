package com.example.jufanapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jufanapp.adapter.Login02Adapter;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity02 extends AppCompatActivity {

    private ViewPager vp;//滑动
    private List<View> list;//用于保存图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login02);

        //添加数据
        addData();
        //初始化控件
        initView();

    }

    private void initView() {
        vp= (ViewPager) findViewById(R.id.vp_login02);

        vp.setAdapter(new Login02Adapter(list));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void LoginOnclick(View v){
        Intent intent=new Intent(LoginActivity02.this,EntryActivity.class);
        startActivity(intent);
    }

    private void addData() {

        list=new ArrayList<View>();
        View view1=View.inflate(LoginActivity02.this,R.layout.view1,null);
        View view2=View.inflate(LoginActivity02.this,R.layout.view2,null);
        View view3=View.inflate(LoginActivity02.this,R.layout.view3,null);

        list.add(view1);
        list.add(view2);
        list.add(view3);

    }
}
