package com.tisu.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tisu.user.entity.User;
import com.tisu.user.mapper.UserMapper;
import com.tisu.user.service.UserService;
import com.tisu.commons.utils.Md5;
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
     * @param user 用户
     * @return 用户对象
     * @throws Exception 抛出异常
     */
    @Override
    public User login(User user) throws Exception {
        User search = userMapper.findUserByEmail(user.getEmail());
        if (search != null && Md5.verify(search.getPassword(),Md5.md5key,user.getPassword())) {
            return search;
        }else {
            return null;
        }
    }
}
