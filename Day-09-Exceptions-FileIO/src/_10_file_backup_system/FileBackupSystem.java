package _10_file_backup_system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileBackupSystem {
    static String backupDir = "backups/";

    public static void createBackup(String sourceFile) {
        try {
            // Create backup directory if doesn't exist
            Files.createDirectories(Paths.get(backupDir));

            // Generate backup filename with timestamp
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String backupFile = backupDir + "backup_" + timestamp + "_" + new File(sourceFile).getName();

            // Copy file
            Files.copy(Paths.get(sourceFile), Paths.get(backupFile));

            System.out.println("Backup created: " + backupFile);
        } catch (NoSuchFileException e) {
            System.out.println("Error: Source file not found!");
        } catch (IOException e) {
            System.out.println("Error creating backup: " + e.getMessage());
        }
    }

    public static void listBackups() {
        File dir = new File(backupDir);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("No backups found!");
            return;
        }

        String[] backups = dir.list();

        if (backups == null || backups.length == 0) {
            System.out.println("No backups found!");
            return;
        }

        System.out.println("\n=== Available Backups ===");
        for (int i = 0; i < backups.length; i++) {
            File backup = new File(backupDir + backups[i]);
            System.out.println((i + 1) + ". " + backups[i] + " (" + backup.length() + " bytes)");
        }
    }

    public static void restoreBackup(String backupFile, String destination) {
        try {
            Files.copy(Paths.get(backupFile), Paths.get(destination), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File restored to: " + destination);
        } catch (NoSuchFileException e) {
            System.out.println("Error: Backup file not found!");
        } catch (IOException e) {
            System.out.println("Error restoring backup: " + e.getMessage());
        }
    }

    public static void deleteBackup(String backupFile) {
        try {
            Files.delete(Paths.get(backupFile));
            System.out.println("Backup deleted: " + backupFile);
        } catch (NoSuchFileException e) {
            System.out.println("Error:  Backup file not found!");
        } catch (IOException e) {
            System.out.println("Error deleting backup: " + e.getMessage());
        }
    }

    public static void compareFiles(String file1, String file2) {
        try {
            byte[] content1 = Files.readAllBytes(Paths.get(file1));
            byte[] content2 = Files.readAllBytes(Paths.get(file2));

            if (content1.length != content2.length) {
                System.out.println("Files are different (different sizes)");
                System.out.println(file1 + ": " + content1.length + " bytes");
                System.out.println(file2 + ": " + content2.length + " bytes");
                return;
            }

            boolean identical = true;
            for (int i = 0; i < content1.length; i++) {
                if (content1[i] != content2[i]) {
                    identical = false;
                    break;
                }
            }

            if (identical) {
                System.out.println("Files are identical!");
            } else {
                System.out.println("Files are different!");
            }

        } catch (IOException e) {
            System.out.println("Error comparing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== File Backup System ===");
            System.out.println("1. Create Backup");
            System.out.println("2. List Backups");
            System.out.println("3. Restore Backup");
            System.out.println("4. Delete Backup");
            System.out.println("5. Compare Files");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter file to backup: ");
                    String sourceFile = scanner.nextLine();
                    createBackup(sourceFile);
                    break;

                case 2:
                    listBackups();
                    break;

                case 3:
                    listBackups();
                    System.out.print("\nEnter backup filename: ");
                    String backupFile = backupDir + scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    restoreBackup(backupFile, destination);
                    break;

                case 4:
                    listBackups();
                    System.out.print("\nEnter backup filename to delete: ");
                    String deleteFile = backupDir + scanner.nextLine();
                    deleteBackup(deleteFile);
                    break;

                case 5:
                    System.out.print("Enter first file: ");
                    String file1 = scanner.nextLine();
                    System.out.print("Enter second file: ");
                    String file2 = scanner.nextLine();
                    compareFiles(file1, file2);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
