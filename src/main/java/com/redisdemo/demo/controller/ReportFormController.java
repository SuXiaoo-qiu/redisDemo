package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.query.OrderQuery;
import com.redisdemo.demo.server.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ReportForm")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "报表管理")
public class ReportFormController {

    @Resource
    private OrderService orderService;

    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "报表分页查询")
    @RequestMapping("/getReportFormPage")
    public PageInfo<ClassInfo> getReportFormPage(@RequestBody OrderQuery query){
        PageInfo<ClassInfo> pageInfo = orderService.getReportFormPage(query);
        return pageInfo;
    }


}