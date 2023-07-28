package ex2student;

public class Employee {

    String name; // The name of the employee.

    boolean trainee; // Whether the employee is a trainee or not.
    int age; // Age of the employee

    boolean birthday;

    /** Create an employee. */

    public Employee(String name, boolean trainee) {
        this.name = name;
        this.trainee = true;

    }
    public Employee(String name, boolean trainee, int age) {
        this.name = name;
        this.trainee = true;
        this.age = age;
    }


    public void Birthday(int age) {
        this.age = age;
        this.age++;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %s)", name, trainee, age);
    }

    /** Print a description of the employee. */
    public void printEmployee() {
        String[] nameArr = name.split("\\s+"); // splitter string mellem "mellemrum" (\\s+ = mellemrum)

        System.out.println("*******************");
        System.out.println("Name: " + nameArr[0]);
        System.out.println("Surname: " + nameArr[nameArr.length-1]); //længde af array er 10, derfor vil (-1) altid fange sidste plads
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");

    }
}
