package in.kishanPandey.Day32_JPA_Cascading.controller;

import in.kishanPandey.Day32_JPA_Cascading.model.Department;
import in.kishanPandey.Day32_JPA_Cascading.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
//    @PostMapping
//    public ResponseEntity<String> createDepartment(@RequestBody Department department){
//        departmentService.createDepartment(department);
//        return ResponseEntity.ok("Done");
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.removeDepartment(id);
        return ResponseEntity.ok("Done");
    }

}
