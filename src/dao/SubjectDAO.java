package dao;

import model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {
    private final Connection connection;

    public SubjectDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new subject to the database
    public void addSubject(Subject subject) throws SQLException {
        String sql = "INSERT INTO Subjects (SubjectID, SubjectName, SubjectDescription, TeacherID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subject.getId());
            stmt.setString(2, subject.getName());
            stmt.setString(3, subject.getDescription());
            if (subject.getTeacherId() != null) {
                stmt.setInt(4, subject.getTeacherId());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }
            stmt.executeUpdate();
        }
    }

    // Remove a subject by ID
    public void deleteSubject(int subjectId) throws SQLException {
        String sql = "DELETE FROM Subjects WHERE SubjectID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, subjectId);
            stmt.executeUpdate();
        }
    }

    // Retrieve all subjects from the database
    public List<Subject> getAllSubjects() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM Subjects";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                subjects.add(new Subject(
                        rs.getInt("SubjectID"),
                        rs.getString("SubjectName"),
                        rs.getString("SubjectDescription"),
                        rs.getInt("TeacherID")
                ));
            }
        }
        return subjects;
    }

    // Update a subject's teacher
    public void updateSubjectTeacher(int subjectId, Integer teacherId) throws SQLException {
        String sql = "UPDATE Subjects SET TeacherID = ? WHERE SubjectID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            if (teacherId != null) {
                stmt.setInt(1, teacherId);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setInt(2, subjectId);
            stmt.executeUpdate();
        }
    }
}