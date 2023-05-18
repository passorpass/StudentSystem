package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.common.Result;
import com.student.entity.Student;
import com.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 查询所有
     * @param Student
     * @return
     */
    @GetMapping("/list")
    public List<Student> List(Student Student){
        log.info("Student:{}", Student);
        return studentService.getAll();

    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     *
     * @return
     */

    @GetMapping("/page")
    public List<Student> page(int page,int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);
        return studentService.Page(page, pageSize);
    }


    /**
     * 添加数据
     * @param student
     * @return
     */
    @PostMapping("/add")
    public Result adminAdd(@RequestBody Student student){

        boolean addone = studentService.addone(student);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",student.toString());
            return Result.success(student);
        }

        return Result.error("添加失败");

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public Result getone(@PathVariable Long id){

        List<Student> List = studentService.getonebyid(id);
        log.info("entity:{}",List.toString());
        return Result.success(List);

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result Del(@PathVariable Long id){
        Boolean aBoolean = studentService.Del(id);
        if(aBoolean){
            log.info("删除成功");
            return Result.success(true+"删除成功");
        }
        log.info("删除失败");
        return Result.error("删除失败"+false);

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/dels")
    public Result dels(@RequestBody List<Integer> ids){

        if(!ids.isEmpty()){
            return Result.success(studentService.Dels(ids));
        }
        return Result.error("批量删除失败");

    }

    /**
     * 根据id修改数据
     * @param student
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody Student student) {
        Boolean aBoolean = studentService.updbyid(student);
        log.info("student:{}", student);
        if (aBoolean) {
            return Result.success(student);
        }
        return Result.error("修改失败");
    }

}
