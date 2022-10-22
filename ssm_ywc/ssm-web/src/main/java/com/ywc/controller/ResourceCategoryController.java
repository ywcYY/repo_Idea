package com.ywc.controller;

import com.ywc.domain.ResourceCategory;
import com.ywc.domain.ResponseResult;
import com.ywc.service.ResourceCategoryService;
import com.ywc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/resourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService resourceCategoryService;
@RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){

    List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();


    return new ResponseResult(true,200,"响应成功",allResourceCategory);





}






}
