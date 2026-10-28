package in.kishanPandey.Day32_JPA_Cascading.service;

import in.kishanPandey.Day32_JPA_Cascading.model.Department;
import in.kishanPandey.Day32_JPA_Cascading.model.Student;
import in.kishanPandey.Day32_JPA_Cascading.repository.DepartmentRepository;
import in.kishanPandey.Day32_JPA_Cascading.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository = studentRepository;
    }

//    @Transactional
//    public void createDepartment(Department department) {
//        Student s1 = new Student();
//        s1.setName("kishan");
//        s1.setDepartement(department);
//
//        Student s2 = new Student();
//        s2.setName("rohit");
//        s2.setDepartement(department);
//
//        Student s3 = new Student();
//        s3.setName("Aditiya");
//        s3.setDepartement(department);
//
//        Student s4 = new Student();
//        s4.setName("Shyam");
//        s4.setDepartement(department);
//        //error
//        System.out.println(department.getName());
//        if(department.getStudents()==null){
//            department.setStudents(new ArrayList<>());
//        }
//        department.getStudents().addAll(List.of(s1, s2, s3, s4));
//        departmentRepository.save(department);
////        studentRepository.save(s1);
////        studentRepository.save(s2);
////        studentRepository.save(s3);
////        studentRepository.save(s4);
//
//    }

    @Transactional
    public void removeDepartment(Long id){
        Department department = departmentRepository.findById(id);
        departmentRepository.remove(department);
    }

}
