package com.tisu.goods.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>商品类型类</p>
 * 设计用意为区分，诸如是否可叠放，是否可以重复购买，是否可消耗，顺带区分栏目
 *
 * @author deporation
 * @date 2021/1/7
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("goodsType")
public class GoodsType {
    /**
     * 商品类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 1)
    @ApiModelProperty("商品类别id")
    private int goodsTypeId;

    /**
     * 商品类别具体描述
     */
    @TableField("商品类型")
    @JSONField(ordinal = 2)
    @ApiModelProperty("商品类别具体描述")
    private String goodsType;
}
