package com.student.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.student.entity.Admin;

import java.util.List;


public interface AdminService extends IService<Admin>  {

    List<Admin> getall();

    boolean addone(Admin admin);

    List<Admin> getonebyid(Integer id);

    List<Admin> getAll();

    //分页查询
    List<Admin> adminPage(int page,int pageSize);

    //根据id删除
    Boolean adminDel(Integer id);

    //批量删除
    Integer adminDels(List<Integer> ids);

    //根据id修改数据
    Boolean updbyid(Admin admin);


}
