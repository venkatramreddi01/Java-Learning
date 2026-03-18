package _03_student_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double marks;

    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll: " + rollNumber + ", Marks: " + marks);
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
}

public class StudentArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Student Management ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Display Statistics");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = scanner.nextInt();
                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();

                    students.add(new Student(name, roll, marks));
                    System.out.println("Student added!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.println("\n=== All Students ===");
                        for (int i = 0; i < students.size(); i++) {
                            System.out.print((i + 1) + ".");
                            students.get(i).display();
                            System.out.println("   Grade: " + students.get(i).getGrade());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = scanner.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNumber == searchRoll) {
                            System.out.println("\nStudent found:");
                            s.display();
                            System.out.println("Grade: " + s.getGrade());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = scanner.nextInt();
                    boolean removed = false;

                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).rollNumber == removeRoll) {
                            students.remove(i);
                            System.out.println("Student removed!");
                            removed = true;
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    if (students.isEmpty()) {
                        System.out.println("No students!");
                    } else {
                        double total = 0;
                        double highest = students.get(0).marks;
                        double lowest = students.get(0).marks;

                        for (Student s : students) {
                            total += s.marks;
                            if (s.marks > highest) highest = s.marks;
                            if (s.marks < lowest) lowest = s.marks;
                        }

                        System.out.println("\n=== Statistics ===");
                        System.out.println("Total students: " + students.size());
                        System.out.println("Average marks: " + (total / students.size()));
                        System.out.println("Highest marks: " + highest);
                        System.out.println("Lowest marks: " + lowest);
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
