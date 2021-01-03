package com.tisu.warehouse.service;

import com.tisu.warehouse.entity.WareHouse;

/**
 * @author deporation
 * @date 2021/1/4 1:39
 */
public interface WareHouseService {
    /**
     * 购买商品改变库存
     * @param wareHouse 需要改变的仓库
     * @return 改变的之后的结果
     */
    WareHouse buyGoods(WareHouse wareHouse);
}
