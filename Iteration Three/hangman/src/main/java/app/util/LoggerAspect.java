package app.util;

import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {
  private Logger logger = Logger.getLogger(getClass().getName());

  @Pointcut("execution(* app.web.*.*(..))")
  public void log() {}

  @Before("log()")
  public void before(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().toShortString();
    logger.info("------------This method: " + name);
  }
}
