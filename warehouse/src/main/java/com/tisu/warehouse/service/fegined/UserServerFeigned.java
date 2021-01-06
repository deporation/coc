package com.tisu.warehouse.service.fegined;

import com.tisu.commons.entity.ResponseResult;
import com.tisu.warehouse.service.fegined.impl.UserServerFegignedImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> 用户服务调动中心 </p>
 * @author deporation
 * @date 2021/1/6 0:41
 */
@Service
@FeignClient(value = "user-service",path = "/user",fallback = UserServerFegignedImpl.class)
public interface UserServerFeigned {
    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    @RequestMapping(value = "/findById")
    ResponseResult getUserDeatilById(@RequestParam(value = "id") int id);
}
