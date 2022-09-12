package com.ming;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;


//jedis操作事务
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","ming");
        //开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();
        try {
            multi.set("user1",result);
            multi.set("user2",result);
           // int i = 1/0;  //异常情况
            multi.exec();
        } catch (Exception e) {
            multi.discard(); //失败了就事务放弃
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            multi.close(); //关闭客户端
        }



    }
}
