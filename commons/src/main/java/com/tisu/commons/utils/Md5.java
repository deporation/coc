package com.tisu.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author deporation
 * @date 2021/1/3 16:08
 */
public class Md5 {
    public final static  String md5key = "tisu";
    /**
     * MD5方法
     * @param text 明文 123456
     * @param key 密钥  lagou
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        return DigestUtils.md5Hex(text+key);
    }

    /**
     * MD5验证方法
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = md5(text, key);
        return md5Text.equalsIgnoreCase(md5);
    }
}
