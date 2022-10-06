package by.sidina.it_shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Component
@Aspect
public class LoggingAspect {
    public final Logger logger = LogManager.getLogger();

    @AfterThrowing(pointcut = "by.sidina.it_shop.aspect.MyPointcut.allMethods()", throwing = "exception")
    public void afterThrowingAnyExceptionLoggingAdvice(JoinPoint joinPoint, Throwable exception) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.error("afterThrowingAnyExceptionLoggingAdvice: " + exception.getMessage() + "MethodName: " + methodSignature.getMethod());
    }
}
