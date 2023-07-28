package exercise3;

public class Customer implements Comparable<Customer> {
    String name;
    int number;


    public Customer(String navn, int number) {
        this.name = navn;
        this.number = number;

    }

    @Override
    public String toString() {
        return "Name = " + name +
                " - Number = " + number;
    }

    @Override
    public int compareTo(Customer other) {
        int compare = (this.name.compareTo(other.name));
        return compare;
    }
}
