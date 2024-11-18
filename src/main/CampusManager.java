package main;

import dao.DBConnection;
import java.sql.Connection;
import java.util.Scanner;
import service.StudentService;
import service.SubjectService;
import service.TeacherService;

public class CampusManager {

    public static void main(String[] args) {
        System.out.println("Welcome to CampusManager!");
        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            StudentService studentService = new StudentService(conn);
            TeacherService teacherService = new TeacherService(conn);
            SubjectService subjectService = new SubjectService(conn);

            int choice;
            do {
                System.out.println("\nChoose an operation:");
                System.out.println("1: Add a New Student");
                System.out.println("2: Remove a Student");
                System.out.println("3: List All Students");
                System.out.println("4: Add a New Teacher");
                System.out.println("5: Remove a Teacher");
                System.out.println("6: List All Teachers");
                System.out.println("7: Add New Subject");
                System.out.println("8: List All Subjects");
                System.out.println("9: Update Subject Teacher");
                System.out.println("10: Remove Subject");
                System.out.println("0: Exit");

                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> studentService.addNewStudent(scanner);
                    case 2 -> studentService.removeStudent(scanner);
                    case 3 -> studentService.listAllStudents();
                    case 4 -> teacherService.addNewTeacher(scanner);
                    case 5 -> teacherService.removeTeacher(scanner);
                    case 6 -> teacherService.listAllTeachers();
                    case 7 -> subjectService.addNewSubject(scanner);
                    case 8 -> subjectService.listAllSubjects();
                    case 9 -> subjectService.updateSubjectTeacher(scanner);
                    case 10 -> subjectService.removeSubject(scanner);
                    case 0 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}