package _03_word_frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Word Frequency Counter ===");
        System.out.println("Enter text (type 'Done' to finish):");

        StringBuilder text = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("DONE")) break;
            text.append(line).append(" ");
        }

        // Convert to lowercase and split into words
        String[] words = text.toString().toLowerCase().split("\\s+");

        // Count frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            // Remove punctuation
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.isEmpty()) continue;

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n=== Word Frequencies ===");
        frequency.forEach((word, count) ->
                System.out.println(word + ": " + count)
        );

        // Find most frequent word
        String mostFrequent = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("\n=== Analysis ===");
        System.out.println("Total unique word: " + frequency.size());
        System.out.println("Total words: " + words.length);
        System.out.println("Most frequent word: " + mostFrequent + " (" + maxCount + " times)");

        scanner.close();
    }
}
