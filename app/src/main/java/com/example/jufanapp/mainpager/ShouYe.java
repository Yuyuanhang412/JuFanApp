package com.example.jufanapp.mainpager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/8.
 */
public class ShouYe extends android.support.v4.app.Fragment {

    private ViewPager vp;
    private FragmentManager fm;
    private TextView tv1, tv2, tv3;//关注 热门 最新
    private View viewpager1, viewpager2, viewpager3;
    private ImageView image_sousuo,image_plate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_item,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //搜索
        image_sousuo= (ImageView) getActivity().findViewById(R.id.image_sousuo);
        image_sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SousuoActivity.class);
                startActivity(intent);
            }
        });


        //奖杯
        image_plate= (ImageView) getActivity().findViewById(R.id.image_plate);
        image_plate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PlateActivity.class);
                startActivity(intent);
            }
        });


        vp=(ViewPager) getActivity().findViewById(R.id.vp_shouye);

        //得到管理者
        fm=getActivity().getSupportFragmentManager();
        //Viewpager的适配器
        vp.setAdapter(new MyFragmentPagerAdapter(fm,getFragment()));


        viewpager1 = getView().findViewById(R.id.view1);
        viewpager2 = getView().findViewById(R.id.view2);
        viewpager3 = getView().findViewById(R.id.view3);

        tv1 = (TextView) getView().findViewById(R.id.tvguanzhu);
        tv2 = (TextView) getView().findViewById(R.id.tvremen);
        tv3 = (TextView) getView().findViewById(R.id.tvzuixin);

        vp.setCurrentItem(1);
        tv2.setTextColor(Color.RED);
        viewpager1.setVisibility(View.GONE);
        viewpager2.setVisibility(View.VISIBLE);
        viewpager3.setVisibility(View.GONE);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    viewpager1.setVisibility(View.VISIBLE);
                    viewpager2.setVisibility(View.GONE);
                    viewpager3.setVisibility(View.GONE);
                    tv1.setTextColor(Color.RED);
                    tv2.setTextColor(Color.BLACK);
                    tv3.setTextColor(Color.BLACK);

                } else if (position == 1) {
                    viewpager1.setVisibility(View.GONE);
                    viewpager2.setVisibility(View.VISIBLE);
                    viewpager3.setVisibility(View.GONE);
                    tv2.setTextColor(Color.RED);
                    tv1.setTextColor(Color.BLACK);
                    tv3.setTextColor(Color.BLACK);

                } else if (position == 2) {
                    viewpager1.setVisibility(View.GONE);
                    viewpager2.setVisibility(View.GONE);
                    viewpager3.setVisibility(View.VISIBLE);
                    tv3.setTextColor(Color.RED);
                    tv1.setTextColor(Color.BLACK);
                    tv2.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        // 设置点击选项，mvp切换游标切换
        tv1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vp.setCurrentItem(0);
                viewpager1.setVisibility(View.VISIBLE);
                viewpager2.setVisibility(View.GONE);
                viewpager3.setVisibility(View.GONE);



            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vp.setCurrentItem(1);
                viewpager2.setVisibility(View.VISIBLE);
                viewpager1.setVisibility(View.GONE);
                viewpager3.setVisibility(View.GONE);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                vp.setCurrentItem(2);
                viewpager3.setVisibility(View.VISIBLE);
                viewpager2.setVisibility(View.GONE);
                viewpager1.setVisibility(View.GONE);
            }
        });


    }

    public List<Fragment> getFragment() {
        List<Fragment>list=new ArrayList<Fragment>();

        list.add(new GuanZhu());
        list.add(new ReMen());
        list.add(new News());
        return list;
    }
}
