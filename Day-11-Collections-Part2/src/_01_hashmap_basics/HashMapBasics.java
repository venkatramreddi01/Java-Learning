package _01_hashmap_basics;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasics {
    public static void main(String[] args) {
        // Create HashMap
        HashMap<String, Integer> fruitPrices = new HashMap<>();

        System.out.println("=== Adding Key-Value Pairs ===");
        fruitPrices.put("Apple", 50);
        fruitPrices.put("Banana", 30);
        fruitPrices.put("Orange", 40);
        fruitPrices.put("Mango", 80);
        System.out.println("Fruit Prices: " + fruitPrices);

        System.out.println("\n=== Accessing Values ===");
        System.out.println("Apple price: " + fruitPrices.get("Apple"));
        System.out.println("Mango price: " + fruitPrices.get("Mango"));

        System.out.println("\n=== Checking Keys and Values ===");
        System.out.println("Contains 'Apple': " + fruitPrices.containsKey("Apple"));
        System.out.println("Contains 'Grapes': " + fruitPrices.containsKey("Grapes"));
        System.out.println("Contains value 30: " + fruitPrices.containsValue(30));

        System.out.println("\n=== Size ===");
        System.out.println("Size: " + fruitPrices.size());

        System.out.println("\n=== Updating Values ===");
        fruitPrices.put("Apple", 60);   // Update existing
        System.out.println("Updated Apple: " + fruitPrices.get("Apple"));

        fruitPrices.replace("Banana", 35);
        System.out.println("Updated Banana: " + fruitPrices.get("Banana"));

        System.out.println("\n=== Get or Default ===");
        int grapePrice = fruitPrices.getOrDefault("Grapes", 0);
        System.out.println("Grapes price (with default): " + grapePrice);

        System.out.println("\n=== Iterating - Method 1: keySet() ===");
        for (String fruit : fruitPrices.keySet()) {
            System.out.println(fruit + " costs " + fruitPrices.get(fruit));
        }

        System.out.println("\n=== Iterating - Method 2: entrySet() ===");
        for (Map.Entry<String, Integer> entry : fruitPrices.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\n=== Iterating - Method 3: forEach ===");
        fruitPrices.forEach((fruit, price) ->
                System.out.println(fruit + ": ₹" + price)
        );

        System.out.println("\n=== Removing ===");
        fruitPrices.remove("Banana");
        System.out.println("After removing Banana: " + fruitPrices);

        System.out.println("\n=== Getting keys and Values ===");
        System.out.println("All keys: " + fruitPrices.keySet());
        System.out.println("All values: " + fruitPrices.values());

        System.out.println("\n=== Clear ===");
        fruitPrices.clear();
        System.out.println("After clear: " + fruitPrices);
        System.out.println("Is empty: " + fruitPrices.isEmpty());


    }
}
