package com.redisdemo.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单信息表
 */

@Data
@ApiModel(value="报表vo")
public class ReportFormVO implements Serializable {
	private static final long serialVersionUID = 1L;
    @ApiModelProperty("价格")
	private String price;
	/** 出发城市 */
    @ApiModelProperty("出发城市")
	private String departureCity;
	/** 到达城市 */
    @ApiModelProperty("到达城市")
	private String arriveCity;
	/** 乘坐人 */
    @ApiModelProperty("乘坐人")
	private String passengers;
}