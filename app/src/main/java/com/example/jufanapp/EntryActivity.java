package com.example.jufanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jufanapp.mainpager.MainActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }

    public void SinaOnClick(View v){
        Intent intent=new Intent(EntryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    //分享
    public void PhoneOnClick(View v){
        showShare();

    }

    //QQ登录
    public void QQOnClick(View v){



        login();
    }


    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("ShareSDK");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(this);
    }


    /**
     * 第三方登录
     */
    private void login() {
        ShareSDK.initSDK(this);
        Platform qq = ShareSDK.getPlatform(this, QQ.NAME);
        qq.authorize();

        qq.setPlatformActionListener(new PlatformActionListener() {

            @Override
            public void onError(Platform qq, int arg1, Throwable arg2) {
                // 弹出失败窗口
                System.out.println("第三方登录失败");
            }

            @Override
            public void onComplete(Platform qq, int arg1, HashMap<String, Object> arg2) {

                // 获取网名
                String userName = qq.getDb().getUserName();
                // 获取头像
                String userIcon = qq.getDb().getUserIcon();
                  Intent intent=new Intent(EntryActivity.this, MainActivity.class);
                    startActivity(intent);

            }

            @Override
            public void onCancel(Platform arg0, int arg1) {
                Log.i("登录失败", "shibai");
            }
        });
    }


}
