package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class exercise5b {
    public static void main(String[] args) {
        int[] c = new int[50];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers between 0-50 boss (End with 0): ");

        int num = input.nextInt();

        while (num != 0) {
        if (num >= 1 && num <= 50) {
        c[num - 1]++;

         }
        num = input.nextInt();
    }

        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
            }

            System.out.println((i+1) + " occurs " + c[i] + " times ");

        }
    }
}
