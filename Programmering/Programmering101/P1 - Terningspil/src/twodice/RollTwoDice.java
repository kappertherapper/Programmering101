package twodice;

import java.util.Scanner;

import static onedie.RollOneDie.rollDie;

public class RollTwoDice {
        private static int rollCount = 0;
        private static int sum = 0;
         private static int sameCount = 0;

         private static int biggestboi = 0;

         private static int[] eyeCount = new int [6];

        public static void main(String[] args) {
            System.out.println("Welcome to the game of Roll to dice");
            printRules();
            System.out.println();

            playTwoDice();

            System.out.println();
            System.out.println("Thank you for rolling the dice");
        }

        private static void printRules() {
            System.out.println("=====================================================");
            System.out.println("Rules of RollOneDie:");
            System.out.println("The player throws one die as long as he/she wants.");
            System.out.println("=====================================================");
        }

        private static void playTwoDice() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Roll? ('no' stops) ");
            String answer = scanner.nextLine();
            while (!answer.equals("no")) {
                int[] faces = rollDice();
                for (int face : faces)

                System.out.println("Eyes: " + face);
                System.out.println();
                sum += sumDice(faces);


                updateStatistics(faces, sum);
                sumDice(faces);

                System.out.print("Roll? ('no' stops) ");
                answer = scanner.nextLine();
            }

            printStatistics();
            scanner.close();
        }

        public static int sumDice(int[] dice) {
            int sum = 0;
            for (int die : dice) {
                sum += die;
            }
            return sum;
        }

        public static int[] rollDice()  {
            int[] terning = new int[2];
            terning[0] = (int) (Math.random() * 6 + 1);
            terning[1] = (int) (Math.random() * 6 + 1);

            return terning;
        }

        private static void updateStatistics(int[] face, int sum) {
            rollCount++;
            if (face[0] == face[1]) {
                sameCount++;
            }

            sum = face[0] + face[1];
            if (sum > biggestboi) {
                biggestboi = sum;


            }
            for (int eye : face) {
                eyeCount[eye-1] += 1;

            }
        }

        private static void printStatistics() {
            System.out.println("\nResults:");
            System.out.println("-------");
            System.out.printf("%17s %4d\n", "Roll count:", rollCount);
            System.out.printf("%17s %4d\n", "Sum :", sum);
            System.out.printf("%17s %4d\n", "Same number count: ", sameCount);
            System.out.printf("%17s %4d\n", "The biggest boi is: ", biggestboi);
            System.out.println("1 2 3 4 5 6 ");

            for (int eye : eyeCount) {
                System.out.print(eye + " ");
            }
        }
    }
