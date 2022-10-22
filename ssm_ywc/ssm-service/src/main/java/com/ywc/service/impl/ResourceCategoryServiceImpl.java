package com.ywc.service.impl;

import com.ywc.dao.ResourceCategoryMapper;
import com.ywc.domain.ResourceCategory;
import com.ywc.service.ResourceCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    private ResourceCategoryMapper resourceCategoryMapper;


    @Override
    public List<ResourceCategory> findAllResourceCategory() {


        List<ResourceCategory> allResourceCategory = resourceCategoryMapper.findAllResourceCategory();


        return  allResourceCategory;


    }
}
