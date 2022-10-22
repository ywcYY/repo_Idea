package com.ywc.service.impl;

import com.ywc.dao.TestMapper;
import com.ywc.domain.Test;
import com.ywc.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Test> findAll() {
        List<Test> all = testMapper.findAll();

        return  all;


    }
}
