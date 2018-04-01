package com.ht.JedisRedis.impl;

import com.ht.JedisRedis.JedisRedisTest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


@Repository("jedisRedisTest")
public class JedisRedisImplTest implements JedisRedisTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(JedisRedisImplTest.class);
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    @Override
    public ShardedJedis getRedisCluster() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("getRedisClent error", e);
        }
        return null;
    }




    @Override
    public void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.close();
    }

    @Override
    public void returnResource(ShardedJedis shardedJedis, boolean broken) {

    }
}
