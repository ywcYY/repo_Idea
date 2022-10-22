package com.ywc.dao;

import com.ywc.domain.Course;
import com.ywc.domain.CourseVO;
import com.ywc.domain.Teacher;

import java.util.List;

public interface CourseMapper {

    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*新增课程信息*/
    public void saveCourse(Course course);


    public  void saveTeacher(Teacher teacher);
    /*回显课程信息（根据id查询对应的课程信息以及对应的讲师信息）*/
    public CourseVO findCourseById(Integer id);
    public  void updateCourse(Course course);
    public void updateTeacher(Teacher teacher);
    public  void  updateCourseStatus(Course course);



}
