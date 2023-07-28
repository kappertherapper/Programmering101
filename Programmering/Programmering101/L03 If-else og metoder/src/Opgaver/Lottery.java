package Opgaver;

// Generate a lottery number (in 10..99)
// (as test, not in the finished program: Print the lottery number)
// Prompt the user for a guess of the lottery number
// Read the guess
// if (guess == lottery number)
//     print YOU WIN $10.000
// else if guess has the same digits as lottery number (in reversed order)
//     print YOU WIN $3.000
// else if guess has one of the digits in lottery number
//     print YOU WIN $1.000
// else
//     print SORRY, YOU LOOSE

import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Generate a lottery number (in 0..99)
        int lottery = (int) (Math.random() * 100);

        // Prompt the user for a guess of the lottery number
        System.out.print("Insert your guess: ");
        int guess = input.nextInt();

        int lottery1 = lottery / 10;
        int lottery2 = lottery % 10;

        int guess1 = guess / 10;
        int guess2 = guess % 10;

        System.out.println("Lottery Number is: " + lottery);

        // if (guess == lottery number)
        if (guess == lottery) {
        System.out.println("YOU WIN $10.000");

        // else if guess has the same digits as lottery number (in reversed order)
    } else if (guess1 == lottery2 && guess2 == lottery1) {
            System.out.println("YOU WIN $3.000");

            // else if guess has one of the digits in lottery number
        } else if (guess1 == lottery2 ||
                   guess2 == lottery1 ||
                   guess1 == lottery1 ||
                   guess2 == lottery2) {
            System.out.println("YOU WIN $1.000");

        }    else {
            System.out.println("SORRY, YOU LOOSE");


        }






    }
}
