package com.xxl.springboot.init.exception;

import com.xxl.springboot.init.result.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义异常
 *
 * @author xxl
 * @date 2025/1/5 18:04
 */
@Data
public class MyException extends RuntimeException {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 接受状态码和消息
     *
     * @param code    状态码
     * @param message 消息
     */
    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 接收枚举类型
     *
     * @param resultCodeEnum 枚举类型
     */
    public MyException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
