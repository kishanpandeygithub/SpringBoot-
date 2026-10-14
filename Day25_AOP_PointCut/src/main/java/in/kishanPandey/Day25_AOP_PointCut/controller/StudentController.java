package in.kishanPandey.Day25_AOP_PointCut.controller;

import in.kishanPandey.Day25_AOP_PointCut.dto.Student;
import in.kishanPandey.Day25_AOP_PointCut.service.StudentService;
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
        String s ="All Student Data";
        return ResponseEntity.ok( studentService.getStudent(s));
    }
}
