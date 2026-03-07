package _01_abstract_class_basics;

// Abstract class
abstract class Vehicle {
    String brand;
    String model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Abstract methods
    abstract void start();
    abstract void stop();
    abstract int getMaxSpeed();

    // Concrete method
    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + getMaxSpeed() + " km/h");
    }
}

class Car extends Vehicle {
    Car(String brand, String model) {
        super(brand, model);
    }

    @Override
    void start() {
        System.out.println(brand + " " + model + " car is starting...");
    }

    @Override
    void stop() {
        System.out.println(brand + " " + model + " car is stopping...");
    }

    @Override
    int getMaxSpeed() {
        return 180;
    }
}

class Motorcycle extends Vehicle {
    Motorcycle(String brand, String model) {
        super(brand, model);
    }

    @Override
    void start() {
        System.out.println(brand + " " + model + " motorcycle is starting...");
    }

    @Override
    void stop() {
        System.out.println(brand + " " + model + " motorcycle is stopping...");
    }

    @Override
    int getMaxSpeed() {
        return 220;
    }
}

public class AbstractClassBasics {
    public static void main(String[] args) {
        // Vehicle vehicle = new Vehicle("Test", "Model 3");    // ERROR!

        Vehicle car = new Car("Toyota", "Fortuner");
        car.displayInfo();
        car.start();
        car.stop();

        System.out.println();

        Vehicle bike = new Motorcycle("BMW", "S 1000 RR");
        bike.displayInfo();
        bike.start();
        bike.stop();
    }
}
