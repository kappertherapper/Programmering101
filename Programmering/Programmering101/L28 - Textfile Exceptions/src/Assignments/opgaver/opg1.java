package Assignments.opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class opg1 {

    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        File in = new File("L28 - Textfile Exceptions/src/Assignments/opgaver/opg1.txt"); // use "/" or "\\", not "\"
        try (Scanner scanner = new Scanner(in)) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number * 2);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }
    }
}
