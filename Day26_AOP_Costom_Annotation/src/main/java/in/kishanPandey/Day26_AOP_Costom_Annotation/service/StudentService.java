package in.kishanPandey.Day26_AOP_Costom_Annotation.service;


import in.kishanPandey.Day26_AOP_Costom_Annotation.annotation.TrackExicutionTime;
import in.kishanPandey.Day26_AOP_Costom_Annotation.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @TrackExicutionTime
    public Student createStudent(Student student) {
        System.out.println("Student Saved");
//        throw new RuntimeException("Some Error Occred");
        return student;
    }

    @TrackExicutionTime(
            warnAfter =1500 ,
            operation = "Get student data"
    )
    public String getStudent(String s){
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println(s);
        return  s;
    }

    public int dummyMethod(){
        return  0;
    }
}
