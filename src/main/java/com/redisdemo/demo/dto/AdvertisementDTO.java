package com.redisdemo.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 广告管理
 */

@Data
@ApiModel(value = "广告管理DTO")
public class AdvertisementDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	/** id */
        @ApiModelProperty("id")
	private Integer id;
	/** 广告标题 */
        @ApiModelProperty("广告标题")
	private String title;
	/** 详情 */
        @ApiModelProperty("详情")
	private String details;
	/** 开始时间 */
        @ApiModelProperty("开始时间")
	private String startTime;
	/** 结束时间 */
        @ApiModelProperty("结束时间")
	private String endTime;

}