package Opgaver;

import java.util.Scanner;

public class opg3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter some numbers between 1..99 (end with 0): ");

        int number = input.nextInt();

        if (number == 0) {
            System.out.println("Listen you motherfucker, u cant just enter 0..");
            return;

        }
        int max = number;
        int count = 0;
        while (number != 0) {
            if (number > max) {
                max = number;
                count = 1;

            } else if (number == max) {
                count++;

            }
            number = input.nextInt();
        }
        System.out.println();
        System.out.println("The largest number is: " + max);
        System.out.println("The count of largest numbers is: " + count);
    }
}
