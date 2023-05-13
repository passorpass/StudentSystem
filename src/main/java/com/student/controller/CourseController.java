package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.entity.Course;
import com.student.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/course")
public class CourseController {

   @Resource
   private CourseService courseService;

    /**
     * 查询所有
     * @param course
     * @return
     */
    @GetMapping("/list")
    public List<Course> adminList(Course course){
        log.info("Course:{}", course);
       return courseService.getAll();

    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     *
     * @return
     */

    @GetMapping("/page")
    public List<Course> page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        return courseService.Page(page, pageSize);

    }


    /**
     * 添加数据
     * @param course
     * @return
     */
    @PutMapping("/add")
    public Boolean adminAdd(Course course){

        boolean addone = courseService.addone(course);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",course.toString());
            return true;
        }

        return false;

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public List<Course> getone(@PathVariable Integer id){

        List<Course> List = courseService.getonebyid(id);
        log.info("admin:{}",List.toString());
        return List;

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean Del(@PathVariable Integer id){
        Boolean aBoolean = courseService.Del(id);
        if(aBoolean){
            log.info("删除成功");
            return true;
        }
        log.info("删除失败");
        return false;

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/dels")
    public Integer dels(@RequestBody List<Integer> ids){

        if(!ids.isEmpty()){
            return courseService.Dels(ids);
        }
        return 0;

    }

    /**
     * 根据id修改数据
     * @param course
     * @return
     */
    @GetMapping("/update")
    public Boolean update(Course course){

        Boolean aBoolean = courseService.updbyid(course);
        log.info("admin:{}", course);
        return aBoolean;

    }


}
