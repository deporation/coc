package com.tisu.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tisu.user.entity.User;
import com.tisu.user.mapper.UserMapper;
import com.tisu.user.service.UserService;
import com.tisu.commons.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author deporation
 * @date 2021/1/1 20:30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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
        if (search != null && Md5.verify(search.getPassword(), Md5.md5key, user.getPassword())) {
            redisTemplate.opsForValue().set("user:" + search.getId(), search, 30, TimeUnit.SECONDS);
            return search;
        } else {
            return null;
        }
    }

    /**
     * 根据id查询结果
     *
     * @param id 用户id
     * @return 查询结果
     */
    @Override
    public User findById(Integer id) {
        User user = (User) redisTemplate.opsForValue().get("user:" + id);
        if (user == null) {
            user = userMapper.findUserById(id);
            if (user == null) {
                return null;
            }
        }
        redisTemplate.opsForValue().set("user:" + id, user, 30, TimeUnit.SECONDS);
        return user;
    }
}
