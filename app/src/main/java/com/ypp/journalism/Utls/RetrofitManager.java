package com.ypp.journalism.Utls;

import android.util.Base64;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ypp.journalism.DB.SearchNews;
import com.ypp.journalism.DB.getNews;
import com.ypp.journalism.Interfaces.IWebmanager;
import com.ypp.journalism.Interfaces.IwebCallBack;
import com.ypp.journalism.Interfaces.Journalism_api;
import com.ypp.journalism.DB.NewsCategory;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager implements IWebmanager {
    //云市场分配的密钥Id
    String secretId = "AKID3q0KG19weMKBws16S1gaayhyic0gap8b0s5";
    //云市场分配的密钥Key
    String secretKey = "d9kVMnnnti39epe5TDnD1LbjAU2ZFaj35MZxgvp1";
    String source = "market";
    // 请求头
    private static Map<String, String> headers = new HashMap<String, String>();
    // 查询参数
    private static Map<String, String> queryParams = new HashMap<String, String>();
    //为切换新闻频道做变量
    public static String channel="头条";
    private Retrofit retrofit;
    Journalism_api journalism_api=retrofit.create(Journalism_api.class);

    //单例模式
    private static RetrofitManager Instance;
    public static RetrofitManager getInstance(){
        if (Instance==null){
            synchronized (RetrofitManager.class){
                if (Instance==null){
                    Instance=new RetrofitManager();
                }
            }
        }
        return Instance;
    }

//    @Override
//    public void get(String url, String Newsrequest, final Callback<NewsCategory> callback) {
//        Calendar cd = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//        String datetime = sdf.format(cd.getTime());
//        String auth = null;
//        try {
//            // 签名
//            auth = calcAuthorization(source, secretId, secretKey, datetime);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //为请求头添加数据
//        headers.put("X-Source", source);
//        headers.put("X-Date", datetime);
//        headers.put("Authorization", auth);
//        //为
//        queryParams.put("channel", channel);
//        queryParams.put("num", "");
//        queryParams.put("start", "");
//        //实现网络请求
//        retrofit=new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build();
//        //创建接口实例
//       journalism_api.getNewsCategory(Newsrequest,headers)
//               .subscribeOn(Schedulers.io())
//               .observeOn(AndroidSchedulers.mainThread())
//               .subscribe(new Observer<NewsCategory>() {
//                   @Override
//                   public void onSubscribe(Disposable d) {
//
//                   }
//
//                   @Override
//                   public void onNext(NewsCategory value) {
//                       callback.onResponse(value);
//                   }
//
//                   @Override
//                   public void onError(Throwable e) {
//
//                   }
//
//                   @Override
//                   public void onComplete() {
//
//                   }
//               });

//        journalism_api.getNewsCategory(Newsrequest,headers,queryParams)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                );
 //   }

    /**
     * KEY加密算法
     * */
    public static String calcAuthorization(String source, String secretId, String secretKey, String datetime)
            throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        String signStr = "x-date: " + datetime + "\n" + "x-source: " + source;
        Mac mac = Mac.getInstance("HmacSHA1");
        Key sKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), mac.getAlgorithm());
        mac.init(sKey);
        byte[] hash = mac.doFinal(signStr.getBytes("UTF-8"));
//        String sig = new BASE64Encoder().encode(hash);
        String sig = Base64.encodeToString(hash,Base64.NO_WRAP);
        String auth = "hmac id=\"" + secretId + "\", algorithm=\"hmac-sha1\", headers=\"x-date x-source\", signature=\"" + sig + "\"";
        return auth;
    }

    @Override
    public void get(String url, String Newsrequest, final IwebCallBack<NewsCategory> iwebCallBack) {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String datetime = sdf.format(cd.getTime());
        String auth = null;
        try {
            // 签名
            auth = calcAuthorization(source, secretId, secretKey, datetime);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //为请求头添加数据
        headers.put("X-Source", source);
        headers.put("X-Date", datetime);
        headers.put("Authorization", auth);
        //为
        queryParams.put("channel", channel);
        queryParams.put("num", "");
        queryParams.put("start", "");
        //实现网络请求
        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //创建接口实例
        journalism_api.getNewsCategory(Newsrequest,headers)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsCategory>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsCategory value) {
                        iwebCallBack.onRuccess(iwebCallBack);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void get(String url, String Newsrequest, Map<String, String> headers, Map<String, String> options, IwebCallBack<getNews> iwebCallBack) {

    }

    @Override
    public void get(String url, String Newsrequest, Map<String, String> headers, String Keyword, IwebCallBack<SearchNews> iwebCallBack) {

    }
}
