package exercise1;

import java.util.ArrayList;


public class exercise1 {
    /**
     * Return a sorted list containing all customers
     * from the lists l1 and l2.
     * Pre: l1 and l2 are sorted.
     */
    public static ArrayList<Cliente> mergeAllCustomers(ArrayList<Cliente> l1, ArrayList<Cliente> l2) {
        ArrayList<Cliente> result = new ArrayList<Cliente>();
        // flet sålænge der er noget i begge lister
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo(l2.get(i2)) <= 0) {
                // s1's tal er mindst
                result.add(l1.get(i1));
                i1++;
            } else {
                // s2's tal er mindst
                result.add(l2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }
        return result;
    }
}
