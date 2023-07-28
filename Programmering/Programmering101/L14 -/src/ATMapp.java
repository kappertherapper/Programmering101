/*
    Use the Account class created in Programming Exercise
    9.7 to simulate an ATM machine. Create ten accounts in an array with id
    0, 1, . . . , 9, and initial balance $100. The system prompts the user to enter an
    id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id
    is accepted, the main menu is displayed as shown in the sample run. You can
    enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
    depositing money, and 4 for exiting the main menu. Once you exit, the system
    will prompt for an id again. Thus, once the system starts, it will not stop.
*/

import java.util.Scanner;

public class ATMapp {

    //Scanner
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //Account 1-10
        account[] accounts = new account[10];
        for (int i = 1; i < 11; i++) {
            accounts[i - 1] = new account(i, 100);
        }

        System.out.println("Enter Account id? (1 - 10): ");
        int id = input.nextInt();

        if (id < 1 || id > 10) {
            id = incorrectid(id);

        }
        while (true) {
            menuDisplay();
            System.out.println("\n" + "Pick from the menu: ");
            int choise = input.nextInt();

            //Balance
            if (choise == 1) {
                System.out.println("\n" + "Balance on the account is: " + accounts[id-1].getBalance());
                id = input.nextInt();
            }

            //Withdraw
            if (choise == 2) {
                System.out.println("\n" + "Enter the amount u want to withdraw");
                accounts[id - 1].withdraw(input.nextDouble());
            }

            //Deposit
            if (choise == 3) {
                System.out.println("\n" + "Enter the amount u want to deposit");
                accounts[id - 1].deposit(input.nextDouble());
            }

            //Exit
            if (choise == 4) {
                System.out.println("\n" + "Enter Account id? (1 - 10): ");
                id = input.nextInt();
            }

            //incorrect
            if (id < 1 || id > 10) {
                id = incorrectid(id);

            }
            //menuchoise(id, choise, accounts);
        }
    }
    public static int incorrectid(int id) {
        while (id < 1 || id > 10) {
            System.out.println("Please enter the correct id");
            id = input.nextInt();
            System.out.println();

        }
        return id;
    }

    //public static void menuchoise(int id, int choise, account[] accounts){


    public static void menuDisplay() {
        System.out.println("Main menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
    }
}
