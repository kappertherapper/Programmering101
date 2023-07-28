package opgaver;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {
    public static void main(String[] args) {
        ArrayList<Integer> tal = new ArrayList<>();
        tal.addAll(List.of(1, 2, 3));

    }

    public static void switchFirstLast(ArrayList<Integer> list){
        int temp = list.get(0);
        list.set(0, list.get(list.size()) - 1);
        list.set(list.size() - 1, temp);

    }

    public static void zeroEvenOut(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0)
                list.set(i,0);
        }
    }

    public static int secondHighest(ArrayList<Integer> list) {
        int highest;
        int secoundHighest;
        if (list.get(0) >= list.get(1)) {
            highest = list.get(0);
            secoundHighest = list.get(1);

        } else {
            highest = list.get(1);
            secoundHighest = list.get(0);
        }
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) > highest) {
                secoundHighest = highest;
                highest = list.get(i);

            } else if (list.get(i) > secoundHighest) {
                secoundHighest = list.get(i);
            }
        }
        return secoundHighest;
    }

    public static int sortAscending(ArrayList<Integer> list) {
        int first = 0;
        int secound = 0;
        for (int i = 0; i < list.size(); i++) {
            first = list.get(0);
            secound = list.get(1);
            if (first < secound) {
                list.set(0,secound);
            }

        }
        return first;
    }
}
