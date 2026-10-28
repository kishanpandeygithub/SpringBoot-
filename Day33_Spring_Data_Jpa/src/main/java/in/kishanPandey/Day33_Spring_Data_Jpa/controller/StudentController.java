package in.kishanPandey.Day33_Spring_Data_Jpa.controller;

import in.kishanPandey.Day33_Spring_Data_Jpa.model.Student;
import in.kishanPandey.Day33_Spring_Data_Jpa.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student
    ){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(
            @PathVariable Long id
    ){
        Student student = studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudent(
            @PathVariable String  name
    ){
        List<Student> student = studentService.fetchAll(name);
        return ResponseEntity.ok(student);
    }

}
