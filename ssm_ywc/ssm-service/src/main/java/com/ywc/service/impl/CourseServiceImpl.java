package com.ywc.service.impl;

import com.ywc.dao.CourseMapper;
import com.ywc.domain.Course;
import com.ywc.domain.CourseVO;
import com.ywc.domain.Teacher;
import com.ywc.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

@Autowired
    private CourseMapper courseMapper;
    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        List<Course> courseByCondition = courseMapper.findCourseByCondition(courseVO);

        return courseByCondition;

    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);
        //保存课程
        courseMapper.saveCourse(course);
        //获取新插入数据的id值
        int id = course.getId();
        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);
        //补全讲师信息
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);
        teacher.setCourseId(id);

        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVO findCourseById(Integer id) {

        return courseMapper.findCourseById(id);

    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVO);
        //信息的补全
        Date date = new Date();

        course.setUpdateTime(date);

        courseMapper.updateCourse(course);


        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        courseMapper.updateTeacher(teacher);


    }

    @Override
    public void updateCourseStatus(int courseId, int status) {
        //1.封装数据
        Course course = new Course();
        course.setId(courseId);
        course.setStatus(status);

        course.setUpdateTime(new Date());


        //2.调用mapper

        courseMapper.updateCourseStatus(course);
    }

}
