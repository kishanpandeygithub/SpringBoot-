package in.kishanPandey.Day36_SpringSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @GetMapping
    public ResponseEntity<String > getStudent(){
        return ResponseEntity.ok("Student retrived successfully");
    }

    @PostMapping
    public ResponseEntity<String > createStudent(){
        return ResponseEntity.ok("Student created successfully");
    }

    @DeleteMapping
    public ResponseEntity<String > deleteStudent(){
        return ResponseEntity.ok("Student Deleted successfully");
    }

    @PutMapping
    public ResponseEntity<String > updatedStudent(){
        return ResponseEntity.ok("Student updated successfully");
    }

    @GetMapping("/token")
    public CsrfToken getToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
