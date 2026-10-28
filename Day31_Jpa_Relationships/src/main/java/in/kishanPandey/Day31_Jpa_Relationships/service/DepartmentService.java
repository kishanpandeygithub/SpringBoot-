package in.kishanPandey.Day31_Jpa_Relationships.service;

import in.kishanPandey.Day31_Jpa_Relationships.model.Department;
import in.kishanPandey.Day31_Jpa_Relationships.model.Student;
import in.kishanPandey.Day31_Jpa_Relationships.repository.DepartmentRepository;
import in.kishanPandey.Day31_Jpa_Relationships.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(
            Department department
            , String studentName) {
        Student student = new Student();
        student.setName(studentName);
        student.setDepartement(department);
        if (department.getStudents() != null)
            department.getStudents().add(student);
        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
