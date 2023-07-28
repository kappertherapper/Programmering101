package Opgaver;

import java.util.Scanner;

public class AftagendeMetode {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Indsæt number 1: ");
        int numberOne = input.nextInt();
        System.out.print("Indsæt number 2: ");
        int numberTwo = input.nextInt();
        System.out.print("Indsæt number 3: ");
        int numberThree = input.nextInt();
        String result = order(numberOne, numberTwo, numberThree);
        System.out.println(result);

    }

    public static String order(int numberOne, int numberTwo, int numberThree) {
        String result = new String();

        if (numberOne < numberTwo && numberTwo < numberThree) {
            result = "Numbers is rising";

        } else if (numberOne > numberTwo && numberTwo > numberThree) {
            result = "Numbers is decenting";

        } else if (numberOne < numberTwo && numberTwo > numberThree) {
            result = "Numbers is either";

        }
        return result;
    }
}