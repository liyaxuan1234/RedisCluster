package com.ht.JedisRedis;

import redis.clients.jedis.ShardedJedis;

public interface JedisRedisTest {
    public abstract  ShardedJedis getRedisCluster();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
