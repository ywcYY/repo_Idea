package com.ywc.dao;

import com.ywc.domain.Resource;
import com.ywc.domain.ResourseVo;

import java.util.List;

public interface ResourceMapper {



    /*
    *
    * 资源分页& 多条件查询*/
    public List<Resource> findAllResourceByPage(ResourseVo resourseVo);
}
