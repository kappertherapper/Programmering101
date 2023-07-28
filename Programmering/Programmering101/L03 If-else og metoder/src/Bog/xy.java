package Bog;

import java.util.Scanner;

public class xy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("y = ");
        int y = input.nextInt();
        int x;

        if (y > 0) {
            x = 1;
        System.out.println("x = " + y++); }
    }

}
