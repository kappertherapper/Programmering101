package Opgaver;
import java.util.Scanner;

//Enter 3 numbers and display them in ascending order

public class Opg33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Algorith

        // Enter numbers
        System.out.println("Enter first number: ");
        double one = input.nextDouble();

        System.out.println("Enter secound number: ");
        double two = input.nextDouble();

        System.out.println("Enter tired number: ");
        double three = input.nextDouble();


        if ((one > two) && (one > three) && (two > three)) {
            System.out.println(three + " " + two + " " + one);

        } else if ((one > two) && (one > three) && (three > two)) {
            System.out.println(two + " " + three + " " + one);

        } else if ((two > one) && (two > three) && (one > three)) {
            System.out.println(three + " " + one + " " + two);

        } else if ((two > one) && (two > three) && (three > one)) {
            System.out.println(one + " " + three + " " + two);

        } else if ((three > one) && (three > two) && (two > one)) {
            System.out.println(one + " " + two + " " + three);

        } else {
            System.out.println(two + " " + one + " " + three);

        }


        }
    }
