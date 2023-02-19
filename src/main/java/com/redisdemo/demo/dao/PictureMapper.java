package com.redisdemo.demo.dao;

import com.redisdemo.demo.dto.PictureDTO;
import com.redisdemo.demo.entity.Picture;
import com.redisdemo.demo.query.PictureQuery;
import com.redisdemo.demo.vo.PictureVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cglib.core.ClassInfo;

import java.util.List;
@Mapper
public interface PictureMapper {
	
  

   
	/**
     *查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<PictureVO> getAll(PictureQuery query);

   
	/**
     *分页查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<ClassInfo>  getPage(PictureQuery query);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Picture getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param pictureDto 新增的记录
     * @return 返回影响行数
     */
	int add(PictureDTO pictureDto);

	/**
     * 修改，修改所有字段
     *
     * @param pictureDto 修改的记录
     * @return 返回影响行数
     */
	int updateById(PictureDTO pictureDto);
	
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