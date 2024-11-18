package dao;

import model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private final Connection connection;

    public TeacherDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new teacher to the database
    public void addTeacher(Teacher teacher) throws SQLException {
        String sql = "INSERT INTO Teachers (TeacherID, firstName, lastName, hireDate, subject, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, teacher.getId());
            stmt.setString(2, teacher.getFirstName());
            stmt.setString(3, teacher.getLastName());
            stmt.setString(4, teacher.getHireDate());
            stmt.setString(5, teacher.getSubject());
            stmt.setString(6, teacher.getEmail());
            stmt.executeUpdate();
        }
    }

    // Remove a teacher by ID
    public void deleteTeacher(int teacherId) throws SQLException {
        String sql = "DELETE FROM Teachers WHERE TeacherID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, teacherId);
            stmt.executeUpdate();
        }
    }

    // Retrieve all teachers from the database
    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM Teachers";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                teachers.add(new Teacher(
                        rs.getInt("TeacherID"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("hireDate"),
                        rs.getString("subject"),
                        rs.getString("email")
                ));
            }
        }
        return teachers;
    }
}