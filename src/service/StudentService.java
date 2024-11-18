package service;

import dao.StudentDAO;
import model.Student;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(Connection connection) {
        this.studentDAO = new StudentDAO(connection);
    }

    public void addNewStudent(Scanner scanner) {
        System.out.println("Enter Student Details:");
        System.out.println("ID:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("First Name:");
        String firstName = scanner.nextLine();
        System.out.println("Last Name:");
        String lastName = scanner.nextLine();
        System.out.println("Date of Birth (YYYY-MM-DD):");
        String dob = scanner.nextLine();
        System.out.println("Gender (M/F):");
        String gender = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();

        Student student = new Student(id, firstName, lastName, dob, gender, email);
        try {
            studentDAO.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listAllStudents() {
        try {
            List<Student> students = studentDAO.getAllStudents();
            students.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeStudent(Scanner scanner) {
        System.out.println("Enter Student ID to remove:");
        int id = Integer.parseInt(scanner.nextLine());
        try {
            studentDAO.deleteStudent(id);
                    System.out.println("Student removed successfully.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

}