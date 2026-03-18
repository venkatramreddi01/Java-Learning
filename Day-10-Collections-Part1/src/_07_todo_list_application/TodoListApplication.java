package _07_todo_list_application;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean completed;
    String priority;

    Task(String description, String priority) {
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    void display(int index) {
        String status = completed ? "[✓]" :"[ ]";
        System.out.println((index + 1) + ". " + status + " " + description + " [" + priority + "]");
    }
}

public class TodoListApplication {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        tasks.add(new Task(description, priority));
        System.out.println("Task added!");
    }

    public static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
            return;
        }

        System.out.println("\n=== To-Do List ===");
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).display(i);
        }
    }

    public static void markComplete() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to mark complete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).completed = true;
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public static void deleteTask() {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter task number to delete: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public static void viewByPriority() {
        System.out.print("Enter priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        System.out.println("\n=== " + priority + " Priority Tasks ===");
        boolean found = false;

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).priority.equals(priority)) {
                tasks.get(i).display(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks with " + priority + " priority!");
        }
    }

    public static void statistics() {
        int total = tasks.size();
        int completed = 0;
        int pending = 0;

        for (Task task: tasks) {
            if (task.completed) completed++;
            else pending++;
        }

        System.out.println("\n=== Statistics ===");
        System.out.println("Total tasks: " + total);
        System.out.println("Completed: " + completed);
        System.out.println("Pending: " + pending);

        if (total > 0) {
            double percentage = (double) (completed * 100) / total;
            System.out.printf("Completed: %.1f%%\n", percentage);
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. View Tasks by Priority");
            System.out.println("6. Statistics");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addTask(); break;

                case 2: viewTasks(); break;

                case 3: markComplete(); break;

                case 4: deleteTask(); break;

                case 5: viewByPriority(); break;

                case 6: statistics(); break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
