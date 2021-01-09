package com.tisu.goods.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

/**
 * <p> 商品表 </p>
 *
 * @author deporation
 * @date 2021/1/7
 **/

@Data
@Document(collection = "goods")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods {

    @MongoId(targetType = FieldType.INT64)
    @ApiModelProperty("商品id")
    @Field("goodsId")
    private int goodsId;

    @Field(name = "goodName", targetType = FieldType.STRING)
    @ApiModelProperty("商品")
    private String goodName;

    @Field(name = "types", targetType = FieldType.ARRAY)
    @ApiModelProperty("商品类型标签")
    private List<GoodsType> types;
}
