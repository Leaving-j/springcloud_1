package com.sc.microserviceconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sc.microserviceconsumermovie.client.UserFeignClient;
import com.sc.microserviceconsumermovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: microservice-provider-user
 * @description: description
 * @author: lw
 * @create: 2019-06-13 15:02
 **/
@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/users/{id}", User.class, id);
    }

    @GetMapping("/userFeign/{id}")
    public User findUserById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    public User findByIdFallback(Long id) {
        return new User(id,"xixi","xiaoxi",12,null);
    }
}