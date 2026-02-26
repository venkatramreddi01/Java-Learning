package _02_student_with_constructor;

class Student {
    String name;
    int rollNumber;
    String course;
    double marks;

    // Default constructor
    public Student() {
        name = "Unknown";
        rollNumber = 0;
        course = "Not assigned";
        marks = 0.0;
    }

    // Parameterized constructor
    public Student(String name, int rollNumber, String course, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.marks = marks;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
        System.out.println("---");
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

public class StudentWithConstructor {
    public static void main(String[] args){
        // Using default constructor
        Student s1 = new Student();
        s1.displayInfo();

        // Using parameterized constructor
        Student s2 = new Student("Nikhil", 108, "Computer Science", 99.9);
        s2.displayInfo();

        Student s3 = new Student("Vivek", 99, "Electronics", 81.0);
        s3.displayInfo();
    }
}
