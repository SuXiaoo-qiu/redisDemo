package com.redisdemo.demo.controller;

import tstudent.entity.Student;
import tstudent.service.StudentService;
import com.joe.joeworld.config.PageInfo;
import com.joe.commonutils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    /**
     * 分页查询
     * @param params
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/findPage")
    public PageInfo<ClassInfo> findPage(@RequestParam Map<String, Object> params){
        PageInfo<ClassInfo> pageInfo = studentService.findPage(params);
        return pageInfo;
    }
    
    /**
    *查询所有记录
    * @param params
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("list")
    public R listAll(@RequestParam Map<String, Object> params) {
        return  R.ok(studentService.listAll(params));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public Student getById(Integer id) {
        return studentService.getById(id);
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param student 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("insert")
    public R insert(@RequestBody Student student) {
   		 return R.ok(studentService.insertIgnoreNull(student));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param student 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("update")
    public R update(@RequestBody Student student) {
        return R.ok(studentService.updateIgnoreNull(student));
    }
    
    /**
     * 删除记录
     *
     * @param student 待删除的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "删除物理删除")
    @RequestMapping("delete")
    public R delete(@RequestBody Student student) {
     	int delete = studentService.delete(student);
          if (delete > 0) {
              return R.ok("删除成功");
          }
          return R.error("删除失败");
      }
}