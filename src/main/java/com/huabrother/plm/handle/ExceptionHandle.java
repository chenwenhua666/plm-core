package com.huabrother.plm.handle;

import com.huabrother.plm.exception.GirlException;
import com.huabrother.plm.utils.ResultUtil;
import com.huabrother.plm.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * chenwenhua
 * 2018\8\24 0024
 * 23:54
 */
@ControllerAdvice
public class ExceptionHandle {

    private  final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException)e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        log.error("系统异常={}",e);
        return ResultUtil.error(-1,"未知错误");
    }
}
