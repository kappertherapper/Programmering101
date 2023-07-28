package pigsgame;

import java.util.Scanner;

public class pigs3 {
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        playPig();

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
    private static void playPig() {
        Scanner snot = new Scanner(System.in);

        int player1 = 0;
        int player2 = 0;
        int finalscore = 100;

        while (player1 < finalscore && player2 < finalscore) {
            System.out.println(" player 1 score = " + player1);
            System.out.println("\n" + " player 2 score = " + player2);
            System.out.println("\n" + "They see me rolling, you rolling?");

            int player1score = playerturn("player1");
            player1 += player1score;
            if (player1score >= finalscore) {
                System.out.println("Player 1 WINSSSS");
                break;
            }

                int player2score = playerturn("player2");
                player2 += player2score;
                if (player2score >= finalscore) {
                    System.out.println("Player 2 WINSSSS");
                    break;

            }

        }


    }

    private static int playerturn(String playername) {
        Scanner input = new Scanner(System.in);

        int turnScore = 0;
        String blomst = input.nextLine();

        while (!blomst.equals("ost")) {

            int dice = rollDie();
            System.out.println(playername + ", rolled " + dice);
            if (dice == 1) {
                System.out.println(playername + " rolled " + dice + " - turn is over ");
                turnScore = 0;



                break;
            }
            turnScore += dice;
            System.out.println("\n" + "Roll again?");
            blomst = input.nextLine();

        }
        System.out.println();
        System.out.println(playername + " gets " + turnScore + " points this turn.");
        System.out.println();


        return turnScore;
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
}

