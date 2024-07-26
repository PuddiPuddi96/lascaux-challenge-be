package it.davide.course.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    //Match only addAccount() method in AccountDao class
    //@Before("execution(public void it.davide.course.aop.dao.AccountDao.addAccount())")

    //Match on method names using wildcards
    //Match methods starting with add in any class
    //@Before("execution(public void add*())")

    //Match methods in any class starting with add and that have Account param
    //@Before("execution(* add*(it.davide.course.aop.model.Account))")

    //Match methods with Acocunt param and more param types (add .. -> any number of arguments)
    //@Before("execution(* add*(it.davide.course.aop.model.Account, ..))")

    //Match methods with any parameters
    //Always narrow the pointcut expression to our package
    //@Before("execution(* it.davide.course.aop..add*(..))")

    //Match methods in a package
    //First wildcard means any class, second one means any method
    //@Before("execution(* it.davide.course.aop.dao.*.*(..))")

    //Use wildcards on return type
    //@Before("execution(public * add*())")

    //Remember: modifier (ex. public) is optional
    //@Before("execution(* add*())")

    //Match any addAccount() method in any class (same signature)
    //@Before("execution(public void addAccount())")

    @Pointcut("execution(* it.davide.course.aop.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* it.davide.course.aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* it.davide.course.aop.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackage()")
    public void beforeAddAccount() {
        System.out.println("\n====> @Before advice on method");
    }

    //Combine pointcut to match methods in DAO package and exclude getter/setter methods
    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n====> Performing api analytics");
    }
}
