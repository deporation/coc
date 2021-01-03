package com.tisu.warehouse.mapper;

import com.tisu.warehouse.entity.WareHouse;

/**
 * <p> 仓库mapper类</p>
 * @author deporation
 * @date 2021/1/4 1:29
 */
public interface WareHouseMapper {
    /**
     * 保存更新的仓库
     * @param wareHouse 仓库实体
     * @return 是否保存成功
     */
    boolean saveWareHouse(WareHouse wareHouse);
}
