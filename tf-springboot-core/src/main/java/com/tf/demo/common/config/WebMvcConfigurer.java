package com.tf.demo.common.config;

import com.alibaba.fastjson.JSONObject;
import com.tf.common.enums.ResultCode;
import com.tf.common.model.Result;
import com.tf.demo.common.aop.JwtInterceptor;
import com.tf.demo.common.exception.JwtTokenEmptyException;
import com.tf.demo.common.exception.JwtTokenInvalidException;
import com.tf.demo.common.exception.ServiceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:58
 * Description:
 */

@Configuration
@Slf4j
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Resource
    private JwtInterceptor jwtInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**");
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add((request, response, handler, e) -> {
            Result<String> result = new Result<>();
            if (e instanceof JwtTokenEmptyException) {
                log.error("JwtTokenEmptyException:{}", e.getMessage());
                result.setResult(ResultCode.ERR_TOKEN_EMPTY);
            } else if (e instanceof JwtTokenInvalidException) {
                log.error("JwtTokenInvalidException:{}", e.getMessage());
                result.setResult(ResultCode.ERR_TOKEN_INVALID);
            } else if (e instanceof ServiceNotFoundException) {
                log.error("NoHandlerFoundException:{}", e.getMessage());
                result.setResult(ResultCode.ERR_SERVICE_NOT_FOUND);
            } else {
                e.printStackTrace();
                log.error("Exception:{}", e.getMessage());
                result.setResult(ResultCode.INTERNAL_SERVER_ERROR);
            }
            responseResult(response, result);
            return new ModelAndView();

        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSONObject.toJSONString(result));
        } catch (IOException e) {
            log.error("responseResult:{}", e.getMessage());
        }
    }
}