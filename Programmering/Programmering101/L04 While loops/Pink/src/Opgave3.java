import java.util.Scanner;

//Write a method that computes the sum of the digits in an integer. Use the following method header:
// public static int sumDigits(double n)
//For example, sumDigits(234) returns 9 (= 2 + 3 + 4).
// (Hint: Use the % op- erator to extract digits and the / operator to remove the extracted digit.
// For in- stance, to extract 4 from 234, use 234 % 10 (= 4).
// To remove 4 from 234, use 234 / 10 (= 23).
// Use a loop to repeatedly extract and remove the digit until all the digits are extracted.
// Write a test program that prompts the user to enter an integer then displays the sum of all its digits.


public class Opgave3 {
    public static void main(String[] args) {
        //Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Input digits: ");
        double n = input.nextInt();
        System.out.println("Result of your digits: " + sumDigits(n));

    }

    public static int sumDigits(double n) {

        double sum = 0;
        double differ = n % 10;
        double count = 0;
        while (count < 10) {
            sum = n + differ;
            n = n / 10;
            count++;

        }


        return (int) sum;
    }
}