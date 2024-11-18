package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private final Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Students (StudentID, firstName, lastName, DOB, gender, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getLastName());
            stmt.setString(4, student.getDob());
            stmt.setString(5, student.getGender());
            stmt.setString(6, student.getEmail());
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM Students WHERE StudentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("StudentID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("DOB"),
                        rs.getString("gender"),
                        rs.getString("email")
                ));
            }
        }
        return students;
    }
}