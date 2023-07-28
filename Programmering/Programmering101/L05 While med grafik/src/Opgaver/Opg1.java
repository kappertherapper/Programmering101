package Opgaver;

import java.util.Scanner;

public class Opg1 {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Indsæt en række tal: ");

        int biggest = 0;
        int lowest = 100;
        int ligeTal = 0;
        int uligeTal = 0;

        int numbers = input.nextInt();
        while (numbers != 0) {


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

