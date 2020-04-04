package com.ypp.journalism.Factroy;

import com.ypp.journalism.Interfaces.IWebmanager;
import com.ypp.journalism.Utls.RetrofitManager;

public class WebFactory {
    public static IWebmanager getWebManager(){
        return RetrofitManager.getInstance();
    }

}
