package com.ht.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

public class JedisRedisTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/spring-redis.xml");
        JedisCluster jedisCluster=context.getBean(JedisCluster.class);
        jedisCluster.set("name","白白");
        jedisCluster.set("age" ,"18");
        System.out.println(jedisCluster.get("name"));
        System.out.println(jedisCluster.get("age"));

    }
}
