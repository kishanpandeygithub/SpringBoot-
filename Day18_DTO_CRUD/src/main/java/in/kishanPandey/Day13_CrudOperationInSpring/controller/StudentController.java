package in.kishanPandey.Day13_CrudOperationInSpring.controller;

import in.kishanPandey.Day13_CrudOperationInSpring.dto.CreateStudentRequestDTO;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.CreateStudentResponceDTO;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.UpdateStudentRequestDto;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.UpdateStudentResponceDto;
import in.kishanPandey.Day13_CrudOperationInSpring.entity.Student;
import in.kishanPandey.Day13_CrudOperationInSpring.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create student
    @PostMapping
    public ResponseEntity<CreateStudentResponceDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentRequestDTO){

        CreateStudentResponceDTO createdStudent = studentService.createStudent(studentRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    //read one student
    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponceDTO> getStudent(@PathVariable Long id){
        CreateStudentResponceDTO studentResp = studentService.getStudent(id);
        return ResponseEntity.ok(studentResp);
    }

    //to get all the student
    @GetMapping
    public ResponseEntity<List<CreateStudentResponceDTO>> getAllStudent(){
        List<CreateStudentResponceDTO> studentList = studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }
    //update
    @PutMapping
    public ResponseEntity<UpdateStudentResponceDto> updateStudent(@RequestParam Long id ,@RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentResponceDto studentResp = studentService.updateStudent(id ,studentReq);
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }
    //delete
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    //soft delete
    //soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudetnSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();
    }
}
