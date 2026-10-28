package in.kishanPandey.repository;

import in.kishanPandey.model.Student;

import java.sql.*;

public class StudentRepository {
    String url = "jdbc:mysql://localhost:3306/student_db";
    String userName = "root";
    String password = "Kishan@123";

    //creating the user
    public void createStudent(Student student) {
        String sql = """
                        INSERT INTO students(name ,email , age) 
                        VALUES(? ,? ,?) 
                """;
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
//            Statement statement = connection.createStatement();
//            String sql = "Insert INTO students(name , email , age)" +
//                    " VALUES " +
//                    "('Kishan' ,'kishan@gmail.com' , 28)";
//            int result = statement.executeUpdate(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffacted = preparedStatement.executeUpdate();
            if (rowAffacted == 1) {
                System.out.println("Created Student successful");
            } else {
                System.out.println("Ctearion student faild");
            }
        } catch (SQLException e) {
            System.out.println("Data base connection faild");
            e.printStackTrace();
        }

    }

    //update user
    public void updatStudent(Student student , long id) {
        String sql = """
                UPDATE students 
                SET name = ?  , email = ?  , age =? 
                WHERE id = ?
                """;
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, id);

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
                System.out.println("Updation operation Successful");
            } else {
                System.out.println("Updation Failed");
            }
        } catch (SQLException e) {
            System.out.println("Data base connection faild");
            e.printStackTrace();
        }

    }

    //delete user
    public void deleteStudent(Long id) {
        String sql = """
                DELETE from students WHERE id =?
                """;

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                System.out.println("Deletion operation Successful");
            } else {
                System.out.println("Deletion Failed");
            }
        } catch (SQLException e) {
            System.out.println("Data base connection faild");
            e.printStackTrace();
        }
    }

    //get user by id
    public void getStudentById(Long id) {
        String sql = "SELECT id ,name , email , age " +
                " FROM students WHERE id = ? ";
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Student student = mapRow(resultSet);
                    System.out.println(student.toString());
                }
            }

        } catch (SQLException e) {
            System.out.println("Data base connection faild");
            e.printStackTrace();
        }
    }

    //get user by id
    public void getStudent() {
        String sql = """
                SELECT id ,name , email , age FROM students
                """ ;
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            try (
                    ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Student student = mapRow(resultSet);
                    System.out.println(student.toString());
                }
            }

        } catch (SQLException e) {
            System.out.println("Data base connection faild");
            e.printStackTrace();
        }
    }

    //complete crud operation in through exicute method
    public void completeCrud() {
        try {
            Connection connection = DriverManager.getConnection(url, userName, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT id , name , email , age " +
                    "FROM student WHERE id=2";

            boolean result = statement.execute(sql);
            //if true then result type is ResultSet(read operation)
            //if false then result type is integer(row affacted)

            if (result) {
                ResultSet resultSet = statement.getResultSet();
            } else {
                int rowAffacted = statement.getUpdateCount();
            }

            System.out.println("Successful");
        } catch (SQLException e) {
            System.out.println("Database connection Faild");
            e.printStackTrace();
        }

    }



    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("email"));
        student.setEmail(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
