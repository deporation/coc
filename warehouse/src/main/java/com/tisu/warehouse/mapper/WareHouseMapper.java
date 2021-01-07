package com.tisu.warehouse.mapper;

import com.tisu.warehouse.entity.WareHouse;

/**
 * <p> 仓库mapper类</p>
 *
 * @author deporation
 * @date 2021/1/4 1:29
 */
public interface WareHouseMapper {
    /**
     * 保存更新的仓库
     *
     * @param wareHouse 仓库实体
     * @return 是否保存成功
     */
    boolean saveWareHouse(WareHouse wareHouse);

    /**
     * 根据uid进行仓库存储查询
     *
     * @param uid 用户uid
     * @return 查询到的仓储结果
     */
    WareHouse findWareHouseByUid(int uid);

    /**
     * 更新仓库
     *
     * @param wareHouse 需要更新的仓库
     * @return 更新是否成功
     */
    boolean updateWareHouse(WareHouse wareHouse);
}
