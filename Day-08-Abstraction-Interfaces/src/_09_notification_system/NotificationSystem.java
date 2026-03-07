package _09_notification_system;

// Abstract Notification class
abstract class Notification {
    String recipient;
    String message;
    String timestamp;

    Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    abstract void send();
    abstract String getNotificationType();
    abstract boolean validateRecipient();

    void displayInfo() {
        System.out.println("\n=== " + getNotificationType() + " ===");
        System.out.println("To: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("Time: " + timestamp);
    }
}

// Email Notification
class EmailNotification extends Notification {
    EmailNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    void send() {
        if (validateRecipient()) {
            System.out.println("Sending email to: " + recipient);
            System.out.println("Subject: Notification");
            System.out.println("Body: " + message);
            System.out.println("Email sent successfully!");
        } else {
            System.out.println("Invalid email address!");
        }
    }

    @Override
    String getNotificationType() {
        return "Email Notification";
    }

    @Override
    boolean validateRecipient() {
        return recipient.contains("@");
    }
}

// SMS Notification
class SMSNotification extends Notification {
    SMSNotification(String recipient, String message) {
        super(recipient, message);
    }

    @Override
    void send() {
        if (validateRecipient()) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Message: " + message);
            System.out.println("SMS sent successfully!");
        } else {
            System.out.println("Invalid phone number!");
        }
    }

    @Override
    String getNotificationType() {
        return "SMS Notification";
    }

    @Override
    boolean validateRecipient() {
        return recipient.matches("\\d{10}");    // 10 digits
    }
}

// Push Notification
class PushNotification extends Notification {
    String appName;

    PushNotification(String recipient, String message, String appName) {
        super(recipient, message);
        this.appName = appName;
    }

    @Override
    void send() {
        if (validateRecipient()) {
            System.out.println("Sending push notification via " + appName);
            System.out.println("User ID: " + recipient);
            System.out.println("Message: " + message);
            System.out.println("Push notification sent!");
        } else {
            System.out.println("Invalid user ID!");
        }
    }

    @Override
    String getNotificationType() {
        return "Push Notification";
    }

    @Override
    boolean validateRecipient() {
        return recipient.startsWith("USER");
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = new Notification[3];

        notifications[0] = new EmailNotification("Adam@example.com", "Your order has been shipped!");
        notifications[1] = new SMSNotification("9876543210", "Your OTP is 123456");
        notifications[2] = new PushNotification("USER12345", "New message received", "WhatsApp");

        System.out.println("=== Notification Service ===");

        for (Notification notification : notifications) {
            notification.displayInfo();
            notification.send();
        }
    }
}
