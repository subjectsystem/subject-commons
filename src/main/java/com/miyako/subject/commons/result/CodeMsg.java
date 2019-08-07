package com.miyako.subject.commons.result;

/**
 * ClassName CodeMsg
 * Description //不同模块之间传递消息
 * Author weila
 * Date 2019-08-07-0007 20:42
 */
public class CodeMsg{

    private int code;
    private String msg;

    public CodeMsg(int code, String msg){
        this.code = code;
        this.msg = msg;
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
}
