package com.xxl.springboot.init.handler;

import com.xxl.springboot.init.result.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常类
 *
 * @author xxl
 * @date 2025/1/5 17:52
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }
}
