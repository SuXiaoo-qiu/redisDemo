package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 城市表
 */

@Data
@ApiModel(value = "城市表Query")
public class CityQuery extends PageQuery  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** id */
        @ApiModelProperty("id")
	private Integer id;
	/** 城市名称 */
        @ApiModelProperty("城市名称")
	private String name;
	/** 城市详情 */
        @ApiModelProperty("城市详情")
	private String cityDetails;
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