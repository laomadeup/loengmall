package com.loengmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mapengliang
 * @createTime 2020/7/16 17:51
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient//开启Eureka客户端
/*
* 开启通用Mapper包的扫描
* 注解报名：tk.mybatis.spring.annotation.MapperScan
* */
@MapperScan(basePackages = {"com.loengmall.dao"})
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
