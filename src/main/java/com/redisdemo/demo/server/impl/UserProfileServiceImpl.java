package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.UserProfileMapper;
import com.redisdemo.demo.dto.UserProfileDTO;
import com.redisdemo.demo.entity.UserProfile;
import com.redisdemo.demo.query.UserProfileQuery;
import com.redisdemo.demo.server.UserProfileService;
import com.redisdemo.demo.vo.UserProfileVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Resource
    private UserProfileMapper userProfileMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(UserProfileQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = userProfileMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<UserProfileVO> getAll(UserProfileQuery userProfileQuery) {
    	return userProfileMapper.getAll(userProfileQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public UserProfile getById(Integer id) {
    	return userProfileMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param userProfiledto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(UserProfileDTO userProfiledto) {
    	return userProfileMapper.add(userProfiledto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param userProfiledto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(UserProfileDTO userProfiledto) {
    	return userProfileMapper.updateById(userProfiledto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return userProfileMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return userProfileMapper.deleteByIds(ids);
    }
    
 
}