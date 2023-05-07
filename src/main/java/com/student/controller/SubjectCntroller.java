package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.entity.Subject;
import com.student.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Controller
@Slf4j
@RequestMapping("/subject")
public class SubjectCntroller {

    @Resource
    private SubjectService SubjectService;

    /**
     * 查询所有
     * @param subject
     * @return
     */
    @GetMapping("/list")
    public List<Subject> adminList(Subject subject){
        log.info("Subject:{}", subject);
       return SubjectService.getAll();

    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     *
     * @return
     */

    @GetMapping("/page")
    public List<Subject> page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        return SubjectService.Page(page, pageSize);

    }


    /**
     * 添加数据
     * @param subject
     * @return
     */
    @PutMapping("/add")
    public Boolean adminAdd(Subject subject){

        boolean addone = SubjectService.addone(subject);


        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",subject.toString());
            return true;
        }

        return false;

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public List<Subject> getone(@PathVariable Integer id){

        List<Subject> List = SubjectService.getonebyid(id);
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
        Boolean aBoolean = SubjectService.Del(id);
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
            return SubjectService.Dels(ids);
        }
        return 0;

    }

    /**
     * 根据id修改数据
     * @param subject
     * @return
     */
    @GetMapping("/update")
    public Boolean update(Subject subject){

        Boolean aBoolean = SubjectService.updbyid(subject);
        log.info("admin:{}", subject);
        return aBoolean;

    }


}
