package com.ywc.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author ywc
 * @ClassName ProductApplication
 * @Description TODO
 * @date 2022-11-09 17:26
 * @Version 1.0
 */

@SpringBootApplication
@MapperScan("com.ywc.product.mapper")
public class ProductApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class,args);
    }


}
