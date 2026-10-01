package in.kishanPandey.Day13_CrudOperationInSpring.controller;

import in.kishanPandey.Day13_CrudOperationInSpring.entity.Student;
import in.kishanPandey.Day13_CrudOperationInSpring.service.StudentService;
import org.hibernate.annotations.SoftDelete;
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
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
    //read one student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp = studentService.getStudent(id);
        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    //to get all the student
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        if(studentList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }
    //update
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id ,@RequestBody Student student){
        Student studentResp = studentService.updateStudent(id ,student);
        if(studentResp==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }
    //delete
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted =  studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("Record Deleted");
    }

    //soft delete
    //soft delete
    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudetnSoftly(@RequestParam Long id){
        Boolean isDeleted =studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record deleted");
    }
}
