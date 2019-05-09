package top.piao888.spring_transaction.service.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AOP.java
 * @Description TODO
 * @createTime 2019年03月22日 16:57:00
 */
@Aspect
@Component
public class AOPforAS5 {
    @Autowired
    private TransactionTemplate transactionTemplate5;
    @Pointcut("execution(public * top.piao888.spring_transaction.service.impl.AccountServiceimpl5.*(..))")  //设置切点
    public void pointcut(){//切点 方法名
    }
    @Around("pointcut()")   //声明 环绕式 并 通过切点方法名引用方法
    public void transaction(final ProceedingJoinPoint proceedingJoinPoint){  //环绕式AOP需要有 ProceedingJoinPoint  代表 织入的方法
        transactionTemplate5.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    proceedingJoinPoint.proceed();  //执行方法
                }catch(Throwable e){
                    throw new RuntimeException();
                }
            }
        });
    }
    /*@Before("execution(public * top.piao888.spring_transaction.service.impl.AccountServiceimpl5.*(..))()")
    public void transaction(){
        System.out.println("123");
    }*/

    public TransactionTemplate getTransactionTemplate5() {
        return transactionTemplate5;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate5) {
        this.transactionTemplate5 = transactionTemplate5;
    }
}
