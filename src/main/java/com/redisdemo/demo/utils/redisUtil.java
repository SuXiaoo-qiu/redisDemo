package com.redisdemo.demo.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class redisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 指定失效时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 查询过期时间
     * @param key 不能为空
     * @return 时间 返回0代表永不过期
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return true存在  false不存在
     */
    public boolean hashKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * @param key 可以传递一个或者多个值
     */
    public void del(String ... key){
        if (key != null && key.length > 0){
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            }else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * setnx 上锁
     * @param key  一般是lock
     * @param value 一般是uuid
     * @param time 缓存时间
     * @return
     */
    public boolean setNx(String key,String value,int time){
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key,value,time,TimeUnit.SECONDS));
    }
    //指定未过期时间
    public boolean setNx(String key, String value){
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key,value));
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value  值
     * @return  true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入 带有过期时间
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key  键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增必须大于0");
        }
        return  redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     * @param key   键
     * @param delta 要减少几(小于0)
     * @return
     */
    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 根据key获取set中所有的值
     * @param key
     * @return
     */
    public Set<Object> sGet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据value 从set中查询判断是否存在
     * @param key
     * @param value
     * @return
     */
    public boolean sHasKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将数据写入set缓存
     * @param key
     * @param values
     * @return
     */
    public long sSet(String key, Object ... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    /**
     * 将数据写入set缓存 设置过期时间
     * @param key
     * @param values
     * @return
     */
    public long sSet(String key, long time,String ... values){
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            // 如果时间大于 0 就吧该key设置过期时间  expire失效
            if (time > 0) {
                expire(key, time);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *  获取set缓存的长度
     * @param key
     * @return
     */
    public long sGetSetSize(String key) {
        try {
            return  redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除值为value的
     * @param key
     * @param values 可以删除多个
     * @return 删除的个数
     */
    public long setRemove(String key, Object ... values) {
        try {
           return redisTemplate.opsForSet().remove(key, values);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }













}
