package in.kishanPandey.Day23_AOP_Introduction.service;

public class LoggindServiceUtil {

    public static void logStart(String className , String methodName){
        System.out.println("Exicuting -> " + className + " : " + methodName);
    }
    public static void logEnd(String className , String methodName){
        System.out.println("Finishing -> " + className + " : " + methodName);
    }
}
