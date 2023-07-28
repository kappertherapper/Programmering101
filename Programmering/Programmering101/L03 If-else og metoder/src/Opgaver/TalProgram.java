package Opgaver;

import java.util.Scanner;

/* Lav et program, der indlæser et heltal fra tastaturet og udskriver negativ, 0 eller
positiv, afhængig af om det indlæste tal er <, == eller > end 0. */

public class TalProgram {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Ask for a number
        System.out.print("Insert a number: ");
        int number = input.nextInt();

        // Find out if number is positiv, = 0, negativ
        if (number > 0) {
            System.out.println("Number is positiv "); }

            else if (number == 0) {
                System.out.println("Number is = 0 "); }

            else if (number < 0) {
                    System.out.println("Number is negativ "); }

        }
    }
