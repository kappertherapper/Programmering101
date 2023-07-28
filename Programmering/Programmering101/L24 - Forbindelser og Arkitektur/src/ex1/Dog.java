package ex1;

public class Dog {

    int number;
    String name;
    Person owner;

    public Dog(int number, String name, Person owner){
        this.number = number;
        this.name = name;
        this.owner = owner;
        owner.addDog(this);
    }

    public String getName() {

        return name;
    }
    public int getNumber() {

        return number;
    }

    public Person getOwner() {

        return owner;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  "number = " + number + "\n" +
                "name = " + name + "\n";
    }
}
