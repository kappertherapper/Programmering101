package Opgaver;

// (Find future dates) Write a program that prompts the user to enter an integer for today’s day of the week
// (Sunday is 0, Monday is 1, . . . , and Saturday is 6).
// Also prompt the user to enter the number of days after today for a future day
// and dis- play the future day of the week

import javax.xml.transform.Result;
import java.util.Scanner;

public class futuredate {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("What is todays date?: ");

        //(Sunday is 0, Monday is 1, . . . , and Saturday is 6)

    }
public static String dates (int date) {
    String result = new String();

    if (date == 0)
        result = "Sunday";

    else if (date == 1)
        result = "Monday";

    else if (date == 2)
        result = "Thursday";

    else if (date == 3)
        result = "Wednesday";

    else if (date == 4)
        result = "Thursdag";

    else if (date == 5)
        result = "Friday";

    else if (date == 6)
        result = "Saturday";

    return result;
}
 }
