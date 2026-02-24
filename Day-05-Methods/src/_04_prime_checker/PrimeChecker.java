package _04_prime_checker;

import java.util.Scanner;

public class PrimeChecker {

    public static boolean isPrime(int num) {
        if (num <= 1){
            return false;
        }
        for(int i = 2; i < Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void printPrimesInRange(int start, int end) {
        System.out.println("Prime numbers between " + start + " and " + end + ":");
        for(int i = start; i <= end; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if(isPrime(num)) {
            System.out.println(num + " is a prime number!");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }

        System.out.println();
        printPrimesInRange(1, 50);

        scanner.close();
    }

}
