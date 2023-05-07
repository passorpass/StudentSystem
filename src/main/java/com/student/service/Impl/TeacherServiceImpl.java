package com.student.service.Impl;


import com.student.entity.Teacher;
import com.student.mapper.TeacherMapper;
import com.student.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAll() {
        return teacherMapper.getAll();
    }

    /*
    分页查询
     */
    @Override
    public List<Teacher> Page(int page, int pageSize) {
        return teacherMapper.Page(page,pageSize);
    }

    @Override
    public Boolean Del(Integer id) {
        return teacherMapper.Del(id);
    }

    @Override
    public Integer Dels(List<Integer> ids) {
        return teacherMapper.Dels(ids);
    }

    @Override
    public Boolean updbyid(Teacher teacher) {
        return teacherMapper.updbyid(teacher);
    }


    /**
     * 查询所有
     * @return
     */


    /**
     * 添加数据
     * @param teacher
     * @return
     */
    @Override
    public boolean addone(Teacher teacher) {

       return teacherMapper.addone(teacher);


    }

    /**
     * id查数据
     * @param id
     * @return
     */
    @Override
    public List<Teacher>  getonebyid(Integer id) {

        return teacherMapper.getOneById(id);

    }




}
