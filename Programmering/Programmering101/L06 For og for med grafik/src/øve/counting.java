package øve;

import java.util.Scanner;

public class counting {
    public static void main(String[] args) {
        //Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Indsæt numre fra 1-5: ");


            int number, sum = 0, count;
            for (count = 0; count < 5; count++) {
            number = input.nextInt();
            sum += number;
        }
            System.out.println("sum is " + sum);
            System.out.println("count is " + count);
    }
}
