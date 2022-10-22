package com.ywc.service;

import com.ywc.domain.Course;
import com.ywc.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {


    List<Course> findCourseByCondition(CourseVO courseVO);


    /*添加课程及讲师信息*/
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;



/*根据id查询课程信息*/
    public CourseVO findCourseById(Integer id);


    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;


/*修改课程状态*/

    public void updateCourseStatus(int courseId,int status);
}
