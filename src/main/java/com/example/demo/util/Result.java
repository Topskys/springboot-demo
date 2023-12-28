package com.example.demo.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 响应工具类
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 是否成功
     */
    private Boolean success;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    private  Result(){};

    /**
     * 成功
     */
    public static<T> Result<T> success(){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("操作成功");
        return result;
    }

    /**
     * 成功，携带响应数据
     */
    public static<T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    /**
     * 错误
     */
    public static<T> Result<T> fail(){
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(ResultCode.FAILURE);
        result.setMsg("操作失败");
        return result;
    }


    /**
     * 错误（带错误参数）
     */
    public static<T> Result<T> fail(String msg){
        Result<T> result = new Result<T>();
        result.setSuccess(false);
        result.setCode(ResultCode.FAILURE);
        result.setMsg(msg);
        return result;
    }



    /**
     * 设置是否成功
     */
    public Result<T> success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    /**
     * 设置状态码
     */
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 设置消息
     */
    public Result<T> msg(String msg){
        this.setMsg(msg);
        return this;
    }

    /**
     * 存在
     */
    public static<T> Result<T> exist(T data){
        Result<T> result = new Result<T>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("操作成功");
        return result;
    }
}