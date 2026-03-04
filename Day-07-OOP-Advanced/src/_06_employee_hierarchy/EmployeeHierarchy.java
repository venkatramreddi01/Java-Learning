package _06_employee_hierarchy;

class Employee {
    protected String name;
    protected int employeeId;
    protected double baseSalary;

    Employee(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + employeeId);
        System.out.println("Salary: $" + calculateSalary());
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, int employeeId, double baseSalary, double bonus) {
        super(name, employeeId, baseSalary);
        this.bonus = bonus;
    }

    double calculateSalary() {
        return baseSalary + bonus;
    }

    void displayInfo() {
        System.out.println("=== Manager ===");
        super.displayInfo();
        System.out.println("Bonus: $" + bonus);
    }
}

class Developer extends Employee {
    double overtimePay;
    int overtimeHours;

    Developer(String name, int employeeId, double baseSalary, double overtimePay, int overtimeHours) {
        super(name, employeeId, baseSalary);
        this.overtimePay = overtimePay;
        this.overtimeHours = overtimeHours;
    }

    double calculateSalary() {
        return baseSalary + (overtimePay * overtimeHours);
    }

    void displayInfo() {
        System.out.println("=== Developer ===");
        super.displayInfo();
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Overtime Pay Rate: $" + overtimePay + "/hr");
    }
}

class Intern extends Employee {
    int months;

    Intern(String name, int employeeId, double baseSalary, int months) {
        super(name, employeeId, baseSalary);
        this.months = months;
    }

    void displayInfo() {
        System.out.println("=== Intern ===");
        super.displayInfo();
        System.out.println("Duration: " + months + " months");
    }
}

public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new Manager("Jack", 101, 80000, 15000);
        employees[1] = new Developer("Rick", 102, 60000, 50, 20);
        employees[2] = new Intern("Alex", 103, 1000, 6);

        double totalSalary = 0;

        System.out.println("=== Company Payroll ===\n");
        for (Employee emp : employees) {
            emp.displayInfo();
            totalSalary += emp.calculateSalary();
            System.out.println();
        }

        System.out.println("Total Payroll: $" + totalSalary);
    }
}
