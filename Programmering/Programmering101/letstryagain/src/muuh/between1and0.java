package muuh;

import java.util.Scanner;

public class between1and0 {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        System.out.println("First number: ");
        double first = input.nextDouble();
        System.out.println("Second number: ");
        double Second = input.nextDouble();

        if (first > 0 && first < 1 && Second > 0 && Second < 1 ) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
