package com.redisdemo.demo.controller;

import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.StudentDTO;
import com.redisdemo.demo.entity.Student;
import com.redisdemo.demo.query.StudentQuery;
import com.redisdemo.demo.server.StudentService;
import com.redisdemo.demo.vo.HttpResult;
import com.redisdemo.demo.vo.StudentVO;
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
@RequestMapping("/Student")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "学生表")
public class StudentController {

    @Resource
    private StudentService studentService;
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    @ApiOperation(value = "条件查询分页")
    @RequestMapping("/getPage")
    public PageInfo<ClassInfo> getPage(@RequestBody StudentQuery query){
        PageInfo<ClassInfo> pageInfo = studentService.getPage(query);
        return pageInfo;
    }
    
    /**
    * 查询所有记录
    * @param query
    * @return 返回集合，没有返回空List
    */
    @ApiOperation(value = "条件查询全部数据")
    @RequestMapping("getAll")
    public HttpResult<StudentVO> getAll (@RequestBody StudentQuery query) {
        return  HttpResult.success(studentService.getAll(query));
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @ApiOperation(value = "根据id查询")
    @RequestMapping("getById")
    public HttpResult<Student> getById(Integer id) {
        return HttpResult.success(studentService.getById(id));
    }    
     
    /**
     * 新增，忽略null字段
     *
     * @param studentDto 新增的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "新增")
    @RequestMapping("add")
    public HttpResult add (@RequestBody StudentDTO studentDto) {
   		 return HttpResult.success((studentService.add(studentDto)));
    }    
      
    /**
     * 修改，忽略null字段
     *
     * @param studentDto 修改的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "修改")
    @RequestMapping("updateById")
    public HttpResult updateById (@RequestBody StudentDTO studentDto) {
        return HttpResult.success((studentService.updateById(studentDto)));
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
         return HttpResult.success(studentService.deleteByIds(ids));
 
      }
      
    /**
     * 删除记录
     *
     * @param student 待删除的记录
     * @return 返回影响行数
     */
    @ApiOperation(value = "删除")
    @RequestMapping("delete")
    public HttpResult delete(Integer id) {
         return HttpResult.success(studentService.delete(id));
 
      }
}