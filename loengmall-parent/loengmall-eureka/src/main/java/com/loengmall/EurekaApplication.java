package com.loengmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mapengliang
 * @createTime 2020/7/16 9:26
 * @desc
 */
@SpringBootApplication
@EnableEurekaServer //开启eureka服务
public class EurekaApplication {


    /**
     * <p>加载启动类，已启动类为当前springboot配置标准</p>
     *
     * * @param args
     *
     * @return
     *
     * @author mapengliang
     * @createTime 2020/7/16 9:34
     */
    public static void main(String[] args) {

        SpringApplication.run(EurekaApplication.class,args);

    }
}
