package com.tisu.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.tisu.user.entity.User;
import com.tisu.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author deporation
 * @date 2021/1/1 20:33
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    @ApiOperation("根據id查詢用戶")
    @ApiImplicitParam(name = "id",value = "用戶id",required = true)
    @ResponseBody
    public String login(@RequestBody Map<String,String> id){
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(User.class,"id","userName");
        return JSON.toJSONString(userService.findUserById(Integer.parseInt(id.get("id"))));
    }

}
