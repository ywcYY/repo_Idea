package com.ywc.service.impl;

import com.ywc.dao.CourseContentMapper;
import com.ywc.domain.CourseSection;
import com.ywc.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CourseContentServiceImpl implements CourseContentService {
    @Autowired
    private CourseContentMapper courseContentMapper;
    @Override
    public List<CourseSection> findSectionByCourseId(Integer courseId) {
        List<CourseSection> list = courseContentMapper.findSectionAndLessonByCourseId(courseId);


        return  list;

    }

    @Override
    public void saveSection(CourseSection courseSection) {

        //1.补全信息
        courseSection.setCreateTime(new Date());
        courseSection.setUpdateTime(new Date());


        //2.调用mapper方法
        courseContentMapper.saveSection(courseSection);



    }
}
