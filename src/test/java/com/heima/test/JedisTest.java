//package com.heima.test;
//
//import com.student.util.JedisConnectionFactory;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import redis.clients.jedis.Jedis;
//
//import java.util.Map;
//
//public class JedisTest {
//
//    private Jedis jedis;
//
//    @BeforeEach
//    void setUp() {
////
////        jedis = new Jedis("192.168.10.137",6379);
////         从连接池获取
//        jedis = JedisConnectionFactory.getjedis();
////      连接密码
//        jedis.auth("123456");
////      选择redis库
//        jedis.select(0);
//
//    }
//
//    @Test
//    void testString() {
////      添加字段
//        String set = jedis.set("name", "胡歌");
//        System.out.println("result =" + set);
//        String name = jedis.get("name");
//        System.out.println("name =" + name);
//
//    }
//
//    @AfterEach
//    void teatDown() {
////      归还
//        if (jedis != null) {
//            jedis.close();
//        }
//    }
//
//    @Test
//    void testHash() {
////
//        jedis.hset("user:1", "name", "jack");
//        jedis.hset("user:1", "age", "23");
////
//        Map<String, String> map = jedis.hgetAll("user:1");
//        System.out.println(map);
//    }
//}
