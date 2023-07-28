package Opgaver;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
    String name;
    int number;


    public Customer (String navn, int number){
        this.name = navn;
        this.number = number;

    }

    @Override
    public String toString() {
        return "Name = " + name +
                " - Number = " + number + "\n";
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.number, other.number);
    }
}
