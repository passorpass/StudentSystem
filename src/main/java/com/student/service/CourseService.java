package com.student.service;


import com.student.entity.Course;

import java.util.List;


public interface CourseService   {



    boolean addone(Course course);

    List<Course> getonebyid(Integer id);

    List<Course> getAll();

    //分页查询
    List<Course> Page(int page,int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Course course);



}
