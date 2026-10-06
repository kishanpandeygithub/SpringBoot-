package in.kishanPandey.Day13_CrudOperationInSpring.excption;

import in.kishanPandey.Day13_CrudOperationInSpring.dto.ExceptionResponceDto;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.ValidationExceptionResponceDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponceDto> handeMethodArgumentNotValidException(
            MethodArgumentNotValidException ex ,HttpServletRequest request){
        Map<String  ,String> fieldErrors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error->{
                    fieldErrors.put(error.getField() , error.getDefaultMessage());
                });
        ValidationExceptionResponceDto validationResponce = new ValidationExceptionResponceDto(
                LocalDateTime.now() ,
                HttpStatus.BAD_REQUEST.value()  ,
                HttpStatus.BAD_REQUEST.getReasonPhrase() ,
                "Validation Error" ,
                request.getRequestURI() ,
                fieldErrors
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationResponce);
    }

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ExceptionResponceDto> handleResourseNotFoundException(ResourseNotFoundException ex , HttpServletRequest request){

        ExceptionResponceDto exceptionResponce = new ExceptionResponceDto(
                LocalDateTime.now() ,
                HttpStatus.NOT_FOUND.value()  ,
                HttpStatus.NOT_FOUND.getReasonPhrase() ,
                ex.getMessage() ,
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponce);
    }

    @ExceptionHandler(DuplicateResourseException.class)
    public ResponseEntity<ExceptionResponceDto> handleDuplicateResourceException(DuplicateResourseException ex ,
                                                                                 HttpServletRequest request){

        ExceptionResponceDto exceptionResponce = new ExceptionResponceDto(
                LocalDateTime.now() ,
                HttpStatus.CONFLICT.value()  ,
                HttpStatus.CONFLICT.getReasonPhrase() ,
                ex.getMessage() ,
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponce);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponceDto> handleRuntimeException(RuntimeException ex , HttpServletRequest request){

        ExceptionResponceDto exceptionResponce = new ExceptionResponceDto(
                LocalDateTime.now() ,
                HttpStatus.INTERNAL_SERVER_ERROR.value()  ,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() ,
                ex.getMessage() ,
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponce);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponceDto> handleGenericException(Exception ex , HttpServletRequest request){
        ExceptionResponceDto exceptionResponce = new ExceptionResponceDto(
                LocalDateTime.now() ,
                HttpStatus.INTERNAL_SERVER_ERROR.value()  ,
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() ,
                ex.getMessage() ,
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponce);
    }
}
