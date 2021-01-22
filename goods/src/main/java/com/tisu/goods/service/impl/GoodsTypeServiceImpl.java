package com.tisu.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tisu.goods.entity.GoodsType;
import com.tisu.goods.mapper.GoodTypeMapper;
import com.tisu.goods.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author deporation
 * @date 2021/1/9
 **/
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodTypeMapper, GoodsType> implements GoodsTypeService {

    private final GoodTypeMapper goodTypeMapper;

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public GoodsTypeServiceImpl(GoodTypeMapper goodTypeMapper, RedisTemplate<String, Object> redisTemplate) {
        this.goodTypeMapper = goodTypeMapper;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 返回所有的商品种类标签
     *
     * @return 所有的商品种类标签
     */
    @Override
    public List<GoodsType> findAllGoodsType() {
        List<GoodsType> goodsTypes = new ArrayList<>();
        if (redisTemplate.opsForValue().get("goodsTypes") instanceof List) {
            goodsTypes = (List<GoodsType>) redisTemplate.opsForValue().get("goodsTypes");
            if (goodsTypes == null) {
                goodsTypes = goodTypeMapper.selectAllGoodsType();
                redisTemplate.opsForValue().set("goodsTypes", goodsTypes);
                return goodsTypes;
            } else {
                return goodsTypes;
            }
        } else {
            goodsTypes = goodTypeMapper.selectAllGoodsType();
            redisTemplate.opsForValue().set("goodsTypes", goodsTypes);
            return goodsTypes;
        }
    }

    /**
     * 批量插入商品种类标签
     *
     * @param goodsTypes 需要插入的goodsType
     * @return 现有所有的商品种类
     */
    @Override
    public List<GoodsType> batchInsertGoodsType(List<GoodsType> goodsTypes) {
        int rows = goodTypeMapper.batchInsertGoodsType(goodsTypes);
        if (rows != 0) {

        }
        return null;
    }
}
