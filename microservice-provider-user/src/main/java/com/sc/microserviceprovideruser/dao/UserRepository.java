package com.sc.microserviceprovideruser.dao;

import com.sc.microserviceprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: microservice-provider-user
 * @description: description
 * @author: lw
 * @create: 2019-06-13 15:01
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}