package Person;

import Opgaver.Person.Person;

public class app {
    public static void main(String[] args) {
        Person p = new Person("Joakim","Langbortistan");
        p.monthlySalary = 200;

        System.out.println(p.toString());
        p.yearlySalary(p.monthlySalary);
        System.out.println("Yearly Salary " + p.yearlySalary);


    }
}
