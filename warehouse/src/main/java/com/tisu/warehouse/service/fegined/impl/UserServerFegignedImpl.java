package com.tisu.warehouse.service.fegined.impl;

import com.tisu.commons.entity.ResponseResult;
import com.tisu.warehouse.service.fegined.UserServerFeigned;
import org.springframework.stereotype.Component;

/**
 * @author deporation
 * @date 2021/1/7 0:36
 */
@Component
public class UserServerFegignedImpl implements UserServerFeigned {

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public ResponseResult getUserDeatilById(int id) {
        return ResponseResult.builder().success(false).state(400).message("failure").content(null).build();
    }
}
