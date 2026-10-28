package in.kishanPandey.Day31_Jpa_Relationships.service;

import in.kishanPandey.Day31_Jpa_Relationships.model.Department;
import in.kishanPandey.Day31_Jpa_Relationships.model.Student;
import in.kishanPandey.Day31_Jpa_Relationships.repository.DepartmentRepository;
import in.kishanPandey.Day31_Jpa_Relationships.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository ,
                          DepartmentRepository departmentRepository) {
        this.departmentRepository =departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student , Long dept_id){
        Department department = departmentRepository.getDepartmentById(dept_id);
        student.setDepartement(department);
        department.getStudents().add(student);
        studentRepository.save(student );
    }
    @Transactional
    public void createStudent(Student student  ,String dept_name){
        Department department = new Department();
        department.setName(dept_name);
        department.getStudents().add(student);
        student.setDepartement(department);

        departmentRepository.save(department);
        studentRepository.save(student);
    }
}
