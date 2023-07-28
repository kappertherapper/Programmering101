package ex1;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        Person person1 = new Person("Wilfred", "1909975566", "45768899");
        Person person2 = new Person("Karsten", "1506955276", "98668812");
        Person person3 = new Person("Yvonne", "0103984477", "55771288");

        Dog dog1 = new Dog(1, "Snebold", person1);
        Dog dog2 = new Dog(2, "Fitto", person1);
        Dog dog3 = new Dog(3, "Ruth", person3);


        System.out.println(person1.getName() + " owns the follwing dogs: ");
        for (Dog dog : person1.getDogs()) {
            System.out.println("Name of dog: " + dog.getName() + "\n" + "Number of dog: " +  dog.getNumber());
        }

        System.out.println(dog1.getName() + " Is owned by: " + dog1.getOwner().getName());



    }
}
