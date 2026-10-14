package in.kishanPandey.Day24_AOP_Advice_Spring.service;

import in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public Student createStudent(Student student) {
        System.out.println("Student Saved");
//        throw new RuntimeException("Some Error Occred");
        return student;
    }

    public String getStudent(){
        String s ="All student data ;";
        System.out.println(s);
        return  s;
    }
}
