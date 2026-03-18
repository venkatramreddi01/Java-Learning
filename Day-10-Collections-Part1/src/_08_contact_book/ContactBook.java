package _08_contact_book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class ContactBook {
    static ArrayList<Contact>  contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added!");
    }

    public static void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts!");
            return;
        }

        System.out.println("\n=== All Contacts ===");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ".");
            contacts.get(i).display();
        }
    }

    public static void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        System.out.println("\n=== Search Results ===");

        for (Contact c : contacts) {
            if (c.name.toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Contact found");
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contacts found!");
        }
    }

    public static void deleteContact() {
        viewAllContacts();
        if (contacts.isEmpty()) return;

        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted!");
        } else {
            System.out.println("Invalid contact number!");
        }
    }

    public static void sortContacts() {
        Collections.sort(contacts, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        System.out.println("Contacts sorted by name!");
        viewAllContacts();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Contact Book ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Sort Contacts");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addContact(); break;

                case 2: viewAllContacts(); break;

                case 3: searchContact(); break;

                case 4: deleteContact(); break;

                case 5: sortContacts(); break;

                case 6:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
