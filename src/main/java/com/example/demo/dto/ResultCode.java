package com.example.demo.dto;

public enum  ResultCode {
    /* 成功状态码 */
    SUCCESS(200, "成功"),

    /*失败*/
    FAILED(400,"失败"),

    /**参数错误：10001-19999
     * 10001, "参数无效"
     */
    PARAM_IS_INVALID(10001, "参数有误"),

    /**无权错误：20000-29999
     *  20001  "未认证"
     */
    NO_AUTHORIZED(20001,"无权操作,未认证");

    public static String getMsg(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.msg;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return this.name();
    }
    public Integer isSuccess() {
        return SUCCESS.code;
    }
    private Integer code;
    private String msg;

    private ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}
