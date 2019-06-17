package com.sc.microserviceconsumermovie.client;

import com.sc.microserviceconsumermovie.entity.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: microservice-consumer-movie
 * @description: description
 * @author: lw
 * @create: 2019-06-17 15:13
 **/
@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
