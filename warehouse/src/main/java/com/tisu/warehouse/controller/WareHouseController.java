package com.tisu.warehouse.controller;

import com.tisu.commons.entity.ResponseResult;
import com.tisu.warehouse.entity.WareHouse;
import com.tisu.warehouse.service.WareHouseService;
import com.tisu.warehouse.service.fegined.UserServerFeigned;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deporation
 * @date 2021/1/4 1:47
 */
@RestController
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;

    @Autowired
    private UserServerFeigned userServerFeigned;

    @RequestMapping(value = "/buy", method = {RequestMethod.POST})
    @ApiOperation("用户购买")
    public ResponseResult saveWareHouse(@RequestBody WareHouse wareHouse) {
        if (wareHouse != null) {
            wareHouseService.buyGoods(wareHouse);
        }
        return ResponseResult.builder().success(true).message("success").state(200).content(wareHouse).build();
    }

    @RequestMapping(value = "getWareHouseDeatil", method = {RequestMethod.GET})
    @ApiOperation("查询一个用户的仓库记录及其用户信息")
    public ResponseResult findWareHouse(@RequestParam(value = "uid") int id) {
        Map<String,Object> result = new HashMap<>();
        result.put("user",userServerFeigned.getUserDeatilById(id).getContent());
        result.put("warehouse",wareHouseService.findWareHouseByUid(id));
        return ResponseResult.builder().
                success(true).
                message("success").
                state(200).
                content(result).
                build();
    }

}
