package com.zhao;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * （注：系统名称 - 模块名称 - 功能名称）
 * Copyright 1998-2023 company dept
 * @author zhaoYI 2023-11-30 21:26
 * @version 0.1
 * @date 2023-11-30（注：最后更新日期）
 * Modification History:
 *    Date         Author       Version     Description
 * ****************************************************
 *  2023-11-30   zhaoYI       0.1         初始开发
 **/
@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableCaching
@EnableTransactionManagement
@MapperScan("com.zhao.springboot.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
