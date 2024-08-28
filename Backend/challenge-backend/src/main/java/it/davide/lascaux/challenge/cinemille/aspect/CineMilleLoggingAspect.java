package it.davide.lascaux.challenge.cinemille.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Log4j2
public class CineMilleLoggingAspect {

    @Before("it.davide.lascaux.challenge.cinemille.aspect.AopExpression.forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        log.info("[START] -> {}", method);
    }

    @AfterReturning(pointcut = "it.davide.lascaux.challenge.cinemille.aspect.AopExpression.forAppFlow()")
    public void afterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        log.info("[END] -> {}", method);
    }

}
