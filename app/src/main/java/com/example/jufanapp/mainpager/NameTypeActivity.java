package com.example.jufanapp.mainpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.jufanapp.R;

public class NameTypeActivity extends AppCompatActivity {

    ImageView im_type_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_type);

        im_type_back= (ImageView) findViewById(R.id.image_type_back);
        im_type_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                // 侧滑过去
                overridePendingTransition(R.anim.return_enter, R.anim.return_exit);

            }
        });

    }
}
