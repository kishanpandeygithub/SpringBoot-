package in.KishanPandey.Day20_SpringBoot_Filters.service;

import in.KishanPandey.Day20_SpringBoot_Filters.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student) {
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

//        try {
//            Thread.sleep(2000);
//        } catch (Exception e) {
//        }

    }

}
