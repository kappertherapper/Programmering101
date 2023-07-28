package Opgaver;

import java.util.Scanner;

public class Opg1b {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        int nextNumber = 0;


        System.out.print("Indsæt en række tal: ");

        int numbers = input.nextInt();
        while (numbers != 0) {
            nextNumber = numbers + nextNumber;


            System.out.println(nextNumber);
            numbers = input.nextInt();
        }
    }
}
