package Opgaver;

import java.util.Scanner;

public class opg1 {
    public static void main(String[] args) {
        // Creates a scanner
        Scanner input = new Scanner(System.in);


        int[][] numbers = {
                {0, 4, 3, 9, 6}, //22
                {1, 3, 5, 2, 2}, //13
                {3, 3, 1, 0, 1}, //8
                {0, 0, 9, 7, 1}  //17
        };

        //1
        print(numbers);

        //2
        System.out.println("\n" + "Choose a row: ");
        int row = input.nextInt();
        int sum = sumRow(numbers, row);
        System.out.println("\n" + "the sum of the given row " + row + " is " + sum);

        //3
        System.out.println("\n" + "Choose a col: ");
        int col = input.nextInt();
        int sum1 = sumColumn(numbers, col);
        System.out.println("\n" + "the sum of the given row " + col + " is " + sum1);

        //4
        int sum2 = sum(numbers);
        System.out.println("\n" + "Sum of all numbers is: " + sum2);

        //5
        int sum3 = getValueAt(numbers, row, col);
        System.out.println("\n" + "The choisen number is: " + sum3);

        //6
        Scanner value = new Scanner(System.in);

        System.out.println("Enter the row: ");
        int rowChoise = value.nextInt();
        System.out.println("Enter the col: ");
        int colChoise = value.nextInt();
        int getValue = getValueAt(numbers, rowChoise, colChoise);
        System.out.println("The Value at " + rowChoise + " " + colChoise + " is " + getValue);

        // 7
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Row: ");
        int inputrow = in.nextInt();
        System.out.println("Enter Cols:");
        int inputcol = in.nextInt();
        System.out.println("Enter New Number: ");
        int newnum = in.nextInt();

        setValueAt(numbers, inputrow, inputcol, newnum);
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

    public static int sumRow(int[][] numbers, int row) { // Returns the sum of the numbers in the given row

        int sum = 0;
        for (int i = 0; i < numbers[row].length; i++) {
            sum += numbers[row][i];


        }
        return sum;
    }

    public static int sumColumn(int[][] numbers, int col) { // Sums the numbers in the given column.
        int sum1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum1 += numbers[i][col];
            {


            }

        }
        return sum1;
    }

    public static int sum(int[][] numbers) { // Returns the sum of all numbers in the array

        int sum2 = 0;
        for (int i = 0; i <= numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                sum2 += numbers[j][i];
            }


        }
        return sum2;
    }

    public static int getValueAt(int[][] numbers, int row, int col) { // gets the value at (row, col) in the array named numbers

        return numbers[row][col];

    }

    public static void setValueAt(int[][] numbers, int row, int col, int value) { // sets the value at (row, col) in the array named numbers
        numbers[row][col] = value;




    }
}

