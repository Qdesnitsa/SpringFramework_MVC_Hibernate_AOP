package by.sidina.it_shop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcut {
    @Pointcut("execution(* by.sidina.it_shop.*.*.*.*(..))")
    public void allMethods() {}
}
