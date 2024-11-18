package service;

import dao.TeacherDAO;
import model.Teacher;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    private final TeacherDAO teacherDAO;

    public TeacherService(Connection connection) {
        this.teacherDAO = new TeacherDAO(connection);
    }

    public void addNewTeacher(Scanner scanner) {
        System.out.println("Enter Teacher Details:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Hire Date (YYYY-MM-DD): ");
        String hireDate = scanner.nextLine();
        System.out.print("Subject: ");
        String subject = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Teacher teacher = new Teacher(id, firstName, lastName, hireDate, subject, email);
        try {
            teacherDAO.addTeacher(teacher);
            System.out.println("Teacher added successfully.");
        } catch (Exception e) {
            System.out.println("Error while adding teacher.");
            e.printStackTrace();
        }
    }

    public void listAllTeachers() {
        try {
            List<Teacher> teachers = teacherDAO.getAllTeachers();
            if (teachers.isEmpty()) {
                System.out.println("No teachers found.");
            } else {
                System.out.printf("%-10s %-15s %-15s %-15s %-20s %-30s\n", "TeacherID", "First Name", "Last Name", "Hire Date", "Subject", "Email");
                teachers.forEach(teacher -> System.out.printf("%-10d %-15s %-15s %-15s %-20s %-30s\n",
                        teacher.getId(), teacher.getFirstName(), teacher.getLastName(),
                        teacher.getHireDate(), teacher.getSubject(), teacher.getEmail()));
            }
        } catch (Exception e) {
            System.out.println("Error while listing teachers.");
            e.printStackTrace();
        }
    }

    public void removeTeacher(Scanner scanner) {
        System.out.print("Enter Teacher ID to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            teacherDAO.deleteTeacher(id);
            System.out.println("Teacher removed successfully.");
        } catch (Exception e) {
            System.out.println("Error while removing teacher.");
            e.printStackTrace();
        }
    }
}