package com.redisdemo.demo.dao;

import com.redisdemo.demo.dto.OrderDTO;
import com.redisdemo.demo.entity.Order;
import com.redisdemo.demo.query.OrderQuery;
import com.redisdemo.demo.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cglib.core.ClassInfo;

import java.util.List;
@Mapper
public interface OrderMapper {
	
  

   
	/**
     *查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<OrderVO> getAll(OrderQuery query);

   
	/**
     *分页查询所有记录
     * @param query
     * @return 返回集合，没有返回空List
     */
	List<ClassInfo>  getPage(OrderQuery query);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	Order getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param orderDto 新增的记录
     * @return 返回影响行数
     */
	int add(OrderDTO orderDto);

	/**
     * 修改，修改所有字段
     *
     * @param orderDto 修改的记录
     * @return 返回影响行数
     */
	int updateById(OrderDTO orderDto);
	
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