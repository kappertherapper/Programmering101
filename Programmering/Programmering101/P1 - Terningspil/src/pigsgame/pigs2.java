package pigsgame;

import java.util.Scanner;

public class pigs2 {
    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pigs");
        printRules();
        System.out.println();

        PlayPig();
        PlayerTwo();

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
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0;
        int playerTotal = 0;
        int dice;

        boolean gameOver = false;
        boolean turnOver = false;
        String shiftturn = scanner.nextLine();

        while (gameOver == false) {
            do { //Rolls dice
                System.out.println("\n" + "Roll the dice: ");
                scanner.nextLine();

                dice = rollDie();
                System.out.println("Eyes: " + dice);

                //vurdere om tur er over - er slag 1, tur over
                // ligger til total
            } while (turnOver == false || dice != 1);

            playerTotal += playerScore;
            System.out.println("Your score is " + playerTotal);

            //hvis total rammer 100, win
            if (playerTotal >= 100) {
                System.out.println("YOU WIN!");
                gameOver = true;
                PlayerTwo();

                //Hvis 1 = tabt
                if (dice == 1) {
                    playerScore = 0;
                    System.out.print("You lose your turn! ");
                    System.out.println("Your total is " + playerTotal);
                    turnOver = true;

                    //h = hold
                    if ((!shiftturn.equals("h"))) {
                        turnOver = true;

                        // reset af playerscore
                        if (turnOver = true) ;
                        {
                            playerScore = 0;

                        }


                    } else {
                        playerScore += dice;
                        System.out.print("Your turn score is " + playerScore);
                        System.out.println(" If you hold you will have " + playerTotal + " points.");
                        System.out.println("Press enter to roll again," + "'h' to hold.");

                        // while (!shiftturn.equals("h"));
                        // turnOver = true;

                    }


                }
            }
        }
    }

        // ROUND SHIFT
        public static void PlayerTwo () {

            Scanner bloom = new Scanner(System.in);
            int PlayerTwoScore = 0;
            int PlayerTwoTotal = 0;
            int dice;

            boolean gameOver = false;
            boolean turnOver = false;

            String shiftturn = bloom.nextLine();


            System.out.println();
            System.out.println("It is player 2's turn.");

            do {
                System.out.println("\n" + "Roll the dice: ");
                bloom.nextLine();

                dice = rollDie();
                rollDie();
                System.out.println("Eyes: " + dice);

                if (dice == 1) {
                    PlayerTwoScore = 0;
                    System.out.print("You lose your turn!");
                    System.out.print("Your total is " + PlayerTwoTotal);
                    turnOver = true;

                } else {
                    PlayerTwoScore += dice;
                    System.out.print("Your turn score is " + PlayerTwoTotal);
                    System.out.println(" If you hold you will have " + PlayerTwoTotal + " points.");
                    System.out.println("Press enter to roll again or 'h' to hold.");

                    // if (!shiftturn.equals("h"));
                    // turnOver = true;

                }
            } while (turnOver == false || dice != 1);
            PlayerTwoTotal += PlayerTwoScore;
            System.out.println("Your score is " + PlayerTwoTotal);
            PlayerTwoScore = 0;
            if (PlayerTwoTotal >= 100) {
                System.out.println("YOU WIN!");
                gameOver = true;
            }

        }


        public static int rollDie() {
            return (int) (Math.random() * 6 + 1);
        }
    }

