package com.ywc.service;

import com.github.pagehelper.PageInfo;
import com.ywc.domain.Resource;
import com.ywc.domain.ResourseVo;

import java.util.List;

public interface ResourceService {


    /*资源分页  && 多条件查询*/


    public PageInfo<Resource> findAllResourceByPage(ResourseVo resourseVo);
}
