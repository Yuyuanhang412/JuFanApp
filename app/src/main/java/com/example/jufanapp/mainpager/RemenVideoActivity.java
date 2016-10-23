package com.example.jufanapp.mainpager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jufanapp.R;
import com.example.jufanapp.adapter.MyGiftAdapter;
import com.example.jufanapp.bean.GiftBean;
import com.example.jufanapp.bean.GuanzhuBean;
import com.example.jufanapp.bean1.Beans;
import com.example.jufanapp.dianzan.HeartLayout;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class RemenVideoActivity extends AppCompatActivity{

    private TXCloudVideoView mPlayerView;
    private TXLivePlayer mLivePlayer;
    private HeartLayout heartLayout;
    private ImageView image_share,image_close,image_message,image_private,image_guanzhu;
    private SQLiteDatabase database;
    private List<GuanzhuBean>list=new ArrayList<GuanzhuBean>();
    private ImageView image_video_helder;
    private TextView tv_video_name,tv_video_online;
    private ImageView image_gift;
    private GridView gv_gift;

    public String urlgift="http://api.vas.jufan.tv/cgi/gift/list?sign=55D0D8B26E3B3100B8633585DD7CA3F8CF2EFE69&r=zlbh";
    private GiftBean listgift;



    Handler handler=new Handler(){

        private View popupWindow_view;

        @Override
        public void handleMessage(Message msg) {

            GiftBean giftBean= (GiftBean) msg.obj;

            List<GiftBean.ContentEntity.JufanEntity.ListEntity> listgift=giftBean.getContent().getJufan().get(0).getList();

            // 获取自定义布局文件pop.xml的视图
            popupWindow_view = getLayoutInflater().inflate(R.layout.pop_view, null,
                    false);

            gv_gift = (GridView) popupWindow_view.findViewById(R.id.grid_gift);
            gv_gift.setAdapter(new MyGiftAdapter(RemenVideoActivity.this,listgift));


            //设置popWindow弹出框
            image_gift.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    PopupWindow window = new PopupWindow(popupWindow_view,
                            WindowManager.LayoutParams.MATCH_PARENT,
                            600);
                    // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
                    //window.setFocusable(true);
                    window.setOutsideTouchable(true);
                    // 实例化一个ColorDrawable颜色为半透明
                    ColorDrawable dw = new ColorDrawable(0xb0000000);
                    window.setBackgroundDrawable(dw);
                    // 在底部显示
                    window.showAtLocation(v,
                            Gravity.BOTTOM, 0, 0);
                    // pop.xml视图里面的控件

                }
            });



        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remen_video);
        MySQLiteOpenHelper lite=new MySQLiteOpenHelper(RemenVideoActivity.this);
        database=lite.getReadableDatabase();
        // LunBo.ContentEntity.ListEntity bean = (LunBo.ContentEntity.ListEntity) getIntent().getSerializableExtra("bean");
        //String bean = getIntent().getStringExtra("bean");
        Intent intent=getIntent();
        String path=intent.getStringExtra("video");
        String imageHelder=intent.getStringExtra("imagehelder");
        String name=intent.getStringExtra("name");
        int online=intent.getIntExtra("online",0);
        final int rid=intent.getIntExtra("rid",0);
        final String image=intent.getStringExtra("image");

        TXLivePlayConfig mPlayConfig = new TXLivePlayConfig();


        new Thread(){

            @Override
            public void run() {

                try {
                    URL url = new URL(urlgift);

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();

                    if (httpURLConnection.getResponseCode() == 200) {

                        InputStream inputStream = httpURLConnection.getInputStream();

                        //解析Gson
                        Gson gson = new Gson();
                        GiftBean giftbean = gson.fromJson(new InputStreamReader(inputStream), GiftBean.class);
                        Log.i("-------", giftbean.toString());
                        Message msg = Message.obtain();
                        msg.obj = giftbean;

                        handler.sendMessage(msg);

                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            };
        }.start();


        //流畅模式
        mPlayConfig.setAutoAdjustCacheTime(true);
        mPlayConfig.setMinAutoAdjustCacheTime(1);
        mPlayConfig.setMaxAutoAdjustCacheTime(5);
        mPlayerView = (TXCloudVideoView) findViewById(R.id.video_view);
        int[] sdkVer = TXLivePusher.getSDKVersion();
        mLivePlayer = new TXLivePlayer(this);
        mLivePlayer.setPlayerView(mPlayerView);
        mLivePlayer.enableHardwareDecode(true);
        mLivePlayer.startPlay(path, TXLivePlayer.PLAY_TYPE_LIVE_FLV);

        mLivePlayer.setRenderMode(TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN);
        mLivePlayer.setRenderRotation(0);
        mLivePlayer.setConfig(mPlayConfig);



        heartLayout = (HeartLayout) findViewById(R.id.heart_layout);
        findViewById(R.id.member_send_good).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heartLayout.addFavor();
            }
        });

        //分享
        image_share= (ImageView) findViewById(R.id.image_video_share);
        image_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });


        image_close= (ImageView) findViewById(R.id.image_video_close);
        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        image_message= (ImageView) findViewById(R.id.image_video_message);
        image_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });


        //关注
        image_private= (ImageView) findViewById(R.id.image_video_private);
        image_private.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values=new ContentValues();
                values.put("id",rid);
                values.put("img",image);
                Log.i("..........",rid+"");
                Log.i("//////////",image+"");
                database.insert("video",null,values);
            }
        });


        image_video_helder= (ImageView) findViewById(R.id.image_video_helder);
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(RemenVideoActivity.this));

        DisplayImageOptions options = new DisplayImageOptions.Builder().displayer(new CircleBitmapDisplayer()).build();
        imageLoader.displayImage(imageHelder,image_video_helder,options);


        tv_video_name= (TextView) findViewById(R.id.tv_video_name);
        tv_video_online= (TextView) findViewById(R.id.tv_video_online);

        tv_video_name.setText(name);
        tv_video_online.setText(online+"");

        //关注
        image_guanzhu= (ImageView) findViewById(R.id.image_video_guanzhu);
        image_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RemenVideoActivity.this,"已关注",Toast.LENGTH_SHORT);
                image_guanzhu.setVisibility(View.GONE);
            }
        });


        //送礼物
        image_gift= (ImageView) findViewById(R.id.image_video_gift);



    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mLivePlayer.stopPlay(true);
        mLivePlayer = null;
        mPlayerView.destroyDrawingCache();
        mPlayerView.onDestroy();
        mPlayerView = null;
    }

    //分享
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


    public void showMessage(){
        View view=View.inflate(RemenVideoActivity.this,R.layout.showmessage_item,null);

        AlertDialog.Builder builder=new AlertDialog.Builder(RemenVideoActivity.this);
        AlertDialog dialog=builder.create();
        dialog.setView(view);
        dialog.show();

    }



}
