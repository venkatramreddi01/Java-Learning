package _04_phone_book;

import java.util.HashMap;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("---");
    }
}

public class PhoneBook {
    static HashMap<String, Contact> contacts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (contacts.containsKey(name)) {
            System.out.println("Contact already exists!");
            return;
        }

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.put(name, new Contact(name, phone, email));
        System.out.println("Contact added!");
    }

    public static void viewAllContacts() {
        if  (contacts.isEmpty()) {
            System.out.println("No contacts!");
            return;
        }

        System.out.println("\n=== All Contacts ===");
        contacts.values().forEach(Contact::display);
    }

    public static void searchContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Contact contact = contacts.get(name);
        if (contact != null) {
            System.out.println("\nContact found:");
            contact.display();
        } else {
            System.out.println("Contact not found!");
        }
    }

    public static void updateContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (!contacts.containsKey(name)) {
            System.out.println("Contact not found!");
            return;
        }

        System.out.print("Enter new phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        contacts.put(name, new Contact(name, phone, email));
        System.out.println("Contact updated!");
    }

    public static void deleteContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (contacts.remove(name) != null) {
            System.out.println("Contact deleted!");
        } else {
            System.out.println("Contact not found!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Phone Book ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:addContact(); break;
                case 2: viewAllContacts(); break;
                case 3: searchContact(); break;
                case 4: updateContact(); break;
                case 5: deleteContact(); break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
