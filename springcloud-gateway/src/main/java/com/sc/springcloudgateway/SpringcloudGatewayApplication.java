package com.sc.springcloudgateway;

import com.sc.springcloudgateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
