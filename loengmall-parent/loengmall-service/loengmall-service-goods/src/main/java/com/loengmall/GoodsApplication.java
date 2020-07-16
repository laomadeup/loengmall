package com.loengmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mapengliang
 * @createTime 2020/7/16 17:51
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient//开启Eureka客户端
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
