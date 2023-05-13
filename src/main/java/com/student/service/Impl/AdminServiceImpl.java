package com.student.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.entity.Admin;
import com.student.mapper.AdminMapper;
import com.student.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper,Admin> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> getAll() {
        return adminMapper.getAll();
    }

    /*
    分页查询
     */
    @Override
    public List<Admin> adminPage(int page, int pageSize) {
        return adminMapper.adminPage(page,pageSize);
    }

    @Override
    public Boolean adminDel(Integer id) {
        return adminMapper.adminDel(id);
    }

    @Override
    public Integer adminDels(List<Integer> ids) {
        return adminMapper.adminDels(ids);
    }

    @Override
    public Boolean updbyid(Admin admin) {

        return adminMapper.updbyid(admin);
    }

    @Override
    public Admin getByUsername(String username) {

        return adminMapper.getByUsername(username);
    }


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Admin> getall() {

        return adminMapper.getAll();

    }

    /**
     * 添加数据
     * @param admin
     * @return
     */
    @Override
    public boolean addone(Admin admin) {

       return adminMapper.addone(admin);


    }

    /**
     * id查数据
     * @param id
     * @return
     */
    @Override
    public List<Admin> getonebyid(Integer id) {

        return adminMapper.getOneById(id);

    }




}
