package in.kishanPandey.controller;

import in.kishanPandey.entity.Student;
import in.kishanPandey.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createstudent(@RequestBody Student studentReq){
        Student studentResp = studentService.CreateStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student > getStudent(@PathVariable("id") Long id){
        Student student = studentService.getStudent(id);
        if (student==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<Student> > getAllStudent(){
        List<Student> student = studentService.getAllStudent();
        return ResponseEntity.ok(student);
    }
}
