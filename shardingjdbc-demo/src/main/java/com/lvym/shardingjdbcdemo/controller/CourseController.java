package com.lvym.shardingjdbcdemo.controller;

import com.lvym.shardingjdbcdemo.entity.Course;
import com.lvym.shardingjdbcdemo.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseMapper courseMapper;
    @RequestMapping("/test")
    public void test(){
        Course course=new Course();
        course.setCname("java");
        course.setUserId(100L);
        course.setCstatus("normal");

        courseMapper.insert(course);
    }

}
