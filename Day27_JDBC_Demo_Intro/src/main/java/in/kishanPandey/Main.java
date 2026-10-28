package in.kishanPandey;

import com.mysql.cj.MysqlConnection;
import in.kishanPandey.model.Student;
import in.kishanPandey.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent(new Student("jay" , "raju@gmail.com" , 21));
//        studentRepository.updatStudent(new Student("shaya" , "shyam@gmail.com" , 21) , 2L);
//        studentRepository.deleteStudent(2L);
//        studentRepository.getStudentById(3L);
        studentRepository.getStudent();
    }
}