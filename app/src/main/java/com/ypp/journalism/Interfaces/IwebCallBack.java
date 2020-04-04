package com.ypp.journalism.Interfaces;

import com.ypp.journalism.DB.NewsCategory;

public interface IwebCallBack<T>{
    /*网络回调方法*/
    //成功返回一个对象
    void onRuccess(IwebCallBack<T> iwebCallBack);
    void fail(String errMSG);
}
