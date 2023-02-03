package com.redisdemo.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private String port;

    @Bean
    public RedissonClient getRedisClient(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host + ":"+port);
        return Redisson.create(config);
    }

    /**
     *少个bean
     */
    /*public RedissonClient getRedisClient(){
        //主从
        Config config = new Config();
        config.useMasterSlaveServers()
            .setMasterAddress("127.0.0.1:6379")
        .addSlaveAddress("127.0.0.1:6389", "127.0.0.1:6332", "127.0.0.1:6419")
        .addSlaveAddress("127.0.0.1:6399");
       return Redisson.create(config);
    }*/
    /*public RedissonClient getRedisClient(){
        //哨兵
        Config config = new Config();
        config.useSentinelServers()
            .setMasterName("mymaster")
        .addSentinelAddress("127.0.0.1:26389", "127.0.0.1:26379")
        .addSentinelAddress("127.0.0.1:26319");
        return Redisson.create(config);
    }*/
    /*public RedissonClient getRedisClient(){
        //集群
        Config config = new Config();
        config.useClusterServers()
            .setScanInterval(2000) // cluster state scan interval in milliseconds
        .addNodeAddress("127.0.0.1:7000", "127.0.0.1:7001")
        .addNodeAddress("127.0.0.1:7002");
        RedissonClient redisson = Redisson.create(config);
     }*/
}
