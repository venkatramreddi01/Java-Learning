package _06_arraylist_vs_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {
    public static void testArrayList() {
        ArrayList<Integer> list = new ArrayList<>();

        // Add elements
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println("ArrayList add: " + (end- start) / 1000000 + " ms");

        // Get elements(random access)
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList get: " + (end - start) / 1000000 + " ms");

        // Insert in middle
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);     // Add at beginning
        }
        end = System.nanoTime();
        System.out.println("ArrayList insert at start: " + (end - start) / 1000000 + " ms");
    }

    public static void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        long start = System.nanoTime();
        for (int i = 0; i< 100000; i++) {
            list.add(i);
        }
        long end = System.nanoTime();
        System.out.println("LinkedList add: " + (end - start) / 1000000 + " ms");

        // Get elements (sequential access)
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList get: " + (end - start) / 1000000 + " ms");
        
        // Insert at beginning
        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            list.addFirst(i);   // Add at beginning
        }
        end = System.nanoTime();
        System.out.println("LinkedList insert at start: " + (end - start) / 1000000 + " ms");
    }

    public static void main(String[] args) {
        System.out.println("=== Performance Comparison ===\n");

        System.out.println("ArrayList:");
        testArrayList();

        System.out.println("\nLinkedList:");
        testLinkedList();

        System.out.println("\n=== Conclusions ===");
        System.out.println("ArrayList: Fast random access, slow insertion at start");
        System.out.println("LinkedList: Slow random access, fast insertion at start/end");
        System.out.println("\nUse ArrayList: Most cases (default choice)");
        System.out.println("Use LinkedList: Frequent insertions/deletions at start/end");
    }
}
