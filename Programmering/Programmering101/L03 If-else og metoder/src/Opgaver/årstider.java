package Opgaver;

import java.util.Scanner;
        /*Hvis måned er 12, 1 eller 2 er årstid = ”Vinter”
          ellers hvis måned er 3, 4 eller 5 er årstid = ”Forår”
          ellers hvis måned er 6, 7 eller 8 er årstid = ”Sommer”
          ellers årstid = ”Vinter”,
          Hvis måned er  2, 5, 8 eller 11 og dagen >= 21:
          Hvis årstid er ”Vinter”, så ændres årstid til ”Forår”
          ellers hvis årstid er ”Forår”, så ændres årstid til ”Sommer”
          ellers hvis årstid er ”Sommer”, så ændres årstid til ”Efterår”
          ellers ændres årstid til ”Vinter” */

public class årstider {
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print("Indsæt måned: ");
        int måned = input.nextInt();
        System.out.print("Indsæt dag: ");
        int dag = input.nextInt();
        String result = årstid(måned, dag);
        System.out.println(result);






        //Skriv er metode der tager to heltal som parametre (måned og dag) og returnerer en
        //String, der beskriver årstiden.
        //Skriv en main() metode, der spørger brugeren efter måned og år, kalder metoden og
        //udskriver resultatet af metode kaldet.

    }
public static String årstid (int måned, int dag) {
        String result = new String();

        if (måned == 12 || måned == 1 || måned == 2)
            result = "Vinter";

            else if (måned == 3 || måned == 4 || måned == 5)
            result = "Forår";

            else if (måned == 6 || måned == 7 || måned == 8)
            result = "Sommer";

            else
            result = "Efterår";

        if (måned == 2 && dag >= 21)
            result = "Forår";

        else if (måned == 5 && dag >= 21)
            result = "Sommer";

        else if (måned == 8 && dag >= 21)
            result = "Efterår";

        else if (måned == 11 && dag >= 21)
            result = "Forår";



        return result;
    }

}
