package in.kishanPandey.Day29_Hibernate.service;

import in.kishanPandey.Day29_Hibernate.model.Student;
import in.kishanPandey.Day29_Hibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student student ,Long id) {
        Student student1 = studentRepository.findById(id);

        student1.setAge(student.getAge());
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());

    }

    @Transactional
    public void deleteStudent(Long id) {
        Student student1 = studentRepository.findById(id);
        if(student1==null){
            throw new RuntimeException("Student not found");
        }
        studentRepository.remove(student1);
    }
}

