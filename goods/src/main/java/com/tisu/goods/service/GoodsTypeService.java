package com.tisu.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tisu.goods.entity.GoodsType;
import com.tisu.goods.mapper.GoodTypeMapper;

import java.util.List;

/**
 * <p>商品种类服务类</p>
 *
 * @author deporation
 * @date 2021/1/9
 **/
public interface GoodsTypeService extends IService<GoodsType> {

    /**
     * 返回所有的商品种类标签
     *
     * @return 所有的商品种类标签
     */
    List<GoodsType> findAllGoodsType();

    /**
     * 批量插入商品种类标签
     *
     * @param goodsTypes 需要插入的goodsType
     * @return 现有所有的商品种类
     */
    List<GoodsType> batchInsertGoodsType(List<GoodsType> goodsTypes);

}
