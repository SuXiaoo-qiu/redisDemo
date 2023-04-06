package com.redisdemo.demo.controller;

import com.redisdemo.demo.entity.Persion;
import com.redisdemo.demo.server.PersionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Persion")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "菜单表")
public class PersionController {
    @Resource
    private PersionService persionService;



@RequestMapping("/getPersions")
    public List<Persion> getPersions() {
        List<Persion> persions = persionService.getPersions();
    System.out.println(persions);

        return persions;

    }

}
