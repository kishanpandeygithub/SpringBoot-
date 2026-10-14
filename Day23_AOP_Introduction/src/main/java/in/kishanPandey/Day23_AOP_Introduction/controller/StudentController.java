package in.kishanPandey.Day23_AOP_Introduction.controller;

import in.kishanPandey.Day23_AOP_Introduction.dto.Student;
import in.kishanPandey.Day23_AOP_Introduction.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService ;

    public StudentController(StudentService studentService){
        this.studentService =studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }
}
