package com.tisu.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tisu.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author deporation
 * @date 2021/1/1 20:25
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return user对象
     */
    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") int id);
}
