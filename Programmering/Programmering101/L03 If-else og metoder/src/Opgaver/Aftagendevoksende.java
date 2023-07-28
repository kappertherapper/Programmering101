package Opgaver;

import java.util.Scanner;

/* Lav et program, der indlæser 3 heltal fra tastaturet og udskriver aftagende, hvis de
tre tal er i aftagende orden, voksende, hvis de tre tal er i voksende orden, eller
hverken-eller, hvis de ikke er voksende eller aftagende.

F.eks.
2 3 4 er voksende
4 3 2 er aftagende
3 4 2 er hverken-eller */

public class Aftagendevoksende {
    public static void main(String[] args) {
        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Ask for numbers
        System.out.print("Inset number one: ");
        int numberOne = input.nextInt();
        System.out.print("Inset number two: ");
        int numberTwo = input.nextInt();
        System.out.print("Inset number three: ");
        int numberThree = input.nextInt();

        // Algoritm
        if (numberOne < numberTwo && numberTwo < numberThree) {
            System.out.println("Numbers is rising");

        } else if  (numberOne > numberTwo && numberTwo > numberThree) {
            System.out.println("Numbers is decenting");

        } else if (numberOne < numberTwo && numberTwo > numberThree) {
            System.out.println("Numbers is either");

        }
    }
}
