package com.tianqing.aop;

import com.tianqing.common.BaseCoreRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 异常日志切面类
 * Created by hyb on 2016/4/12.
 */
@Component
@Slf4j
@Aspect
public class ExceptionAspect {

    //@Pointcut("execution(* *(..))")
    @Pointcut("execution(* com.tianqing.service.*.*.*(..))")
    public void allMethod(){};

    @AfterThrowing(pointcut="allMethod()",throwing = "ex")
    public void afterThrowException(JoinPoint jp,Throwable ex){
        String reqSeq=null;
        if(jp.getArgs().length>0 && jp.getArgs()[0] instanceof BaseCoreRequest){
            reqSeq=((BaseCoreRequest)jp.getArgs()[0]).getReqSeq();
        }
        System.out.println("log an Exception");
        log.error("[{}]There is an Exception has been thrown about follow messages:",reqSeq,ex);
    }

}
