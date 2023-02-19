package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.CityMapper;
import com.redisdemo.demo.dto.CityDTO;
import com.redisdemo.demo.entity.City;
import com.redisdemo.demo.query.CityQuery;
import com.redisdemo.demo.server.CityService;
import com.redisdemo.demo.vo.CityVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(CityQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = cityMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<CityVO> getAll(CityQuery cityQuery) {
    	return cityMapper.getAll(cityQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public City getById(Integer id) {
    	return cityMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param citydto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(CityDTO citydto) {
    	return cityMapper.add(citydto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param citydto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(CityDTO citydto) {
    	return cityMapper.updateById(citydto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return cityMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return cityMapper.deleteByIds(ids);
    }
    
 
}