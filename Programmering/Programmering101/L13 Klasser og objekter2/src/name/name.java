package name;

public class name {
    String firstName;
    String middelName = "";
    String lastName;

    public name(String firstName, String middelName, String lastName){

        this.firstName = firstName;
        this.middelName = middelName;
        this.lastName = lastName;

    }
    public name(String firstName, String lastName){

        this.firstName = firstName;
        this.middelName = "";
        this.lastName = lastName;

    }

    public String getFullName(){
        int index = lastName.length()-2;

        String fullName =
                firstName.substring(0,2).toUpperCase() +
                middelName.length() +
                lastName.substring(index).toLowerCase();

        return fullName;
    }

    public String getUsername() {

        return null;
    }
}
