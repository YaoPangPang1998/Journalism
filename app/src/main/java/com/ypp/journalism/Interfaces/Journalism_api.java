package com.ypp.journalism.Interfaces;

import com.ypp.journalism.DB.NewsCategory;
import com.ypp.journalism.DB.SearchNews;
import com.ypp.journalism.DB.getNews;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface Journalism_api {
    /*获取新闻分类请求
    * */
    @GET("{Newsrequest}")
    Observable<NewsCategory> getNewsCategory(@Path("Newsrequest") String Newsrequest,@HeaderMap Map<String, String> headers);
    /*获取新闻请求*/
    @GET("{Newsrequest}")
    Observable<getNews> getgetNews(@Path("Newsrequest")  String Newsrequest, @HeaderMap Map<String, String> headers, @QueryMap Map<String, String> options);
    /*按关键字搜索请求*/
    @GET("{Newsrequest}")
    Observable<SearchNews> getSearchNews(@Path("Newsrequest")String Newsrequest,@HeaderMap Map<String,String> headers,@Query("Keyword") String Keyword);

}
