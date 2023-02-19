package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.AdvertisementMapper;
import com.redisdemo.demo.dto.AdvertisementDTO;
import com.redisdemo.demo.entity.Advertisement;
import com.redisdemo.demo.query.AdvertisementQuery;
import com.redisdemo.demo.server.AdvertisementService;
import com.redisdemo.demo.vo.AdvertisementVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(AdvertisementQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = advertisementMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<AdvertisementVO> getAll(AdvertisementQuery advertisementQuery) {
    	return advertisementMapper.getAll(advertisementQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Advertisement getById(Integer id) {
    	return advertisementMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param advertisementdto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(AdvertisementDTO advertisementdto) {
    	return advertisementMapper.add(advertisementdto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param advertisementdto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(AdvertisementDTO advertisementdto) {
    	return advertisementMapper.updateById(advertisementdto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return advertisementMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return advertisementMapper.deleteByIds(ids);
    }
    
 
}