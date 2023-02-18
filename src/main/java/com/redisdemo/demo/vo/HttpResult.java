package com.redisdemo.demo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "返回结果实体类", description = "结果实体类")
public class HttpResult<T> implements Serializable {

    private int code = 200;
    //private static final int FAIL_CODE = 500;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 请求成功时的响应结果
     * @return
     */
    public static HttpResult success(){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(httpResult.code);
        httpResult.setMsg("SUCCESS");
        return httpResult;
    }

    /**
     * 请求成功时的响应结果
     * @param msg 自定义响应内容
     * @return
     */
    public static HttpResult success(String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        httpResult.setCode(httpResult.code);
        return httpResult;
    }

    /**
     * 请求成功时的响应结果
     * @param data 要响应的数据
     * @return
     */
    public static HttpResult success(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(httpResult.code);
        httpResult.setMsg("SUCCESS");
        httpResult.setData(data);
        return httpResult;
    }

    /**
     * 请求成功时的响应结果
     * @param msg 自定义响应的内容
     * @param data 自定义响应数据
     * @return
     */
    public static HttpResult success(String msg, Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(httpResult.code);
        httpResult.setMsg(msg);
        httpResult.setData(data);
        return httpResult;
    }

    /**
     * 请求失败时的响应内容
     * @return
     */
    public static HttpResult error(){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(500);
        httpResult.setMsg("未知错误可能是缓存问题，请刷新后重试");
        return httpResult;
    }

    /**
     * 请求失败时的相应内容
     * @param msg 自定义相应内容
     * @return
     */
    public static HttpResult error(String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(500);
        httpResult.setMsg(msg);
        return httpResult;
    }






















   /* private static final long serialVersionUID = 1L;
    public static volatile java.lang.Integer error_prefix;
    @ApiModelProperty(value = "返回码")
    private java.lang.Integer code;
    @ApiModelProperty(value = "返回消息")
    private java.lang.String message;
    @ApiModelProperty(value = "返回数据")
    private T data;

        private ResultVO() {

        }

        public ResultVO(ResultCode resultCode, T data) {
            this.code = resultCode.code();
            this.message = resultCode.message();
            this.data = data;
        }

        private void setResultCode(ResultCode resultCode) {
            this.code = resultCode.code();
            this.message = resultCode.message();
        }

        // 返回成功
        public static ResultVO success() {
            ResultVO result = new ResultVO();
            result.setResultCode(ResultCode.SUCCESS);
            return result;
        }
        // 返回成功
        public ResultVO success(T data) {
            ResultVO result = new ResultVO();
            result.setResultCode(ResultCode.SUCCESS);
            result.setData(data);
            return result;
        }


        // 返回失败
        public static ResultVO error(String message) {
            ResultVO result = new ResultVO();
            result.setCode(500);
            result.setMessage(message);
            return result;
        }
        // 返回失败
        public static ResultVO error(ResultCode resultCode) {
            ResultVO result = new ResultVO();
            result.setResultCode(resultCode);
            return result;
        }*/
    }