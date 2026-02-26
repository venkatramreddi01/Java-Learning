package _09_product;

class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;
    private String category;

    // Constructor
    public Product(String productId, String name, Double price, int stock, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    // Methods
    public boolean isInStock() {
        return stock > 0;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            stock += quantity;
            System.out.println("Added " + quantity + " units. New stock: " + stock);
        }
    }

    public boolean sell(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            System.out.println("Sold " + quantity + " units. Remaining stock: " + stock);
            return true;
        } else if (quantity > stock) {
            System.out.println("Insufficient stock! Available: " + stock);
            return false;
        } else {
            System.out.println("Invalid quantity!");
            return false;
        }
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            double discount = price * (percentage / 100);
            price -= discount;
            System.out.println("Discount applied! New price: $" + price);
        }
    }

    public void displayInfo() {
        System.out.println("\n--- Product Information ---");
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Status: " + (isInStock() ? "In Stock" : "Out of Stock"));
        System.out.println("-------------------------\n");
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product laptop = new Product("P001", "Dell XPS 15", 1299.99, 10, "Electronics");
        Product phone = new Product("P002", "iphone 15", 999.99, 5, "Electronics");

        laptop.displayInfo();
        phone.displayInfo();

        // Sell products
        laptop.sell(3);
        laptop.displayInfo();

        // Apply discount
        phone.applyDiscount(10);
        phone.displayInfo();

        // Add stock
        laptop.addStock(5);
        laptop.displayInfo();
    }
}
