package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.entity.Student;
import com.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Controller
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
    public List<Student> page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        return studentService.Page(page, pageSize);

    }


    /**
     * 添加数据
     * @param Student
     * @return
     */
    @PutMapping("/add")
    public Boolean adminAdd(Student Student){

        boolean addone = studentService.addone(Student);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",Student.toString());
            return true;
        }

        return false;

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public List<Student> getone(@PathVariable Integer id){

        List<Student> List = studentService.getonebyid(id);
        log.info("entity:{}",List.toString());
        return List;

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean Del(@PathVariable Integer id){
        Boolean aBoolean = studentService.Del(id);
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
            return studentService.Dels(ids);
        }
        return 0;

    }

    /**
     * 根据id修改数据
     * @param student
     * @return
     */
    @GetMapping("/update")
    public Boolean update(Student student){

        Boolean aBoolean = studentService.updbyid(student);
        log.info("admin:{}", student);
        return aBoolean;

    }


}
