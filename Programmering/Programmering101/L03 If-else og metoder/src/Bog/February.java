package Bog;
import java.util.Scanner;

public class February {
    public static void main(String[] args) {
        //creats scanner
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        //check if the year is a leap year
        boolean isLeapYear =
                (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Display the result
        System.out.println(year + " is a leap year? " + isLeapYear);
    }
}
