package com.tisu.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.google.common.net.MediaType;
import com.tisu.commons.entity.ResponseResult;
import com.tisu.user.entity.User;
import com.tisu.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author deporation
 * @date 2021/1/1 20:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ApiOperation("用户登录")
    public String login(@RequestBody User user, HttpServletRequest request) throws Exception {
        User search = userService.login(user);
        ResponseResult responseResult = new ResponseResult();
         if (search != null){
             HttpSession session = request.getSession();
             String accessToken = UUID.randomUUID().toString();
             session.setAttribute("accessToken", accessToken);
             session.setAttribute("user_id",user.getId());
             redisTemplate.opsForValue().set("user"+user.getId(),search,30, TimeUnit.SECONDS);
             responseResult = ResponseResult.builder().success(true).state(200).message("success").content(search).build();
         }else{
             responseResult = ResponseResult.builder().success(false).state(400).message("failure").content(search).build();
         }
        System.out.println(responseResult);
        return JSON.toJSONString(responseResult);
    }

}
