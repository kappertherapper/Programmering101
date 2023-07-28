package Opgaver;

import java.util.Scanner;

public class opg3locateLowest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter The Number Of Matrix Rows: ");
        int row = scan.nextInt();

        System.out.print("Enter The Number Of Matrix Columns: ");
        int col = scan.nextInt();


        //defining 2D array to hold matrix data
        int[][] matrix = new int[row][col];

        // Enter Matrix Data
        enterMatrixData(scan, matrix, row, col);

        // Print Matrix Data
        printMatrixData(matrix, row, col);

        // Print min element
        getMinValue(matrix);

        System.out.println("\n" + "The smallest boy in town is: " + getMinValue(matrix));

    }

    public static void enterMatrixData(Scanner scan, int[][] matrix, int row, int col) {

        System.out.println("Enter Matrix Data (4 x 4 : 1 2 3 4): ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                matrix[i][j] = scan.nextInt();
            }
        }
    }

    public static void printMatrixData(int[][] matrix, int row, int col) {

        System.out.println("\n" + "The Matrix to solve is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(matrix[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public static int getMinValue(int[][] matrix) {
        int minValue = matrix[0][0];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].length; i++) {
                if (matrix[j][i] < minValue) {
                    minValue = matrix[j][i];


                }
            }
        }
        return minValue;
    }
}
