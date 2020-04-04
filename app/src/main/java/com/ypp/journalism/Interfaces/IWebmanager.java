package com.ypp.journalism.Interfaces;

import com.ypp.journalism.DB.NewsCategory;
import com.ypp.journalism.DB.SearchNews;
import com.ypp.journalism.DB.getNews;

import java.util.Map;

import retrofit2.Callback;

public interface IWebmanager {
    /**
     * 获取新闻分类请求重载
     * */
    void get(String url, String Newsrequest, IwebCallBack<NewsCategory> iwebCallBack);
    /**
     * 获取新闻请求
     * */
    void get(String url, String Newsrequest, Map<String,String> headers, Map<String, String> options, IwebCallBack<getNews> iwebCallBack);
    /**
     * 按关键字搜索请求
     * */
    void get(String url, String Newsrequest, Map<String,String> headers, String Keyword, IwebCallBack<SearchNews> iwebCallBack);
}
