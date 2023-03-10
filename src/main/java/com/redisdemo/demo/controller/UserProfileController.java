package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.UserProfileDTO;
import com.redisdemo.demo.entity.UserProfile;
import com.redisdemo.demo.query.UserProfileQuery;
import com.redisdemo.demo.server.UserProfileService;
import com.redisdemo.demo.vo.HttpResult;
import com.redisdemo.demo.vo.UserProfileVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/UserProfile")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "测试表")
@Slf4j
public class UserProfileController {

    @Resource
    private UserProfileService userProfileService;
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody UserProfileQuery query){
        PageInfo<ClassInfo> pageInfo = userProfileService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<UserProfileVO> getAll (@RequestBody UserProfileQuery query) {
        return  HttpResult.success(userProfileService.getAll(query));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<UserProfile> getById(Integer id) {
        return HttpResult.success(userProfileService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param userProfileDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody UserProfileDTO userProfileDto) {
   		 return HttpResult.success((userProfileService.add(userProfileDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param userProfileDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody UserProfileDTO userProfileDto) {
        return HttpResult.success((userProfileService.updateById(userProfileDto)));
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
         return HttpResult.success(userProfileService.deleteByIds(ids));
 
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
         return HttpResult.success(userProfileService.delete(id));
 
      }
}