package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class ResultVO<T> {

    private Integer code=0;

    private Integer count;

    private Integer status=200;

    private  String msg="success";

    @JsonProperty("data")
    private List<T> list;

    public ResultVO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    //    @JsonProperty("data2")
//    private List<Message> messageList ;
}
