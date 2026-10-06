package in.kishanPandey.Day13_CrudOperationInSpring.service;

import in.kishanPandey.Day13_CrudOperationInSpring.dto.CreateStudentRequestDTO;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.CreateStudentResponceDTO;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.UpdateStudentRequestDto;
import in.kishanPandey.Day13_CrudOperationInSpring.dto.UpdateStudentResponceDto;
import in.kishanPandey.Day13_CrudOperationInSpring.entity.Student;
import in.kishanPandey.Day13_CrudOperationInSpring.excption.DuplicateResourseException;
import in.kishanPandey.Day13_CrudOperationInSpring.excption.ResourseNotFoundException;
import in.kishanPandey.Day13_CrudOperationInSpring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public CreateStudentResponceDTO createStudent(CreateStudentRequestDTO studentRequestDto) {
        //bissnuss logic
        Student student = mapToEntity(studentRequestDto);
        if (emailExist(student)) {
            throw new DuplicateResourseException("Student With this email " + student.getEmail() + " Already Exists");
        }
        Student studentResponce = studentRepository.save(student);

        return mapToDTO(studentResponce);
    }

    /*get student
    now in the soft delete it should be the
    seletc * from student where id= 1 and deleted  = false;
    then we can change name of the standard jpa methods and jpa create its implamention internally
    findByIdAndDeleteFalse
    */
    public CreateStudentResponceDTO getStudent(Long id) {
//        costom method
        Student studentResp = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourseNotFoundException("Student with id " + id + " not found"));
        return mapToDTO(studentResp);
    }

    //get all the student
    /*
    select * from student
     */
    public List<CreateStudentResponceDTO> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream()
                .map(this::mapToDTO)
                .toList();
    }

    //update the student

    public UpdateStudentResponceDto updateStudent(Long id, UpdateStudentRequestDto studentReq) {
        Student studentToSave = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourseNotFoundException("Resource with id " + id + " is not Found"));

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapToUpdateDTO(savedStudent);
    }

    //delete the student
    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(()-> new ResourseNotFoundException("Student with id "+ id +" not found"));
        studentRepository.delete(studentToBeDeleted);
    }

    //delete student softly
    public void deleteStudentSoftly(Long id) {

        Student studentToDelete = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(()->new ResourseNotFoundException("Student with id "+ id +" not found"));

        studentToDelete.setDeleted(true);
        studentRepository.save(studentToDelete);
    }

    private Student mapToEntity(CreateStudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setEmail(studentRequestDTO.getEmail());
        student.setRollNo(studentRequestDTO.getRollNo());
        student.setSubject(studentRequestDTO.getSubject());

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        //builder design patter is used here
        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponceDTO mapToDTO(Student student) {
        CreateStudentResponceDTO responceDTO = new CreateStudentResponceDTO();
        responceDTO.setId(student.getId());
        responceDTO.setName(student.getName());
        responceDTO.setAge(student.getAge());
        responceDTO.setEmail(student.getEmail());
        responceDTO.setRollNo(student.getRollNo());
        responceDTO.setSubject(student.getSubject());
        responceDTO.setCreatedAt(student.getCreatedAt());
        responceDTO.setUpdatedAt(student.getUpdatedAt());
        responceDTO.setMessage("Student Saved Successfully");
        return responceDTO;
    }

    private UpdateStudentResponceDto mapToUpdateDTO(Student student) {
        UpdateStudentResponceDto updatedResponce = new UpdateStudentResponceDto();
        updatedResponce.setId(student.getId());
        updatedResponce.setName(student.getName());
        updatedResponce.setAge(student.getAge());
        updatedResponce.setEmail(student.getEmail());
        updatedResponce.setRollNo(student.getRollNo());
        updatedResponce.setSubject(student.getSubject());
        updatedResponce.setUpdatedAt(student.getUpdatedAt());
        updatedResponce.setMessage("Student Updated Successfully");

        return updatedResponce;
    }

    private boolean emailExist(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }
}
