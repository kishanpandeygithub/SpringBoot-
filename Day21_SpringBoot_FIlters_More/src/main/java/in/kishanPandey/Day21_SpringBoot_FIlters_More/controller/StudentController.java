package in.kishanPandey.Day21_SpringBoot_FIlters_More.controller;


import in.kishanPandey.Day21_SpringBoot_FIlters_More.dto.Student;
import in.kishanPandey.Day21_SpringBoot_FIlters_More.dto.StudentResponceDto;
import in.kishanPandey.Day21_SpringBoot_FIlters_More.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController (StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentResponceDto> createStudent(@RequestBody Student student){
        StudentResponceDto responceDto = studentService.createStudent(student);
        return ResponseEntity.ok(responceDto);
    }

}

