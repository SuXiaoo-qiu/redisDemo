package com.redisdemo.demo.controller;

import com.redisdemo.demo.utils.redisUtil;
import com.redisdemo.demo.vo.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    @Resource
    private redisUtil redisUtil;
    @Resource
    private RedissonClient redisson;
    /**
     * 测试分布式锁 使用setnx
     * @return
     */
    @PostMapping("/redisLockTest")
    public String redisLockTest(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        boolean lock = redisUtil.setNx("lock1", uuid,50);
        if (lock) {
            //已经上锁
            //--------------- 逻辑代码开始------------------
            Object value = redisUtil.get("num");
            if (null==value || "".equals(value)){
                return "key 是空的";
            }
            //如果不是空的就证明有值
            int num = Integer.parseInt(value + "");
            //吧redis的num加1
            redisUtil.set("num",++num);
            //--------------- 逻辑代码结束------------------
            //删除锁 为了防止误删 新增一个判断
            if (uuid.equals(redisUtil.get("lock1").toString())){
                redisUtil.del("lock1");
                return "成功";
            }else {
                return "失败";
            }
        }else {
            //上锁失败
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "done";
    }


    /**
     * 测试分布式锁 使用Redission  默认的lock锁
     * @return
     */
    @PostMapping("/redissonTest")
    public String redissonTest(){
        String lockKey = UUID.randomUUID().toString().replaceAll("-", "");
        RLock lock = redisson.getLock(lockKey);
        try {
            //上锁
            lock.lock();
            synchronized (this){
                //--------------- 逻辑代码开始------------------
                if (redisUtil.get("num") == null){
                    log.info("num为空");
                }else {
                    // 获取当前库存
                    int stok= Integer.parseInt(redisUtil.get("num").toString());
                    if (stok > 0) {
                       int realStock =  stok - 1;
                       // 减少后 更新库存
                        redisUtil.set("num",realStock+"");
                        log.info("当前库存为"+realStock);

                    }else {
                        log.info("扣减失败，库存不足");

                    }
                }
            }

        }catch (Exception e) {
            log.info("系统错误");

        }
        finally {
            lock.unlock();
            log.info("锁已关闭");
        }
            //--------------- 逻辑代码结束------------------
            //删除锁 为了防止误删 新增一个判断

        return "" ;

        }








    @PostMapping("/add")
    public String add(){
        String key = "add";
        Object value = UUID.randomUUID().toString().replace("-", "");
        boolean set = redisUtil.set(key, value);
        if (set) {
            return "成功";
        }
        return "失败";
    }


    @PostMapping("/tt")
    public HttpResult tt(){
        String key = "add";
        Object value = UUID.randomUUID().toString().replace("-", "");
        boolean set = redisUtil.set(key, value);
        System.out.println(HttpResult.success(redisUtil.get(value.toString())));
        System.out.println(HttpResult.success());
        HttpResult.success();
        System.out.println(HttpResult.error("错误"));
        if (set) {
            return HttpResult.success();
        }
        return HttpResult.error("c出错了");
    }
}
