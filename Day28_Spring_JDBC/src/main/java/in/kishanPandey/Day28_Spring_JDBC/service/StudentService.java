package in.kishanPandey.Day28_Spring_JDBC.service;

import in.kishanPandey.Day28_Spring_JDBC.model.Student;
import in.kishanPandey.Day28_Spring_JDBC.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.awt.*;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudent();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentRepository.updateStudent(student, student.getId());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}

