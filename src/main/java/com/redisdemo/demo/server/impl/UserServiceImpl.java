package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.UserMapper;
import com.redisdemo.demo.dto.UserDTO;
import com.redisdemo.demo.entity.User;
import com.redisdemo.demo.query.UserQuery;
import com.redisdemo.demo.server.UserService;
import com.redisdemo.demo.utils.ExcelUtil;
import com.redisdemo.demo.vo.UserVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(UserQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = userMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<UserVO> getAll(UserQuery userQuery) {
    	return userMapper.getAll(userQuery);
    }

    @Override
    public void exportExcel(UserQuery userQuery, HttpServletResponse response) {

        List<List<String>> dataList = new ArrayList<>();

        dataList = userMapper.exportExcel(userQuery);
        List<String> titleList = Arrays.asList("序号","项目编码", "项目名称", "创建时间", "创建人");
        ExcelUtil.uploadExcelAboutUser(response,"apply.xlsx",titleList,dataList);
    }

    @Override
    public UserVO getOne(UserQuery query) {
        return userMapper.getOne(query);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public User getById(Integer id) {
    	return userMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param userdto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(UserDTO userdto) {
    	return userMapper.add(userdto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param userdto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(UserDTO userdto) {
    	return userMapper.updateById(userdto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return userMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return userMapper.deleteByIds(ids);
    }
    
 
}