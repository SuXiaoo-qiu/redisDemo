package com.redisdemo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(TimeUnit.SECONDS);
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

}
