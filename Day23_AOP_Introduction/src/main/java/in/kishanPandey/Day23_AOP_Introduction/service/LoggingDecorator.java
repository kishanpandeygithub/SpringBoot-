package in.kishanPandey.Day23_AOP_Introduction.service;

import in.kishanPandey.Day23_AOP_Introduction.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService{
    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
        //logging realted logic
        LoggindServiceUtil.logStart
                ("StudentService" , "createStudent");
        studentServiceImpl.createStudent(student);
        LoggindServiceUtil.logEnd
                ("StudentService" , "createStudent");


    }
}
