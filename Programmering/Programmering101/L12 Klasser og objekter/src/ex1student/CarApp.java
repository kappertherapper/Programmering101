package ex1student;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        System.out.println("Test: " + myCar.toString());
        System.out.println();

        String brand = myCar.brand;
        System.out.println("Brand " + brand);
        System.out.println("My car: " + myCar.brand + ", " + myCar.color);

        myCar.km = 0;
        System.out.println("Km nu: " + myCar.km);

        Car myCar2 = new Car("Jaguar", "Forrest Green", "Bowler", 0);
        System.out.println("\n" + "Test: " + myCar2.toString());
        System.out.println();

        String brand2 = myCar2.brand;
        System.out.println("Brand " + brand2);
        System.out.println("My car: " + myCar2.brand + ", " + myCar2.color);

        myCar2.km = 0;
        System.out.println("Km nu: " + myCar2.km);



    }
}
