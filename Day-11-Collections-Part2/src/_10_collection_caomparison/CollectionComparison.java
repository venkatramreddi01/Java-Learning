package _10_collection_caomparison;

import java.util.*;

public class CollectionComparison {
    public static void main(String[] args) {
        System.out.println("=== HASHMAP vs LINKEDHASHMAP vs TREEMAP");

        // HashMap
        System.out.println("HashMap (No Order):");
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("C", 3);
        hashmap.put("A", 1);
        hashmap.put("B", 2);
        System.out.println(hashmap);

        // LinkedHashMap
        System.out.println("\nLinkedHashMap (Insertion Order):");
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put("C", 3);
        linkedMap.put("A", 1);
        linkedMap.put("B", 2);
        System.out.println(linkedMap);

        // TreeMap
        System.out.println("\nTreeMap (Sorted by Key):");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 3);
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        System.out.println(treeMap);

        System.out.println("\n\n=== HASHSET vs LINKEDHASHSET vs TREESET ===\n");

        // HashSet
        System.out.println("HashSet (No Order):");
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(2);
        hashSet.add(8);
        hashSet.add(1);
        hashSet.add(2); // Duplicate ignored
        System.out.println(hashSet);

        // LinkedHashSet
        System.out.println("\nLinkedHashSet (Insertion Order):");
        LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(5);
        linkedSet.add(2);
        linkedSet.add(8);
        linkedSet.add(1);
        linkedSet.add(2);   // Duplicate ignored
        System.out.println(linkedSet);

        // TreeSet
        System.out.println("\nTreeSet (Sorted):");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(2); // Duplicate ignored
        System.out.println(treeSet);

        System.out.println("\n\n=== PERFORMANCE COMPARISON ===\n");

        int size = 100000;

        // HashMap Performance
        long start = System.nanoTime();
        HashMap<Integer, Integer> perfHashMap = new HashMap<>();
        for (int i = 0;  i < size; i++) {
            perfHashMap.put(i, i * 2);
        }

        long end = System.nanoTime();
        System.out.println("HashMap insertion time: " + (end - start) / 1000000 + " ms");

        // TreeMap performance
        start = System.nanoTime();
        TreeMap<Integer, Integer> perfTreeMap = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            perfTreeMap.put(i, i * 2);
        }
        end = System.nanoTime();
        System.out.println("TreeMap insertion time: " + (end - start) / 1000000 + " ms");

        System.out.println("\n\n=== WHEN TO USE WHAT ===\n");

        System.out.println("Use HashMap when:");
        System.out.println(" - Default choice for key-value storage");
        System.out.println(" - Don't care about order");
        System.out.println(" - Need fastest performance");

        System.out.println("\nUse LinkedHashMap when:");
        System.out.println(" - Need insertion order");
        System.out.println(" - Building cache systems");
        System.out.println(" - History tracking");

        System.out.println("\nUse TreeMap when:");
        System.out.println(" - Need sorted keys");
        System.out.println(" - Range queries needed");
        System.out.println(" - First/last operations");

        System.out.println("\nUse HashSet when:");
        System.out.println(" - Need unique elements");
        System.out.println(" - Don't care about order");
        System.out.println(" - Fastest uniqueness check");

        System.out.println("\nUse LinkedHashSet when:");
        System.out.println(" - Need unique + insertion order");
        System.out.println(" - Maintaining order matters");

        System.out.println("\nUse TreeSet when:");
        System.out.println(" - Need unique + sorted");
        System.out.println(" - Navigation operations");
        System.out.println(" - Range queries on unique elements");
    }
}
