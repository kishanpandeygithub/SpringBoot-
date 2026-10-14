package in.kishanPandey.Day26_AOP_Costom_Annotation.controller;


import in.kishanPandey.Day26_AOP_Costom_Annotation.dto.Student;
import in.kishanPandey.Day26_AOP_Costom_Annotation.service.StudentService;
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

