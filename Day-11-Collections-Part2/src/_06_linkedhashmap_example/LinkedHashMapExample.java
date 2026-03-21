package _06_linkedhashmap_example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        System.out.println("=== HashMap (No Order) ===");
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("Zebra", 1);
        hashmap.put("Apple", 2);
        hashmap.put("Mango", 3);
        hashmap.put("Banana", 4);

        System.out.println("HashMap:");
        hashmap.forEach((key, value) ->
                System.out.println(key + " = " + value)
        );

        System.out.println("\n=== LinkedHashMap (Insertion Order) ===");
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("Zebra", 1);
        linkedMap.put("Apple", 2);
        linkedMap.put("Mango", 3);
        linkedMap.put("Banana", 4);

        System.out.println("LinkedHashMap:");
        linkedMap.forEach((key, value) ->
                System.out.println(key + " = " + value)
        );

        System.out.println("\n=== Use Case: Recent Items Cache ===");
        LinkedHashMap<String, String> cache = new LinkedHashMap<>(5, 0.75f, true);

        cache.put("page1", "Home");
        cache.put("page2", "About");
        cache.put("page3", "Contact");
        cache.put("page4", "Services");
        cache.put("page5", "Blog");

        System.out.println("Initial cache: " + cache);

        // Access page2 - moves to end
        cache.get("page2");
        System.out.println("After accessing page2: " + cache);

        // Access page4 - moves to end
        cache.get("page4");
        System.out.println("After accessing page4: " + cache);

        System.out.println("\n=== Browser History Simulation ===");
        LinkedHashMap<Integer, String> history = new LinkedHashMap<>();

        history.put(1, "google.com");
        history.put(2, "github.com");
        history.put(3,"stackoverflow.com");
        history.put(4, "linkedin.com");

        System.out.println("Browse history (in order):");
        for (Map.Entry<Integer, String> entry :  history.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
}
