package Assignments.opgaver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class opg2 {

    public static void main(String[] args) {
        File in = new File("L28 - Textfile Exceptions/src/Assignments/opgaver/opg1.txt");
        ArrayList<Integer> dd = new ArrayList<>();
        try (Scanner scanner = new Scanner(in)) {
            int sum = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                try {
                    int d = Integer.parseInt(line);
                    dd.add(d);
                } catch (NumberFormatException ex) {
                    System.out.println("Not a Integer.");
                }
            }
            for (int i = dd.size() - 1; i >= 0; i--) {
                System.out.print(dd.get(i) + " ");
                //System.out.println("Array is " + dd);

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Sorry! An unexpected error has occurred.");
            System.out.println("Technical message: " + ex.getMessage());
        }
    }
}
