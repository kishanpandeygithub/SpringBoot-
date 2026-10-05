package in.kishanPandey.service;

import in.kishanPandey.entity.Student;
import in.kishanPandey.repostory.StudentRepostory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepostory studentRepostory;
    public StudentService(StudentRepostory studentRepostory) {
        this.studentRepostory = studentRepostory;
    }


    public Student CreateStudent(Student studentReq) {
        return studentRepostory.save(studentReq);
    }
    public Student getStudent(Long id){
        return studentRepostory.findById(id);
    }
    public List<Student> getAllStudent(){
        return studentRepostory.findAll();
    }
}
