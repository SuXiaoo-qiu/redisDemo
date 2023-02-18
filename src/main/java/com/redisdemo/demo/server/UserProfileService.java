package com.redisdemo.demo.server;


import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dto.UserProfileDTO;
import com.redisdemo.demo.entity.UserProfile;
import com.redisdemo.demo.query.UserProfileQuery;
import com.redisdemo.demo.vo.UserProfileVO;
import org.springframework.cglib.core.ClassInfo;

import java.util.List;

public interface UserProfileService {
    
    /**
     * 分页查询
     * @param query
     * @return
     */
    PageInfo<ClassInfo> getPage(UserProfileQuery query);
   
	/**
     *查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<UserProfileVO> getAll(UserProfileQuery query);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	UserProfile getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param userProfileDto 新增的记录
     * @return 返回影响行数
     */
	int add(UserProfileDTO userProfileDto);

	/**
     * 修改，修改所有字段
     *
     * @param userProfileDto 修改的记录
     * @return 返回影响行数
     */
	int updateById(UserProfileDTO userProfileDto);
	
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