package in.kishanPandey.Day13_CrudOperationInSpring.dto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDTO {
    @NotBlank(message = "Name can not be the null/empty")
    @Size(min = 2  ,max = 50  ,message = "Student name must be 2 to 50 char long")
    private String name;
    @NotNull(message = "Age is required")
    @Min(value = 18 , message = "age must be greater the 18")
    private int age;
    @NotNull(message = "Email should not be null")
    @Email(message = "student email must be valid")
    private String email;

    @NotNull(message = "Roll no is required")
    private int rollNo;

    @NotBlank(message = "Subject is required")
    private String  subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
