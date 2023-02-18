package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 学生表
 */

@Data
@Getter
@Setter
@ApiModel(value = "学生表Query")
public class StudentQuery extends PageQuery  implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	/** 学号 */
        @ApiModelProperty("学号")
	private Integer studentNum;
	/** 学生姓名 */
        @ApiModelProperty("学生姓名")
	private String studentName;
	/** 民族 */
        @ApiModelProperty("民族")
	private String nation;
	/** 学院 */
        @ApiModelProperty("学院")
	private String college;
	/** 专业 */
        @ApiModelProperty("专业")
	private String major;
	/** 年级 */
        @ApiModelProperty("年级")
	private String grade;
	/** 学生班级 */
        @ApiModelProperty("学生班级")
	private String studentClass;
	/** 学生身份证 */
        @ApiModelProperty("学生身份证")
	private String studentId;
	/** 性别 1男 2女 */
        @ApiModelProperty("性别 1男 2女")
	private String studentSex;
	/** 创建人 */
        @ApiModelProperty("创建人")
	private String createPeople;
	/** 创建时间 */
        @ApiModelProperty("创建时间")
	private String createTime;
	/** 修改人 */
        @ApiModelProperty("修改人")
	private String updatePeople;
	/** 修改时间 */
        @ApiModelProperty("修改时间")
	private String updateTime;
	/** 是否有效 10有效 00 无效 */
        @ApiModelProperty("是否有效 10有效 00 无效")
	private String isDelete;



}