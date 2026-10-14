package in.kishanPandey.Day23_AOP_Introduction.service;

import in.kishanPandey.Day23_AOP_Introduction.dto.Student;
import in.kishanPandey.Day23_AOP_Introduction.repostory.StudentRepository;
import org.springframework.stereotype.Component;

@Component

public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){


        studentRepository.save(student);


    }
}
