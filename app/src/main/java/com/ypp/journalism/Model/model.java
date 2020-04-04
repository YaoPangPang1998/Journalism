package com.ypp.journalism.Model;

import com.ypp.journalism.Config.UrlConfig;
import com.ypp.journalism.Interfaces.IloadListener;

public class model implements imodel {
    @Override
    public void BeanLoad(IloadListener iloadListener) {
        String Homeurl= UrlConfig.baseurl+UrlConfig.requestType[1];

    }
}
