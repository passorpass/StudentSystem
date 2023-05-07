package com.student.service.Impl;


import com.student.entity.Student;
import com.student.mapper.StudentMapper;
import com.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper StudentMapper;

    @Override
    public List<Student> getAll() {
        return StudentMapper.getAll();
    }

    /*
    分页查询
     */
    @Override
    public List<Student> Page(int page, int pageSize) {
        return StudentMapper.Page(page,pageSize);
    }

    @Override
    public Boolean Del(Integer id) {
        return StudentMapper.Del(id);
    }

    @Override
    public Integer Dels(List<Integer> ids) {
        return StudentMapper.Dels(ids);
    }

    @Override
    public Boolean updbyid(Student student) {
        return StudentMapper.updbyid(student);
    }


    /**
     * 查询所有
     * @return
     */


    /**
     * 添加数据
     * @param Student
     * @return
     */
    @Override
    public boolean addone(Student Student) {

       return StudentMapper.addone(Student);


    }

    /**
     * id查数据
     * @param id
     * @return
     */
    @Override
    public List<Student>  getonebyid(Integer id) {

        return StudentMapper.getOneById(id);

    }




}
