package arrays;

import java.util.Scanner;

public class exercise5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] numbs = new int[10];

        System.out.println("input some numbers boss: ");

        int odd = 0;
        int even = 0;
        int numb = input.nextInt();

        for (int i = 0; i < 10; i++) {
            if (numb % 2 == 0 ) {
                even += 1;
            } else {
                odd += 1;

            }
            numb = input.nextInt();
        }
        System.out.println("Odd numbers amount: " + odd);
        System.out.println("Even numbers amount: " + even);
    }

}
