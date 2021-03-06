package com.ht.test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedisClusterTest {

    private static final String[] CLUSTERS = {
            "127.0.0.1:6380",
            "127.0.0.1:6381",
            "127.0.0.1:6382",
            "127.0.0.1:6383",
            "127.0.0.1:6384",
            "127.0.0.1:6385"
    };

    public static void main(String[] args) throws IOException {
        Set<HostAndPort> jedisClusterNodes= new HashSet<>();
        for(String cluster:CLUSTERS){
          String [] clusterInfor=cluster.split(":");
          jedisClusterNodes.add(new HostAndPort(clusterInfor[0],Integer.valueOf(clusterInfor[1])));
        }
        JedisCluster jedisCluster=new JedisCluster(jedisClusterNodes);
        jedisCluster.set("test","bar");
        System.out.println(jedisCluster.get("test"));
        System.out.println(jedisCluster.get("k1"));
        jedisCluster.close();

    }
    /**
     * 第二种集群方式
     * */


}