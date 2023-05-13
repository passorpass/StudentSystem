package com.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    //查询所有
    List<Admin> getAll();

    //添加
    boolean addone(Admin admin);

    //根据id查询数据（回写数据）
    List<Admin> getOneById(Integer id);

    //分页查询
    List<Admin> adminPage(int page,int pageSize);

    //根据id删除
    Boolean adminDel(Integer id);

    //批量删除
    Integer adminDels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Admin admin);


    Admin getByUsername(String username);





}
