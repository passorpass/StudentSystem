package com.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    //查询所有
    List<Student> getAll();

    //添加
    boolean addone(Student Student);

    //根据id查询数据（回写数据）
     List<Student> getOneById(Long id);

    //分页查询
     List<Student> Page(int page, int pageSize);

    //根据id删除
    Boolean Del(Long id);

    //批量删除
    Integer Dels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Student student);


}
