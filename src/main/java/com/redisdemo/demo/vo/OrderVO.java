package com.redisdemo.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 订单信息表
 */

@Data
@ApiModel(value="订单信息表VO")
public class OrderVO  implements Serializable {
	private static final long serialVersionUID = 1L;


	private Integer id;
	/** 价格 */
    @ApiModelProperty("价格")
	private String price;
	/** 订单详情 */
    @ApiModelProperty("订单详情")
	private String orderDetails;
	/** 出发城市 */
    @ApiModelProperty("出发城市")
	private String departureCity;
	/** 到达城市 */
    @ApiModelProperty("到达城市")
	private String arriveCity;
	/** 乘坐人 */
    @ApiModelProperty("乘坐人")
	private String passengers;
	/** 开始时间 */
    @ApiModelProperty("开始时间")
	private String startTime;
	/** 结束时间 */
    @ApiModelProperty("结束时间")
	private String endTime;

}