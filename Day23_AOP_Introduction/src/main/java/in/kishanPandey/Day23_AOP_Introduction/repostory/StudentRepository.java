package in.kishanPandey.Day23_AOP_Introduction.repostory;

import in.kishanPandey.Day23_AOP_Introduction.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(Student student){
        try {
            Thread.sleep(2000);
        }catch (Exception e){}
        System.out.println("Student is saved to db");
    }
}
