package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.CityDTO;
import com.redisdemo.demo.entity.City;
import com.redisdemo.demo.query.CityQuery;
import com.redisdemo.demo.server.CityService;
import com.redisdemo.demo.vo.CityVO;
import com.redisdemo.demo.vo.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/City")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "城市表")
public class CityController {

    @Resource
    private CityService cityService;
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody CityQuery query){
        PageInfo<ClassInfo> pageInfo = cityService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<CityVO> getAll (@RequestBody CityQuery query) {
        return  HttpResult.success(cityService.getAll(query));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<City> getById(Integer id) {
        return HttpResult.success(cityService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param cityDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody CityDTO cityDto) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cityDto.setCreateTime(simpleDateFormat.format(new Date()));
   		 return HttpResult.success((cityService.add(cityDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param cityDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody CityDTO cityDto) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cityDto.setUodateTime(simpleDateFormat.format(new Date()));
        return HttpResult.success((cityService.updateById(cityDto)));
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
         return HttpResult.success(cityService.deleteByIds(ids));
 
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
         return HttpResult.success(cityService.delete(id));
 
      }
}