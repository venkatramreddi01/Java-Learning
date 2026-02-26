package _07_employee;

class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double salary;

    // Static variable to generate unique IDs
    private static int idCounter = 1000;

    // Constructor
    public Employee(String name, String department, double salary) {
        this.employeeId = ++idCounter;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getEmployeeId(){
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Methods
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = salary * (percentage / 100);
            salary += raiseAmount;
            System.out.println("Raise of " + percentage + "% given!");
            System.out.println("New salary: $" + salary);
        }
    }

    public void displayInfo() {
        System.out.println("\n--- Employee Information ---");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("---------------------------\n");
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Venkatram", "Engineering", 99000);
        Employee emp2 = new Employee("Adarsh", "Marketing", 100000);
        Employee emp3 = new Employee("Karthik", "Architecture", 70000);
        Employee emp4 = new Employee("Mahesh", "Sales", 71000);
        Employee emp5 = new Employee("Kamalnath", "Army", 90000);

        emp1.displayInfo();
        emp2.displayInfo();
        emp3.displayInfo();
        emp4.displayInfo();
        emp5.displayInfo();

        // Give raise
        emp2.giveRaise(20);
        emp2.displayInfo();
    }
}
