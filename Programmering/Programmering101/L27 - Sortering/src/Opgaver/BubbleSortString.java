package Opgaver;

import java.util.ArrayList;

public class BubbleSortString {
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
}
