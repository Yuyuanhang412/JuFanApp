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
import com.example.jufanapp.bean.GuanzhuBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by w8888 on 2016/10/14.
 */
public class MyGuanZhuAdapter extends BaseAdapter{

    Context context;
    List<GuanzhuBean>list;

    public MyGuanZhuAdapter(Context context, List<GuanzhuBean> list) {
        this.context=context;
        this.list=list;
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
        if(convertView==null){
            vh=new viewHolder();
            convertView=View.inflate(context, R.layout.ty_video_item,null);
            vh.rid= (TextView) convertView.findViewById(R.id.tv_id);
            vh.image_ty_01= (ImageView) convertView.findViewById(R.id.image_guanzhu_01);
            convertView.setTag(vh);
        }else{
            vh= (viewHolder) convertView.getTag();
        }

        ImageLoader imageLoa=ImageLoader.getInstance();
        imageLoa.init(ImageLoaderConfiguration.createDefault(context));
        imageLoa.displayImage(list.get(position).getImag(),vh.image_ty_01);
        vh.rid.setText(list.get(position).getId());

        return convertView;
    }


    class viewHolder{
        TextView rid;
        ImageView image_ty_01;
    }

}
