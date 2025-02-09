package com.xxl.springboot.init.controller;

import com.xxl.springboot.init.exception.MyException;
import com.xxl.springboot.init.result.R;
import com.xxl.springboot.init.result.ResultCodeEnum;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xxl
 * @date 2024/12/29 0:21
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/2")
    @ResponseBody
    public String home() {
        return "www.xxl.cnnn";
    }

    @RequestMapping("/testException")
    @ResponseBody
    public R testException() {
        Integer num = 1 / 0;
        return R.ok().data("num", num);
    }

    @RequestMapping("/testParamException")
    @ResponseBody
    public R testParamException(@RequestParam("num") Integer num) {
        if (num == null) {
            throw new MyException(ResultCodeEnum.PARAM_ERROR);
        }
        return R.ok().data("num", num);
    }
}
