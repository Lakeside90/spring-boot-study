package com.demozi.spring.boot.data;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScans({@MapperScan("com.demozi.spring.boot.data.mysql.mybatisplus.mapper"),
        @MapperScan("com.demozi.spring.boot.data.mysql.mybatisplus.generator.gencode.mapper")})
public class SpringBootDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataApplication.class, args);
    }

}
