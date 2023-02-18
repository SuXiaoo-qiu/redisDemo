package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageQuery<T> implements java.io.Serializable {

    @ApiModelProperty("当前页数默认为1")
    private Integer pageCode;

    @ApiModelProperty("每页大小默认为100000")
    private Integer pageSize = 100000;
}