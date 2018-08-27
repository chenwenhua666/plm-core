package com.huabrother.plm.enums;

/**
 * chenwenhua
 * 2018\8\25 0025
 * 0:46
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOLE(100,"可能在上小学"),
    MIDDLE_SCHOOLE(101,"可能在上初中");


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
