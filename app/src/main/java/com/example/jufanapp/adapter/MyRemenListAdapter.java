package com.example.jufanapp.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.bean.Bean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by w8888 on 2016/10/9.
 */
public class MyRemenListAdapter extends BaseAdapter{

    private Context context;
    private List<Bean.ContentEntity.ListEntity>list1;

    public MyRemenListAdapter(Context context, List<Bean.ContentEntity.ListEntity> list1) {
            this.context=context;
        this.list1=list1;

    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder vh;
        if(convertView==null){
            vh=new viewHolder();
            convertView=View.inflate(context, R.layout.remen_list_item,null);
            vh.image_remen_header= (ImageView) convertView.findViewById(R.id.image_remen_header);
            vh.tv_remen_place= (TextView) convertView.findViewById(R.id.tv_remen_place);
            vh.tv_remen_name= (TextView) convertView.findViewById(R.id.tv_remen_name);
            vh.tv_remen_online= (TextView) convertView.findViewById(R.id.tv_remen_online);


            vh.image_remen_list= (ImageView) convertView.findViewById(R.id.image_remen_list);
            convertView.setTag(vh);

        }else {

            vh= (viewHolder) convertView.getTag();
        }

        ImageLoader imageloader=ImageLoader.getInstance();
        imageloader.init(ImageLoaderConfiguration.createDefault(context));
       // imageloader.displayImage(list1.get(position).getBigheadimg(),vh.image_remen_list);

        //imageloader.displayImage(list1.get(position).getSmallheadimg(),vh.image_remen_header);

        //设置切角图
        DisplayImageOptions options1 = new DisplayImageOptions.Builder().displayer(new RoundedBitmapDisplayer(20)).build();
        imageloader.displayImage(list1.get(position).getBigheadimg(), vh.image_remen_list, options1);

        //设置圆形图
        DisplayImageOptions options = new DisplayImageOptions.Builder().displayer(new CircleBitmapDisplayer()).build();
        imageloader.displayImage(list1.get(position).getSmallheadimg(), vh.image_remen_header, options);


        vh.tv_remen_name.setText(list1.get(position).getName());
        vh.tv_remen_place.setText(list1.get(position).getPlace());
        vh.tv_remen_online.setText(list1.get(position).getOnline()+"");

        return convertView;
    }

    class viewHolder{
        ImageView image_remen_list,image_remen_header;
        TextView tv_remen_name,tv_remen_place,tv_remen_online;

    }
}
