package _10_school_management_system;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.Scanner;

// Base class
class Person {
    protected String name;
    protected int age;
    protected String id;

    Person(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("ID: " + id);
    }
}

// Student class
class Student extends Person {
    private String className;
    private double marks;

    Student(String name, int age, String id, String className, double marks) {
        super(name, age, id);
        this.className = className;
        this.marks = marks;
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    void displayInfo() {
        System.out.println("\n=== Student Information ===");
        super.displayInfo();
        System.out.println("Class: " + className);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
    }
}

// Teacher class
class Teacher extends Person {
    private String subject;
    private double salary;

    Teacher(String name, int age, String id, String subject, double salary) {
        super(name, age, id);
        this.subject = subject;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("\n=== Teacher Information ===");
        super.displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Salary: $" + salary);
    }
}

// Staff class
class Staff extends Person {
    private String role;
    private double salary;

    Staff(String name, int age, String id, String role, double salary) {
        super(name, age, id);
        this.role = role;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("\n=== Staff Information ===");
        super.displayInfo();
        System.out.println("Role: " + role);
        System.out.println("Salary: $" + salary);
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();

        // Add sample data
        people.add(new Student("Alexa", 22, "S001", "10-A", 85.5));
        people.add(new Student("John", 21, "S002", "12-B", 92.0));
        people.add(new Teacher("Dr. Bob", 45, "T001", "Mathematics", 60000));
        people.add(new Teacher("Ms. Julie", 38, "T002", "Physics", 55000));
        people.add(new Staff("Adam", 35, "ST001", "Admin", 40000));

        while (true) {
            System.out.println("\n==== School Management System ====");
            System.out.println("1. View All People");
            System.out.println("2. View Students Only");
            System.out.println("3. View Teachers Only");
            System.out.println("4. View Staff Only");
            System.out.println("5. Search by ID");
            System.out.println("6. Count Statistics");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("===== All People =====");
                    for (Person person : people) {
                        person.displayInfo();
                    }
                    break;

                case 2:
                    System.out.println("\n===== Students =====");
                    for (Person person : people) {
                        if (person instanceof Student) {
                            person.displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("===== Teachers =====");
                    for (Person person : people) {
                        if (person instanceof Teacher) {
                            person.displayInfo();
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n===== Staff =====");
                    for (Person person : people) {
                        if (person instanceof Staff) {
                            person.displayInfo();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Enter ID: ");
                    String searchId = scanner.nextLine();
                    boolean found = false;

                    for (Person person : people) {
                        if (person.id.equals(searchId)){
                            person.displayInfo();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No person found with ID: " + searchId);
                    }
                    break;

                case 6:
                    int studentCount = 0, teacherCount = 0, staffCount = 0;

                    for (Person person : people) {
                        if (person instanceof Student) studentCount++;
                        else if (person instanceof Teacher) teacherCount++;
                        else if (person instanceof Staff) staffCount++;
                    }

                    System.out.println("\n===== Statistics =====");
                    System.out.println("Total People: " + people.size());
                    System.out.println("Students: " + studentCount);
                    System.out.println("Teachers: " + teacherCount);
                    System.out.println("Staff: " + staffCount);
                    break;

                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
