package com.student.service;


import com.student.entity.Subject;

import java.util.List;


public interface SubjectService {



    boolean addone(Subject subject);

    List<Subject> getonebyid(Integer id);

    List<Subject> getAll();

    //分页查询
    List<Subject> Page(int page,int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Subject subject);


}
