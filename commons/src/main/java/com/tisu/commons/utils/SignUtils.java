package com.tisu.commons.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Map;


/**
 * <p>验签工具类</p>
 *
 * @author deporation
 * @date 2021/1/12
 **/
@Slf4j
public class SignUtils {

    /**
     * 验签方法，java
     *
     * @param secret 密钥
     * @param param  参数字典
     * @return 签名是否验证成功
     * @throws Exception md5模块异常
     */
    public static boolean checkSign(String secret, Map<String, String> param) throws Exception {
        // 服务端签名不参与签名计算
        String remoteSign = param.remove("sign");
        String[] keys = param.keySet().toArray(new String[0]);
        // 1. 针对参数进行排序
        Arrays.sort(keys);
        // 2. 构造文本
        String method = null;
        StringBuilder textBuilder = new StringBuilder();
        if (param.containsKey("signMethod")) {
            method = param.get("signMethod");
            if ("md5".equals(method)) {
                textBuilder.append(secret);
            }
        } else {
            method = "md5";
            textBuilder.append(secret);
        }

        Arrays.stream(keys).forEach(key -> textBuilder.append(key).append(param.get(key)));
        log.info(textBuilder.toString());
        // 3. 进行验签
        if ("md5".equals(method)) {
            log.info(md5(textBuilder.toString(), secret).toUpperCase());
            return md5(textBuilder.toString(), secret).toUpperCase().equals(remoteSign);
        } else if ("hmac".equals(method)) {
            return encryptHMAC(textBuilder.toString(), secret).equals(remoteSign);
        } else {
            return false;
        }
    }

    /**
     * MD5方法
     *
     * @param text 明文 加密文本
     * @param key  密钥  YYXYTEST
     * @return 密文
     * @throws Exception Exception
     */
    private static String md5(String text, String key) throws Exception {
        //加密后的字符串
        log.info(text + key);
        return DigestUtils.md5Hex(text + key);
    }

    private static String encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        StringBuilder sign = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(aByte & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }

}
