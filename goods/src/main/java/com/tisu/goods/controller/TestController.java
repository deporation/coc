package com.tisu.goods.controller;

import com.alibaba.fastjson.JSON;
import com.tisu.commons.entity.ResponseResult;
import com.tisu.commons.utils.SignUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>签名验证</p>
 *
 * @author deporation
 * @date 2021/1/12
 **/
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {
    private static final String SECRET = "XGXTEST";

    @RequestMapping(value = "sign", method = {RequestMethod.POST})
    public String checkSign(@RequestBody Map<String, String> body, HttpServletRequest request) throws Exception {
        Map<String, String[]> queryString = request.getParameterMap();

        StringBuilder stringBuilder = new StringBuilder();

        Map<String, String> param = new HashMap<>();

        queryString.forEach((k, v) -> {
            Arrays.stream(v).forEach(stringBuilder::append);
            param.put(k, stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        });
        param.putAll(body);

        boolean res = SignUtils.checkSign(SECRET, param);
        System.out.println(res);
        if (res) {
            return JSON.toJSONString(ResponseResult.builder().success(res).message("success").state(200).content(param).build());
        } else {
            return JSON.toJSONString(ResponseResult.builder().success(res).message("failure").state(400).content(param).build());
        }
    }
}
