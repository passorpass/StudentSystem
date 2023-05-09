package com.student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.entity.redis.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
class StudentSystemApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

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
        User user = new User("虎哥",25);
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
    void testHash(){
        stringRedisTemplate.opsForHash().put("user:400","name","虎哥");
        stringRedisTemplate.opsForHash().put("user:400","age","21");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:400");
        System.out.println("entried = "+ entries);
    }

}
