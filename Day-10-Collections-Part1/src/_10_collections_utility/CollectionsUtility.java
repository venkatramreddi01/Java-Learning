package _10_collections_utility;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsUtility {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);
        numbers.add(9);
        numbers.add(3);

        System.out.println("=== Original List ===");
        System.out.println(numbers);

        System.out.println("\n=== Sorting ===");
        Collections.sort(numbers);
        System.out.println("Sorted (ascending): " + numbers);

        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted (descending): " + numbers);

        System.out.println("\n=== Reverse ===");
        Collections.reverse(numbers);
        System.out.println("Reversed: " + numbers);

        System.out.println("\n=== Shuffle ===");
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers);

        System.out.println("\n=== Min and Max ===");
        System.out.println("Min: " + Collections.min(numbers));
        System.out.println("Max: " + Collections.max(numbers));

        System.out.println("\n=== Binary Search (must be sorted) ===");
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Index of 5: " + index);

        System.out.println("\n=== Frequency ===");
        numbers.add(5);
        numbers.add(5);
        System.out.println("List: " + numbers);
        System.out.println("Frequency of 5: " + Collections.frequency(numbers, 5));

        System.out.println("\n=== Fill ===");
        Collections.fill(numbers, 0);
        System.out.println("After fill(0): " + numbers);

        System.out.println("\n=== Rotation ===");
        ArrayList<String> words = new ArrayList<>();
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("D");
        words.add("E");

        System.out.println("Original: " + words);
        Collections.rotate(words, 2);
        System.out.println("After rotate(2): " + words);

        System.out.println("\n=== Swap ===");
        Collections.swap(words, 0, 4);
        System.out.println("After swap(0, 4): " + words);

        System.out.println("\n=== Copy ===");
        ArrayList<String> copy = new ArrayList<>(words);
        System.out.println("Copy: " + copy);

        System.out.println("\n=== Disjoint ===");
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(4);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);
        System.out.println("List1 and List2 disjoint: " + Collections.disjoint(list1, list2));
        System.out.println("List1 and List3 disjoint: " + Collections.disjoint(list1, list3));
    }
}
