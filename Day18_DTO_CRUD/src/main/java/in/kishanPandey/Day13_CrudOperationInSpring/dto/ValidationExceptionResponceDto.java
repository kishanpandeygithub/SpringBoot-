package in.kishanPandey.Day13_CrudOperationInSpring.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponceDto {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String  ,String> fielsErrors;

    public ValidationExceptionResponceDto(LocalDateTime timeStamp, int statusCode, String error, String message, String path, Map<String, String> fielsErrors) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fielsErrors = fielsErrors;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFielsErrors() {
        return fielsErrors;
    }

    public void setFielsErrors(Map<String, String> fielsErrors) {
        this.fielsErrors = fielsErrors;
    }
}
