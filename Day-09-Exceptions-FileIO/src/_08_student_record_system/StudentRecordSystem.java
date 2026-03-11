package _08_student_record_system;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String id;
    String name;
    int age;
    double marks;

    Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + marks;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        return new Student(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}

public class StudentRecordSystem {
    static String filename = "students.txt";

    public static void addStudent(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(student.toFileString());
            writer.newLine();
            System.out.println("Student added successfully!");
        } catch (IOException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromFileString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing records found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }

        return students;
    }

    public static void displayAllStudents() {
        ArrayList<Student> students = loadStudents();

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n=== All Students ===");
        for (Student student : students) {
            student.display();
        }
    }

    public static void searchStudent(String id) {
        ArrayList<Student> students = loadStudents();
        boolean found = false;

        for (Student student : students) {
            if (student.id.equals(id)) {
                System.out.println("\nStudent found:");
                student.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Record System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    addStudent(new Student(id, name, age, marks));
                    break;

                case 2:
                    displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    searchStudent(searchId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
