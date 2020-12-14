package com.example.demo02.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Li Ning
 * @version 1.0
 * @date 2020/12/14 0014 10:05
 * Description:Spring AOP 基于类的切面实现
 */
@Component
@Aspect
@Order(1)
public class LogAspect2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class) ;

    @Pointcut("within(com.example.demo02.controller.*)")
    public void requestServer (){
        //@Pointcut定义了一个切点，因为是请求日志切边，因此切点定义的是Controller包下的所有类下的方法。定义切点以后在通知注解中直接使用requestServer方法名就可以了
        //@annotation(org.springframework.transaction.annotation.Transactional) 带有@Transactional标注的任意方法.
        //@ within 和 @ target针对类的注解,@annotation是针对方法的注解.
        //使用“target(类型全限定名)”匹配当前目标对象类型的执行方法；注意target中使用的表达式必须是类型全限定名，不支持通配符；
    }

    @Before("requestServer()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("===============================Start Order=1========================");
        LOGGER.info("IP                 : {}", request.getRemoteAddr());
        LOGGER.info("URL                : {}", request.getRequestURL().toString());
        LOGGER.info("HTTP Method        : {}", request.getMethod());
        LOGGER.info("Class Method       : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
    }

    @Around("requestServer()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("Request Params       : {}", getRequestParams(proceedingJoinPoint));
        LOGGER.info("Result               : {}", result);
        LOGGER.info("Time Cost            : {} ms", System.currentTimeMillis() - start);

        return result;
    }

    private Map<String,Object> getRequestParams(ProceedingJoinPoint proceedingJoinPoint) {
        Map<String, Object> requestParams = new HashMap<>();

        //参数名
        String[] paramNames = ((MethodSignature)proceedingJoinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();

        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];

            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                value = file.getOriginalFilename();  //获取文件名
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

    //@Pointcut("within(com.example.demo02.controller.*)")
    @After("requestServer()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("===============================End Order=1========================");
    }
}
