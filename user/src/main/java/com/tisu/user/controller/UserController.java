package com.tisu.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.tisu.user.entity.User;
import com.tisu.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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
    /**
     * 在MyRedisConfig文件中配置了redisTemplate的序列化之后， 客户端也能正确显示键值对了
     */
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ApiOperation("根据id查询用户")
    @ApiImplicitParam(name = "id",value = "用户id",required = true)
    public String login(@RequestBody Map<String,String> query){
        User user = (User) redisTemplate.opsForValue().get("user"+query.get("id"));
         if (user == null){
            user = userService.findUserById(Integer.parseInt(query.get("id")));
            redisTemplate.opsForValue().set("user"+query.get("id"),user,30, TimeUnit.SECONDS);
         }
        return JSON.toJSONString(user);
    }

}
