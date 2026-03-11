package _07_file_operations;

import java.io.File;
import java.io.IOException;

public class FileOperations {

    public static void displayFileInfo(String filename) {
        File file = new File(filename);

        System.out.println("\n=== File Information ===");
        System.out.println("File name: " +file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());

        if (file.exists()) {
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Can write: " + file.canWrite());
            System.out.println("Size: " + file.length() + "bytes");
        }
    }

    public static void createFile(String filename) {
        File file = new File(filename);
        try {
            if (!file.createNewFile()) {
                System.out.println("File created: " + filename);
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " +e.getMessage());
        }
    }

    public static void deleteFile(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            System.out.println("File deleted: " + filename);
        } else {
            System.out.println("Failed to delete file or file doesn't exist");
        }
    }

    public static void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);

        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed from " + oldName + " to " + newName);
        } else {
            System.out.println("Failed to rename file");
        }
    }

    public static void listDirectory(String dirPath) {
        File dir = new File(dirPath);

        if (dir.isDirectory()) {
            System.out.println("\n=== Directory Contents ===");
            String[] files = dir.list();

            if (files != null) {
                for (String file : files) {
                    File f = new File(dir, file);
                    String type = f.isDirectory() ? "[DIR]" : "[FILE]";
                    System.out.println(type + " " + file);
                }
            }
        } else {
            System.out.println("Not a directory!");
        }
    }

    public static void main(String[] args) {
        String testFile = "Test.txt";

        System.out.println("=== Creating File ===");
        createFile(testFile);

        displayFileInfo(testFile);

        System.out.println("\n=== Listing Current Directory ===");
        listDirectory(".");

        System.out.println("\n=== Renaming File ===");
        renameFile(testFile, "renamed.txt");

        displayFileInfo("renamed.txt");

        System.out.println("\n=== Deleting File ===");
        deleteFile("renamed.txt");
    }

}
