package com.redisdemo.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.sql.rowset.BaseRowSet;
import java.io.Serializable;

/**
 * 用户表
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "导出用户")
public class MyUser extends BaseRowSet implements Serializable {
	private static final long serialVersionUID = 1L;

		@ExcelProperty(value = {"id"}, index = 0)
		private Integer id;
	/** 用户名称 */
        @ApiModelProperty("用户名称")
		@ExcelProperty(value = {"name"}, index = 1)
		private String name;
	/** 账号 */
        @ApiModelProperty("账号")
		@ExcelProperty(value = {"accountNumber"}, index = 2)
		private String accountNumber;
	/** 密码 */
        @ApiModelProperty("密码")
		@ExcelProperty(value = {"password"}, index = 3)
		private String password;
	/** 创建时间 */
        @ApiModelProperty("创建时间")
		@ExcelProperty(value = {"createTime"}, index = 4)
		private String createTime;
	/** 修改时间 */
        @ApiModelProperty("修改时间")
		@ExcelProperty(value = {"uodateTime"}, index = 5)
		private String uodateTime;
	/** 创建人 */
        @ApiModelProperty("创建人")
		@ExcelProperty(value = {"createPeople"}, index = 6)
		private String createPeople;
	/** 修改人 */
        @ApiModelProperty("修改人")
		@ExcelProperty(value = {"uodatePeople"}, index = 7)
		private String uodatePeople;

	
	
}