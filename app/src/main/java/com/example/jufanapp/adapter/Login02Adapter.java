package com.example.jufanapp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by w8888 on 2016/9/29.
 */
public class Login02Adapter extends PagerAdapter{

    List<View>list;

    public Login02Adapter(List<View> list) {
        this.list = list;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=list.get(position);
        ViewGroup parent= (ViewGroup) view.getParent();
        if(parent!=null){
            container.removeAllViews();
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return list!=null? list.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
