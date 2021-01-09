package com.tisu.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tisu.goods.entity.GoodsType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>商品类别标签mapper</p>
 *
 * @author deporation
 * @date 2021/1/9
 **/
@Mapper
@Component
public interface GoodTypeMapper extends BaseMapper<GoodsType> {

    /**
     * 批量插入标签
     *
     * @param goodsTypes 标签集合
     * @return 插入成功个数
     */
    @Insert("<script> " +
            "INSERT INTO goodsType(type) " +
            "VALUES" +
            "<foreach collection='goodsTypes' item ='goodsType' index='index' separator=','>" +
            "(#{goodsType.type})" +
            "</foreach>" +
            "</script>"
    )
    int batchInsertGoodsType(List<GoodsType> goodsTypes);

    /**
     * 查询所有的标签
     *
     * @return 返回所有的标签
     */
    @Select("SELECT * FROM goodsType")
    List<GoodsType> selectAllGoodsType();
}
