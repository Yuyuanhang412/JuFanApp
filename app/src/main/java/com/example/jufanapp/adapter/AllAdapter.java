package com.example.jufanapp.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.bean.AllBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.List;

/**
 * Created by w8888 on 2016/10/20.
 */
public class AllAdapter extends BaseAdapter {

    Context context;
    List<AllBean.ContentEntity.DataEntity> list;
    private final ImageLoader imageLoader;

    public AllAdapter(Context context, List<AllBean.ContentEntity.DataEntity> list) {
        this.context=context;
        this.list=list;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));

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
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=View.inflate(context, R.layout.all_item_01,null);
            vh.image_all= (ImageView) convertView.findViewById(R.id.image_all_01);
            vh.tv_all_name= (TextView) convertView.findViewById(R.id.tv_all_nickname);
            vh.tv_all_mount= (TextView) convertView.findViewById(R.id.tv_all_mount);

            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }

        DisplayImageOptions options = new DisplayImageOptions.Builder().displayer(new CircleBitmapDisplayer()).build();
        imageLoader.displayImage(list.get(position).getHeadImgSmall(), vh.image_all, options);

        vh.tv_all_name.setText(list.get(position).getNickname());
        vh.tv_all_mount.setText("送出"+list.get(position).getOut_amount()+"聚钻");

        return convertView;
    }

    class ViewHolder{
        ImageView image_all;
        TextView tv_all_name,tv_all_mount;

    }

}
