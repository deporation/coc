package com.tisu.warehouse.controller;

import com.alibaba.fastjson.JSON;
import com.tisu.commons.entity.ResponseResult;
import com.tisu.warehouse.entity.WareHouse;
import com.tisu.warehouse.service.WareHouseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

/**
 * @author deporation
 * @date 2021/1/4 1:47
 */
@RestController
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;

    @RequestMapping(value = "/buy",method = {RequestMethod.POST})
    @ApiOperation("用户购买")
    public ResponseResult saveWareHouse(@RequestBody WareHouse wareHouse){
        if (wareHouse != null){
            wareHouseService.buyGoods(wareHouse);
        }
        return ResponseResult.builder().success(true).message("success").state(200).content(wareHouse).build();
    }
}
