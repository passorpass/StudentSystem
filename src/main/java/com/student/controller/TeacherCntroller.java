package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.common.Result;
import com.student.entity.Teacher;
import com.student.service.TeacherService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/teacher")
public class TeacherCntroller {

    @Resource
    private TeacherService teacherService;

    /**
     * 查询所有
     * @param teacher
     * @return
     */
    @GetMapping("/list")
    public List<Teacher> adminList(Teacher teacher){
        log.info("Teacher:{}", teacher);
       return teacherService.getAll();

    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     *
     * @return
     */

    @GetMapping("/page")
    public List<Teacher> page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        return teacherService.Page(page, pageSize);

    }


    /**
     * 添加数据
     * @param teacher
     * @return
     */
    @PutMapping("/add")
    public Result<String> adminAdd(Teacher teacher){

        boolean addone = teacherService.addone(teacher);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",teacher.toString());
            return Result.success("添加成功");
        }

        return Result.error("添加失败");

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public Result<List<Teacher>> getone(@PathVariable Integer id){

        List<Teacher> List = teacherService.getonebyid(id);
        log.info("admin:{}",List.toString());
        return Result.success(List);

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result<String> Del(@PathVariable Integer id){
        Boolean aBoolean = teacherService.Del(id);
        if(aBoolean){
            log.info("删除成功");
            return Result.success("删除成功");
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
            return teacherService.Dels(ids);
        }
        return 0;

    }

    /**
     * 根据id修改数据
     * @param teacher
     * @return
     */
    @GetMapping("/update")
    public Result<Boolean> update(Teacher teacher){

        Boolean aBoolean = teacherService.updbyid(teacher);
        log.info("admin:{}", teacher);
        if(aBoolean) {
            return Result.success(aBoolean);
        }
        return Result.error("修改失败"+ false);
    }


}
