package com.ywc.controller;


import com.ywc.domain.Test;
import com.ywc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController  //Controller+ ResponseBody


@RequestMapping("/test")

public class TestController {
    @Autowired
    private TestService testService;

@RequestMapping("/findAll")
    public List<Test> findAll(){
        List<Test> all = testService.findAll();
        return all;

    }
}
