package com.tisu.warehouse.mapper.impl;

import com.tisu.warehouse.entity.WareHouse;
import com.tisu.warehouse.mapper.WareHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author deporation
 * @date 2021/1/4 1:35
 */
@Component
public class WareHouseMapperImpl implements WareHouseMapper {

    @Resource
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

    /**
     * 根据uid进行仓库存储查询
     *
     * @param uid 用户uid
     * @return 查询到的仓储结果
     */
    @Override
    public WareHouse findWareHouseByUid(int uid) {
        Query query = new Query(Criteria.where("uid").is(uid));
        return mongoTemplate.findOne(query,WareHouse.class);
    }
}
