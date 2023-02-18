package com.redisdemo.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 测试表
 */

@Data
@ApiModel(value="测试表VO")
public class UserProfileVO  implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	private Integer deviceId;
	private String gender;
	private Integer age;
	private String university;
	private String province;
	private Float gpa;

}