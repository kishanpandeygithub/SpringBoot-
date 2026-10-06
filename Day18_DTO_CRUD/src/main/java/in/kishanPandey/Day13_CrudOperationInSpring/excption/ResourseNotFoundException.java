package in.kishanPandey.Day13_CrudOperationInSpring.excption;

public class ResourseNotFoundException extends RuntimeException{
    public ResourseNotFoundException(String message){
        super(message);
    }
}
