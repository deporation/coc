package com.tisu.warehouse.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>仓库实体</p>
 * @author deporation
 * @date 2021/1/4 1:17
 */
@Data
@Document(collection = "warehouse")
public class WareHouse implements Serializable {

    @Field("uid")
    @ApiModelProperty("仓库持有者的uid")
    @JSONField(ordinal = 2)
    private int uid;

    @Field("wareHouse")
    @ApiModelProperty("仓库分类存储信息")
    @JSONField(ordinal = 3)
    private Map<String, List<Object>> wareHouse;

}
