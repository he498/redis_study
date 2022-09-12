package com.ming;

import redis.clients.jedis.Jedis;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Set;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.ping());

        //常用的API
        //String、List、Set、Zset、Hash、geo、hyperloglog、bitmaps

        System.out.println(jedis.flushDB());
        System.out.println(jedis.exists("name"));
        System.out.println(jedis.set("username","ming"));
        System.out.println(jedis.get("username"));
        System.out.println(jedis.set("password","123456"));
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println(jedis.del("password"));
        System.out.println(jedis.exists("password"));


    }
}
