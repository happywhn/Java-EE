package com.itheima.aspectj.annotation;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类，在此类中编写通知
 */
@Aspect
@Component
public class MyAspect {
    // 定义切入点表达式
    @Pointcut("execution(* com.itheima.jdk.*.*(..))")
    // 使用一个返回值为void、方法体为空的方法来命名切入点
    private void myPointCut(){}
    //前置通知
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知：模拟执行权限检查...");
        System.out.println("目标类是："+joinPoint.getTarget());
        System.out.println(",被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    // 后置通知
    @AfterReturning(value = "myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.println("后置通知：模拟记录日志...，");
        System.out.println("被植入增强处理的目标方法我i："+joinPoint.getSignature().getName());
    }
    //环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint processingJoinPoint) throws Throwable {
        // 开始
        System.out.println("环绕开始；执行目标方法之前，模拟开启事务...");
        // 执行当前目标方法
        Object obj = processingJoinPoint.proceed();
        //结束
        System.out.println("环绕结束，执行目标方法之后，模拟不安比事务...");
        return obj;
    }
    // 异常通知
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
        System.out.println("异常通知："+"出错了"+e.getMessage());
    }
    // 最终通知
    @After("myPointCut()")
    public void myAfter() {
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }
}
