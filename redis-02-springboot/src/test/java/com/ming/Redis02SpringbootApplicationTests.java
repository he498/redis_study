package com.ming;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.ming.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    //redisTemplate
    //opsForValue 操作字符串 类似String
    //opsForList 操作List 类似List
    //opsForSet
    //opsForHash
    //opsForZSet
    //opsForGeo
    //opsForHyperLogLog
    //opsForValue().setBit

    //获取连接对象
//    RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();
    @Test
    void contextLoads() {
       redisTemplate.opsForValue().set("mykey","ming");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("ming", 3);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        //没有序列化对象无法传输，传输对象数据时需要将其序列化才能传输。所有的对象需要序列化
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
