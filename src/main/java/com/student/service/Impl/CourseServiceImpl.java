package com.student.service.Impl;


import com.student.entity.Course;
import com.student.mapper.CourseMapper;
import com.student.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CourseServiceImpl  implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAll() {
        return courseMapper.getAll();
    }

    /*
    分页查询
     */
    @Override
    public List<Course> Page(int page, int pageSize) {
        return courseMapper.Page(page,pageSize);
    }

    @Override
    public Boolean Del(Integer id) {
        return courseMapper.Del(id);
    }

    @Override
    public Integer Dels(List<Integer> ids) {
        return courseMapper.Dels(ids);
    }

    @Override
    public Boolean updbyid(Course course) {
        return courseMapper.updbyid(course);
    }


    /**
     * 查询所有
     * @return
     */


    /**
     * 添加数据
     * @param course
     * @return
     */
    @Override
    public boolean addone(Course course) {

       return courseMapper.addone(course);


    }

    /**
     * id查数据
     * @param id
     * @return
     */
    @Override
    public List<Course>  getonebyid(Integer id) {

        return courseMapper.getOneById(id);

    }




}
