package com.ypp.journalism.Interfaces;

import com.ypp.journalism.DB.NewsCategory;

public interface IloadListener {
    /**
     * @param newsCategory 成功回调
     */
    void Success(NewsCategory newsCategory);

    /**
     * @param errMsg 错误信息
     */
    void Error(String errMsg);
}
