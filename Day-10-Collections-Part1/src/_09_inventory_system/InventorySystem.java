package _09_inventory_system;

import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String id;
    String name;
    int quantity;
    double price;

    Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.printf("ID: %s | Name: %s | Qty: %d | Price: $%.2f | Value: $%.2f\n", id, name, quantity, price, quantity * price);
    }
}

public class InventorySystem {
    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        // Checks if ID exists
        for (Product p : inventory) {
            if (p.id.equals(id)) {
                System.out.println("Product ID already exists!");
                return;
            }
        }

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: $");
        double price = scanner.nextDouble();
        scanner.nextLine();

        inventory.add(new Product(id, name, quantity, price));
        System.out.println("Product added!");
    }

    public static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\n=== Inventory ===");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print((i + 1) + ". ");
            inventory.get(i).display();
        }
    }

    public static void updateStock() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        for (Product p : inventory) {
            if (p.id.equals(id)) {
                System.out.print("Enter quantity to add (negative to reduce): ");
                int change = scanner.nextInt();
                scanner.nextLine();

                p.quantity += change;
                if (p.quantity < 0) p.quantity = 0;

                System.out.println("Stock updated! New quantity: " + p.quantity);
                return;
            }
        }

        System.out.println("Product not found!");
    }

    public static void searchProduct() {
        System.out.print("Enter product ID or name: ");
        String search = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\n=== Search Results ===");

        for (Product p : inventory) {
            if (p.id.toLowerCase().contains(search) || p.name.toLowerCase().contains(search)) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found!");
        }
    }

    public static void lowStockAlert() {
        System.out.print("Enter minimum quantity threshold: ");
        int threshold = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n=== Low Stock Alert ===");
        boolean found = false;

        for (Product p : inventory) {
            if (p.quantity < threshold) {
                p.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("All products have sufficient stock!");
        }
    }

    public static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String id = scanner.nextLine();
        boolean found = false;

        for (Product p : inventory) {
            if (p.id.equals(id)) {
                inventory.remove(p);
                System.out.println("Product deleted!");
                found = true;
                return;
            }
        }

        if (!found) {
            System.out.println("No product found!");
        }
    }

    public static void calculateValue() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        double totalValue = 0;
        for (Product p : inventory) {
            totalValue += p.quantity * p.price;
        }

        System.out.println("\n=== Inventory Value ===");
        System.out.println("Total products: " + inventory.size());
        System.out.printf("Total inventory value: $%.2f\n", totalValue);
    }

    public static void main(String[] args) {
        // Sample data
        inventory.add(new Product("P001", "Laptop", 10, 999.99));
        inventory.add(new Product("P002", "Mouse", 50, 29.99));
        inventory.add(new Product("P003", "Keyboard", 30, 79.99));

        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Stock");
            System.out.println("4. Search Product");
            System.out.println("5. Low Stock Alert");
            System.out.println("6. Delete Product");
            System.out.println("7. Calculate Total Value");
            System.out.println("8. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewInventory(); break;
                case 3: updateStock(); break;
                case 4: searchProduct(); break;
                case 5: lowStockAlert(); break;
                case 6: deleteProduct(); break;
                case 7: calculateValue(); break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
