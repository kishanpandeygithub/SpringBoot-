package in.kishanPandey.Day26_AOP_Costom_Annotation.aspect;

import in.kishanPandey.Day26_AOP_Costom_Annotation.annotation.TrackExicutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforMethod(){
//        System.out.println("Method intercepted");
//    }

    @Around("@annotation(trackExicutionTime)")
    public Object mesaureExicutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExicutionTime trackExicutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            String operation = trackExicutionTime.operation();

            if (operation.isBlank()) {
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExicutionTime.warnAfter();
            if (duration > warningThreshold) {
                System.out.println("Slow Operatio Alert");
                System.out.println("Time taken by method name :" +
                        " " + operation + " , duration :" + duration);
            } else
                System.out.println("Time taken by method name : " + operation + " , duration :" + duration);
        }
    }
}
