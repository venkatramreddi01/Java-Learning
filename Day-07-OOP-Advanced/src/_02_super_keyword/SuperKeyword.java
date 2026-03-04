package _02_super_keyword;

class Vehicle {
    String brand;
    int maxSpeed;

    Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        System.out.println("Vehicle constructor is called");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }

    void start() {
        System.out.println(brand + " is starting...");
    }
}


class Car extends Vehicle {
    int doors;
    String fuelType;

    Car(String brand, int maxSpeed, int doors, String fuelType) {
        super(brand, maxSpeed);    // Call parent method
        this.doors = doors;
        this.fuelType = fuelType;
        System.out.println("Car constructor called");
    }

    void displayInfo() {
        super.displayInfo();    // Call parent method
        System.out.println("Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
    }

    void start() {
        super.start();  // Call parent start()
        System.out.println("Car engine started!");
    }
}

class Bike extends Vehicle {
    String type;

    Bike(String brand, int maxSpeed, String type) {
        super(brand, maxSpeed);
        this.type = type;
        System.out.println("Bike constructor called");
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        System.out.println("Creating Car:");
        Car car = new Car("Toyota", 250, 4, "Diesel");
        car.displayInfo();
        car.start();

        System.out.println("\nCreating Bike:");
        Bike bike = new Bike("Yamaha", 180, "Sport");
        bike.displayInfo();

    }
}
