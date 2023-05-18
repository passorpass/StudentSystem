package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.common.Result;
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
    public Result<Boolean> adminAdd(Course course){

        boolean addone = courseService.addone(course);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",course.toString());
            return Result.success(addone);
        }

        return Result.error("添加失败");

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<Course>> getone(@PathVariable Integer id){

        List<Course> List = courseService.getonebyid(id);
        log.info("admin:{}",List.toString());
        return Result.success(List);

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> Del(@PathVariable Integer id){
        Boolean aBoolean = courseService.Del(id);
        if(aBoolean){
            log.info("删除成功");
            return Result.success(aBoolean);
        }
        log.info("删除失败");
        return Result.error("删除失败");

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
    public Result<Boolean> update(Course course){

        Boolean aBoolean = courseService.updbyid(course);
        log.info("admin:{}", course);
        if(aBoolean) {
            return Result.success(aBoolean);
        }

        return Result.error("修改失败");
    }


}
