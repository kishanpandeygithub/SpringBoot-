package in.kishanPandey.Day32_JPA_Cascading.service;

import in.kishanPandey.Day32_JPA_Cascading.model.Department;
import in.kishanPandey.Day32_JPA_Cascading.model.Profile;
import in.kishanPandey.Day32_JPA_Cascading.model.Student;
import in.kishanPandey.Day32_JPA_Cascading.repository.DepartmentRepository;
import in.kishanPandey.Day32_JPA_Cascading.repository.ProfileRepository;
import in.kishanPandey.Day32_JPA_Cascading.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private DepartmentRepository departmentRepository;
    private ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository ,
                          DepartmentRepository departmentRepository ,
                          ProfileRepository profileRepository) {
        this.departmentRepository =departmentRepository;
        this.studentRepository = studentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student){
        Department department = new Department();
        department.setName("CSE");
        Profile profile = new Profile();
        profile.setBio("Simple bio");

        student.setDepartement(department);
        student.setProfile(profile);

        profileRepository.save(profile);
        studentRepository.save(student);
        departmentRepository.save(department);
    }
    @Transactional
    public Student fetchStudentById(Long id){
        Student student = studentRepository.findById(id);
        System.out.println("Lazely fetched student");
        Department d1 = student.getDepartement();
        System.out.println("Lazely fetched department");
        Profile profile = student.getProfile();
        System.out.println("Lazely fetched profile");
        return student;
    }

}
