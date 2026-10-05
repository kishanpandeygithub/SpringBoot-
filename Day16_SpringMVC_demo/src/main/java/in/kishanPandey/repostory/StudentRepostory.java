package in.kishanPandey.repostory;

import in.kishanPandey.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class StudentRepostory {
    private Map<Long, Student> studentDB;

    public StudentRepostory() {
        studentDB = new HashMap<>();
    }

    public Student save(Student studentReq) {
        studentDB.put(studentReq.getId(), studentReq);
        return studentReq;
    }

    public Student findById(Long id) {
        return studentDB.get(id);
    }

    public List<Student> findAll() {
        return new  ArrayList<>(studentDB.values());
    }
}
