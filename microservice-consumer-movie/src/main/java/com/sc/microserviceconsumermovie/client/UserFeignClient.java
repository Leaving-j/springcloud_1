package com.sc.microserviceconsumermovie.client;

import com.sc.microserviceconsumermovie.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

/**
 * @program: microservice-consumer-movie
 * @description: description
 * @author: lw
 * @create: 2019-06-13 17:01
 **/
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
