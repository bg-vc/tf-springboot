package com.tf.demo.web.api.test;

import com.tf.common.enums.ResultCode;
import com.tf.common.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 11:15
 * Description:
 */
@RestController
@RequestMapping("demo/api/test/")
public class TestController {

    public static String type;

    @RequestMapping(value = "check", method = RequestMethod.GET)
    public Result<String> test() {
        Result<String> result = new Result<>();
        String data = "hello:" + type;
        return result.setResult(ResultCode.SUCCESS).setData(data);
    }

    @Value("${active.type}")
    public void setType(String type) {
        TestController.type = type;
    }

}