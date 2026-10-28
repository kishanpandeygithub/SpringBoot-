package in.kishanPandey.Day31_Jpa_Relationships.controller;

import in.kishanPandey.Day31_Jpa_Relationships.model.Student;
import in.kishanPandey.Day31_Jpa_Relationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            , @RequestParam Long dept_id) {
        studentService.createStudent(student , dept_id);
        return ResponseEntity.ok("Done");
    }
    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student ,@RequestParam String dept_name
    ) {
        studentService.createStudent(student , dept_name );
        return ResponseEntity.ok("Done");
    }
}
