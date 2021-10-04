package hello.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP로 사용하기 위한 annotation
@Component  // 이렇게 해도 되고, SpringConfig에 직접 설정 등록해도 됨.
public class TimeTraceAop {

    @Around("execution(* hola.springbasic..*(..))") // 공통 관심사 적용을 위한 targeting
    public Object excecute(ProceedingJoinPoint joinPoint) throws  Throwable {
        long start = System.currentTimeMillis();
        System.out.println("STRAT: " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}