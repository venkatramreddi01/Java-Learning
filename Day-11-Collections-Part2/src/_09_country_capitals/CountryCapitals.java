package _09_country_capitals;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class CountryCapitals {
    static HashMap<String, String> capitals = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    static void initializeData() {
        capitals.put("India", "New Delhi");
        capitals.put("USA", "Washington DC");
        capitals.put("UK", "London");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");
        capitals.put("Japan", "Tokyo");
        capitals.put("China", "Beijing");
        capitals.put("Australia", "Canberra");
        capitals.put("Canada", "Ottawa");
        capitals.put("Brazil", "Brasilia");
    }

    static void addCountry() {
        System.out.print("Enter country name: ");
        String country = scanner.nextLine();

        if (capitals.containsKey(country)) {
            System.out.println("Country already exists!");
            return;
        }

        System.out.print("Enter capital: ");
        String capital = scanner.nextLine();

        capitals.put(country, capital);
        System.out.println("Country added!");
    }

    static void viewAll() {
        if (capitals.isEmpty()) {
            System.out.println("No countries!");
            return;
        }

        System.out.println("\n=== All Countries (Unsorted) ===");
        capitals.forEach((country, capital) ->
                System.out.println(country + " -> " + capital)
        );
    }

    static void viewSorted() {
        if (capitals.isEmpty()) {
            System.out.println("No countries!");
            return;
        }

        TreeMap<String, String> sorted = new TreeMap<>(capitals);

        System.out.println("\n=== All Countries (Alphabetically) ===");
        sorted.forEach((country, capital) ->
                System.out.println(country + " -> " + capital)
        );
    }

    static void searchCountry() {
        System.out.print("Enter country name: ");
        String country = scanner.nextLine();

        if (capitals.containsKey(country)) {
            System.out.println("Capital of " + country + " is " + capitals.get(country));
        } else {
            System.out.println("Country not found!");
        }
    }

    static void searchCapital() {
        System.out.print("Enter capital name: ");
        String capital = scanner.nextLine();

        boolean found = false;
        for (HashMap.Entry<String, String> entry : capitals.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(capital)) {
                System.out.println(capital + " is the capital of " + entry.getKey());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Capital not found!");
        }
    }

    static void quiz() {
        if (capitals.isEmpty()) {
            System.out.println("No countries to quiz!");
            return;
        }

        String[] countries = capitals.keySet().toArray(new String[0]);
        int randomIndex = (int) (Math.random() * countries.length);
        String country = countries[randomIndex];

        System.out.println("\n=== Quiz ===");
        System.out.println("What is the capital of " + country + "?");
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase(capitals.get(country))) {
            System.out.println("✓ Correct!");
        } else {
            System.out.println("✗ Wrong! Correct answer: " + capitals.get(country));
        }
    }

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("\n=== Country-Capital Directory ===");
            System.out.println("1. Add Country");
            System.out.println("2. View All (Unsorted)");
            System.out.println("3. View All (Sorted)");
            System.out.println("4. Search by Country");
            System.out.println("5. Search by capital");
            System.out.println("6. Quiz Me!");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addCountry(); break;
                case 2: viewAll(); break;
                case 3:  viewSorted(); break;
                case 4: searchCountry(); break;
                case 5: searchCapital(); break;
                case 6: quiz(); break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
