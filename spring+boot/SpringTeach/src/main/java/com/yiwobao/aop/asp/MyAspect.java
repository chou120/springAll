package com.yiwobao.aop.asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class MyAspect {
    /**
     * 通知方法
     */
    public void writeLog(){
        System.out.println("使用spring的AOP切入日志...");
    }

    /**
     * 前置通知
     * JoinPoint:代表当前拦截的方法对象，使用该对象可以获取拦截方法的信息（例如：类名，方法名，方法参数等）
     */
    public void before(JoinPoint jp){
        System.out.println("执行了前置通知");
        System.out.println("代理对象类型："+jp.getThis().getClass());
        System.out.println("拦截的方法名称："+jp.getSignature().getName());
        System.out.println("拦截方法的参数列表："+ Arrays.asList(jp.getArgs()));
    }



    /**
     * 最终通知
     * JoinPoint:代表当前拦截的方法对象，使用该对象可以获取拦截方法的信息（例如：类名，方法名，方法参数等）
     */
    public void after(JoinPoint jp){
        System.out.println("执行了后置通知");
        System.out.println("代理对象类型："+jp.getThis().getClass());
        System.out.println("拦截的方法名称："+jp.getSignature().getName());
        System.out.println("拦截方法的参数列表："+Arrays.asList(jp.getArgs()));
    }


    /**
     * 后置通知
     * JoinPoint:代表当前拦截的方法对象，使用该对象可以获取拦截方法的信息（例如：类名，方法名，方法参数等）
     */
    public void afterReturning(JoinPoint jp,Object money){
        System.out.println("执行了后置通知");
        System.out.println("代理对象类型："+jp.getThis().getClass());
        System.out.println("拦截的方法名称："+jp.getSignature().getName());
        System.out.println("拦截方法的参数列表："+Arrays.asList(jp.getArgs()));

        System.out.println("苍老师：你的银行号卡多了"+money+"元！");
    }

    /**
     * 异常通知
     * JoinPoint:代表当前拦截的方法对象，使用该对象可以获取拦截方法的信息（例如：类名，方法名，方法参数等）
     * Throwable e： 该变量为目标方法传递过来的异常对象，里面包含异常信息
     */
    public void afterThrowing(JoinPoint jp,Throwable e){
        System.out.println("执行了后置通知");
        System.out.println("代理对象类型："+jp.getThis().getClass());
        System.out.println("拦截的方法名称："+jp.getSignature().getName());
        System.out.println("拦截方法的参数列表："+Arrays.asList(jp.getArgs()));

        System.out.println("邮件通知：系统发生错误，异常信息为："+e.getMessage());
    }

    /**
     * 环绕通知
     * ProceedingJoinPoint:
     */
    public void around(ProceedingJoinPoint pjp){
        System.out.println("开启事务");
        //调用目标对象方法
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("提交事务");
    }




}
