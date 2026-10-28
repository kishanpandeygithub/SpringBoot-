package in.kishanPandey.Day30_Hibernate_Internals.service;


import in.kishanPandey.Day30_Hibernate_Internals.model.Student;
import in.kishanPandey.Day30_Hibernate_Internals.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        if(student1==null){
            throw new RuntimeException("Student Not found");
        }
//        studentRepository.detach(student1);
//        student1 = studentRepository.attachAgain(student1);

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

