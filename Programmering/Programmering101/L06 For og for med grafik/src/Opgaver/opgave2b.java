package Opgaver;

import java.util.Scanner;

public class opgave2b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter upper limit ");
        int lowerLimit = input.nextInt();
        System.out.print("Enter lower limit ");
        int upperLimit = input.nextInt();

        int result = opgb(lowerLimit, upperLimit);
        System.out.println("Alle lige tal er: " + result);


    }

    public static int opgb(int a, int b) {

            int sum = 0;
            for (int tal = a; tal <= b; tal++) {
            if (tal % 2 == 0) {
                sum += tal;
            }



        }
        return sum;
    }
}

