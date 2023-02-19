package com.redisdemo.demo.server;


import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.UserDTO;
import com.redisdemo.demo.entity.User;
import com.redisdemo.demo.query.UserQuery;
import com.redisdemo.demo.vo.UserVO;
import org.springframework.cglib.core.ClassInfo;

import java.util.List;

public interface UserService {
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    PageInfo<ClassInfo> getPage(UserQuery query);
   
	/**
     *查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<UserVO> getAll(UserQuery query);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	User getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param userDto 新增的记录
     * @return 返回影响行数
     */
	int add(UserDTO userDto);

	/**
     * 修改，修改所有字段
     *
     * @param userDto 修改的记录
     * @return 返回影响行数
     */
	int updateById(UserDTO userDto);
	
	/**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
	int delete(Integer id);

	/**
     * 批量删除记录
     *
     * @param ids 待删除的记录
     * @return 返回影响行数
     */
	 int deleteByIds(List<String> ids);
	
}