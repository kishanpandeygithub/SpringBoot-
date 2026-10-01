package in.kishanPandey.Day13_CrudOperationInSpring.service;

import in.kishanPandey.Day13_CrudOperationInSpring.entity.Student;
import in.kishanPandey.Day13_CrudOperationInSpring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //create the student
    public Student createStudent(Student studentRequest) {
        //bissnuss logic
        studentRequest.setDeleted(false);
        Student studentResponce = studentRepository.save(studentRequest);
        return studentResponce;
    }

    /*get student
    now in the soft delete it should be the
    seletc * from student where id= 1 and deleted  = false;
    then we can change name of the standard jpa methods and jpa create its implamention internally
    findByIdAndDeleteFalse
    */
    public Student getStudent(Long id) {
//        costom method
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    //get all the student
    /*
    select * from student
     */
    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    //update the student

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentResp.isEmpty()) {
            return null;
        }
        Student studentToSave = studentResp.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setEmail(studentReq.getEmail());

        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);
    }

    //delete the student
    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
        studentRepository.deleteById(id);
        if (studentRepository.existsById(id)) {
            return false;
        }
        return true;
    }

    //delete student softly
    public Boolean deleteStudentSoftly(Long id) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent) {
            return false;
        }
        Optional<Student> studentToDelete = studentRepository.findByIdAndDeletedIsFalse(id);
        if (studentToDelete.isEmpty()) {
            return false;
        }
        Student deletedStudent = studentToDelete.get();
        deletedStudent.setDeleted(true);
        studentRepository.save(deletedStudent);
        return true;
    }
}
