package com.example.jufanapp.mainpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jufanapp.R;

/**
 * Created by w8888 on 2016/10/8.
 */
public class Type extends android.support.v4.app.Fragment {

    private TextView tv_my_name;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.my_item,null);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_my_name= (TextView) getActivity().findViewById(R.id.tv_my_name);

        tv_my_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),NameTypeActivity.class);
                startActivity(intent);
            }
        });


    }
}
