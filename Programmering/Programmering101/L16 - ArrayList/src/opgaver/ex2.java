package ex2student;

import java.util.ArrayList;
import java.util.List;
    public class ex2 {

        /*** Tests all the methods.*/

        public static void main(String[] args) {
            ArrayList<Integer> ints = new ArrayList<>();
            ints.add(12);
            ints.add(0);
            ints.add(45);
            ints.add(7);
            ints.add(-16);
            ints.add(0);
            ints.add(23);
            ints.add(-10);

            // ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
            System.out.println("ints: " + ints);
            System.out.println();

            // Prints sum
            int total = sum1(ints);
            System.out.println("Sum: " + total);

            //Print minimum
            int minimum = minimum(ints);
            System.out.println("Minimum: " + minimum);

            //Print maximum
            int maximum = maximum(ints);
            System.out.println("Maximum: " + maximum);

            //Print average
            double average = average(ints);
            System.out.println("Average: " + average);

            //Print all zeros
            int zeros = zeroes(ints);
            System.out.println("Zeros: " + zeros);

            //Print new array with even numbers
            System.out.println("Evens: " + evens(ints));

            // Test of sum() method: correct sum is 61.
            // Test of minimum() method: correct minimum is -16.
            // Test of maximum() method: correct maximum is 45.
            // Test of average() method: correct average is 7.625.
            // Test of zeroes() method: correct number of zeroes is 2.
            // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        }
        // sum made with for statement

        public static int sum1(ArrayList<Integer> list) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                sum += number;
            }
            return sum;
        }

        /*** Return the minimum of all numbers in the list. */
        public static int minimum(ArrayList<Integer> list) {
            int min = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                if (min > number) {
                    min = number;

                }
            }

            return min;
        }

        /*** Return the maximum of all numbers in the list. */
        public static int maximum(ArrayList<Integer> list) {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                if (max < number) {
                    max = number;
                }
            }
            return max;
        }

        /*** Return the average of the numbers in the list.*/
        public static double average(ArrayList<Integer> list){
            double average = 0;
            double sum = 0;
            for (int i = 0; i < list.size(); i++) {
                int number = list.get(i);
                sum += list.get(i);
                average = sum / list.size();

            }
            return average;
        }

        /** Return the number of zeros in the list. */
        public static int zeroes(ArrayList<Integer> list){
            int zeros = 0;
            for (int zero : list) {
                if (zero == 0)
                zeros++;

            }
            return zeros;
        }

        /** Return a new list containing the even numbers in the list. */
        public static ArrayList<Integer> evens(ArrayList<Integer> list){
            ArrayList<Integer> evens = new ArrayList<>();
            for (int even : list) {
                if (even % 2 == 0) {
                    evens.add(even);
                }
            }
            return evens;
        }

    }