package Opgaver;

import com.sun.source.tree.ReturnTree;
import com.sun.tools.javac.Main;

import java.util.Scanner;

// Girl < 8 Tumbling girls
//     >= 8 Springy girls
//  Boy < 8 Young cubs -
//     >= 8 Cool boys

public class ChildsGym {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter Age: ");
        int age = input.nextInt();
        System.out.print("Is it a boy?: ");
        boolean isBoy = input.nextBoolean();
        String Result = team(isBoy, age);
        System.out.println(Result);

    }

    public static String team(boolean isBoy, int age) {
        String Result = new String();

        if (age < 8 && isBoy == true) {
            Result = "Young cubs";

        } else if (age >= 8 && isBoy == true) {
            Result = "Cool Boys";

        }  else if(age< 8&& isBoy == false) {
            Result ="Tumbling girls";

        }  else if (age >= 8 && isBoy == false) {
            Result = "Springy girls";
        }
        return Result;
    }
}


