package service;

import dao.SubjectDAO;
import model.Subject;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class SubjectService {
    private final SubjectDAO subjectDAO;

    public SubjectService(Connection connection) {
        this.subjectDAO = new SubjectDAO(connection);
    }

    public void addNewSubject(Scanner scanner) {
        System.out.println("Enter Subject Details:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Teacher ID (optional, leave blank for none): ");
        String teacherIdInput = scanner.nextLine();
        Integer teacherId = teacherIdInput.isEmpty() ? null : Integer.parseInt(teacherIdInput);

        Subject subject = new Subject(id, name, description, teacherId);
        try {
            subjectDAO.addSubject(subject);
            System.out.println("Subject added successfully.");
        } catch (Exception e) {
            System.out.println("Error while adding subject.");
            e.printStackTrace();
        }
    }

    public void listAllSubjects() {
        try {
            List<Subject> subjects = subjectDAO.getAllSubjects();
            if (subjects.isEmpty()) {
                System.out.println("No subjects found.");
            } else {
                System.out.printf("%-10s %-20s %-50s %-10s\n", "SubjectID", "Name", "Description", "TeacherID");
                subjects.forEach(subject -> System.out.printf("%-10d %-20s %-50s %-10s\n",
                        subject.getId(), subject.getName(), subject.getDescription(),
                        subject.getTeacherId() == null ? "None" : subject.getTeacherId()));
            }
        } catch (Exception e) {
            System.out.println("Error while listing subjects.");
            e.printStackTrace();
        }
    }

    public void updateSubjectTeacher(Scanner scanner) {
        System.out.print("Enter Subject ID: ");
        int subjectId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Teacher ID to assign (or leave blank to remove teacher): ");
        String teacherIdInput = scanner.nextLine();
        Integer teacherId = teacherIdInput.isEmpty() ? null : Integer.parseInt(teacherIdInput);

        try {
            subjectDAO.updateSubjectTeacher(subjectId, teacherId);
            System.out.println("Subject updated successfully.");
        } catch (Exception e) {
            System.out.println("Error while updating subject.");
            e.printStackTrace();
        }
    }

    public void removeSubject(Scanner scanner) {
        System.out.print("Enter Subject ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            subjectDAO.deleteSubject(id);
            System.out.println("Subject removed successfully.");
        } catch (Exception e) {
            System.out.println("Error while removing subject.");
            e.printStackTrace();
        }
    }
}