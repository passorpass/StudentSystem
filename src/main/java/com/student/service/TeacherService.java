package com.student.service;


import com.student.entity.Teacher;

import java.util.List;


public interface TeacherService {



    boolean addone(Teacher teacher);

    List<Teacher> getonebyid(Integer id);

    List<Teacher> getAll();

    //分页查询
    List<Teacher> Page(int page,int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Teacher teacher);


}
