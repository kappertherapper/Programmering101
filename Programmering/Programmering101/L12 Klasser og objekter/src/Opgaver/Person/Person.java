package Opgaver.Person;

public class Person {

    String name;
    String adress;

    public int monthlySalary;
    public double yearlySalary;

    public Person(String name, String adress, int monthlySalary) {
        this.name = name;
        this.adress = adress;
        this.monthlySalary = monthlySalary;
    }

    public Person(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public void yearlySalary (int monthlySalary) {
        this.yearlySalary = (monthlySalary * 12) * 1.025;

    }

    @Override
    public String toString() {
        return "Name = " + name +
                "\n" + "Adress = " + adress +
                "\n" + "MonthlySalary = " + monthlySalary;


    }
}
