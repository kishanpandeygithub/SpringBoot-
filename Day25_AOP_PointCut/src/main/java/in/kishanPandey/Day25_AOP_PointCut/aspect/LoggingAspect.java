package in.kishanPandey.Day25_AOP_PointCut.aspect;

import in.kishanPandey.Day25_AOP_PointCut.dto.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("@args(jdk.jfr.Timestamp)"+
    "&&"+ "within(in.kishanPandey.Day25_AOP_PointCut.service..*)")
    public void LogBeforeMethod() {
        System.out.println("Method Intercepted");
    }


//    @Before("args(in.kishanPandey.Day25_AOP_PointCut.dto.Student)" +
//            "&&" +
//            "within(in.kishanPandey.Day25_AOP_PointCut.service..*)")
//    public void LogBeforeMethod() {
//        System.out.println("Method Intercepted");
//    }


//    @Before("@within(org.springframework.stereotype.Service)")
//    public void LogBeforeMethod() {
//        System.out.println("Method Intercepted");
//    }


//
//    //    multiple services aspact
//    @Pointcut("within(in.kishanPandey.Day25_AOP_PointCut.service..*) " +
//            "&&" +
//            "execution(public * * (..))")
//    public void logPublicServiceMethod(){
//
//    }
//    @Before("logPublicServiceMethod()")
//    public void LogBeforeMethod() {
//        System.out.println("Method Intercepted");
//    }


//    @Before("within(in.kishanPandey.Day25_AOP_PointCut.service..*) " +
//    "&&" +
//    "execution(public * * (..))")
//    public void LogBeforeMethod() {
//        System.out.println("Method Intercepted");
//    }

//    @Before("bean(studentService) ")
//    public void LogBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void LogBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Around("@annotation(jdk.jfr.Timestamp)")
//    public void evaluateTimeMethod(ProceedingJoinPoint joinPoint){
//        long startTime = System.currentTimeMillis();
//        joinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
//    }


//    //point cut : * represent any of the things
//    @Before("within(in.kishanPandey.Day25_AOP_PointCut.service.*)")
//    public void LogBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    //point cut : * represent any of the things
//    @Before("execution(* in.kishanPandey.Day25_AOP_PointCut.service.StudentService.*(..))")
//    public void LogBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }


//    point cut
//    @Before("execution(in.kishanPandey.Day25_AOP_PointCut.dto.Student" +
//            " in.kishanPandey.Day25_AOP_PointCut.service.StudentService" +
//            ".createStudent(in.kishanPandey.Day25_AOP_PointCut.dto.Student))")
//    public void LogBeforeMethod2(){
//        System.out.println("Creation Method Intersepted");
//    }
}
