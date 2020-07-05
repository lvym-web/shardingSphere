package com.lvym.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lvym.shardingjdbcdemo.entity.Course;
import com.lvym.shardingjdbcdemo.entity.Udict;
import com.lvym.shardingjdbcdemo.entity.User;
import com.lvym.shardingjdbcdemo.mapper.CourseMapper;
import com.lvym.shardingjdbcdemo.mapper.UdictMapper;
import com.lvym.shardingjdbcdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingjdbcDemoApplicationTests {


    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UdictMapper udictMapper;
    @Test
    public void add() {


        Course course = new Course();
        course.setCname("sql");
        course.setUserId(100L);
        course.setCstatus("normal");

        courseMapper.insert(course);

    }

    @Test
    public void add2() {

        for (int i = 9; i < 21; i++) {
            Course course = new Course();
            course.setCname("sql");
            course.setUserId(55L + i);
            course.setCstatus("good");

            courseMapper.insert(course);
        }


    }
    @Test
    public void add3() {

        for (int i = 0; i < 11; i++) {
            User user = new User();
           user.setUname("@@hostname");
           user.setStatus("good+"+i);

            userMapper.insert(user);
        }

    }

    @Test
    public void add4() {
        Udict udict = new Udict();
        udict.setUstatus("1");
        udict.setUvalue("启用");
        udictMapper.insert(udict);
    }
    @Test
    public void delete4() {
        QueryWrapper<Udict> wrapper = new QueryWrapper<>();
        wrapper.eq("dictid",482153696667369473L);
        udictMapper.delete(wrapper);
    }

    @Test
    public void query() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 482113086367465473L);

        Course course = courseMapper.selectOne(wrapper);
        System.out.println("课程:" + course);
    }

    @Test
    public void query2() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();

        // wrapper.eq("cid",482113086367465473L);

        List<Course> courses = courseMapper.selectList(wrapper);
        System.out.println("课程:" + courses);
    }
    @Test
    public void query3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // wrapper.eq("cid",482113086367465473L);

        List<User> courses = userMapper.selectList(wrapper);
        System.out.println("课程:" + courses);
    }

}
