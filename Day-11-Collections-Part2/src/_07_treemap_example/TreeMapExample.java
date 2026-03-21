package _07_treemap_example;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        System.out.println("=== TreeMap (Sorted by keys) ===");
        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(105, "Eve");
        students.put(102, "Bob");
        students.put(101, "Alice");
        students.put(104, "David");
        students.put(103, "Charlie");

        System.out.println("Students (sorted by roll number):");
        students.forEach((roll, name) ->
                System.out.println("Roll " + roll + ": " + name)
        );

        System.out.println("\n=== TreeMap Specific Methods ===");
        System.out.println("First entry: " + students.firstEntry());
        System.out.println("Last entry: " + students.lastEntry());
        System.out.println("First key: " + students.firstKey());
        System.out.println("Last key: " + students.lastKey());

        System.out.println("\n=== Navigation Methods ===");
        System.out.println("Higher key than 103: " + students.higherKey(103));
        System.out.println("Lower key than 103: " + students.lowerKey(103));
        System.out.println("Ceiling key (>=103): " + students.ceilingKey(103));
        System.out.println("Floor Key (<=103): " + students.floorKey(103));

        System.out.println("\n=== Submap ===");
        Map<Integer, String> subMap = students.subMap(102, 105);
        System.out.println("Students from roll 102 to 104: " + subMap);

        System.out.println("\n=== Use Case: Leaderboard ===");
        TreeMap<Integer, String> leaderboard = new TreeMap<>();

        leaderboard.put(950, "Player1");
        leaderboard.put(1200, "Player2");
        leaderboard.put(800, "Player3");
        leaderboard.put(1500, "Player4");
        leaderboard.put(1000, "Player5");

        System.out.println("Leaderboard (sorted by score):");
        leaderboard.descendingMap().forEach((score, player) ->
                System.out.println(player + ": " + score + " points")
        );

        System.out.println("\nTop 3 players:");
        int count = 0;
        for (Map.Entry<Integer, String> entry : leaderboard.descendingMap().entrySet()) {
            System.out.println((++count) + ". " + entry.getValue() + "- " + entry.getKey());
            if (count == 3) break;
        }
    }
}
