package com.gzj.aop;

import com.alibaba.fastjson.JSON;
import com.gzj.utils.HttpContextUtils;
import com.gzj.utils.IpUtils;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
@Log4j2
public class Log4j2Aspect {
    //定义切面
    @Pointcut("execution(* com.gzj.controller.*.*(..))")
    public void pointCut(){};
    //环绕通知
    @Around("pointCut()")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //保存日志
        recordLog(point, time);
        return result;
    }
    private void recordLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("=====================log start================================");
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}", className + "." + methodName + "()");

//        //请求的参数
        Object[] args = joinPoint.getArgs();
        if(args.length!=0){
            String params = null;
            try{
                params = JSON.toJSONString(args[0]);
            }catch (Exception ex){

            }
            System.out.println(params);
            log.info("params:{}", params);
        }
        //获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IpUtils.getIpAddr(request));


        log.info("excute time : {} ms", time);
        log.info("=====================log end================================");
    }

}
