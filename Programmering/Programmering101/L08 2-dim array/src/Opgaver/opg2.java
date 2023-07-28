package Opgaver;

import java.util.Scanner;

public class opg2 {
    public static void main(String[] args) {
        int[][] numbers = {
                {0, 4, 3, 9, 6}, //22
                {1, 3, 5, 2, 2}, //13
                {3, 3, 1, 0, 1}, //8
                {0, 0, 9, 7, 1}  //17
        };
        Scanner in = new Scanner(System.in);

        //1
        int setValue = 5;
        int setrow = 0;
        int setCol = 0;
        setValueAt(numbers, setrow, setCol, setValue);
        print(numbers);

        System.out.println();

        //2
        int set23 = 0;
        int set23row = 0;
        int set23Col = 0;
        set23(numbers, set23row, set23Col, set23);
        print(numbers);

        System.out.println();

        //3
        int set32 = 0;
        int set32row = 0;
        int set32Col = 0;
        set32(numbers, set32row, set32Col, set32);
        print(numbers);

        System.out.println();

        //4
        int skak = 0;
        int skakRow = 0;
        int skakCol = 0;
        skak(numbers, skakRow, skakCol, skak);
        print(numbers);

        System.out.println();

        //5
        int vindue = 0;
        int vinRow = 0;
        int vinCol = 0;
        vindue(numbers, vinRow, vinCol, vindue);
        print(numbers);

    }

    public static void print(int[][] numbers) { // Prints the array as a table

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j] == 1)
                    numbers[i][j] = 1;
                System.out.printf(numbers[i][j] + " ");
            }
            System.out.println();
            // System.out.println(Arrays.deepToString("%5d", numbers));

        }
    }

    public static void setValueAt(int[][] numbers, int row, int col, int value) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <= numbers.length; j++) {
                numbers[i][j] = 5;

            }
        }
    }


    public static void set23(int[][] numbers, int row, int col, int value) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <= numbers.length; j++) {
                if (i % 2 == 0) {
                    numbers[i][j] = 2;
                } else {
                    numbers[i][j] = 3;
                }

            }
        }
    }

    public static void set32(int[][] numbers, int row, int col, int value) {

        for (int i = 0; i <= numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i % 2 == 0) {
                    numbers[j][i] = 2;
                } else {
                    numbers[j][i] = 3;
                }
            }
        }
    }

    public static void skak(int[][] numbers, int row, int col, int value) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if ((i + j) % 2 == 0) {
                    numbers[i][j] = 0;
                } else {
                    numbers[i][j] = 1;

                }
            }
        }
    }

    public static void vindue(int[][] numbers, int row, int col, int value) {

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j <= numbers.length; j++) {
                numbers[i][j] = 5;
                for (int y = 1; y < numbers.length - 1; ++y) {
                    for (int k = 1; k < numbers.length; k++) {
                        numbers[y][k] = 2;

                    }
                }
            }
        }
    }
}