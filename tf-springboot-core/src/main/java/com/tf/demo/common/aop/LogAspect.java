package com.tf.demo.common.aop;

import com.tf.common.enums.ResultCode;
import com.tf.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Author:       VinceChen
 * Date:         2020-11-12 10:17
 * Description:
 */
@Aspect
@Order(0)
@Slf4j
@Component("logAspect")
public class LogAspect {
    @Pointcut("execution(* com.tf.demo.web..*.*(..))")
    public void logPointCut() {
    }

    @Around(value = "logPointCut()")
    public Object logOperate(ProceedingJoinPoint joinPoint) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result;
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        String methodName = method.getDeclaringClass().getSimpleName() + "." + method.getName();

        log.info("[log aop] begin; method:{}", methodName);
        try {
            result = joinPoint.proceed();
            log.info("[log aop] end; method:{}, costTime:{}", methodName, stopWatch.getTime());
        } catch (Throwable throwable) {
            log.error("[log aop] exception; method:{}, costTime:{}", methodName, stopWatch.getTime());
            result = new Result(ResultCode.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
