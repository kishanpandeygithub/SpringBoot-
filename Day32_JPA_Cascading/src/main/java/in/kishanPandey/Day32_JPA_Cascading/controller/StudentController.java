package in.kishanPandey.Day32_JPA_Cascading.controller;

import in.kishanPandey.Day32_JPA_Cascading.model.Student;
import in.kishanPandey.Day32_JPA_Cascading.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.rmi.RMIServerImpl_Stub;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> createStudent(
            @PathVariable Long id) {
        Student student = studentService.fetchStudentById( id);
        return ResponseEntity.ok(student);
    }
}
