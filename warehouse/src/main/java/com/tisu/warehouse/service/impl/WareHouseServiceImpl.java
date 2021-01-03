package com.tisu.warehouse.service.impl;

import com.tisu.warehouse.entity.WareHouse;
import com.tisu.warehouse.mapper.WareHouseMapper;
import com.tisu.warehouse.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deporation
 * @date 2021/1/4 1:45
 */
@Service
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseMapper wareHouseMapper;

    /**
     * 购买商品改变库存
     *
     * @param wareHouse 需要改变的仓库
     * @return 改变的之后的结果
     */
    @Override
    public WareHouse buyGoods(WareHouse wareHouse) {
        if (wareHouseMapper.saveWareHouse(wareHouse)){
            return wareHouse;
        }else{
            return null;
        }
    }
}
