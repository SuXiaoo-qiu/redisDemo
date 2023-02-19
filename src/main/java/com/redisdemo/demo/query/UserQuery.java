package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户表
 */

@Data
@ApiModel(value = "用户表Query")
public class UserQuery extends PageQuery  implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	/** 用户名称 */
        @ApiModelProperty("用户名称")
	private String name;
	/** 账号 */
        @ApiModelProperty("账号")
	private String accountNumber;
	/** 密码 */
        @ApiModelProperty("密码")
	private String password;
	/** 创建时间 */
        @ApiModelProperty("创建时间")
	private String createTime;
	/** 修改时间 */
        @ApiModelProperty("修改时间")
	private String uodateTime;
	/** 创建人 */
        @ApiModelProperty("创建人")
	private String createPeople;
	/** 修改人 */
        @ApiModelProperty("修改人")
	private String uodatePeople;

	
	
}