package com.tisu.user.controller;

import com.alibaba.fastjson.JSON;
import com.tisu.commons.entity.ResponseResult;
import com.tisu.user.entity.User;
import com.tisu.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author deporation
 * @date 2021/1/1 20:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ApiOperation("用户登录")
    @ApiImplicitParam(name = "user", value = "用户", paramType = "body", dataType = "User")
    public ResponseResult login(@RequestBody User user, HttpServletRequest request) throws Exception {
        User search = userService.login(user);
        ResponseResult responseResult;
         if (search != null){
             HttpSession session = request.getSession();
             String accessToken = UUID.randomUUID().toString();
             session.setAttribute("accessToken", accessToken);
             session.setAttribute("userId",user.getId());
             Map<String, Object> map = new HashMap<>();
             map.put("accessToken", accessToken);
             map.put("userId", search.getId());
             responseResult = ResponseResult.builder().success(true).state(200).message("success").content(map).build();
         } else {
             responseResult = ResponseResult.builder().success(false).state(400).message("failure").content(null).build();
         }
        return responseResult;
    }

    @RequestMapping(value = "/findById", method = {RequestMethod.GET})
    @ApiOperation("根据用户的user_id来获取用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", dataType = "int", required = true)
    public ResponseResult findById(@RequestParam int id) {
        User user = userService.findById(id);
        ResponseResult responseResult;
        if (user == null) {
            responseResult = ResponseResult.builder().success(false).state(400).message("未找到该用户").content(null).build();
        } else {
            responseResult = ResponseResult.builder().success(true).state(200).message("success").content(JSON.toJSON(user)).build();
        }
        return responseResult;
    }

}
