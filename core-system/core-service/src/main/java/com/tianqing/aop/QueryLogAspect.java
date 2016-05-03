package com.tianqing.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 查询日志切面类
 * Created by hyb on 2016/4/12.
 */
@Component
@Slf4j
@Aspect
public class QueryLogAspect {

    @Pointcut("execution(* com.tianqing.service.query.*.*(..))")
    public void queryMethod(){};

    @Before(value="queryMethod()")
    public void beforeHandler(JoinPoint jp) throws Throwable{
        log.info("Class:{},Method:{},Request:{}",
                jp.getSignature().getDeclaringTypeName(),jp.getSignature().getName(),jp.getArgs().length>0?jp.getArgs()[0]:null);
    }

}
