package opg1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class opgaver {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(linFileSearchPerson("L33 - Repetition/src/opg1/personer.txt", "Hansen"));
        findfællesTal("L33 - Repetition/src/opg1/tal1.txt", "L33 - Repetition/src/opg1/tal2.txt", "L33 - Repetition/src/opg1/tal3.txt");

    }

    public static String linFileSearchPerson(String fileName, String target) throws FileNotFoundException {
        File in = new File(fileName);
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String linje = scanner.nextLine();
            int indexOfLastSpace = linje.lastIndexOf(' ');
            String lastName = linje.substring(indexOfLastSpace + 1);
            if (lastName.equals(target)) {
                return linje;
            }
        }
        return null;
    }

    public static void findfællesTal(String fileName1, String fileName2, String fileNameNy) throws FileNotFoundException {

        File in1 = new File(fileName1);
        File in2 = new File(fileName2);
        Scanner scanner1 = new Scanner(in1);
        Scanner scanner2 = new Scanner(in2);
        PrintWriter writer = new PrintWriter(fileNameNy);

        int num1 = scanner1.nextInt();
        int num2 = scanner2.nextInt();
        boolean num1Valid = true;
        boolean num2Valid = true;

        while (num1Valid && num2Valid) {
            if (num1 == num2) {
                writer.println(num1);

                if (scanner1.hasNextInt()) {
                    num1 = scanner1.nextInt();
                } else {
                    num1Valid = false;
                }

                if (scanner2.hasNextInt()) {
                    num2 = scanner2.nextInt();
                } else {
                    num2Valid = false;
                }

            } else if (num1 < num2) {
                writer.println(num1);

                if (scanner1.hasNextInt()) {
                    num1 = scanner1.nextInt();
                } else {
                    num1Valid = false;
                }
            } else {
                writer.println(num2);

                if (scanner2.hasNextInt()) {
                    num2 = scanner2.nextInt();
                } else {
                    num2Valid = false;
                }
            }
        }

        if (num1Valid) {
            writer.println(num1);
            while (scanner1.hasNextInt()) {
                writer.println(scanner1.nextInt());
            }
        }

        if (num2Valid) {
            writer.println(num2);
            while (scanner2.hasNextInt()) {
                writer.println(scanner2.nextInt());
            }
        }

        scanner1.close();
        scanner2.close();
        writer.close();
    }
}



