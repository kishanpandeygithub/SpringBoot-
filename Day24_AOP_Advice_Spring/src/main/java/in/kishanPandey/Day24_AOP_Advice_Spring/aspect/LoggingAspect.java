package in.kishanPandey.Day24_AOP_Advice_Spring.aspect;

import in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.sound.midi.Soundbank;
import java.util.concurrent.ForkJoinTask;

@Component
@Aspect
public class LoggingAspect {

    /*
    //point cut address & aspect advice
    @Before("execution(String in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService.createStudent())")
    public void logBeforeMethod(JoinPoint joinPoint){

        Object [] arr =joinPoint.getArgs();
        System.out.println("Studetn is going to be saved");
    }
     */


    /*
    //point cut address & aspect advice
    //we should not modify somethig in the @AfterRetuning it is not the good practice
    @AfterReturning(
            value = "execution(" +
                    "in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student" +
                    " in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService" +
                    ".createStudent(in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student))" ,
            returning = "student")
    public void logAfterReturningMethod(Student student){
        //we can not catch the accesspation in the @AfterReturning it will go to the controller
//        System.out.println("Target method return "+ result);
//
//        student.setAge(21);
//        student.setName("Aditiya");

//        System.out.println("Interepeted studetn is called");
    }
     */

    /*
    //@AfterThrowing
    @AfterThrowing(
            value = "execution(" +
                    "in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student" +
                    " in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService" +
                    ".createStudent(in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student))"  ,
                   throwing = "exception")
    public void logAfterThrowingMethod(Throwable exception){
        System.out.println("Exception Type : " + exception.getClass().getName());
        System.out.println("Exception Type : " + exception.getMessage());
        System.out.println("Log After Throwing method"+ "An Exception Occored");
    }

     */


    /*
    //after method
    @After(
            value = "execution(" +
                    "in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student" +
                    " in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService" +
                    ".createStudent(in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student))"  )
    public void logAfterThrowingMethod(){
        System.out.println("Log After method exicuted");
    }
     */

    /*

    //around method: it will controll the loging which is exicuted after or before the service
    @Around(
            value = "execution(" +
                    "in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student" +
                    " in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService" +
                    ".createStudent(in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student))" )
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Before target method");
        try{
            Object result = joinPoint.proceed();
            System.out.println("Exicution Successfull ");
            return result;
        }catch (Exception e){
            System.out.println(" Exicution Failed");
            throw e;
        }
        finally {

            System.out.println("After target method");
        }
    }

     */

    @Around("execution(* in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] arr = joinPoint.getArgs();

        String originalString =(String) arr[0];
        String modifiedString = originalString.toUpperCase();

        Object[] modifiedArr = {
                modifiedString
        };

        String returnType = (String) joinPoint.proceed(modifiedArr);
        returnType =  returnType+ "String Interepted";
        return  returnType;
    }
}
