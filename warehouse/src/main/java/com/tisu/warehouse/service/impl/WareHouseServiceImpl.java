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
     */
    @Override
    public void saveOrUpdateWareHouse(WareHouse wareHouse) {
        if (wareHouseMapper.findWareHouseByUid(wareHouse.get_id()) != null) {
            wareHouseMapper.updateWareHouse(wareHouse);
        } else {
            wareHouseMapper.saveWareHouse(wareHouse);
        }
    }

    /**
     * 根据用户uid查询仓库情况
     *
     * @param uid 用户id
     * @return 用户仓库结果
     */
    @Override
    public WareHouse findWareHouseByUid(int uid) {
        return wareHouseMapper.findWareHouseByUid(uid);
    }
}
