package com.zz.csms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "com.zz.csms.dao" })
public class CsmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsmsApplication.class, args);
    }

}
