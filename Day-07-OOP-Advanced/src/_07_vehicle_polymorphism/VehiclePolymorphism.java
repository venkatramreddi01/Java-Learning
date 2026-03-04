package _07_vehicle_polymorphism;

import com.sun.security.jgss.GSSUtil;

class Vehicle {
    protected String brand;
    protected String model;
    protected double pricePerDay;

    Vehicle(String brand, String model, double pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    double calculateRentalCost(int days) {
        return pricePerDay * days;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price per day: $" + pricePerDay);
    }
}

class Car extends Vehicle {
    boolean hasAC;

    Car(String brand, String model, double pricePerDay, boolean hasAC) {
        super(brand, model, pricePerDay);
        this.hasAC = hasAC;
    }

    double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        if (hasAC) {
            cost += 10 * days;  // Extra $10/day for AC
        }
        return cost;
    }

    void displayInfo() {
        System.out.println("=== Car ===");
        super.displayInfo();
        System.out.println("AC: " + (hasAC ? "Yes" : "No"));
    }
}

class Bike extends Vehicle {
    String type;

    Bike(String brand, String model, double pricePerDay, String type) {
        super(brand, model, pricePerDay);
        this.type = type;
    }

    double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        if (type.equals("Sport")) {
            cost += 5 * days;   // Extra $5/day for sport bikes
        }
        return cost;
    }

    void displayInfo() {
        System.out.println("=== Bike ===");
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

class Truck extends Vehicle {
    double loadCapacity;

    Truck(String brand, String model, double pricePerDay, double loadCapacity) {
        super(brand, model, pricePerDay);
        this.loadCapacity = loadCapacity;
    }

    double calculateRentalCost(int days) {
        double cost = super.calculateRentalCost(days);
        cost += loadCapacity * 2 * days;    // $2 per ton per day
        return cost;
    }

    void displayInfo() {
        System.out.println("=== Truck ===");
        super.displayInfo();
        System.out.println("Load Capacity: "  + loadCapacity + " tons");
    }
}

public class VehiclePolymorphism {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[3];

        fleet[0] = new Car("Toyota", "Fortuner", 50, true);
        fleet[1] = new Bike("Yamaha", "R15", 20, "Sport");
        fleet[2] = new Truck("Tata", "LPT 1613", 100, 5);

        int rentalDays = 5;

        System.out.println("=== Vehicle Rental System ===\n");
        System.out.println("Rental Duration: " + rentalDays + " days\n");

        for (Vehicle vehicle : fleet) {
            vehicle.displayInfo();
            System.out.println("Total Cost: $" + vehicle.calculateRentalCost(rentalDays));
            System.out.println();
        }
    }
}
