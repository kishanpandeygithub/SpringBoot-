package in.kishanPandey.Day13_CrudOperationInSpring.excption;

public class DuplicateResourseException extends RuntimeException{
    public DuplicateResourseException(String message){
        super(message);
    }
}
