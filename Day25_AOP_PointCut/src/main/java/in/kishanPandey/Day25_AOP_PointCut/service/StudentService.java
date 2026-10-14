package in.kishanPandey.Day25_AOP_PointCut.service;


import in.kishanPandey.Day25_AOP_PointCut.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Timestamp
    public Student createStudent(Student student) {
        System.out.println("Student Saved");
//        throw new RuntimeException("Some Error Occred");
        return student;
    }


//    @EvaluationTime
    public String getStudent(String s){
        System.out.println(s);
        return  s;
    }

    public int dummyMethod(){
        return  0;
    }
}