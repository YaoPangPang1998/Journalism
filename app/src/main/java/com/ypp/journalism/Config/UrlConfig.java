package com.ypp.journalism.Config;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class UrlConfig {
    public static String baseurl="https://service-aqvnjmiq-1257101137.gz.apigw.tencentcs.com/release/news/";
    public static String [] requestType={"search","channel","get"};
    public static String SecretID="AKID3q0KG19weMKBws16S1gaayhyic0gap8b0s5";
    public static String SecretKey="d9kVMnnnti39epe5TDnD1LbjAU2ZFaj35MZxgvp1";
    //ID以及KEY
    //云市场分配的密钥Id
    public static String secretId = "AKID3q0KG19weMKBws16S1gaayhyic0gap8b0s5";
    //云市场分配的密钥Key
    public static String secretKey = "d9kVMnnnti39epe5TDnD1LbjAU2ZFaj35MZxgvp1";
    public static String source = "market";

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

}
