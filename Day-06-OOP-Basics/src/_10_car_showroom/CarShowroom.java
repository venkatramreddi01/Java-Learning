package _10_car_showroom;

import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String model;
    private String brand;
    private int year;
    private double price;
    private String color;
    private boolean sold;

    // Static counter for total cars
    private static int totalCars = 0;

    // Constructor
    public Car(String model, String brand, int year, double price, String color){
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.sold = false;
        totalCars++;
    }

    // Getters
    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public boolean isSold() {
        return sold;
    }

    public static int getTotalCars() {
        return totalCars;
    }

    // Methods
    public void sellCar() {
        if (!sold) {
            sold = true;
            System.out.println("Car sold successfully!");
        } else {
            System.out.println("Car already sold!");
        }
    }

    public void applyDiscount(double percentage) {
        if (!sold && percentage > 0 && percentage <= 100) {
            double discount = price * (percentage/ 100);
            price -= discount;
            System.out.println("Discount of " + percentage + "% applied!");
            System.out.println("New price: $" + price);
        }
    }

    public void displayInfo() {
        System.out.println("\n ========== Car Details");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (sold ? "SOLD" : "AVAILABLE"));
        System.out.println("================================\n");
    }
}

public class CarShowroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> inventory = new ArrayList<>();

        // Add initial inventory
        inventory.add(new Car("Tesla", "Model 3", 2024, 45000, "White"));
        inventory.add(new Car("BMW", "M3", 2024, 75000, "Black"));
        inventory.add(new Car("Toyota", "Camry", 2023, 28000, "Silver"));
        inventory.add(new Car("Mercedes", "C-Class", 2024, 55000, "Blue"));

        while (true) {
            System.out.println("\n====== Car Showroom Menu ======");
            System.out.println("1. View All Cars");
            System.out.println("2. View Available Cars");
            System.out.println("3. Sell a Car");
            System.out.println("4. Apply Discount");
            System.out.println("5. Add New Car");
            System.out.println("6. Show Statistics");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n===== ALL CARS =====");
                    for (Car car : inventory) {
                        car.displayInfo();
                    }
                    break;

                case 2:
                    System.out.println("\n===== AVAILABLE CARS =====");
                    for (Car car : inventory) {
                        if (!car.isSold()) {
                            car.displayInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter car index to sell (0-" + (inventory.size()-1) + "): ");
                    int sellIndex = scanner.nextInt();
                    if (sellIndex >= 0 && sellIndex < inventory.size()) {
                        inventory.get(sellIndex).sellCar();
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 4:
                    System.out.print("Enter car index (0-" + (inventory.size()-1) + "): ");
                    int discountIndex = scanner.nextInt();
                    System.out.print("Enter discount percentage: ");
                    double discount = scanner.nextDouble();
                    if (discountIndex >= 0 && discountIndex < inventory.size()) {
                        inventory.get(discountIndex).applyDiscount(discount);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;

                case 5:
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Price: $");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();

                    inventory.add(new Car(brand, model, year, price, color));
                    System.out.println("Car added successfully!");
                    break;

                case 6:
                    int available = 0;
                    int sold = 0;
                    double totalValue = 0;

                    for (Car car : inventory) {
                        if (car.isSold()) {
                            sold++;
                        } else {
                            available++;
                            totalValue += car.getPrice();
                        }
                    }

                    System.out.println("\n===== SHOWROOM STATISTICS =====");
                    System.out.println("Total Cars: " + Car.getTotalCars());
                    System.out.println("Available: " + available);
                    System.out.println("Sold: " + sold);
                    System.out.println("Inventory Value: $" + totalValue);
                    System.out.println("==============================\n");
                    break;

                case 7:
                    System.out.println("Thank you for visiting!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
