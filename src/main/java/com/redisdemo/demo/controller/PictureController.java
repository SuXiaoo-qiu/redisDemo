package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.PictureDTO;
import com.redisdemo.demo.entity.Picture;
import com.redisdemo.demo.query.PictureQuery;
import com.redisdemo.demo.server.PictureService;
import com.redisdemo.demo.vo.HttpResult;
import com.redisdemo.demo.vo.PictureVO;
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
@RequestMapping("/Picture")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "图片信息表")
public class PictureController {

    @Resource
    private PictureService pictureService;
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody PictureQuery query){
        PageInfo<ClassInfo> pageInfo = pictureService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<PictureVO> getAll (@RequestBody PictureQuery query) {
        return  HttpResult.success(pictureService.getAll(query));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<Picture> getById(Integer id) {
        return HttpResult.success(pictureService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param pictureDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody PictureDTO pictureDto) {
   		 return HttpResult.success((pictureService.add(pictureDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param pictureDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody PictureDTO pictureDto) {
        return HttpResult.success((pictureService.updateById(pictureDto)));
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
         return HttpResult.success(pictureService.deleteByIds(ids));
 
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
         return HttpResult.success(pictureService.delete(id));
 
      }
}