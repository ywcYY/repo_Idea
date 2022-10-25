package com.ywc.page.Controller;

import com.ywc.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ywc
 * @ClassName PageController
 * @Description TODO
 * @date 2022-11-10 13:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/page")
public class PageController {

@Autowired
    private RestTemplate restTemplate;
    @GetMapping("/getProduct/{id}")
    public Products getProduct(@PathVariable Integer id){
        //发送http请求给商品微服务  ，将id传过去 ，获取id所对应的product对象
        String url ="http://127.0.0.1:9000/product/query/";

        Products forObject = restTemplate.getForObject(url + id, Products.class);

        return forObject;


    }




}
