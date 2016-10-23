package com.example.jufanapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.bean1.Beans;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by w8888 on 2016/10/9.
 */
public class MyNewsAdapter extends BaseAdapter {
    private Context context;
    private List<Beans.ContentEntity.ListEntity> list;

    public MyNewsAdapter(Context context, List<Beans.ContentEntity.ListEntity> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder vh;
        if (convertView == null) {
            vh = new viewHolder();
            convertView = View.inflate(context, R.layout.news_gv_item, null);
            vh.image_news_01 = (ImageView) convertView.findViewById(R.id.image_news_01);
            vh.tv_name= (TextView) convertView.findViewById(R.id.tv_news_name);
            vh.tv_place= (TextView) convertView.findViewById(R.id.tv_news_place);
            vh.tv_online= (TextView) convertView.findViewById(R.id.tv_news_online);

            convertView.setTag(vh);

        } else {

            vh = (viewHolder) convertView.getTag();
        }

       /* if (list.get(position).getBigheadimg() == null) {
            new DisplayImageOptions.Builder().showImageForEmptyUri(R.drawable.li_default_head).showImageOnFail(R.drawable.li_default_head).showImageOnLoading(R.drawable.li_default_head);

        }*/

        ImageLoader imageloader = ImageLoader.getInstance();
        imageloader.init(ImageLoaderConfiguration.createDefault(context));
        //imageloader.displayImage(list.get(position).getMidheadimg(), vh.image_news_01);

        //设置切角图
        DisplayImageOptions options= new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(20)).build();
        imageloader.displayImage(list.get(position).getMidheadimg(), vh.image_news_01, options);

        vh.tv_name.setText(list.get(position).getName());
        vh.tv_place.setText(list.get(position).getPlace());
        vh.tv_online.setText(list.get(position).getOnline()+"");


        return convertView;
    }

    class viewHolder {
        ImageView image_news_01;
        TextView tv_name,tv_place,tv_online;

    }

}
