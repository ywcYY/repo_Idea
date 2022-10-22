package com.ywc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.dao.ResourceMapper;
import com.ywc.domain.Resource;
import com.ywc.domain.ResourseVo;
import com.ywc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl  implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo) {
        PageHelper.startPage(resourseVo.getCurrentPage(), resourseVo.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourseVo);
        PageInfo<Resource> resourcePageInfo = new PageInfo<>(allResourceByPage);
        return resourcePageInfo;



    }
}
