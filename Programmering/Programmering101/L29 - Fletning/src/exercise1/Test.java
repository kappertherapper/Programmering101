package exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Cliente> list1 = new ArrayList<Cliente>();
        ArrayList<Cliente> list2 = new ArrayList<Cliente>();

        list1.add(new Cliente("John", "Smith"));
        list1.add(new Cliente("Michael", "Johnson"));
        list1.add(new Cliente("Christopher", "Lee"));
        list1.add(new Cliente("Andrew", "Wilson"));
        list1.add(new Cliente("William", "Jones"));
        list1.add(new Cliente("Lucas", "Hernandez"));
        list1.add(new Cliente("Alexander", "White"));
        list1.add(new Cliente("Benjamin", "Scott"));
        list1.add(new Cliente("Ethan", "King"));
        list1.add(new Cliente("Aiden", "Baker"));

        list2.add(new Cliente("Emily", "Davis"));
        list2.add(new Cliente("Ashley", "Brown"));
        list2.add(new Cliente("Sarah", "Parker"));
        list2.add(new Cliente("Rachel", "Taylor"));
        list2.add(new Cliente("Jessica", "Hernandez"));
        list2.add(new Cliente("Sofia", "Rodriguez"));
        list2.add(new Cliente("Ava", "Gonzalez"));
        list2.add(new Cliente("Mia", "Taylor"));
        list2.add(new Cliente("Isabella", "Martinez"));
        list2.add(new Cliente("Emily", "Nelson"));

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(exercise1.mergeAllCustomers(list1, list2));
    }
}
