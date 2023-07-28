package Assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class exercise1 {

    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        try (Scanner scanner = new Scanner(System.in)) {

            int index = -1;
            while (index < 0 || index > 9) {
                System.out.println("Type in an index (0..9): ");
                index = scanner.nextInt();
                try {
                    System.out.printf("Prime at index %d is %d", index, primes[index]);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("please write an integer in 0..9");
                }
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("the index was not an integer");
            }
        }
    }
