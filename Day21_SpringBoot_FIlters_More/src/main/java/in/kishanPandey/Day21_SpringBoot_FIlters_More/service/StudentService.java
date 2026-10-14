package in.kishanPandey.Day21_SpringBoot_FIlters_More.service;

import in.kishanPandey.Day21_SpringBoot_FIlters_More.dto.Student;
import in.kishanPandey.Day21_SpringBoot_FIlters_More.dto.StudentResponceDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponceDto createStudent(Student student) {

        StudentResponceDto responceDto = new StudentResponceDto();

        responceDto.setName(student.getName());
        responceDto.setMessage("Student is saved Successfully");
        return responceDto;
    }

}