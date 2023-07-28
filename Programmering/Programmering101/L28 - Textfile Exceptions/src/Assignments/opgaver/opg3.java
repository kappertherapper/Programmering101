package Assignments.opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class opg3 {
    public static void main(String[] args) {
        printTextFile();
    }

    public static void printTextFile() {
        String fileName = "L28 - Textfile Exceptions/src/Assignments/opgaver/ligeUligetal100.txt";
        File out = new File(fileName);
        try (PrintWriter writer = new PrintWriter(out)) {
            int number = 1;
            for (int i = 0; i < 49; i++) {
                number += 2;
                writer.println(number);

            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
