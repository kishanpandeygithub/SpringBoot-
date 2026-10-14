package in.kishanPandey.Day23_AOP_Introduction.service;

import in.kishanPandey.Day23_AOP_Introduction.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExicutionTimeService implements StudentService {
    private LoggingDecorator loggingDecorator;

    public ExicutionTimeService(LoggingDecorator loggingDecorator) {
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student) {
        long startTime = System.currentTimeMillis();
        loggingDecorator.createStudent(student);
        long endTime = System.currentTimeMillis();
        System.out.println("Exicition time is : "+ (endTime-startTime));
    }
}
