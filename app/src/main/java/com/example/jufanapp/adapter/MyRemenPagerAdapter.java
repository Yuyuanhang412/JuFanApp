package com.example.jufanapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jufanapp.R;
import com.example.jufanapp.bean.Bean;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by w8888 on 2016/10/9.
 */
public class MyRemenPagerAdapter extends PagerAdapter {

    private Context context;
    private  List<Bean.ContentEntity.BannerEntity>listdata;
    private Handler handler;

    public MyRemenPagerAdapter(Context context, List<Bean.ContentEntity.BannerEntity> listdata, Handler handler) {
            this.context=context;
        this.listdata=listdata;
        this.handler=handler;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.remen_pager_item, null);
        ImageView vp_iv=(ImageView) view.findViewById(R.id.vp_iv);
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.displayImage(listdata.get(position%listdata.size()).getImg(),vp_iv);
        container.addView(view);
        return view;
    }
}
