package com.huabrother.plm.exception;

import com.huabrother.plm.enums.ResultEnum;

/**
 * chenwenhua
 * 2018\8\25 0025
 * 0:02
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
