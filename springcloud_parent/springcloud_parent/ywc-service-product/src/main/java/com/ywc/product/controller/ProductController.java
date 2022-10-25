package com.ywc.product.controller;

import com.ywc.common.pojo.Products;

import com.ywc.product.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author ywc
 * @ClassName ProductController
 * @Description TODO
 * @date 2022-11-09 17:41
 * @Version 1.0
 */
@RestController

@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/query/{id}")
    public Products queryById(@PathVariable Integer id){
        return productService.queryById(id);


    }



}
