package com.tisu.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tisu.user.entity.User;
import com.tisu.user.mapper.UserMapper;
import com.tisu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author deporation
 * @date 2021/1/1 20:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id查询用户对象
     *
     * @param id 用户uid
     * @return 用户对象
     */
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }
}
