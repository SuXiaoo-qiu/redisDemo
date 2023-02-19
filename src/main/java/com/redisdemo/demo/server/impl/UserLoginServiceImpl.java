package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.UserLoginMapper;
import com.redisdemo.demo.dto.UserLoginDTO;
import com.redisdemo.demo.entity.UserLogin;
import com.redisdemo.demo.query.UserLoginQuery;
import com.redisdemo.demo.server.UserLoginService;
import com.redisdemo.demo.vo.UserLoginVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userLoginMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(UserLoginQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = userLoginMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<UserLoginVO> getAll(UserLoginQuery userLoginQuery) {
    	return userLoginMapper.getAll(userLoginQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public UserLogin getById(Integer id) {
    	return userLoginMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param userLogindto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(UserLoginDTO userLogindto) {
    	return userLoginMapper.add(userLogindto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param userLogindto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(UserLoginDTO userLogindto) {
    	return userLoginMapper.updateById(userLogindto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return userLoginMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return userLoginMapper.deleteByIds(ids);
    }
    
 
}