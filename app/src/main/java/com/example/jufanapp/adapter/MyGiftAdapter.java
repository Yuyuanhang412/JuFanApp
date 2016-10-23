package com.example.jufanapp.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.jufanapp.R;
import com.example.jufanapp.bean.GiftBean;
import com.example.jufanapp.mainpager.RemenVideoActivity;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by w8888 on 2016/10/19.
 */
public class MyGiftAdapter extends BaseAdapter {

    private Context context;
    private List<GiftBean.ContentEntity.JufanEntity.ListEntity> listgift;
    private final ImageLoader imageLoader;

    public MyGiftAdapter(Context context, List<GiftBean.ContentEntity.JufanEntity.ListEntity> listgift) {
        this.context=context;
        this.listgift=listgift;
        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
    }

    @Override
    public int getCount() {
        return listgift.size();
    }

    @Override
    public Object getItem(int position) {
        return listgift.get(position);
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
            convertView=View.inflate(context, R.layout.pop_item,null);
            vh.image_gift= (ImageView) convertView.findViewById(R.id.image_pop_gift);
            vh.tv_zhuan= (TextView) convertView.findViewById(R.id.tv_pop_zhuan);
            vh.tv_jinyan= (TextView) convertView.findViewById(R.id.tv_pop_jinyan);
            convertView.setTag(vh);

        }else{
            vh= (ViewHolder) convertView.getTag();
        }


        imageLoader.displayImage(listgift.get(position).getUrl(),vh.image_gift);

        vh.tv_zhuan.setText(listgift.get(position).getExp()+"钻");
        vh.tv_jinyan.setText(listgift.get(position).getDesc());

        return convertView;
    }

    class ViewHolder{
        private ImageView image_gift;
        private TextView tv_zhuan,tv_jinyan;

    }

}
