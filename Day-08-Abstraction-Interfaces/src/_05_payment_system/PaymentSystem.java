package _05_payment_system;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

// Abstract class for common payment behavior
abstract class Payment {
    String paymentId;
    double amount;
    String status;

    Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.status = "Pending";
    }

    abstract void processPayment();
    abstract String getPaymentMethod();

    void displayInfo() {
        System.out.println("\n=== Payment Information ===");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Method: " + getPaymentMethod());
        System.out.println("Amount: $" + amount);
        System.out.println("Status: " + status);
    }

    void generateReceipt() {
        System.out.println("\n--- RECEIPT ---");
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Amount Paid: $" + amount);
        System.out.println("Method: " + getPaymentMethod());
        System.out.println("Status: " + status);
        System.out.println("Thank you!");
    }
}

// Interface for refundable payments
interface Refundable {
    void refund(double amount);
    boolean canRefund();
}

// Credit Card Payment
class CreditCardPayment extends Payment implements Refundable {
    String cardNumber;
    String cardHolder;

    CreditCardPayment(String id, double amount, String cardNumber, String cardHolder) {
        super(id, amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    void processPayment() {
        System.out.println("Processing credit card payment...");
        System.out.println("Charging $" + amount + " to card ending in " + cardNumber.substring(cardNumber.length() - 4));
        status = "Completed";
    }

    @Override
    String getPaymentMethod() {
        return "Credit Card";
    }

    @Override
    public void refund(double refundAmount) {
        if (canRefund() && refundAmount <= amount) {
            System.out.println("Refunding $" + refundAmount + " to " + cardHolder);
            status = "Refunded";
        } else{
            System.out.println("Refund not possible");
        }
    }

    @Override
    public boolean canRefund() {
        return status.equals("Completed");
    }
}

// UPI Payment
class UPIPayment extends Payment implements Refundable {
    String upiId;

    UPIPayment(String id, double amount, String upiId) {
        super(id, amount);
        this.upiId = upiId;
    }


    @Override
    void processPayment() {
        System.out.println("Processing  UPI payment...");
        System.out.println("Sending $" + amount + " to " + upiId);
        status = "Completed";
    }

    @Override
    String getPaymentMethod() {
        return "UPI";
    }

    @Override
    public void refund(double refundAmount) {
        if (canRefund() && refundAmount <= amount) {
            System.out.println("Refunding $" + refundAmount + " to UPI ID: " + upiId);
            status = "Refunded";
        }
    }

    @Override
    public boolean canRefund() {
        return status.equals("Completed");
    }
}

// Cash Payment (not refundable)
class CashPayment extends Payment {
    CashPayment(String id, double amount) {
        super(id, amount);
    }

    @Override
    void processPayment() {
        System.out.println("Accepting cash payment of $" + amount);
        status = "Completed";
    }

    @Override
    String getPaymentMethod() {
        return "Cash";
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Payment Processing System ===\n");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Cash");
        System.out.print("Choose payment method: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter amount: $");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Payment payment = null;

        switch (choice) {
            case 1:
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter card holder name: ");
                String cardHolder = scanner.nextLine();
                payment = new CreditCardPayment("PAY001", amount, cardNumber, cardHolder);
                break;

            case 2:
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                payment = new UPIPayment("PAY002", amount, upiId);
                break;

            case 3:
                payment = new CashPayment("PAY003", amount);
                break;

            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        payment.displayInfo();
        payment.processPayment();
        payment.displayInfo();
        payment.generateReceipt();

        // Try refund for refundable payments
        if (payment instanceof Refundable) {
            System.out.print("\nWant to refund? (yes/no): ");
            String refundChoice = scanner.nextLine();
            if (refundChoice.equalsIgnoreCase("yes")) {
                System.out.print("Enter refund amount: $");
                double refundAmount = scanner.nextDouble();
                ((Refundable) payment).refund(refundAmount);
                payment.displayInfo();
            } else {
                System.out.println("\nCash payments cannot be refunded.");
            }

            scanner.close();
        }
    }
}
