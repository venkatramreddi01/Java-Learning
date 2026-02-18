package _05_starpattern;

public class StarPattern {
    public static void main(String[] args){
        int rows = 5;

        // Outer loop for rows
        for(int i = 1; i <= rows; i++){
            // Inner loop for stars in each row
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();   // New line after each row
        }
    }
}
