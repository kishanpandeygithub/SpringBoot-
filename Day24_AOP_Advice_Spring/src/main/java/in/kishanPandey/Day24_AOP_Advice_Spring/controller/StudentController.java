package in.kishanPandey.Day24_AOP_Advice_Spring.controller;

import in.kishanPandey.Day24_AOP_Advice_Spring.dto.Student;
import in.kishanPandey.Day24_AOP_Advice_Spring.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student responce = studentService.createStudent(student);
        return ResponseEntity.ok(responce);
    }

    @GetMapping
    public ResponseEntity<String> getStudent(){
        return ResponseEntity.ok( studentService.getStudent());
    }
}
