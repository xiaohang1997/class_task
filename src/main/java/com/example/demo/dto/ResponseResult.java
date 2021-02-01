package com.example.demo.dto;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功返回的统一数据格式
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> success(Integer code,String msg,T data){
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 无参success方法
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> success(){

        return success(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.msg(),null);
    }

    /**
     * 传递数据的success方法
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> success(T data){

        return success(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.msg(),data);
    }


    /**
     * 传递数据和消息的success方法
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> success(String msg,T data){

        return success(ResultCode.SUCCESS.code(),msg,data);
    }
    /**
     * 失败返回的统一数据格式
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> fail(Integer code,String msg,T data){
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 无参数的fail方法
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> fail(){

        return fail(ResultCode.FAILED.code(),ResultCode.FAILED.msg(),null);
    }

    /**
     * 放回消息的fail方法
     * @param msg
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> fail(String msg){

        return fail(ResultCode.FAILED.code(),msg,null);
    }

    /**
     * 返回状态码和消息的fail方法
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> fail(Integer code,String msg){

        return fail(code,msg,null);
    }

    /**
     * 返回消息和数据的fail方法
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> fail(String msg,T data){

        return fail(ResultCode.FAILED.code(),msg,data);
    }

    /**
     * 没有权限返回统一数据格式
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> noAuthorityFail(){

        return fail(ResultCode.NO_AUTHORIZED.code(),ResultCode.NO_AUTHORIZED.msg(),null);
    }

    /**
     * 参数错误返回的统一数据格式
     * @param <T>
     * @return
     */
    public static<T> ResponseResult<T> paramError(){
        return fail(ResultCode.PARAM_IS_INVALID.code(),ResultCode.PARAM_IS_INVALID.msg(),null);
    }
}
