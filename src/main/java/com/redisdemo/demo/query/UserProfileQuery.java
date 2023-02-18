package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 测试表
 */

@Data
@ApiModel(value = "测试表Query")
public class UserProfileQuery extends PageQuery  implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	private Integer deviceId;
	private String gender;
	private Integer age;
	private String university;
	private String province;
	private Float gpa;



}