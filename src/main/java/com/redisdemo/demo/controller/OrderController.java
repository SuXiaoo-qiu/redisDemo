package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.OrderDTO;
import com.redisdemo.demo.entity.Order;
import com.redisdemo.demo.query.OrderQuery;
import com.redisdemo.demo.server.OrderService;
import com.redisdemo.demo.vo.HttpResult;
import com.redisdemo.demo.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Order")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "订单信息表")
public class OrderController {

    @Resource
    private OrderService orderService;
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody OrderQuery query){
        PageInfo<ClassInfo> pageInfo = orderService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<OrderVO> getAll (@RequestBody OrderQuery query) {
        return  HttpResult.success(orderService.getAll(query));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<Order> getById(Integer id) {
        return HttpResult.success(orderService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param orderDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody OrderDTO orderDto) {
   		 return HttpResult.success((orderService.add(orderDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param orderDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody OrderDTO orderDto) {
        return HttpResult.success((orderService.updateById(orderDto)));
    }
    
    /**
     * 批量删除记录
     *
     * @param ids 待删除的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "批量删除")
    @RequestMapping("deleteByIds")
    public HttpResult deleteByIds(@RequestBody List<String> ids) {
         return HttpResult.success(orderService.deleteByIds(ids));
 
      }
      
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "删除")
    @RequestMapping("delete")
    public HttpResult delete(Integer id) {
         return HttpResult.success(orderService.delete(id));
 
      }

}