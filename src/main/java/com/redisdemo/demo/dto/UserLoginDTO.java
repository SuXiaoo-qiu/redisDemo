package com.redisdemo.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录表
 */

@Data
@ApiModel(value = "用户登录表DTO")
public class UserLoginDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	/** id */
        @ApiModelProperty("id")
	private Integer id;
	/** 登录用户名字 */
        @ApiModelProperty("登录用户名字")
	private String loginUserAme;
	/** 最后一次登录时间 */
        @ApiModelProperty("最后一次登录时间")
	private String lastLoginTime;

}