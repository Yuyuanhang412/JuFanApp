package com.example.jufanapp.mainpager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.MyGuanZhuAdapter;
import com.example.jufanapp.bean.GuanzhuBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by w8888 on 2016/10/8.
 */
public class GuanZhu extends android.support.v4.app.Fragment {


    private GridView gv_guanzhu_item;
    private List<GuanzhuBean> list=new ArrayList<GuanzhuBean>();
    private SQLiteDatabase database;
    private MyGuanZhuAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.guanzhu_item,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        MySQLiteOpenHelper lite=new MySQLiteOpenHelper(getActivity());
        database=lite.getReadableDatabase();

        show();


        gv_guanzhu_item= (GridView) getActivity().findViewById(R.id.gv_guanzhu_01);

        adapter = new MyGuanZhuAdapter(getActivity(), list);
        gv_guanzhu_item.setAdapter(adapter);



    }

    private void show() {

        //list.clear();
        Cursor cursor=database.query("video",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            GuanzhuBean bean=new GuanzhuBean();

           int id=cursor.getInt(cursor.getColumnIndex("rid"+""));
            String img=cursor.getString(cursor.getColumnIndex("midheadimg"));

            bean.setId(id+"");
            bean.setImag(img);

            list.add(bean);

        }
//adapter.notifyDataSetChanged();

    }
}
