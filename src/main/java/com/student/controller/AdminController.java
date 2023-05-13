package com.student.controller;


//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.student.common.Result;
import com.student.entity.Admin;
import com.student.service.AdminService;
import com.student.util.JwtUtil;
import com.student.util.LoginForm;
import com.student.util.PasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    /**
     * 登录
     * @param loginForm
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm) throws NoSuchAlgorithmException {
        // 获取登录表单中的用户名和密码
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // 根据用户名从数据库中获取对应的用户信息
        Admin admin = adminService.getByUsername(username);

        // 如果用户不存在或密码不正确，则返回登录失败信息
        if (admin == null || !PasswordEncoderUtil.matchesPassword(password, admin.getPassword())) {
            return Result.error("用户名或密码错误！");
        }

        // 生成token并返回给前端
        String token = JwtUtil.generateToken(admin.getId());
        return Result.success(token);
    }


    /**
     * 退出登录
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        // 从请求头中获取token
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            // 从token中获取用户id
            Long userId = JwtUtil.getUserId(token.substring(7));
            // 根据用户id从数据库中获取对应的用户信息
            Admin admin = adminService.getById(userId);
            if (admin != null) {
                // 清空用户的登录状态信息
                admin.setToken("");
                adminService.updateById(admin);
                return Result.success("退出登录成功！");
            }
        }
        return Result.error("退出登录失败！");
    }



    /**
     * 查询所有，暂定没有分页
     * @param admin
     * @return
     */
    @GetMapping("/list")
    public Result adminList(Admin admin){
        log.info("Admin:{}", admin);
       return Result.success(adminService.getAll());

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

        return Result.success(adminService.adminPage(page, pageSize));

    }


    /**
     * 添加数据
     * @param admin
     * @return
     */
    @PostMapping("/add")
    public Result adminAdd(@Valid Admin admin, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        boolean addone = adminService.addone(admin);
        if(addone){
            log.info("添加的信息如下：admin: {}", admin);
            return Result.success(true);
        }
        return Result.error("添加数据失败");
    }

    /**
     * 根据id回写数据
     */
    @GetMapping("/{id}")
    public Result admingetone(@PathVariable Integer id){
        List<Admin> admin = adminService.getonebyid(id);
        if (admin == null) {
            return Result.error("未找到id为" + id + "的管理员信息");
        }
        log.info("admin: {}", admin.toString());
        return Result.success(admin);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result adminDel(@PathVariable Integer id){
        if (adminService.adminDel(id)) {
            log.info("删除成功");
            return Result.success(true);
        } else {
            log.info("删除失败");
            return Result.error("删除失败");
        }
    }

    @PostMapping("/dels")
    public Result dels(@RequestBody List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return Result.error("参数为空");
        }
        return Result.success(adminService.adminDels(ids));
    }

    /**
     * 更新
     * @param admin
     * @return
     */
    @GetMapping("/update")
    public Result update(Admin admin) {
        if (admin == null || admin.getId() == null) {
            return Result.error("参数为空或缺少必要参数");
        }
        boolean success = adminService.updbyid(admin);
        log.info("admin: {}", admin);
        return Result.success(success);
    }


}
