package com.dfy.heart.util;

import cn.hutool.crypto.SecureUtil;

/**
 * @author zhangzuhao
 * @description:
 * @date: 2021/4/20 15:24
 */
public class AuthUtil {

    private static final String appId = "dfygoletsgo";
    private static final Long MIN_15 = 15 * 60 * 1000L;

    public static boolean authAccess(String sign, Long time) {
        long currentTimeMillis = System.currentTimeMillis();
        if (MIN_15.compareTo(currentTimeMillis - time) < 0) {
            return false;
        }
        String hex16 = getMd5Sign(appId + time);
        if (!hex16.equals(sign)) {
            return false;
        }
        return true;
    }

    private static String getMd5Sign(String key) {
        return SecureUtil.md5(key);
    }

    public static void main(String[] args) {
        long timeMillis = System.currentTimeMillis();
        String md5Sign = getMd5Sign(appId + timeMillis);
        System.out.println(md5Sign);
        System.out.println(timeMillis);
    }
}
