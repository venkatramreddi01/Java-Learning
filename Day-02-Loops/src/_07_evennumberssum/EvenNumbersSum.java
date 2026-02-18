package _07_evennumberssum;

public class EvenNumbersSum {
    public static void main(String[] args){
        int sum = 0;

        for(int i = 1; i <= 50; i++){
            if(i % 2 != 0) {
                continue;   // Skips odd numbers
            }
            System.out.print(i + ", ");
            sum += i;
        }
        System.out.println("\nThe sum of even numbers from 1 to 50 is " + sum);
    }
}
