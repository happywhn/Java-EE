package com.itheima.aspectj.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    //前置通知
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知：模拟执行权限检查...");
        System.out.println("目标类是："+joinPoint.getTarget());
        System.out.println(",被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
    }
    public void myAfterReturning(JoinPoint joinPoint) {
        System.out.println("后置通知：模拟记录日志...，");
        System.out.println("被植入增强处理的目标方法我i："+joinPoint.getSignature().getName());
    }
    //环绕通知
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
    public void myAfterThrowing(JoinPoint joinPoint,Throwable e) {
        System.out.println("异常通知："+"出错了"+e.getMessage());
    }
    // 最终通知
    public void myAfter() {
        System.out.println("最终通知：模拟方法结束后的释放资源...");
    }
}
