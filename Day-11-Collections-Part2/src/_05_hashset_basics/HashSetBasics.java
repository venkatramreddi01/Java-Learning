package _05_hashset_basics;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetBasics {
    public static void main(String[] args) {
        // Create HashSet
        HashSet<String> fruits = new HashSet<>();

        System.out.println("=== Adding Elements ===");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Apple");    // Duplicate - will be ignored!

        System.out.println("Fruits: " + fruits);
        System.out.println("Size: " + fruits.size());   // 4, not 5!

        System.out.println("\n=== Checking Elements ===");
        System.out.println("Contains Apple: " + fruits.contains("Apple"));
        System.out.println("Contains Grapes: " + fruits.contains("Grapes"));

        System.out.println("\n=== Removing ===");
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        System.out.println("\n=== Iterating ===");
        for (String fruit :  fruits) {
            System.out.println("- " + fruit);
        }

        System.out.println("\n=== Removing Duplicates from ArrayList ===");
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);
        numbers.add(5);

        System.out.println("Original list: " + numbers);

        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        System.out.println("Unique numbers: " + uniqueNumbers);

        // Convert back to ArrayList
        ArrayList<Integer> uniqueList = new ArrayList<>(uniqueNumbers);
        System.out.println("Back to ArrayList: " + uniqueList);

        System.out.println("\n=== Set Operations ===");
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Union
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Intersection
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Difference
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (Set1 - Set2): " + difference);

        System.out.println("\n=== Clear ===");
        fruits.clear();
        System.out.println("Is empty: " + fruits.isEmpty());

    }
}
