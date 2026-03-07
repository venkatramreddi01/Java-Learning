package _10_ecommerce_system;

import java.util.ArrayList;
import java.util.Scanner;

// Interface for purchasable items
interface Purchasable {
    double getPrice();
    boolean isAvailable();
    void purchase(int quantity);
}

// Interface for shopping items
interface Shippable {
    double getShippingCost();
    String getEstimatedDelivery();
}

// Abstract Product class
abstract class Product implements Purchasable {
    protected String productId;
    protected String name;
    protected double price;
    protected int stock;

    Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    abstract String getCategory();

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isAvailable(){
        return stock > 0;
    }

    @Override
    public void purchase(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            System.out.println("Purchased " + quantity + " x " + name);
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    void displayInfo() {
        System.out.println("\n--- " + name + " ----");
        System.out.println("ID: " + productId);
        System.out.println("Category: " + getCategory());
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Status: " + (isAvailable() ? "Available" : "Out of Stock"));
    }
}

// Physical Product (Shippable)
class PhysicalProduct extends Product implements Shippable {
    double weight;

    PhysicalProduct(String id, String name, double price, int stock, double weight) {
        super(id, name, price, stock);
        this.weight = weight;
    }


    @Override
    String getCategory() {
        return "Physical Product";
    }

    @Override
    public double getShippingCost() {
        return weight * 5;  // $5 per kg
    }

    @Override
    public String getEstimatedDelivery() {
        return "3-5 business days";
    }
}

// Digital Product (instant delivery)
class DigitalProduct extends Product {
    String downloadUrl;

    DigitalProduct(String id, String name, double price, String downloadUrl) {
        super(id, name, price, Integer.MAX_VALUE);  // Unlimited stock
        this.downloadUrl = downloadUrl;
    }


    @Override
    String getCategory() {
        return "Digital Product";
    }

    void download() {
        System.out.println("Downloading from: " + downloadUrl);
    }
}

// Shopping Cart
class ShoppingCart {
    ArrayList<Product> items = new ArrayList<>();

    void addItem(Product product) {
        items.add(product);
        System.out.println(product.name + " added to cart");
    }

    void removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            System.out.println(items.get(index).name + " removed form cart");
            items.remove(index);
        }
    }

    double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }

        // Add shipping for physical products
        for (Product item : items) {
            if (item instanceof Shippable) {
                total += ((Shippable) item).getShippingCost();
            }
        }
        return total;
    }

    void displayCart() {
        System.out.println("\n===== Shopping Cart =====");
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for(int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + "." + items.get(i).name + " - $" + items.get(i).getPrice());

            if (items.get(i) instanceof Shippable) {
                Shippable shippable = (Shippable) items.get(i);
                System.out.println(" Shipping: $" + shippable.getShippingCost());
                System.out.println(" Delivery: " + shippable.getEstimatedDelivery());
            }
        }

        System.out.println("\nTotal: $" + calculateTotal());
    }

    void checkout() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("\n===== Order Summary =====");
        displayCart();

        for (Product item : items) {
            item.purchase(1);
        }

        System.out.println("\nOrder placed successfully!");
        System.out.println("Total charged: $" + calculateTotal());
        items.clear();
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create products
        ArrayList<Product> products = new ArrayList<>();
        products.add(new PhysicalProduct("P001", "Laptop", 999.99, 10, 2.5));
        products.add(new PhysicalProduct("P002", "Mouse", 29.99, 50, 0.2));
        products.add(new DigitalProduct("D001", "E-Book", 9.99, "http://download.com/ebook"));
        products.add(new DigitalProduct("D002", "Software License", 49.99, "http://download.com/software"));

        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n===== E-Commerce Store =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n===== Products =====");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". ");
                        products.get(i).displayInfo();

                        if (products.get(i) instanceof Shippable) {
                            Shippable s = (Shippable) products.get(i);
                            System.out.println("Shipping: $" + s.getShippingCost());
                            System.out.println("Delivery : " + s.getEstimatedDelivery());
                        } else{
                            System.out.println("Delivery: Instant (Digital)");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter product number (1-" + products.size() + "): ");
                    int productIndex = scanner.nextInt() - 1;
                    if (productIndex >= 0 && productIndex < products.size()) {
                        cart.addItem(products.get(productIndex));
                    } else {
                        System.out.println("Invalid product!");
                    }
                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:
                    cart.displayCart();
                    if (!cart.items.isEmpty()) {
                        System.out.print("Enter item number to remove: ");
                        int removeIndex = scanner.nextInt() - 1;
                        cart.removeItem(removeIndex);
                    }
                    break;

                case 5:
                    cart.checkout();
                    break;

                case 6:
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
