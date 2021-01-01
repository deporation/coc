package com.tisu.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tisu.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deporation
 * @date 2021/1/1 20:28
 */
public interface UserService extends IService<User> {
    /**
     * 根据id查询用户对象
     *
     * @param id 用户uid
     * @return 用户对象
     */
    User findUserById(int id);
}
