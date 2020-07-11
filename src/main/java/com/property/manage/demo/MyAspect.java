package com.property.manage.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyAspect
 * @description: AOP 切面实例
 * @author: sunzhengwei
 * @create: 2020/7/9 14:51
 */

/**
 * 切面注解讲解
 @Aspect 用来类上,代表这个类是一个切面
 @Before 用在方法上代表这个方法是一个前置通知方法
 @After 用在方法上代表这个方法是一个后置通知方法
 @Around 用在方法上代表这个方法是一个环绕的方法
 @Around 用在方法上代表这个方法是一个环绕的方法
 @order(数字)用在类上，数字越小进入越早
 **/
/**
 环绕，前置，后置全部存在
 先进入环绕，在进入前置，离开前置，离开环绕，进入后置，离开后置
 **/
@Aspect
@Component
public class MyAspect {

    //@Before 用在方法上代表这个方法是一个前置通知方法  注解的参数是切点表达式
    @Before("execution(* com.property.manage.service.UserServiceImple.*.*(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("前置通知");
        //JoinPoint 通过该对象可以获取到被切入的对象的信息
        joinPoint.getTarget();//目标对象
        joinPoint.getSignature();//方法签名
        joinPoint.getArgs();//方法参数
    }


    @After("execution(* com.property.manage.service.UserServiceImple.*.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("后置通知");
        joinPoint.getTarget();//目标对象
        joinPoint.getSignature();//方法签名
        joinPoint.getArgs();//方法参数
    }

    @Around("execution(* com.property.manage.service.UserServiceImple.*.*(..))")
    public Object before(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        proceedingJoinPoint.getTarget();//目标对象
        proceedingJoinPoint.getSignature();//方法签名
        proceedingJoinPoint.getArgs();//方法参数
        Object proceed = proceedingJoinPoint.proceed();//放行执行目标方法  这一步必须存在
        System.out.println("目标方法执行之后回到环绕通知");
        return proceed;//返回目标方法返回值
    }
}
