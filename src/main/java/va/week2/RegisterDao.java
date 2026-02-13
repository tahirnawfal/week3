package va.week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/cpan368";
    private String jdbcUsername = "cpan368_nawfalahmad";
    private String jdbcPassword = "root"; 

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public int registerStudent(Registration student) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO student" +
            " (student_id, first_name, last_name, username, password, mobile_number, email, postal_code) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            
            preparedStatement.setString(1, student.getStudentId());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getUsername());
            preparedStatement.setString(5, student.getPassword());
            preparedStatement.setString(6, student.getMobileNumber());
            preparedStatement.setString(7, student.getEmail());
            preparedStatement.setString(8, student.getPostalCode());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}