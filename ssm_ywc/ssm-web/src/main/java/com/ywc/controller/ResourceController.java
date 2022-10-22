package com.ywc.controller;

import com.github.pagehelper.PageInfo;
import com.ywc.domain.Resource;
import com.ywc.domain.ResourseVo;
import com.ywc.domain.ResponseResult;
import com.ywc.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    public ResponseResult  findAllResourceByPage(@RequestBody ResourseVo resourseVo){

        PageInfo<Resource> allResourceByPage = resourceService.findAllResourceByPage(resourseVo);



        return  new ResponseResult(true,200,"响应成功",allResourceByPage);




    }

}
