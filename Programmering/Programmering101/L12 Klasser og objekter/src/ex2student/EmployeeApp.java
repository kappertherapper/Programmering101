package ex2student;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", true, 12);
        System.out.println("Test: " + e1);
        System.out.println();

        System.out.println("Name: " + e1.name);
        System.out.println("Trainee? " + e1.trainee);
        System.out.println("Age: " + e1.age);
        System.out.println();

        e1.trainee = false;
        e1.printEmployee();
        //e1.Birthday();
        //System.out.println("HAPPY BIRTHDAY!!!" + "\n" + "Age: " + e1.age);
        System.out.println();
    }
}
