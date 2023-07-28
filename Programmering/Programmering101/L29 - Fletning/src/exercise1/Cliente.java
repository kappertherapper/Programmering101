package exercise1;

public class Cliente implements Comparable<Cliente> {
    private String firstName;
    private String lastName;

    public Cliente(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "First name: " + firstName +
                "- Last name: " + lastName + "\n";
    }

    @Override
    public int compareTo(Cliente other) {
        int compare = (this.lastName.compareTo(other.lastName));
        if (compare == 0) {
            compare = this.firstName.compareTo(other.firstName);
        }
        return compare;
    }
}
