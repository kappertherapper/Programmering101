package exercise2;

import java.util.Arrays;

import static exercise2.ex2.sharedNumbers;

public class test {
    public static void main(String[] args) {
    int[] list1;
    list1 = new int[] {2, 4, 6, 8, 10, 12, 14};
    int[] list2;
    list2 = new int[] {1, 2, 4, 5, 6, 9, 12, 17};

    int[] sorted = sharedNumbers(list1, list2);
        System.out.println(Arrays.toString(sorted));
    }
}
