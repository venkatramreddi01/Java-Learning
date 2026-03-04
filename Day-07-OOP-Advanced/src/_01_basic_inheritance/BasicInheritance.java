package _01_basic_inheritance;

// Parent class
class Person {
    String name;
    int age;

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    void introduce() {
        System.out.println("Hi, I'm " + name);
    }
}

// Child class
class Student extends Person {
    String studentId;
    String course;

    void study() {
        System.out.println(name + " is studying " + course);
    }

    void displayStudentInfo() {
        displayInfo();  //  Inherited method
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

// Another child class
class Teacher extends Person {
    String employeeId;
    String subject;

    void teach() {
        System.out.println(name + " is teaching " + subject);
    }

    void displayTeacherInfo() {
        displayInfo();  // Inherited method
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
    }
}

public class BasicInheritance {
    public static void main(String[] args) {
        System.out.println("=== Student ===");
        Student student = new Student();
        student.name = "Venkatram";
        student.age = 22;
        student.studentId = "VN108";
        student.course = "Computer Science";

        student.introduce();
        student.displayInfo();
        student.study();

        System.out.println("\n=== Teacher ===");
        Teacher teacher = new Teacher();
        teacher.name = "Dr. Nikhil";
        teacher.age = 36;
        teacher.employeeId = "VN939";
        teacher.subject = "Drawing";

        teacher.introduce();
        teacher.displayTeacherInfo();
        teacher.teach();
    }
}
