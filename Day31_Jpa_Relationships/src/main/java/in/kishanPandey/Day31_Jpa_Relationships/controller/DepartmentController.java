package in.kishanPandey.Day31_Jpa_Relationships.controller;

import in.kishanPandey.Day31_Jpa_Relationships.model.Department;
import in.kishanPandey.Day31_Jpa_Relationships.model.Student;
import in.kishanPandey.Day31_Jpa_Relationships.service.DepartmentService;
import in.kishanPandey.Day31_Jpa_Relationships.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment(
            @RequestBody Department department ,
            @RequestParam String studentName
            ){
        departmentService.createDepartment(department , studentName);
        return  ResponseEntity.ok("Done");
    }

}
