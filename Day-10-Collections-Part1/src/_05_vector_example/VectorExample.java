package _05_vector_example;

import java.util.Enumeration;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        System.out.println("=== Initial Capacity ===");
        System.out.println("Capacity: " + vector.capacity());   // Default 10
        System.out.println("Size: " + vector.size());

        System.out.println("\n=== Adding Elements ===");
        for (int i = 1; i <= 12; i++) {
            vector.add(i * 10);
        }
        System.out.println("Vector: " + vector);
        System.out.println("Capacity after adding 12 elements: " + vector.capacity());
        System.out.println("Size: " + vector.size());

        System.out.println("\n=== Accessing ===");
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());
        System.out.println("Element at 5: " + vector.elementAt(5));

        System.out.println("\n=== Searching ===");
        System.out.println("Contains 50: " + vector.contains(50));
        System.out.println("Index of 70: " + vector.indexOf(70));

        System.out.println("\n=== Legacy Methods ===");
        vector.addElement(130);     // Legacy add
        vector.insertElementAt(25, 2);  // Insert at index
        System.out.println("After legacy operations: " + vector);

        System.out.println("\n=== Enumeration (old-style iteration) ===");
        Enumeration<Integer> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement() + " ");
        }

        System.out.println("\n\n=== Removing ===");
        vector.remove(0);   // Remove by index
        vector.removeElement(50);   // Remove by value
        System.out.println("After removal: " +vector);

        System.out.println("\n=== Comparison ===");
        System.out.println("Vector is synchronized (thread-safe)");
        System.out.println("ArrayList is not synchronized (faster)");
        System.out.println("Use Vector only in multi-threaded scenarios");
    }
}
