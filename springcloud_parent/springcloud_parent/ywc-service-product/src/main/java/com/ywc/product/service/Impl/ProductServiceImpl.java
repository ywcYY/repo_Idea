package com.ywc.product.service.Impl;

import com.ywc.common.pojo.Products;
import com.ywc.product.mapper.ProductMapper;
import com.ywc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ywc
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @date 2022-11-09 17:37
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductMapper productMapper;



    @Override
    public Products queryById(Integer id) {
        return productMapper.selectById(id);
    }
}
