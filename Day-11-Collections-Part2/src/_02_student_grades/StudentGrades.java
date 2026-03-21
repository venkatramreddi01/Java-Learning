package _02_student_grades;

import java.util.HashMap;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> studentMarks = new HashMap<>();

        while (true) {
            System.out.println("\n=== Student Grade Manager ===");
            System.out.println("1. Add Student Grade");
            System.out.println("2. View All Grades");
            System.out.println("3. Search Student");
            System.out.println("4. Update Grade");
            System.out.println("5. Remove student");
            System.out.println("6. Class Statistics");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    studentMarks.put(name.toLowerCase(), marks);
                    System.out.println("Marks added!");
                    break;

                case 2:
                    if (studentMarks.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.println("\n=== All Students ===");
                        studentMarks.forEach((student, g) ->
                                System.out.println(student + ": " + g + " (" + getLetterGrade(g) + ")")
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    String searchName = scanner.nextLine().toLowerCase();

                    if (studentMarks.containsKey(searchName)) {
                        double g = studentMarks.get(searchName);
                        System.out.println(searchName + ": " + g + " (" + getLetterGrade(g) + ")");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name: ");
                    String updateName = scanner.nextLine().toLowerCase();

                    if (studentMarks.containsKey(updateName)) {
                        System.out.print("Enter new marks: ");
                        double newMarks = scanner.nextDouble();
                        scanner.nextLine();
                        studentMarks.put(updateName, newMarks);
                        System.out.println("Grade updated!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine().toLowerCase();

                    if (studentMarks.remove(removeName) != null) {
                        System.out.println("Student removed!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    if (studentMarks.isEmpty()) {
                        System.out.println("No students!");
                    } else {
                        double sum = 0;
                        double highest = Double.NEGATIVE_INFINITY;
                        double lowest = Double.POSITIVE_INFINITY;

                        for (double g : studentMarks.values()) {
                            sum += g;
                            if (g > highest) highest = g;
                            if (g < lowest) lowest = g;
                        }

                        System.out.println("\n=== Class Statistics ===");
                        System.out.println("Total students: " + studentMarks.size());
                        System.out.println("Average marks: " + (sum / studentMarks.size()));
                        System.out.println("Highest marks: " + highest);
                        System.out.println("Lowest marks: " + lowest);
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static String getLetterGrade(double marks) {
        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}
