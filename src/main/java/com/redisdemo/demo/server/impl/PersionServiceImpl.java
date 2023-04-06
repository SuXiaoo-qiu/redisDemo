package com.redisdemo.demo.server.impl;

import com.redisdemo.demo.dao.PersionMapper;
import com.redisdemo.demo.entity.Persion;
import com.redisdemo.demo.server.PersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersionServiceImpl implements PersionService {
    @Resource
    private PersionMapper persionMapper;
    @Override
    public List<Persion> getPersions() {


        // 查询所有数据
        List<Persion> persions = persionMapper.getPersions();
        ArrayList<Persion> parent = new ArrayList<>();
        persions.forEach(itme->{
            //如果等于0就是跟节点
            if (itme.getParentId()==0){
                parent.add(itme);
            }
        });
        //在根据跟节点找子节点
        parent.forEach(son->{
            List<Persion> son1 = getSon(son.getId(), persions);
            son.setChildren(son1);
        });


        System.out.println(parent);
        return parent;
    }


    private List<Persion> getSon(int id ,List<Persion> persions){
        //添加子类
        ArrayList<Persion> son = new ArrayList<>();
        persions.forEach(sunOne->{
            //如果子类的父id 和 当前id一样 就把它仍在儿子节点
            if (id == sunOne.getParentId()){
                son.add(sunOne);
            }
        });
        // 在循环儿子节点找孙子节点
        son.forEach(grandson->{
            List<Persion> grandsonOne = this.getSon(grandson.getId(), persions);
            grandson.setChildren(grandsonOne);


        });
        if (son==null){
            return null;
        }
        return son;

    }
}
