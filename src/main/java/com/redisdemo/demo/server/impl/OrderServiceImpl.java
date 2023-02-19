package com.redisdemo.demo.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redisdemo.demo.dao.OrderMapper;
import com.redisdemo.demo.dto.OrderDTO;
import com.redisdemo.demo.entity.Order;
import com.redisdemo.demo.query.OrderQuery;
import com.redisdemo.demo.server.OrderService;
import com.redisdemo.demo.vo.OrderVO;
import org.springframework.cglib.core.ClassInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    
    /**
    * 分页查询所有记录
    * @param query
    * @return
    */
    @Override
    public PageInfo<ClassInfo> getPage(OrderQuery query) {
        PageHelper.startPage(query.getPageCode(),query.getPageSize());
        List<ClassInfo> page = orderMapper.getPage(query);
        return new PageInfo<>(page);
    }
    

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    @Override
    public List<OrderVO> getAll(OrderQuery orderQuery) {
    	return orderMapper.getAll(orderQuery);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    @Override
    public Order getById(Integer id) {
    	return orderMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param orderdto 新增的记录
     * @return 返回影响行数
     */
    @Override
    public int add(OrderDTO orderdto) {
    	return orderMapper.add(orderdto);
    }
	
	
    /**
     * 修改，修改所有字段
     *
     * @param orderdto 修改的记录
     * @return 返回影响行数
     */
    @Override
    public int updateById(OrderDTO orderdto) {
    	return orderMapper.updateById(orderdto);
    }
	
    /**
     * 删除记录
     *
     * @param id 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int delete(Integer id) {
    	return orderMapper.delete(id);
    }
	
    
     /**
     * 删除记录 批量
     *
     * @paramids 待删除的记录
     * @return 返回影响行数
     */
    @Override
    public int deleteByIds( List<String> ids) {
    	return orderMapper.deleteByIds(ids);
    }
    
 
}