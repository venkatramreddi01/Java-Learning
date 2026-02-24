package _10_tower_of_hanoi;

import java.util.Scanner;

public class TowerOfHanoi {

    static int moveCount = 0;

    // Solve Tower of Hanoi
    public static void solveTowerOfHanoi(int n, char source, char destination, char auxiliary){
        // Base case: only one disk
        if (n == 1) {
            moveCount++;
            System.out.println("Move " + moveCount + ": Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary using destination
        solveTowerOfHanoi(n - 1, source, auxiliary, destination);

        // Move the largest disk from source to destination
        moveCount++;
        System.out.println("Move " + moveCount + ": Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from auxiliary to destination using source
        solveTowerOfHanoi(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = scanner.nextInt();

        System.out.println("\nSolution for " + n + " disks:");
        System.out.println("Towers: A (source), B (auxiliary), C (destination)\n");

        moveCount = 0;
        solveTowerOfHanoi(n, 'A', 'C', 'B');

        System.out.println("\nTotal moves: " + moveCount);
        System.out.println("Minimum moves needed: " + (int)(Math.pow(2, n) - 1));

        scanner.close();
    }
}
