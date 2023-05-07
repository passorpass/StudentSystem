package com.student.mapper;

import com.student.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TeacherMapper {

    //查询所有
    List<Teacher> getAll();

    //添加
    boolean addone(Teacher teacher);

    //根据id查询数据（回写数据）
     List<Teacher> getOneById(Integer id);

    //分页查询
     List<Teacher> Page(int page, int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Teacher teacher);


}
