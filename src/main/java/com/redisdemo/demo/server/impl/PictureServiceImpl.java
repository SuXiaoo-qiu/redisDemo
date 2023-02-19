package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.PictureMapper;
import com.redisdemo.demo.dto.PictureDTO;
import com.redisdemo.demo.entity.Picture;
import com.redisdemo.demo.query.PictureQuery;
import com.redisdemo.demo.server.PictureService;
import com.redisdemo.demo.vo.PictureVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureMapper pictureMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(PictureQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = pictureMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<PictureVO> getAll(PictureQuery pictureQuery) {
    	return pictureMapper.getAll(pictureQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Picture getById(Integer id) {
    	return pictureMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param picturedto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(PictureDTO picturedto) {
    	return pictureMapper.add(picturedto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param picturedto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(PictureDTO picturedto) {
    	return pictureMapper.updateById(picturedto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return pictureMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return pictureMapper.deleteByIds(ids);
    }
    
 
}