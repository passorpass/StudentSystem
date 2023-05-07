package com.student.mapper;

import com.student.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SubjectMapper {

    //查询所有
    List<Subject> getAll();

    //添加
    boolean addone(Subject subject);

    //根据id查询数据（回写数据）
     List<Subject> getOneById(Integer id);

    //分页查询
     List<Subject> Page(int page, int pageSize);

    //根据id删除
    Boolean Del(Integer id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Subject subject);


}
