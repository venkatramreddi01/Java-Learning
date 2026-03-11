package _06_file_read_write;

import java.io.*;
import java.util.Scanner;

public class FileReadWrite {

    public static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)){
            writer.write(content);
            System.out.println("Successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void readFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            System.out.println("\n=== File Contents ===");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        }
    }

    public static void appendToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(content);
            System.out.println("Successfully appended to " + filename);
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "output.txt";

        while (true) {
            System.out.println("\n=== File Operations ===");
            System.out.println("1. Write to file");
            System.out.println("2. Read from file");
            System.out.println("3. Append to file");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();     // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter content to write: ");
                    String writeContent = scanner.nextLine();
                    writeToFile(filename, writeContent + "\n");
                    break;

                case 2:
                    readFromFile(filename);
                    break;

                case 3:
                    System.out.print("Enter content to append: ");
                    String appendContent = scanner.nextLine();
                    appendToFile(filename, appendContent + "\n");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
