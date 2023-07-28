package muuh;

import java.util.Scanner;

public class ifAllSame {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        System.out.println("First number: ");
        int first = input.nextInt();
        System.out.println("Second number: ");
        int Second = input.nextInt();
        System.out.println("Third number: ");
        int third = input.nextInt();
        System.out.println("Fourth number: ");
        int Fourth = input.nextInt();

        if (Fourth == third && third == Second && Second == first) {
            System.out.println("Alle numbers are the same");

        } else {
            System.out.println("numbers are not the same");
        }
    }
}
