package _06_static_example;

class Counter {
    static int objectCount = 0; // Static - shared by all objects
    int instanceId;             // Instance - unique per object;

    // Constructor
    public Counter() {
        objectCount++;          // Increment for every object created
        instanceId = objectCount;
    }

    void displayInfo() {
        System.out.println("Object ID: " + instanceId);
        System.out.println("Total objects created: " + objectCount);
        System.out.println("---");
    }

    // Static method
    static void displayTotalObjects() {
        System.out.println("Total objects in system: " + objectCount);
        // Cannot access instanceID here - it's not static!
    }
}

public class StaticExample {
    public static void main(String[] args) {
        System.out.println("Creating objects...\n");

        Counter c1 = new Counter();
        c1.displayInfo();

        Counter c2 = new Counter();
        c2.displayInfo();

        Counter c3 = new Counter();
        c3.displayInfo();

        // Calling static method using class name
        Counter.displayTotalObjects();

        // All objects see the same static variable
        System.out.println("\nObject 1 sees count: " + Counter.objectCount);
        System.out.println("\nObject 2 sees count: " + Counter.objectCount);
        System.out.println("\nObject 3 sees count: " + Counter.objectCount);
    }
}
