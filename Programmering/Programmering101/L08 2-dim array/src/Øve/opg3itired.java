package Øve;

import java.util.Scanner;

public class opg3itired {
    public static void main(String[] args) {

        //set up the array and assign name and table size
        int[][] startNum = new int[3][4];

        //user input
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < startNum[0].length; i++) {
            //get user input
            System.out.print("Please enter your value, u kind soul (4x4): ");

            //push into the array
            int inputValue = input.nextInt();
            startNum[0][i] = inputValue;

        }

        for (int i = 1; i < startNum.length; i++) {
            for (int j = 0; j < startNum[0].length; j++) {
                startNum[i][j] = (i + 1) * startNum[0][j];
            }
            print(startNum);
        }

    }

    public static void print(int[][] startNum) { // Prints the array as a table
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (startNum[i][j] == 1)
                    startNum[i][j] = 1;
                System.out.printf(startNum[i][j] + " ");
            }
            System.out.println();

            // public static double averageMajorDiagonal(double[][] m) {


        }
    }
}
