package com.tisu.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author deporation
 * @date 2021/1/1 18:42
 */
@Data
@EntityScan
@TableName("user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 用户uid
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JSONField(ordinal = 1)
    @ApiModelProperty(value = "用戶id")
    private int id;
    /**
     * 用户名
     */
    @JSONField(ordinal = 2)
    @TableId("userName")
    @ApiModelProperty("用戶名")
    private String userName;
    /**
     * 密码
     */
    @JSONField(serialize = false)
    @TableId("password")
    @ApiModelProperty("密碼")
    private String password;
}
