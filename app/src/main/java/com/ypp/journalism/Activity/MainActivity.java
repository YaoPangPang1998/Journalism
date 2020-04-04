package com.ypp.journalism.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.DnsResolver;
import android.os.Bundle;
import android.util.Log;

import com.ypp.journalism.Config.UrlConfig;
import com.ypp.journalism.DB.NewsCategory;
import com.ypp.journalism.Factroy.WebFactory;
import com.ypp.journalism.Interfaces.IwebCallBack;
import com.ypp.journalism.R;

import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements iview {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String url = "https://service-aqvnjmiq-1257101137.gz.apigw.tencentcs.com/release/news/";
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                WebFactory.getWebManager().get(url, UrlConfig.requestType[2], new IwebCallBack() {
//                    @Override
//                    public void onRuccess(NewsCategory newsCategory) {
//                        Log.i("sssss", "onRuccess: "+newsCategory.getResult().get(0).toString());
//                    }
//
//                    @Override
//                    public void fail(String errMSG) {
//
//                    }
//                });
////                NewManager.todo();
//            }
//        }).start();
        //Callback<>
    }
}
