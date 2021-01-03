package com.tisu.warehouse.mapper.impl;

import com.tisu.warehouse.entity.WareHouse;
import com.tisu.warehouse.mapper.WareHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author deporation
 * @date 2021/1/4 1:35
 */
@Component
public class WareHouseMapperImpl implements WareHouseMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存更新的仓库
     *
     * @param wareHouse 仓库实体
     * @return 是否保存成功
     */
    @Override
    public boolean saveWareHouse(WareHouse wareHouse) {
        mongoTemplate.save(wareHouse);
        return true;
    }
}
