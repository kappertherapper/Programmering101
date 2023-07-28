package Opgaver;

import java.util.Scanner;

public class opgave3a {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Indsæt en række tal (slut med 0): ");

        int biggest = 0;
        int lowest = 100;
        int ligeTal = 0;
        int uligeTal = 0;


         for (int numbers = input.nextInt(); numbers != 0;) {

            if (numbers > biggest)
                biggest = numbers;

            if (numbers < lowest)
                lowest = numbers;

            if (numbers % 2 == 0)
                ligeTal++;

            if (numbers % 2 != 0)
                uligeTal++;


            numbers = input.nextInt();

        }
        System.out.println("Lige tal: " + ligeTal);
        System.out.println("Ulige tal: " + uligeTal);
        System.out.println("Highest number: " + biggest);
        System.out.println("Lowest number: " + lowest);
    }
}
