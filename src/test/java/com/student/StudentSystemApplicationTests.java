package com.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.common.Result;
import com.student.controller.AdminController;
import com.student.entity.Admin;
import com.student.entity.redis.User;
import com.student.service.AdminService;
import com.student.util.LoginForm;
import com.student.util.PasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.student.controller.AdminController;
import com.student.entity.Admin;
import com.student.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Slf4j
class StudentSystemApplicationTests {


    @Resource
    private MockMvc mockMvc;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private AdminService adminService;

    @Test
    void contextLoads() {
//         写入一条数据
        stringRedisTemplate.opsForValue().set("age", "25");

        Object age = stringRedisTemplate.opsForValue().get("age");
        System.out.println("age =" + age);
    }

    @Test
    void testtoString() {
//         写入一条数据
        stringRedisTemplate.opsForValue().set("name", "王五");

        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name =" + name);
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testObject() throws JsonProcessingException {
//        创建对象
        User user = new User("虎哥", 25);
//        手动序列化
        String json = mapper.writeValueAsString(user);

//         写入一条数据
        stringRedisTemplate.opsForValue().set("user:200", json);

        String o = stringRedisTemplate.opsForValue().get("user:200");
//       手动反序列化
        User user1 = mapper.readValue(json, User.class);

        System.out.println("user1 =" + user1);
    }

    @Test
    void testHash() {
        stringRedisTemplate.opsForHash().put("user:400", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user:400", "age", "21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entried = " + entries);
    }


    @Test
    public void testAddOne() {
        Admin admin = new Admin();
        // 设置属性
        admin.setUsername("admin");
        admin.setAge(26);
        admin.setSex("male");
        admin.setPassword("123456");
        boolean result = adminService.addone(admin);
        Assert.assertTrue(result);
    }

    @Test
    public void testGetOneById() {
        Integer id = 1;
        List<Admin> adminList = adminService.getonebyid(id);
        Assert.assertNotNull(adminList);
        Assert.assertEquals(1, adminList.size());
    }

    @Test
    public void testAdminDel() {
        Integer id = 1;
        boolean result = adminService.adminDel(id);
        Assert.assertTrue(result);
    }

    /**
     * 登录
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception {
        // 构造登录请求的参数
        String username = "test";
        String password = "123456";
        String requestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

        // 发起登录请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn();

        // 获取响应的JSON字符串
        String contentAsString = result.getResponse().getContentAsString();
        log.warn(contentAsString);

        // 解析JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        Result<?> responseResult = objectMapper.readValue(contentAsString, new TypeReference<Result<?>>() {});

        // 获取返回结果中的code字段值
        int code = responseResult.getCode();
        log.warn("code ===》"+code);

        // 根据code值判断登录是否成功
        if (code == Result.SUCCESS_CODE) {
            // 登录成功
            log.warn("登录成功");
        } else {
            // 登录失败
            log.warn("登录失败");
        }
    }

    /**
     * 退出
     * @throws Exception
     */
    @Test
    public void testLogout() throws Exception {
        // 创建MockMvc对象
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AdminController()).build();

        // 模拟退出登录请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/admin/logout")
                .header("Authorization", "BearerJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODQxNTI3MTV9.HeIGdqL8tBRfVHmrUv17XJyvMb9nF32rkh6jMiKgHi4")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // 获取响应的JSON字符串
        String contentAsString = result.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }
}










