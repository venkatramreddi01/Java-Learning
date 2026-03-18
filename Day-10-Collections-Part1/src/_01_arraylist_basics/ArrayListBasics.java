package _01_arraylist_basics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayListBasics {
    public static void main(String[] args) {
        // Create ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        System.out.println("=== Adding Elements ===");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        System.out.println("Fruits: " + fruits);

        // Add at specific index
        fruits.add(1, "Grapes");
        System.out.println("After adding at index 1: " + fruits);

        System.out.println("\n=== Accessing Elements ===");
        System.out.println("First fruit: " + fruits.get(0));
        System.out.println("Third fruit: " + fruits.get(2));
        System.out.println("Size: " + fruits.size());

        System.out.println("\n=== Modifying Elements ===");
        fruits.set(0, "Pineapple");
        System.out.println("After changing first: " + fruits);

        System.out.println("\n=== Searching ===");
        System.out.println("Contains 'Mango': " + fruits.contains("Mango"));
        System.out.println("Index of 'Orange': " + fruits.indexOf("Orange"));

        System.out.println("\n=== Removing Elements ===");
        fruits.remove(2);   // Remove by index
        System.out.println("After removing index 2: " + fruits);

        fruits.remove("Banana");    // Remove by value
        System.out.println("After removing 'Banana': " + fruits);

        System.out.println("\n=== Sorting ===");
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);

        Collections.reverse(fruits);
        System.out.println("Reversed: " + fruits);

        System.out.println("\n=== Looping ===");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }

        System.out.println("\n=== Utility Methods ===");
        System.out.println("Is empty: " + fruits.isEmpty());

        ArrayList<String> copy = new ArrayList<>(fruits);
        System.out.println("Copy: " + copy);

        fruits.clear();
        System.out.println("After clear: " + fruits);
        System.out.println("Is empty now: " + fruits.isEmpty());
    }
}
