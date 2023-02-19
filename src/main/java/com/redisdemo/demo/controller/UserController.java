package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.UserDTO;
import com.redisdemo.demo.dto.UserLoginDTO;
import com.redisdemo.demo.entity.User;
import com.redisdemo.demo.query.UserQuery;
import com.redisdemo.demo.server.UserLoginService;
import com.redisdemo.demo.server.UserService;
import com.redisdemo.demo.vo.HttpResult;
import com.redisdemo.demo.vo.UserVO;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/User")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "用户表")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserLoginService userLoginService;
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody UserQuery query){
        PageInfo<ClassInfo> pageInfo = userService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<UserVO> getAll (@RequestBody UserQuery query) {
        return  HttpResult.success(userService.getAll(query));
    }


    @ApiOperation(value = "登录")
    @RequestMapping("login")
    @Transactional //开启事务
    public HttpResult<UserVO> login (@RequestBody HashMap<String,Object> haashMap) {
        if (StringUtil.isNullOrEmpty(haashMap.get("username").toString())){
            return HttpResult.error("请输入用户名");
        }
        if (StringUtil.isNullOrEmpty(haashMap.get("password").toString())){
            return HttpResult.error("请输入密码");
        }
        UserQuery user = new UserQuery();
        user.setAccountNumber(haashMap.get("username").toString());
        user.setPassword(haashMap.get("password").toString());
        List<UserVO> all = userService.getAll(user);
        if (all != null && all.size() > 0) {
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            userLoginDTO.setLoginUserAme(haashMap.get("username").toString());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userLoginDTO.setLastLoginTime(simpleDateFormat.format(new Date()));
            int add = userLoginService.add(userLoginDTO);
            if (add > 0) {
                return  HttpResult.success(all);
            }
            throw new RuntimeException("用户不存在");
        }
        return  HttpResult.error("用户不存在");
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<User> getById(Integer id) {
        return HttpResult.success(userService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param userDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody UserDTO userDto) {
   		 return HttpResult.success((userService.add(userDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param userDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody UserDTO userDto) {
        return HttpResult.success((userService.updateById(userDto)));
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
         return HttpResult.success(userService.deleteByIds(ids));
 
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
         return HttpResult.success(userService.delete(id));
 
      }
}