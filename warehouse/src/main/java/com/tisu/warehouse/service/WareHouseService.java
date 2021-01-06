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

    /**
     * 根据用户uid查询仓库情况
     * @param uid 用户id
     * @return 用户仓库结果
     */
    WareHouse findWareHouseByUid(int uid);
}
