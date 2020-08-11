package com.gsl.data;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ：Guo Shi Lin
 * @date ： 2020/8/10 14:29
 * @description：启动类
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class DataSourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }
}
