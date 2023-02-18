package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.StudentMapper;
import com.redisdemo.demo.dto.StudentDTO;
import com.redisdemo.demo.entity.Student;
import com.redisdemo.demo.query.StudentQuery;
import com.redisdemo.demo.server.StudentService;
import com.redisdemo.demo.vo.StudentVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(StudentQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = studentMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<StudentVO> getAll(StudentQuery studentQuery) {
    	return studentMapper.getAll(studentQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Student getById(Integer id) {
    	return studentMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param studentdto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(StudentDTO studentdto) {
    	return studentMapper.add(studentdto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param studentdto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(StudentDTO studentdto) {
    	return studentMapper.updateById(studentdto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return studentMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return studentMapper.deleteByIds(ids);
    }
    
 
}