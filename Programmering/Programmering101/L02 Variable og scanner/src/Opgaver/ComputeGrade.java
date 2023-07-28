package Opgaver;

import java.util.Scanner;

public class ComputeGrade {
    public static void main(String[] args) {

        //Create a Scanner
        Scanner input = new Scanner(System.in);

        //Ask for score
        System.out.println("Score: ");
        int score = input.nextInt();

        //Grades ranked
        if (score >= 90) {
            System.out.println("Grade is A");

        } else if (score >= 80) {
            System.out.println("Grade is B");

        } else if (score >= 70) {
            System.out.println("Grade is C");

        } else if (score >= 60) {
            System.out.println("Grade is D");

        } else if (score >= 50) {
            System.out.println("Grade is F");

            }
        }

}
