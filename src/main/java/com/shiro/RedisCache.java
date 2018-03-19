package com.shiro;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisCache {
    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


//    获得 Redis 的资源
    public Jedis getJedisResource(){
        System.out.println("redis 中查找");
        return jedisPool.getResource();
    }

    /**
     * 增加数据到 redis 中
     * @param key
     * @param value
     */
    public void setDataToRedis(String key,String value){
        System.out.println("添加到 redis");
        getJedisResource().set(key,value);
    }


    /**
     * 获得 Redis 中的
     * @param key
     * @return
     */
    public String getDataFromRedis(String key){
        return getJedisResource().get(key);
    }



}
