package Assignments.opgaver.opg5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileUtil {
    public static int max(String filename) {
        File in = new File(filename);
        try (Scanner scanner = new Scanner(in)) {
            int max = 0;
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > max) {
                    max = number;
                }
            }
            return max;
        } catch (FileNotFoundException ex) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }
        return 0;
    }


    public static int min(String filename) {
        File in = new File(filename);
        try (Scanner scanner = new Scanner(in)) {
            int min = scanner.nextInt();

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (min > number) {
                    min = number;
                }
            }
            return min;
        } catch (FileNotFoundException ex) {
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }
        return 0;
    }

   public static double gennemsnit(String filename) {
       File in = new File(filename);
       try (Scanner scanner = new Scanner(in)) {
           double sum = 0;
           double count = 0;
           while (scanner.hasNextDouble()) {
               count++;
               double number = scanner.nextDouble();
                   sum += number;
           }
           double average = sum / count;
           return average;
       } catch (FileNotFoundException ex) {
           System.err.println("Sorry! An unexpected error has occurred.");
           System.err.println("Technical message: " + ex.getMessage());
       }
       return 0;
   }
}
