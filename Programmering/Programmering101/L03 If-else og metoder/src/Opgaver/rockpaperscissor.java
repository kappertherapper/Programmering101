package Opgaver;

import java.util.Scanner;

public class rockpaperscissor {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        int computerChoice = (int) (Math.random() * 3);
        System.out.println("Test: Computer choice is " + computerChoice);

        int userChoice = input.nextInt();

        // Block
        if (userChoice < 0 || userChoice > 2) {
            System.out.println("You must choose 0, 1 or 2");
        }

        String result = calcResult(userChoice, computerChoice);
        System.out.println(result);

    }

    public static String calcResult(int userNo, int computerNo) {
        String result;

        if (userNo == computerNo) {
            result = "Computer is " + noToName(computerNo) + "You are" + noToName(userNo) + "It is a draw";
        }
        return calcResult(userNo, computerNo);
    }


    public static String noToName(int no) {
        String name;
        if (no == 0) name = "Scissors";
        else if (no == 1) name = "Rock";
        else name = "paper";

        return name;

    }


}

