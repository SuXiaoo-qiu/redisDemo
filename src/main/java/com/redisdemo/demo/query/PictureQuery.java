package com.redisdemo.demo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 图片信息表
 */

@Data
@ApiModel(value = "图片信息表Query")
public class PictureQuery extends PageQuery  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** id */
        @ApiModelProperty("id")
	private Integer id;
	/** 图片名称 */
        @ApiModelProperty("图片名称")
	private String pictureName;
	/** 图片地址 */
        @ApiModelProperty("图片地址")
	private String pictureUrl;
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