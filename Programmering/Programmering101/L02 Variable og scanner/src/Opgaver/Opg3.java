package Opgaver;
// Enter 2 numbers and display them in ascending order.
import java.util.Scanner;
public class Opg3 {

    public static void main(String[] args) {
        // Algorim

    Scanner input = new Scanner(System.in);

    // Ask for the first number
        System.out.println("Enter first number: ");
    double firstNumber = input.nextDouble();

    //Ask for the secound number
        System.out.println("Enter secound number: ");
    double secoundNumber = input.nextDouble();

    // If firstnumber is bigger end secound. Then display secound before firstNumber
    if (firstNumber >= secoundNumber) {
        System.out.println(secoundNumber +  " " + firstNumber);

    // else reverse it (secoundNumber bigger then firstNumber. Then display firstNumber before secoundNumber
    } else {
        System.out.println(firstNumber + " " + secoundNumber);
    }



    }
}
