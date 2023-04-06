package com.redisdemo.demo;

import com.redisdemo.demo.server.PersionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(TimeUnit.SECONDS);
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
    @Resource
    private PersionService persionService;

    @Test
    void contextLoads1() {
     this.persionService.getPersions();
    }

}
