package com.tisu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tisu.user.entity.User;

/**
 * @author deporation
 * @date 2021/1/1 20:28
 */
public interface UserService extends IService<User> {
    /**
     * 根据id查询用户对象
     *
     * @param user 用户
     * @return 用户对象
     * @throws Exception 抛出异常
     */
    User login(User user) throws Exception;


}
