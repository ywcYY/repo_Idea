package com.ywc.controller;

import com.ywc.domain.CourseSection;
import com.ywc.domain.ResponseResult;
import com.ywc.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {
    @Autowired
    private CourseContentService courseContentService;
    @RequestMapping("/courseContent")
    public ResponseResult findSectionAndLessonByCourseId(@RequestParam Integer courseId){

        List<CourseSection> sectionByCourseId = courseContentService.findSectionByCourseId(courseId);

        ResponseResult result = new ResponseResult(true, 200, "响应成功", sectionByCourseId);

        return  result;


    }
/*新增章节信息*/
@RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){
        courseContentService.saveSection(courseSection);
        return  new ResponseResult(true,200,"新增章节成功",null);



    }




}
