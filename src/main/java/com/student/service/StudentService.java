package com.student.service;


import com.student.entity.Student;

import java.util.List;


public interface StudentService {



    boolean addone(Student Student);

    List<Student> getonebyid(Integer id);

    List<Student> getAll();

    //分页查询
    List<Student> Page(int page,int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Student student);


}
