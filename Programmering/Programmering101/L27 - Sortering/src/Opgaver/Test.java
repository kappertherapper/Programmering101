package Opgaver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> b = new ArrayList<String>();
        b.add("hvadsåderduergrim:)");
        b.add("hvadsåder12");
        b.add("hvadsåder1");
        b.add("hvadsåder123");
        b.add("hvadsåder55555");
        b.add("hvadsåderhey1234");
        b.add("hvadså");

        String[] d;
        d = new String[]{"elefant", "citron", "banan", "dadler", "abe"};
        String[] sorted = selectionSort(d);

        ArrayList<Customer> c = new ArrayList<>();
        c.add(new Customer("Bob", 1));
        c.add(new Customer("Bent", 3));
        c.add(new Customer("Birgitte", 2));
        c.add(new Customer("Gustav", 5));
        c.add(new Customer("Martin", 4));
        c.add(new Customer("Andreas", 7));
        c.add(new Customer("Joakim", 6));

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = randomizer();
        ArrayList<Integer> list2 = randomizer();



        //Testing..
        System.out.println("Bubble sort, String: " + bubbleSort(b));
        System.out.println("Selection sort, customers: " + selectionSortCustomer(c));
        System.out.println("Selection sort, String: " + Arrays.toString(sorted));

        System.out.println("Cheat codes:");

        System.out.println(b); // print the list before sorting
        Collections.sort(b);
        System.out.println(b); // print the list after sorting

        System.out.println();

        System.out.println("Bubble sort, Integer: " + bubbleSortInt(list1));
        System.out.println("Insertion sort, Integer: " + insertionSortInt(list1));
        System.out.println("Selection sort, Integer: " + selectionSortInt(list1));

        //Timing for Bubble sort..
        long startTime = System.currentTimeMillis();
        bubbleSortInt(list1);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);  // in nanoseconds
        System.out.println("Bubble sort time: " + duration + " ms");

        //Timing for Insertion sort...
        long startTime1 = System.currentTimeMillis();
        bubbleSortInt(list1);
        long endTime1 = System.currentTimeMillis();
        long duration1 = (endTime1 - startTime1);  // in nanoseconds
        System.out.println("Insertion sort time: " + duration1 + " ms");

        //Timing for Selection sort...
        long startTime2 = System.currentTimeMillis();
        bubbleSortInt(list1);
        long endTime2 = System.currentTimeMillis();
        long duration2 = (endTime2 - startTime2);  // in nanoseconds
        System.out.println("Selection sort time: " + duration2 + " ms");



    }


    // Opgave 1
    public static ArrayList<String> bubbleSort(ArrayList<String> arr) {
        // arr has an unsorted part followed by a sorted part,
        // i is the index of the last number in the unsorted part
        for (int i = arr.size() - 1; i > 0; i--) {
            // bubble the biggest number in the unsorted part up to index i
            for (int j = 0; j < i; j++) {
                if (arr.get(j).length() > arr.get(j + 1).length()) {
                    String temp = (arr.get(j));
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }

    //Opgave 2
    public static String[] selectionSort(String[] arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexOfMin]) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                String temp = arr[i];
                arr[i] = arr[indexOfMin];
                arr[indexOfMin] = temp;
            }
        }
        return arr;
    }

    public static ArrayList<Customer> selectionSortCustomer(ArrayList<Customer> customers) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 0; i < customers.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < customers.size(); j++) {
                if (customers.get(j).compareTo(customers.get(indexOfMin)) < 0) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                Customer temp = customers.get(i);
                customers.set(i, customers.get(indexOfMin));
                customers.set(indexOfMin, temp);
            }
        }
        return customers;
    }

    // Opgave 3
    public static String[] insertionSortString(String[] arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i;
            while (j > 0 && temp.compareTo(arr[j - 1]) < 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static ArrayList<Customer> insertionSort(ArrayList<Customer> customers) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 1; i < customers.size(); i++) {
            Customer temp = customers.get(i);
            int j = i;
            while (j > 0 && temp.compareTo(customers.get(j - 1)) < 0) {
                customers.set(j, customers.get(j - 1));
                j--;
            }
            customers.set(j, temp);
        }
        return customers;
    }

    // Opgave 4
    public static ArrayList<Integer> bubbleSortInt(ArrayList<Integer> arr) {
        // arr has an unsorted part followed by a sorted part,
        // i is the index of the last number in the unsorted part
        for (int i = arr.size() - 1; i > 0; i--) {
            // bubble the biggest number in the unsorted part up to index i
            for (int j = 0; j < i; j++) {
                if (arr.get(j).longValue() > arr.get(j + 1).longValue()) {
                    int temp = (arr.get(j));
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        return arr;
    }

    public static ArrayList<Integer> insertionSortInt(ArrayList<Integer> arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 1; i < arr.size(); i++) {
            int temp = arr.get(i);
            int j = i;
            while (j > 0 && temp < arr.get(j - 1)) {
                arr.set(j, arr.get(j - 1));
                j--;
            }
            arr.set(j, temp);
        }
        return arr;
    }

    public static ArrayList<Integer> selectionSortInt(ArrayList<Integer> arr) {
        // arr has a sorted part followed by an unsorted part
        // i is the index of the first number in the unsorted part
        for (int i = 0; i < arr.size() - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(indexOfMin)) {
                    indexOfMin = j;
                }
            }
            if (indexOfMin != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(indexOfMin));
                arr.set(indexOfMin, temp);
            }
        }
        return arr;
    }

    public static ArrayList<Integer> randomizer() {

        Random r = new Random();
        int[] ints = r.ints(1000, 1, 10000).toArray();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int e : ints) {
            numbers.add(e);
        }
        return numbers;
    }
}


