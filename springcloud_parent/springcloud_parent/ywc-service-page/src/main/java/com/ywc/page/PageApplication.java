package com.ywc.page;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ywc
 * @ClassName PageApplication
 * @Description TODO
 * @date 2022-11-10 13:22
 * @Version 1.0
 */
@SpringBootApplication
public class PageApplication {

    public static void main(String[] args) {

        SpringApplication.run(PageApplication.class, args);
    }
    //向我们的容器中注入一个RestTemplate，封装了HttpClient
    @Bean
    public RestTemplate restTemplate(){

        return  new RestTemplate();

    }


}
