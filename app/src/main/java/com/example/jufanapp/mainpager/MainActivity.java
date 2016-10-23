package com.example.jufanapp.mainpager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jufanapp.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tv_channel, tv_setting, tv_jia;
    private Fragment fg1, fg2;
    private FragmentManager fman;
    private FragmentTransaction fts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fman = getSupportFragmentManager();


        bindViews();
        tv_channel.performClick();   //模拟一次点击，既进去后选择第一项

        if (fg1 == null) {
            fg1 = new ShouYe();
            fts.add(R.id.ly_content, fg1);

        }

        
    }

    private void bindViews() {
        tv_channel = (TextView) findViewById(R.id.txt_channel);
        tv_setting = (TextView) findViewById(R.id.txt_setting);
        tv_jia = (TextView) findViewById(R.id.txt_message);

        tv_channel.setOnClickListener(this);
        tv_setting.setOnClickListener(this);
        tv_jia.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    private void setSelected() {

        tv_channel.setSelected(false);
        tv_setting.setSelected(false);

    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) fragmentTransaction.hide(fg1);
        if (fg2 != null) fragmentTransaction.hide(fg2);

    }

    @Override
    public void onClick(View v) {

        FragmentTransaction fTransaction = fman.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()) {
            case R.id.txt_channel:
                setSelected();
                tv_channel.setSelected(true);
                if (fg1 == null) {
                    fg1 = new ShouYe();
                    fTransaction.add(R.id.ly_content, fg1);

                } else {
                    fTransaction.show(fg1);
                    fTransaction.hide(fg2);
                }
                break;
            case R.id.txt_setting:
                setSelected();
                tv_setting.setSelected(true);
                if (fg2 == null) {
                    fg2 = new Type();
                    fTransaction.add(R.id.ly_content, fg2);
                } else {
                    fTransaction.show(fg2);
                    fTransaction.hide(fg1);
                }
                break;
            case R.id.txt_message:
                Intent intent = new Intent(MainActivity.this, JiaActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        fTransaction.commit();
        
    }
}
