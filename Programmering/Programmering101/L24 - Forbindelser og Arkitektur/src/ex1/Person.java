package ex1;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String cpr;
    private String phone;
    private List<Dog> dogs = new ArrayList<>();


   public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPhone() {
        return phone;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog){
       dogs.add(dog);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "Name = " + name + "\n" +
                "Cpr = " + cpr + "\n" +
                "Phone = " + phone + "\n";
    }
}
