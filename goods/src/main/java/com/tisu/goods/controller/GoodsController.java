package com.tisu.goods.controller;

import com.tisu.commons.utils.SignUtils;
import com.tisu.commons.entity.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 商品控制器 </p>
 *
 * @author deporation
 * @date 2021/1/9
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping(value = "/findGoodsByType", method = {RequestMethod.GET})
    public ResponseResult findGoodsByType(@RequestParam(value = "id") int goodType) {

        return null;
    }

}
