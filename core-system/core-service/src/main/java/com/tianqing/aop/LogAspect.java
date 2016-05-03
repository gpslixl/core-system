package com.tianqing.aop;

import com.tianqing.common.util.validator.BaseValidator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 引用日志切面
 * Created by hyb on 2016/4/12.
 */
@Component
@Slf4j
@Aspect
public class LogAspect {

    private static BaseValidator validator;
    static{
        validator=new BaseValidator();
    }

    @Pointcut("execution(* com.tianqing.service.handle.*.*(..))")
    public void handlerMethod(){};

    @Before(value="handlerMethod()")
    public void beforeHandler(JoinPoint jp) throws Throwable{
        if(jp.getArgs().length>0){
            validator.validate(jp.getArgs()[0]);
        }
        log.info("Class:{},Method:{},Request:{}",
                jp.getSignature().getDeclaringTypeName(),jp.getSignature().getName(),jp.getArgs().length>0?jp.getArgs()[0]:null);
    }

}
