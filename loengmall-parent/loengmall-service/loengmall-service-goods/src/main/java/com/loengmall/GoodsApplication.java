package com.loengmall;

import com.loeng.entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
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
@MapperScan(basePackages = {"com.loengmall.goods.dao"})
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }

    /**
     * <p>idWorker</p>
     *
     * * @param 
     *
     * @return com.loeng.entity.IdWorker
     *
     * @author mapengliang
     * @createTime 2020/7/21 22:53
     */
    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
