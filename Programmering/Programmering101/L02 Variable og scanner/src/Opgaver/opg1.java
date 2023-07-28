package Opgaver;
import java.util.Scanner;

/* Make a program , that inputs amount and caculates sales tax (6%) */
public class opg1 {
    public static void main(String[] args) {
        // Algoritm
        Scanner input = new Scanner(System.in);

        // Asking the user for the purchase amount
        System.out.println("enter purchased amount: ");
        double amount = input.nextDouble();
        double tax = amount * 0.06;

        // Tax amount
        System.out.println("sales tax (6%) is: " + tax);



    }
}
