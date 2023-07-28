package pigsgame;

import java.util.Scanner;

public class Pigs {
    private static int rollCount = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollOneDie");
        printRules();
        System.out.println();

        PlayPig();
        //PlayPig2();


        System.out.println();
        System.out.println("Thank you for playing Pigs");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pig:");
        System.out.println("First player -kaster- the die, until hitting 1 or decides to stop");
        System.out.println("Same goes for secound player");
        System.out.println("when deciding to stop, the points from the round, gets summed up");
        System.out.println("first to 100, wins");
        System.out.println("=====================================================");
    }

    private static void PlayPig() {
        Scanner input = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = input.nextLine();
        while (!answer.equals("no")) {

            input.nextLine();
            int eyes = rollDie();
            rollDie();
            System.out.println("Eyes: " + eyes);
            answer = input.nextLine();
        }
        input.close();
    }

    private static void PlayPig2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll the dice: ");
        scanner.nextLine();

        int eyes = rollDie();
        rollDie();
        System.out.println("Eyes: " + eyes);

    }

    public static int rollDie() {

        return (int) (Math.random() * 6 + 1);

    }

    public static int sumDice(int[] dice) {
        int sum = 0;
        for (int die : dice) {
            sum += die;
        }
        return sum;
    }

    private static void updateStatistics(int face) {
        rollCount++;

    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        //System.out.printf("%17s %4d\n", "Roll count:", rollCount);
    }
}
