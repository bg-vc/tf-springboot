package com.tf.demo.common.aop;

import com.tf.demo.common.config.JwtConfigurer;
import com.tf.demo.common.constant.Const;
import com.tf.demo.common.exception.JwtTokenEmptyException;
import com.tf.demo.common.exception.JwtTokenInvalidException;
import com.tf.demo.common.exception.ServiceNotFoundException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:18
 * Description:
 */
@Component
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JwtConfigurer jwtConfigurer;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws RuntimeException {

        String uri = request.getRequestURI();
        if (uri.contains("/error")) {
            throw new ServiceNotFoundException(" 服务接口不存在");
        }
        if (uri.contains("/demo/api/test")) {
            return true;
        }

        String token = request.getHeader(Const.JWT_HEADER);
        if (StringUtils.isBlank(token)) {
            throw new JwtTokenEmptyException(Const.JWT_HEADER + "不能为空");
        }
        Claims claims = jwtConfigurer.getTokenClaim(token);
        if (null == claims) {
            throw new JwtTokenInvalidException(Const.JWT_HEADER + "无效");
        }
        if (jwtConfigurer.isTokenExpired(claims.getExpiration())) {
            throw new JwtTokenInvalidException(Const.JWT_HEADER + "过期");
        }
        boolean flag = jwtConfigurer.isValidFromRedis(token);
        if (!flag) {
            throw new JwtTokenInvalidException(Const.JWT_HEADER + "失效");
        }
        //request.setAttribute("identityId", claims.getSubject());
        return true;
    }
}