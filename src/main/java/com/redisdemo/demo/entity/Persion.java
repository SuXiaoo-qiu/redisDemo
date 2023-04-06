package com.redisdemo.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "树形菜单表")
public class Persion {

    private Integer id;
    private String name;
    private Integer  parentId;

    private List<Persion> children;
}
