package com.miyako.subject.commons.result;

import java.io.Serializable;

/**
 * ClassName Result
 * Description //不同模块之间传递消息和数据
 * Author weila
 * Date 2019-08-07-0007 20:41
 */
public class Result<T> implements Serializable{

    private int code;
    private String msg;
    private T data;

    private Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> create(CodeMsg codeMsg, T data){
        return new Result<T>(codeMsg.getCode(), codeMsg.getMsg(), data);
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}

