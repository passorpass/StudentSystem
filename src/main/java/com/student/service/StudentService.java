package com.student.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.student.entity.Student;
import com.student.mapper.StudentMapper;

import java.util.List;


public interface StudentService extends IService<Student> {



    boolean addone(Student Student);

    List<Student> getonebyid(Long id);

    List<Student> getAll();

    //分页查询
    List<Student> Page(int page,int pageSize);

    //根据id删除
    Boolean Del(Long id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Student student);


}
