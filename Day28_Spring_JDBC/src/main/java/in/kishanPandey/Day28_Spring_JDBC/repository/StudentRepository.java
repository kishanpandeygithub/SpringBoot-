package in.kishanPandey.Day28_Spring_JDBC.repository;


import in.kishanPandey.Day28_Spring_JDBC.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
@Repository
public class StudentRepository {

//    private StudentRowMapper studentRowMapper = new StudentRowMapper();
    private RowMapper<Student> studentRowMapper =new BeanPropertyRowMapper<>(Student.class);
    private JdbcTemplate jdbcTemplate;
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createStudent(Student student) {
        String sql = """
                INSERT INTO students(name, email, age)
                VALUES(?, ?, ?)
                """;
        int rowAffected = jdbcTemplate.update(sql
                ,student.getName() , student.getEmail() , student.getAge());

        if (rowAffected == 1) {
            System.out.println("Create Student successful");
        } else {
            System.out.println("Create Student failed");
        }
    }

    public void updateStudent(Student student, Long id) {
        String sql = """
                UPDATE students
                SET name = ?,
                    email = ?,
                    age = ?
                WHERE id = ?
                """;
        int rowAffected = jdbcTemplate.update(sql
                ,student.getName() , student.getEmail() , student.getAge() ,id );
        if (rowAffected == 1) {
            System.out.println("Update operation successful");
        } else {
            System.out.println("Updation failed");
        }

    }

    public void deleteStudent(Long id) {
        String sql = """
                    DELETE from students WHERE id = ?
                """;
        int rowAffected = jdbcTemplate.update(sql , id);

        if (rowAffected == 1) {
            System.out.println("Delete operation successful");
        } else {
            System.out.println("Deletion failed");
        }

    }

    public Student getStudentById(Long id) {

        String sql = """
                SELECT id, name, email, age FROM students
                WHERE id = ?
                """;
        Student student = jdbcTemplate.queryForObject(sql , studentRowMapper , id);
        return student;
    }

    public List<Student> getStudent() {
        List<Student> studentList = new ArrayList<>();
        String sql = """
                SELECT id, name, email, age FROM students
                """;
        List<Student> students = jdbcTemplate.query(sql ,
                studentRowMapper);
        return students;
    }


}
