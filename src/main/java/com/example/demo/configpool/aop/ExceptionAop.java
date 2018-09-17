package com.example.demo.configpool.aop;

import com.example.demo.utils.exceptionutil.BusinessException;
import com.example.demo.utils.resultutil.ResultCodeEnum;
import com.example.demo.utils.resultutil.ResultUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 创建人:连磊
 * 日期: 2018/9/17. 10:55
 * 描述：
 */
@Aspect
@Component
@Order(0)
public class ExceptionAop {

    @Pointcut("execution(* com.example.demo..*.*(..))")
    public void executionService(){}
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void executionRequest() {}

    /**
     * 执行方法前异常：前置异常
     * @param joinPoint
     */
    @Before("executionService()")
    public void doBefore(JoinPoint joinPoint){

    }

    /**
     * 处理异常信息
     * @param proceedingJoinPoint
     * @return
     */
    @Around("executionService() && executionRequest()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            String code = null;
            if (throwable instanceof BusinessException){
                BusinessException businessException = (BusinessException) throwable;
                code = businessException.getCode();
                result = ResultUtils.createResult().setResultMessage(businessException.getMessage() , code);
            }else {
                result = ResultUtils.createResult().setResultMessage(ResultCodeEnum.REQUEST_UNKNOWN_ERROR.getMessage(), ResultCodeEnum.REQUEST_UNKNOWN_ERROR.getCode());
            }
        }
        if (result instanceof ResultUtils){
            return result;
        }else {
            return ResultUtils.createResult().setResultMessage(ResultCodeEnum.REQUEST_SUCCESS.getMessage(), ResultCodeEnum.REQUEST_SUCCESS.getCode());
        }
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @AfterReturning("executionService()")
    public void doAfterReturning(JoinPoint joinPoint){

    }

    /**
     * 执行后异常：后置异常
     * @param joinPoint
     */
    @After("executionService()")
    public void doAfter(JoinPoint joinPoint){

    }
}
