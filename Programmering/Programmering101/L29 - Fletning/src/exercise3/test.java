package exercise3;

import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        ArrayList<Customer> c = new ArrayList<>(); // Arraylist of Customer objects
        c.add(new Customer("Bob", 1));
        c.add(new Customer("Bent", 3));
        c.add(new Customer("Birgitte", 2));
        c.add(new Customer("Gustav", 5));
        c.add(new Customer("Martin", 4));
        c.add(new Customer("Andreas", 7));
        c.add(new Customer("Joakim", 6));

        Customer[] d = new Customer[7]; // Array of Customer objects
        d[0] = new Customer("John", 8);
        d[1] = new Customer("Bent", 3);
        d[2] = new Customer("Henrik", 9);
        d[3] = new Customer("Lommer", 12);
        d[4] = new Customer("Asger", 10);
        d[5] = new Customer("Mathias", 11);
        d[6] = new Customer("Joakim", 6);

        ArrayList<Customer> result = goodCustomer(c, d);
        System.out.println(result);




    }
    /**
     * Return a sorted ArrayList containing all customers
     * from l1 that are not in l2.
     * Pre: l1 and l2 are sorted and l2 has no empty
     * entries.
     */
    public static ArrayList<Customer> goodCustomer(ArrayList<Customer> s1, Customer[] s2) {
        ArrayList<exercise3.Customer> result = new ArrayList<>();
        // flet sålænge der er noget i begge lister
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.length) {
            if (s1.get(i1).compareTo(s2[i2]) == 0) {
                // hvis s1 har elementer fra s2
                result.add(s1.get(i1));
                i1++;
                i2++;
            } else {
                i1++;
                i2++;
            }
        }
        return result;
    }
}
