package _08_treeset_example;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        System.out.println("=== TreeSet (Sorted + Unique) ===");
        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(20);
        numbers.add(80);
        numbers.add(10);
        numbers.add(60);
        numbers.add(20);    // Duplicate - ignored

        System.out.println("Numbers: " + numbers);  // Automatically sorted!

        System.out.println("\n=== TreeSet Specific Methods ===");
        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());

        System.out.println("\n=== Navigation ===");
        System.out.println("Higher than 50: " + numbers.higher(50));
        System.out.println("Lower than 50: " + numbers.lower(50));
        System.out.println("Ceiling (>=55): " + numbers.ceiling(55));
        System.out.println("Floor (<=55): " + numbers.floor(55));

        System.out.println("\n=== Subset Operations ===");
        System.out.println("Numbers less than 60: " + numbers.headSet(60));
        System.out.println("Numbers greater than or equal to 50: " + numbers.tailSet(50));
        System.out.println("Numbers between 20 and 80: " + numbers.subSet(20, 80));

        System.out.println("\n=== Polling (Remove and Return) ===");
        System.out.println("Poll first: " + numbers.pollFirst());   // Removes 10
        System.out.println("Poll last: " + numbers.pollLast());     // Removes 80
        System.out.println("After polling: " + numbers);

        System.out.println("\n=== Descending Order ===");
        TreeSet<Integer> descending = (TreeSet<Integer>) numbers.descendingSet();
        System.out.println("Descending: " + descending);

        System.out.println("\n=== Use Cas: Priority System ===");
        TreeSet<String> tasks = new TreeSet<>();
        tasks.add("High-Fix bug");
        tasks.add("Low-Update docs");
        tasks.add("Medium-Review code");
        tasks.add("High-Deploy app");
        tasks.add("Medium-Test feature");

        System.out.println("Tasks (sorted by priority):");
        for (String task : tasks) {
            System.out.println("- " + task);
        }

        System.out.println("\n=== Use Case: Exam Scores (Sorted) ===");
        TreeSet<Double> scores = new TreeSet<>();
        scores.add(85.5);
        scores.add(92.3);
        scores.add(78.9);
        scores.add(95.1);
        scores.add(88.1);

        System.out.println("All scores (ascending): " + scores);
        System.out.println("Highest score: " + scores.last());
        System.out.println("Lowest score: " + scores.first());
        System.out.println("Scores above 90: " + scores.tailSet(90.0));
    }
}
