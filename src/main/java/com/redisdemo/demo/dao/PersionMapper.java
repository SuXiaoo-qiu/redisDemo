package com.redisdemo.demo.dao;

import com.redisdemo.demo.entity.Persion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PersionMapper {
    public List<Persion> getPersions() ;

}
