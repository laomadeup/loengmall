package com.loengmall.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author mapengliang
 * @createTime 2020/8/10 10:07
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.loengmall.content.dao")
public class ContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentApplication.class,args);
    }
}
