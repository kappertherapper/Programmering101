package Opgaver;

import java.util.Scanner;

public class sign {
    public static void main(String[] args) {

        //Create a scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Indsæt number ");
        int number = input.nextInt();
        String result = sign(number);
        System.out.println(result);


    }

    public static String sign(int number) {
        String result = new String();

        // Find out if number is positiv, = 0, negativ

        if (number > 0)
            result = "Number is positiv";

        else if (number == 0)
            result = "Number is = 0";

            else if (number < 0)
                result = "Number is negativ";

            return result;
        }
    }