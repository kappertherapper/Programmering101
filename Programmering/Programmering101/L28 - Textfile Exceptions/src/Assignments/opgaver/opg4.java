package Assignments.opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class opg4 {
    public static void main(String[] args) {
        File out = new File("L28 - Textfile Exceptions/src/Assignments/opgaver/123.txt");

        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(out)) {
            System.out.println("Type in positiv decimal numbers: (end with -1)");
            boolean finished = false;
            while (!finished) {
                try {
                    double d = scanner.nextDouble();
                    if (d == -1) {
                        finished = true;
                    } else {
                        System.out.println("Typed in: " + d);
                        writer.println(d);
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("NOT a decimal number!");
                    System.out.println();
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println("End of program ");
    }
}
