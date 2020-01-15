package com.example.demo;

import com.example.demo.contorl.MyBatis;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@MapperScan("com.mybatis.mapper")
public class SicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SicApplication.class, args);
        MyBatis.getMyBatis();
    }

}
