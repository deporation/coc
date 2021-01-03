package com.tisu.commons.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

/**
 * @author deporation
 * @date 2021/1/3 16:37
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ResponseResult {
    @JSONField(ordinal = 1)
    private Boolean success;
    @JSONField(ordinal = 2)
    private Integer state;
    @JSONField(ordinal = 3)
    private String message;
    @JSONField(ordinal = 4)
    private Object content;

}
