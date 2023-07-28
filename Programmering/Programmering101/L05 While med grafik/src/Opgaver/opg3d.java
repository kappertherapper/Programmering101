package Opgaver;

import java.util.Scanner;

public class opg3d {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter some numbers between 1..99 (end with 0): ");


        int lastRead = 0;
        int count = 1;
        int number = input.nextInt();
        while (number != 0) {
            if (number == lastRead) {
                count++;

            } else {
                if (count > 1) System.out.println(lastRead + " ");
                lastRead = number;
                count = 1;

                }
                number = input.nextInt();
            }
           if (count > 1) {
               System.out.println(lastRead + " ");
           }
        }
    }

