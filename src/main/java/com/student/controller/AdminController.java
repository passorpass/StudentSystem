package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.common.Result;
import com.student.entity.Admin;
import com.student.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 查询所有，暂定没有分页
     * @param admin
     * @return
     */
    @GetMapping("/list")
    public Result adminList(Admin admin){
        log.info("Admin:{}", admin);
       return Result.succee(adminService.getAll());

    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     *
     * @return
     */

    @GetMapping("/page")
    public Result page(int page, int pageSize){
        log.info("page = {},pageSize = {}" ,page,pageSize);

        return Result.succee(adminService.adminPage(page, pageSize));

    }


    /**
     * 添加数据
     * @param admin
     * @return
     */
    @PutMapping("/add")
    public Result adminAdd(Admin admin){

        boolean addone = adminService.addone(admin);

        if(addone){
            log.info("\n添加的信息如下：\tadmin:{}",admin.toString());
            return Result.succee(true);
        }

        return Result.error("false");

    }

    /**
     * 根据id回写数据
     * @return
     */
    @GetMapping("/{id}")
    public Result admingetone(@PathVariable Integer id){

        List<Admin> adminList = adminService.getonebyid(id);
        log.info("admin:{}",adminList.toString());
        return Result.succee(adminList);

    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result adminDel(@PathVariable Integer id){
        Boolean aBoolean = adminService.adminDel(id);
        if(aBoolean){
            log.info("删除成功");
            return Result.succee(true);
        }
        log.info("删除失败");
        return Result.error("false");

    }

    @PostMapping("/dels")
    public Result dels(@RequestBody List<Integer> ids){

        if(!ids.isEmpty()){
            return Result.succee(adminService.adminDels(ids));
        }
        return Result.error("0");

    }

    @GetMapping("/update")
    public Result update(Admin admin){

        Boolean aBoolean = adminService.updbyid(admin);
        log.info("admin:{}", admin);
        return Result.succee(aBoolean);

    }


}
