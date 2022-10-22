package com.ywc.dao;

import com.ywc.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {







    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);



    /*新增章节信息*/


    public void saveSection(CourseSection  courseSection);
}
