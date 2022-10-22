package com.ywc.service;

import com.ywc.domain.CourseSection;

import java.util.List;

public interface CourseContentService {


public List<CourseSection> findSectionByCourseId(Integer courseId);





public  void saveSection(CourseSection courseSection);
}
