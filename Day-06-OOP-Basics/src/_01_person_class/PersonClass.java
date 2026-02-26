package _01_person_class;

class Person {
    // Fields
    String name;
    int age;
    String city;

    // Method to display info
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("---");
    }

    // Method to check if adult
    boolean isAdult() {
        return age >= 18;
    }
}

public class PersonClass {
    public static void main(String[] args) {
        // Creating objects
        Person person1 = new Person();
        person1.name = "John";
        person1.age = 25;
        person1.city = "New York";

        Person person2 = new Person();
        person2.name = "Alice";
        person2.age = 17;
        person2.city = "London";

        // Using objects
        person1.displayInfo();
        System.out.println("Is adult? " + person1.isAdult());
        System.out.println();

        person2.displayInfo();
        System.out.println("Is adult? " + person2.isAdult());
    }
}
