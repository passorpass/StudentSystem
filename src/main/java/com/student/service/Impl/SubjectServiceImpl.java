package com.student.service.Impl;


import com.student.entity.Subject;
import com.student.mapper.SubjectMapper;
import com.student.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper SubjectMapper;

    @Override
    public List<Subject> getAll() {
        return SubjectMapper.getAll();
    }

    /*
    分页查询
     */
    @Override
    public List<Subject> Page(int page, int pageSize) {
        return SubjectMapper.Page(page,pageSize);
    }

    @Override
    public Boolean Del(Integer id) {
        return SubjectMapper.Del(id);
    }

    @Override
    public Integer Dels(List<Integer> ids) {
        return SubjectMapper.Dels(ids);
    }

    @Override
    public Boolean updbyid(Subject Subject) {
        return SubjectMapper.updbyid(Subject);
    }


    /**
     * 查询所有
     * @return
     */


    /**
     * 添加数据
     * @param Subject
     * @return
     */
    @Override
    public boolean addone(Subject subject) {

       return SubjectMapper.addone(subject);


    }

    /**
     * id查数据
     * @param id
     * @return
     */
    @Override
    public List<Subject>  getonebyid(Integer id) {

        return SubjectMapper.getOneById(id);

    }




}
