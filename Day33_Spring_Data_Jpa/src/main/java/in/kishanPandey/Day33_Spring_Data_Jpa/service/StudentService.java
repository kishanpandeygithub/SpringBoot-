package in.kishanPandey.Day33_Spring_Data_Jpa.service;

import in.kishanPandey.Day33_Spring_Data_Jpa.model.Student;
import in.kishanPandey.Day33_Spring_Data_Jpa.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository= studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        Optional<Student> student =  studentRepository.findById(id);
        return student.get();
    }

    public List<Student > fetchAll(String name){

        Sort sort = Sort.by("age");

        Pageable pageable = PageRequest.of(0 , 2);

        Page<Student> studentList = studentRepository.findAll(pageable);

        for(Student s: studentList.getContent()){
            System.out.println(s);
        }
        return studentList.getContent();
    }

    public void updateStudent(Student studentReq , Long id ){
        Optional<Student> studentRes = studentRepository.findById(id);

        Student student = studentRes.get();
        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
        student.setEmail(studentReq.getEmail());

    }
}
