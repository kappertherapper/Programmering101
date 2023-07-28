package Opgaver;

/* Age Institution
        0    Home
        1,2  Nursery
        3-5  Kindergarten
        6-16 School
        17-  Out of school */

import java.util.Scanner;

public class ChildApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Age: ");
        int age = input.nextInt();
        String Institution = institution(age);
        System.out.println(Institution);


    }

    public static String institution(int age) {
        String institution1 = new String();


        if (age == 0) {
            institution1 = "home";

        } else if (age > 0 && age <= 2) {
            institution1 = "Nursery";

        } else if (age >= 3 && age <= 5) {
            institution1 = "Kindergarten";

        } else if (age >= 6 && age <= 16) {
            institution1 = "School";

        } else if (age >= 17) {
            institution1 = "Out of School";


        }
        return institution1;
    }



    }

