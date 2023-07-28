import java.util.Scanner;

public class Opgave2 {

    //Lav en klasse med en main() metode.
    //Tilføj til klassen en metode printPowersOfTwo(), der udskriver alle potenser af
    //2 fra 2^2 til 2^20.
    //(Bemærk, at metodens returtype er void, de den ikke returnerer noget.)
    //Kald metoden i main() metoden.
    //OBS: Metoden må ikke bruge Math.pow(a,b).

    public static void main(String[] args) {

        int count = 1;

        for (int sum = 2; count <= 20; sum = sum * 2){


            System.out.println(sum);
            count++;

        }
    }
}



